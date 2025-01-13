package com.darkskripe.mod_core.items_and_blocks;

import com.darkskripe.mod_core.ModCore;
import net.minecraftforge.eventbus.api.IEventBus;

public class SkObjectReg {
    public static void register(IEventBus eventBus) {
        ModCore.LOGGER.info("Registering skruiperya lvl up items");
        SkItems.register(eventBus);
        ModCore.LOGGER.info("Registering skruiperya lvl up blocks");
        SkBlocks.registerSimpleBlocks(eventBus);
    }
}
