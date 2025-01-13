package com.darkskripe.mod_core.recipes;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.IModBusEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SkRecipeTypes {
    static DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(
            ForgeRegistries.RECIPE_TYPES, ModCore.MODID
    );

    static RegistryObject<RecipeType<UpgradeSmithRecipe>> UPGRADE_SMITH_RECIPE_TYPE=RECIPE_TYPES.register("upgrade_smith_recipe_type",
            () -> new RecipeType<UpgradeSmithRecipe>() {});

    public static void registerRecipeTypes(IEventBus event) {
        RECIPE_TYPES.register(event);
    }
}
