package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.SkItems;
import com.darkskripe.mod_core.villagers.SkVillagers;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


@Mod.EventBusSubscriber(modid = ModCore.MODID)
public class SkTrades {
       //  package net.minecraft.world.entity.npc;

        @SubscribeEvent
        public static void addCustomTrades(VillagerTradesEvent event) {
            ModCore.LOGGER.info("Registering villager trades");

            if(event.getType() == SkVillagers.SK_UPGRADER_SMITH.get()) {
                Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.NOVICE_SWORD_SOUL.get(), RandomSource.create().nextInt(15,17)),
                        new ItemStack(SkItems.ADEPT_SWORD_SOUL.get(), 1),
                        10, 8, 0.01f));

                trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.ADEPT_SWORD_SOUL.get(), 1),
                        new ItemStack(SkItems.NOVICE_SWORD_SOUL.get(), RandomSource.create().nextInt(11,15)),
                        10, 8, 0.01f));


                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.ADEPT_SWORD_SOUL.get(), RandomSource.create().nextInt(15,17)),
                        new ItemStack(SkItems.MASTER_SWORD_SOUL.get(), 1),
                        10, 18, 0.01f));


                trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.MASTER_SWORD_SOUL.get(), 1),
                        new ItemStack(SkItems.ADEPT_SWORD_SOUL.get(), RandomSource.create().nextInt(11,15)),
                        10, 18, 0.01f));


                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.MASTER_SWORD_SOUL.get(), RandomSource.create().nextInt(15,17)),
                        new ItemStack(SkItems.EMINENT_SWORD_SOUL.get(), 1),
                        7, 25, 0.01f));

                trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.EMINENT_SWORD_SOUL.get(), 1),
                        new ItemStack(SkItems.MASTER_SWORD_SOUL.get(), RandomSource.create().nextInt(11,15)),
                        7, 25, 0.01f));

                trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                        new ItemCost(SkItems.MASTER_SWORD_SOUL.get(), RandomSource.create().nextInt(4,8)),
                        new ItemStack(SkItems.BLANK_ASPECT_COIN.get(), 1),
                        7, 25, 0.01f));
            }
        }

   //     @SubscribeEvent
   //     public static void addCustomWanderingTrades(WandererTradesEvent event) {
   //         List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
    //        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

    //        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
    //                new ItemStack(Items.EMERALD, 12),
    //                new ItemStack(ModItems.SAPPHIRE_BOOTS.get(), 1),
    //                3, 2, 0.2f));

    //        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
     //               new ItemStack(Items.EMERALD, 24),
     //               new ItemStack(ModItems.METAL_DETECTOR.get(), 1),
     //               2, 12, 0.15f));
     //   }

}
