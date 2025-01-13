package com.darkskripe.mod_core.sword_smith_lvl.component;

import com.darkskripe.mod_core.ModCore;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.ExtraCodecs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.UnaryOperator;

public class SkComponents {
    public static DeferredRegister<DataComponentType<?>> DATA_COMPONENTS=DeferredRegister.create(
            Registries.DATA_COMPONENT_TYPE, ModCore.MODID
    );
    public static RegistryObject<DataComponentType<Integer>> SWORD_CLASS=register("sword_class",
            builder->builder.persistent(ExtraCodecs.intRange(1,10)));


    public static RegistryObject<DataComponentType<Integer>> SWORD_CURRENT_LVL=register("sword_current_level",
            builder->builder.persistent(ExtraCodecs.intRange(1,100)));


    public static RegistryObject<DataComponentType<Float>> SWORD_CURRENT_EXP=register("sword_current_experience",
            builder->builder.persistent(ExtraCodecs.NON_NEGATIVE_FLOAT));


    public static RegistryObject<DataComponentType<Integer>> SWORD_TOKENS=register("sword_tokens",
            builder->builder.persistent(ExtraCodecs.intRange(0,100)));


    public static RegistryObject<DataComponentType<AspectsCodecMap>> ASPECTS=register("aspects",
            builder->builder.persistent(AspectsCodecMap.CODEC));



    private static <T>RegistryObject<DataComponentType<T>> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return DATA_COMPONENTS.register(name, () -> builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void register(IEventBus bus) {
        DATA_COMPONENTS.register(bus);
    }
}
