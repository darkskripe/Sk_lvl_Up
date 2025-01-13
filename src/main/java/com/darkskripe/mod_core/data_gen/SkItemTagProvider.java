package com.darkskripe.mod_core.data_gen;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.SkItems;
import com.darkskripe.mod_core.util.SkTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class SkItemTagProvider extends ItemTagsProvider {
    public SkItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
                             CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, ModCore.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(SkTags.Items.SWORD_SOUL)
                .add(SkItems.NOVICE_SWORD_SOUL.get())
                .add(SkItems.ADEPT_SWORD_SOUL.get())
                .add(SkItems.MASTER_SWORD_SOUL.get())
                .add(SkItems.EMINENT_SWORD_SOUL.get());

        tag(SkTags.Items.SMITHS_HAMMER)
                .add(SkItems.NOVICE_SMITHS_HAMMER.get())
                .add(SkItems.ADEPT_SMITHS_HAMMER.get())
                .add(SkItems.MASTER_SMITHS_HAMMER.get())
                .add(SkItems.EMINENT_SMITHS_HAMMER.get());
    }
}
