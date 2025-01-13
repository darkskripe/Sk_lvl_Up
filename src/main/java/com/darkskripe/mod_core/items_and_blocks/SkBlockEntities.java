package com.darkskripe.mod_core.items_and_blocks;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.custom.UpgradeSmithBlockEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class SkBlockEntities {
   public static DeferredRegister<BlockEntityType<?>> SK_LVL_UP_BLOCK_ENTITIES =DeferredRegister.create(
            ForgeRegistries.BLOCK_ENTITY_TYPES, ModCore.MODID
    );

    public static final RegistryObject<BlockEntityType<UpgradeSmithBlockEntity>> UPGRADE_SMITH_BLOCK_ENTITY = SK_LVL_UP_BLOCK_ENTITIES
            .register("upgrade_smith",
                    ()->new BlockEntityType<>(UpgradeSmithBlockEntity::new,Set.of(SkBlocks.UPGRADE_SMITH_BLOCK.get()))
                            );

    public static void register(IEventBus eventBus) {
        SK_LVL_UP_BLOCK_ENTITIES.register(eventBus);
    }
}
