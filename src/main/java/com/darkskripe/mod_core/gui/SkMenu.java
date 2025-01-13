package com.darkskripe.mod_core.gui;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.gui.custom.UpgradeSmithContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SkMenu {
   public static DeferredRegister<MenuType<?>> SK_LVL_UP_MENU_TYPES= DeferredRegister.create(
            ForgeRegistries.MENU_TYPES, ModCore.MODID
    );

   public static RegistryObject<MenuType<UpgradeSmithContainerMenu>> UPGRADE_SMITH_CONTAINER_MENU=SK_LVL_UP_MENU_TYPES.register(
            "upgrade_smith_menu",
            ()-> IForgeMenuType.create(UpgradeSmithContainerMenu::new)
    );

    public static void register(IEventBus bus) {
        SK_LVL_UP_MENU_TYPES.register(bus);
    }
}
