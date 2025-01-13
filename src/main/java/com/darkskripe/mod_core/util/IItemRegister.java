package com.darkskripe.mod_core.util;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public interface IItemRegister {
    static <T extends Item> RegistryObject<T> registerItem(DeferredRegister<T> deferredRegister, String name, Supplier<T> supplier){
        ModCore.LOGGER.info("Registering "+name+"item from skriperya lvl up");
        RegistryObject<T> registryObject=deferredRegister.register(name,supplier);
        return registryObject;
    }



}
