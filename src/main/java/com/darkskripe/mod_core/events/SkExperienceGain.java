package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler;
import com.darkskripe.mod_core.sword_smith_lvl.SwordDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.UsableWeaponClasses;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

import static com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler.SK_DATA_KEY;

@Mod.EventBusSubscriber(modid = ModCore.MODID)

public class SkExperienceGain {
    public static float swordExpCoef=1;
    @SubscribeEvent
    public static void onEntityKill(final LivingDeathEvent event) {
        DamageSource source = event.getSource();
        if(source.getEntity() instanceof Player player) {
            if(UsableWeaponClasses.isInUsedWeaponClasses(player.getMainHandItem().getItem())){
                LivingEntity target = event.getEntity();
                CompoundTag playerData = player.getPersistentData().getCompound(SK_DATA_KEY);
                SwordDataHelper.addExperienceAndUpdateData(player.getMainHandItem(),playerData.getFloat(PlayerDataHandler.SK_ACHIEVEMENT_EXP_COEF)*getExpFromKill(target)/swordExpCoef);
            }
        }

    }

    private static float getExpFromKill(LivingEntity target) {
        if(target.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)&&
                (target.getAttributes().hasAttribute(Attributes.ARMOR)&& target.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS))){

            return (float) (target.getMaxHealth()+target.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.5f+target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)+target.getAttributeValue(Attributes.ARMOR))/getTargetSize(target);
        }
        if (target.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)&&
                (target.getAttributes().hasAttribute(Attributes.ARMOR))){
            return (float) (target.getMaxHealth()+target.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.5f+target.getAttributeValue(Attributes.ARMOR))/getTargetSize(target);
        }
        if (target.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)){
            return (float) (target.getMaxHealth()+target.getAttributeValue(Attributes.ATTACK_DAMAGE)*1.5f)/getTargetSize(target);
        }
        return (float) ((float) target.getMaxHealth()/getTargetSize(target));

    }

    private static float getTargetSize(LivingEntity target) {
        if(target.getBbHeight()*target.getBbWidth()>1)return target.getBbHeight()*target.getBbWidth();
        return 1/(target.getBbHeight()*target.getBbWidth());
    }
}
