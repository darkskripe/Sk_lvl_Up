package com.darkskripe.mod_core.client;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.gui.SkMenu;
import com.darkskripe.mod_core.gui.custom.UpgradeSmithScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ModCore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModHandler {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            MenuScreens.register(SkMenu.UPGRADE_SMITH_CONTAINER_MENU.get(), UpgradeSmithScreen::new);
        });
    }
}
