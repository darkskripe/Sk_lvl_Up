package com.darkskripe.mod_core.creative_tabs;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.SkBlocks;
import com.darkskripe.mod_core.items_and_blocks.SkItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SkCreativeTabs {
    public static DeferredRegister<CreativeModeTab> CREATIVE_TABS=DeferredRegister.create(
            Registries.CREATIVE_MODE_TAB, ModCore.MODID
    );

    public static final RegistryObject<CreativeModeTab> SK_LVL_UP_OBJECTS = CREATIVE_TABS.register("objects_creative_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .title(Component.translatable("itemGroup.sk_lvl_up_objects_creative_tab"))
            .icon(() -> SkItems.BLANK_ASPECT_COIN.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(SkBlocks.UPGRADE_SMITH_BLOCK.get());
                output.accept(SkItems.NOVICE_SWORD_SOUL.get());
                output.accept(SkItems.ADEPT_SWORD_SOUL.get());
                output.accept(SkItems.MASTER_SWORD_SOUL.get());
                output.accept(SkItems.EMINENT_SWORD_SOUL.get());
                output.accept(SkItems.NOVICE_SMITHS_HAMMER.get());
                output.accept(SkItems.ADEPT_SMITHS_HAMMER.get());
                output.accept(SkItems.MASTER_SMITHS_HAMMER.get());
                output.accept(SkItems.EMINENT_SMITHS_HAMMER.get());
                output.accept(SkItems.BLANK_ASPECT_COIN.get());
            }).build());

    public static void register(IEventBus bus) {
        ModCore.LOGGER.info("Registering SkCreativeTabs");
        CREATIVE_TABS.register(bus);
    }
}
