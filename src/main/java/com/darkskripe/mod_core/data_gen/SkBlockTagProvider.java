package com.darkskripe.mod_core.data_gen;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SkBlockTagProvider extends BlockTagsProvider {
    public SkBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, ModCore.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
     //   tag(BlockTags.NEEDS_DIAMOND_TOOL)
     //           .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
    }
}
