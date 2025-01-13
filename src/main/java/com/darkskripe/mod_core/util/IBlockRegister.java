package com.darkskripe.mod_core.util;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.SkItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.objectweb.asm.tree.FieldInsnNode;

import java.util.function.Supplier;

public interface IBlockRegister {
     static <T extends Block> RegistryObject<T> registerBlock(DeferredRegister<T> deferredRegister, String name, Supplier<T> block) {
        ModCore.LOGGER.info("Registering "+name+" block from skriperya lvl up");
        RegistryObject<T> toReturn = deferredRegister.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        ModCore.LOGGER.info("Registering "+name+" ItemBlock from skriperya lvl up");
        return SkItems.SK_LVL_UP_ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(SkItems.SK_LVL_UP_ITEMS.key(name))));
    }


}
