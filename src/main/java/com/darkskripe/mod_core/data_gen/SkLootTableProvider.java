package com.darkskripe.mod_core.data_gen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Set;

public class SkLootTableProvider extends BlockLootSubProvider {
    protected SkLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
  //      dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
  //      dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
   //     // dropSelf(ModBlocks.MAGIC_BLOCK.get());

  //      this.add(ModBlocks.ALEXANDRITE_ORE.get(),
   //             block -> createOreDrop(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get()));
   //     this.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(),
   //             block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 2, 6));
    }

   // protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
   //     HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
   //     return this.createSilkTouchDispatchTable(
   //             pBlock, this.applyExplosionDecay(
   //                     pBlock, LootItem.lootTableItem(item)
   //                             .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
   //                             .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
   //             )
    //    );
   // }

  //  @Override
  //  protected Iterable<Block> getKnownBlocks() {
   //     return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
  //  }
}
