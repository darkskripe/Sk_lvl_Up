package com.darkskripe.mod_core.util;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class SkTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(ModCore.MODID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SWORD_SOUL = createTag("sword_soul");
        public static final TagKey<Item> SMITHS_HAMMER = createTag("smiths_hammer");
        public static final TagKey<Item> ASPECT_COIN = createTag("aspect_coin");
        public static final TagKey<Item> SWORD_REBORN_COIN = createTag("sword_reborn_coin");



        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(ModCore.MODID, name));
        }
    }
}
