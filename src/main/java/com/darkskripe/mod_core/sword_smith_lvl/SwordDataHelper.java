package com.darkskripe.mod_core.sword_smith_lvl;


import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import com.darkskripe.mod_core.sword_smith_lvl.sword_classes.SwordClasses;
import com.fasterxml.jackson.databind.JsonSerializable;
import com.mojang.authlib.minecraft.TelemetrySession;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler.SK_DATA_KEY;

public class SwordDataHelper {

    public static void setInitialSwordStats(ItemStack sword, Player player) {
        int swordClass=generateSwordClass(player);
        sword.set(SkComponents.SWORD_CLASS.get(), swordClass);
        sword.set(SkComponents.SWORD_CURRENT_LVL.get(), 1);
        sword.set(SkComponents.SWORD_CURRENT_EXP.get(), 0.0f);
        sword.set(SkComponents.SWORD_TOKENS.get(),generateSwordTokensByMaterial(sword));
        recreateSwordStatsByClass(sword,true);

    }

    public static void addExperienceAndUpdateData(ItemStack sword,float exp) {
        int swordClass=sword.get(SkComponents.SWORD_CLASS.get());
        float currentExp = sword.get(SkComponents.SWORD_CURRENT_EXP.get());
        int currentLevel = sword.get(SkComponents.SWORD_CURRENT_LVL.get());
        int necessaryExp=getNecessaryExp(swordClass,currentLevel);
        if (!ifSwordClassIsBiggerThan6AndMaxLevelAndHasFullExp(swordClass,currentLevel,currentExp,necessaryExp)) {
            if (currentExp + exp >= necessaryExp) {
                if (currentLevel == SwordClasses.SWORD_CLASSES.get(swordClass).getMax_lvl()) {
                    if (swordClass != 10) {
                        updateClassUp(sword, swordClass);
                        addRestExp(sword, necessaryExp, currentExp + exp);
                    }
                } else {
                    updateLvlUp(sword, swordClass, currentLevel);
                    addRestExp(sword, necessaryExp, currentExp + exp);
                }
                if (getNecessaryExp(swordClass, sword.get(SkComponents.SWORD_CURRENT_LVL.get())) <= sword.get(SkComponents.SWORD_CURRENT_EXP.get())) {
                    addExperienceAndUpdateData(sword, 0);
                }
            } else {
                sword.set(SkComponents.SWORD_CURRENT_EXP.get(), currentExp + exp);
            }
        }
    }

    private static boolean ifSwordClassIsBiggerThan6AndMaxLevelAndHasFullExp(int swordClass, int swordLevel,float currentExp,float necessaryExp) {
        return swordClass >= 6 && swordLevel == SwordClasses.SWORD_CLASSES.get(swordClass).getMax_lvl() && currentExp >= necessaryExp;
    }

    private static void updateLvlUp(ItemStack sword,int currentSwordClass,int currentLevel) {
        sword.set(SkComponents.SWORD_CURRENT_LVL.get(), currentLevel+1);
        if(ifCanAddAspectByLvl(currentSwordClass,currentLevel)){
            sword.set(SkComponents.SWORD_TOKENS.get(),
                    sword.get(SkComponents.SWORD_TOKENS.get())+1);
        }
        Random random=new Random();
        sword.set(DataComponents.MAX_DAMAGE,sword.get(DataComponents.MAX_DAMAGE)+random.nextInt(3));

        List<Double> attackAndAttackSpeed=getAttackAndAttackSpeed(sword);
         setSwordAttribute(sword,
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, attackAndAttackSpeed.getFirst()*1.0006, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
        setSwordAttribute(sword,
                Attributes.ATTACK_SPEED,
                new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackAndAttackSpeed.get(1), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
    }



    private static boolean ifCanAddAspectByLvl(int currentClass,int currentLvl){
        int aspectFactor=SwordClasses.SWORD_CLASSES.get(currentClass).getAspect_lvl_up_factor();
        if(aspectFactor!=0){
            return (currentLvl + 1) % aspectFactor == 0;
        }
        return false;
    }

    private static void updateClassUp(ItemStack sword,int currentSwordClass) {
        sword.set(SkComponents.SWORD_CLASS.get(), currentSwordClass+1);
        sword.set(SkComponents.SWORD_CURRENT_LVL.get(), 1);
        int swordTokens=sword.get(SkComponents.SWORD_TOKENS.get());
        sword.set(SkComponents.SWORD_TOKENS.get(),generateSwordTokensByMaterial(sword)+swordTokens);
        recreateSwordStatsByClass(sword,false);
        sword.set(DataComponents.DAMAGE,0);
    }


    private static void addRestExp(ItemStack sword,int necessaryExpForLvlUp,float totalExp) {
        if(totalExp>necessaryExpForLvlUp)sword.set(SkComponents.SWORD_CURRENT_EXP.get(), totalExp-necessaryExpForLvlUp);
    }

    private static int getNecessaryExp(int swordClass,int currentLevel) {
        int firstExp=SwordClasses.SWORD_CLASSES.get(swordClass).getStart_necessary_exp();
        if(currentLevel==1)return firstExp;
        else return firstExp+Math.round(SwordClasses.SWORD_CLASSES.get(swordClass).getExp_coef()*1.035f*currentLevel);
    }

    public static void recreateSwordStatsByClass(ItemStack sword,boolean firstRecreation) {
        if(UsableWeaponClasses.isInUsedWeaponClasses(sword.getItem())) {
            int swordClass=sword.getComponents().get(SkComponents.SWORD_CLASS.get());
            float classQualityCoef=getClassQualityCoef(swordClass);

            int max_damage=sword.getMaxDamage();
            if(!firstRecreation)max_damage=Math.round(max_damage/getClassQualityCoef(swordClass-1));
            sword.set(DataComponents.MAX_DAMAGE,Math.round(max_damage*getRandomInRange(classQualityCoef)));

            List<Double> attackAndAttackSpeed=getAttackAndAttackSpeed(sword);
            if(!firstRecreation){
                attackAndAttackSpeed.set(0,((attackAndAttackSpeed.get(0)+1)/(getClassQualityCoef(swordClass-1)*0.95))-1);
                attackAndAttackSpeed.set(1,attackAndAttackSpeed.get(1)-getClassAttackSpeedCoef(swordClass-1));
            }
            setSwordAttribute(sword,
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (attackAndAttackSpeed.getFirst()+1)*getRandomInRange(classQualityCoef)-1, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
            setSwordAttribute(sword,
                    Attributes.ATTACK_SPEED,
                    new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackAndAttackSpeed.get(1)+getRandomInRange((float) getClassAttackSpeedCoef(swordClass)), AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
        }
    }

    public static void setSwordAttribute(ItemStack sword, Holder<Attribute> attributeHolder, AttributeModifier attributeModifier, EquipmentSlotGroup equipmentSlotGroup) {
        ItemAttributeModifiers itemAttributeModifiers = sword.getComponents().get(DataComponents.ATTRIBUTE_MODIFIERS);
        ItemAttributeModifiers updatedModifiers = itemAttributeModifiers.withModifierAdded(
                attributeHolder, // Correct Holder<Attribute>
                attributeModifier,
                equipmentSlotGroup
        );
        sword.set(DataComponents.ATTRIBUTE_MODIFIERS, updatedModifiers);
    }

    public static List<Double> getAttackAndAttackSpeed(ItemStack sword) {
        List<Double> list=new ArrayList<>(2);
        ItemAttributeModifiers itemAttributeModifiers = sword.getComponents().get(DataComponents.ATTRIBUTE_MODIFIERS);
        for (ItemAttributeModifiers.Entry entry : itemAttributeModifiers.modifiers()) {
            if (entry.attribute().is(Attributes.ATTACK_DAMAGE)) {
                list.add(0,entry.modifier().amount());
            }
            if (entry.attribute().is(Attributes.ATTACK_SPEED)) {
                list.add(1,entry.modifier().amount());
            }
        }
        return list;
    }



    private static double getClassAttackSpeedCoef(int swordClass) {
        return SwordClasses.SWORD_CLASSES.get(swordClass).getAttack_speed_coef();
    }

    private static float getClassQualityCoef(int swordClass) {
        return SwordClasses.SWORD_CLASSES.get(swordClass).getQuality_coef();
    }

    public static int getClassMaxLevel(int swordClass) {
        return SwordClasses.SWORD_CLASSES.get(swordClass).getMax_lvl();
    }

    public static int generateSwordClass(Player player) {
        CompoundTag playerData = player.getPersistentData().getCompound(SK_DATA_KEY);
        int playerSmithLvl=playerData.getInt(PlayerDataHandler.SK_SMITH_LVL);
        if(playerSmithLvl==1)return 1;
        Random random = new Random();
        if(playerSmithLvl==2)return random.nextInt(2);
        return getWeightedRandom(playerSmithLvl);
    }

    private static int generateSwordTokensByMaterial(ItemStack stack){
        if(stack.getComponents().has(DataComponents.ENCHANTABLE)){
            float enchantValue= Objects.requireNonNull(stack.getComponents().get(DataComponents.ENCHANTABLE)).value();
            return Math.round(enchantValue/10);
        }
        return 0;
    }

    private static int getWeightedRandom(int playerSmithLvl) {
        Random random = new Random();
        double randValue = random.nextDouble() * 100;
        if (randValue < 25) {
            return playerSmithLvl;
        } else if (randValue <= 75) {
            return playerSmithLvl-1;
        } else {
            return playerSmithLvl-2;
        }
    }

    private static float getRandomInRange(float base) {
        Random random = new Random();
        return base - base/10 + (2 * base/10) * random.nextFloat();
    }

    public static void recreateSwordStatsByClassForCommand(ItemStack sword,ItemStack deafultInstance) {
        if(UsableWeaponClasses.isInUsedWeaponClasses(sword.getItem())) {
            int swordClass=sword.getComponents().get(SkComponents.SWORD_CLASS.get());
            float classQualityCoef=getClassQualityCoef(swordClass);

            int max_damage=deafultInstance.getMaxDamage();
            sword.set(DataComponents.MAX_DAMAGE,Math.round(max_damage*classQualityCoef));

            List<Double> attackAndAttackSpeed=getAttackAndAttackSpeed(deafultInstance);
            setSwordAttribute(sword,
                    Attributes.ATTACK_DAMAGE,
                    new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (attackAndAttackSpeed.getFirst()+1)*getRandomInRange(classQualityCoef)-1, AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
            setSwordAttribute(sword,
                    Attributes.ATTACK_SPEED,
                    new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, attackAndAttackSpeed.get(1)+getClassAttackSpeedCoef(swordClass), AttributeModifier.Operation.ADD_VALUE),
                    EquipmentSlotGroup.MAINHAND
            );
        }
    }


}
