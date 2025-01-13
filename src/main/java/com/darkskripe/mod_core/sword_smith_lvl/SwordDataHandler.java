package com.darkskripe.mod_core.sword_smith_lvl;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHandler;
import com.darkskripe.mod_core.player_smith_lvl.PlayerDataHelper;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = ModCore.MODID)
public class SwordDataHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.phase == TickEvent.Phase.START && !event.player.level().isClientSide()) {
            Player player = event.player;
            NonNullList<ItemStack> inventory = player.getInventory().items;
            for (ItemStack stack : inventory) {
                if (stack.isEmpty() || !UsableWeaponClasses.isInUsedWeaponClasses(stack.getItem())) {
                    continue;
                }
                if (stack.getComponents().has(SkComponents.SWORD_CLASS.get())) {
                    continue;
                }
                SwordDataHelper.setInitialSwordStats(stack, player);
            }
        }
    }




}
