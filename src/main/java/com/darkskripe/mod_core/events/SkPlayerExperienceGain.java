package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.SwordDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.UsableWeaponClasses;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = ModCore.MODID)

public class SkPlayerExperienceGain {
    @SubscribeEvent
    public static void onPlayerCraftSkUsableWeapon(PlayerEvent.ItemCraftedEvent event) {
        ItemStack item=event.getCrafting();
        if(UsableWeaponClasses.isInUsedWeaponClasses(item.getItem())) {
            if(event.getEntity() instanceof Player player) {
                CompoundTag playerData = player.getPersistentData().getCompound(PlayerDataHandler.SK_DATA_KEY);
                PlayerDataHelper.addExpToSmithPlayer(player,getExpForCraftEvent(item)*playerData.getFloat(PlayerDataHandler.SK_ACHIEVEMENT_EXP_COEF)/2);
            }
        }
    }

    private static float getExpForCraftEvent(ItemStack stack) {
        List<Double> attackAndSpeed= SwordDataHelper.getAttackAndAttackSpeed(stack);
        float enchantValue;
        if(stack.get(DataComponents.ENCHANTABLE) == null)enchantValue=1;
        else enchantValue=stack.get(DataComponents.ENCHANTABLE).value();
        if(enchantValue>=18)enchantValue= (float) Math.pow(enchantValue,2.5);
        int maxDamage=stack.getMaxDamage();
        if (maxDamage <=100)maxDamage/=4;
        return (float) (attackAndSpeed.getFirst()*(4-attackAndSpeed.get(1))*maxDamage*enchantValue/1000);

    }
}
