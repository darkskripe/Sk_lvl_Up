package com.darkskripe.mod_core.items_and_blocks;


import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.custom.UpgradeSmithBlock;
import com.darkskripe.mod_core.util.IBlockRegister;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmithingTableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SkBlocks implements IBlockRegister {
    public static final DeferredRegister<Block> SK_LVL_UP_BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ModCore.MODID);

    public static final RegistryObject<Block> UPGRADE_SMITH_BLOCK = IBlockRegister.registerBlock(SK_LVL_UP_BLOCKS,"upgrade_smith",
            () -> new UpgradeSmithBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SMITHING_TABLE)
                    .lightLevel((state) -> 5)
                    .setId(SK_LVL_UP_BLOCKS.key("upgrade_smith"))
            )
    );

    protected static void registerSimpleBlocks(IEventBus eventBus) {
        SK_LVL_UP_BLOCKS.register(eventBus);
    }

}
