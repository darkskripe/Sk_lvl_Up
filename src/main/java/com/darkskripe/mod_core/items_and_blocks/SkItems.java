package com.darkskripe.mod_core.items_and_blocks;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.util.IItemRegister;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SkItems implements IItemRegister {
    public static final DeferredRegister<Item> SK_LVL_UP_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ModCore.MODID);

    public static final RegistryObject<Item> NOVICE_SWORD_SOUL = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"novice_sword_soul",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("novice_sword_soul"))
                    .rarity(Rarity.COMMON)
                    .component(DataComponents.MAX_STACK_SIZE,16)));

    public static final RegistryObject<Item> ADEPT_SWORD_SOUL = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"adept_sword_soul",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("adept_sword_soul"))
                    .rarity(Rarity.UNCOMMON)
                    .component(DataComponents.MAX_STACK_SIZE,16)));


    public static final RegistryObject<Item> MASTER_SWORD_SOUL = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"master_sword_soul",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("master_sword_soul"))
                    .rarity(Rarity.RARE)
                    .component(DataComponents.MAX_STACK_SIZE,16)));

    public static final RegistryObject<Item> EMINENT_SWORD_SOUL = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"eminent_sword_soul",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("eminent_sword_soul"))
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.MAX_STACK_SIZE,16)));

    public static final RegistryObject<Item> BLANK_ASPECT_COIN = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"blank_aspect_coin",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("blank_aspect_coin"))
                    .rarity(Rarity.RARE)
                    .component(DataComponents.MAX_STACK_SIZE,16)));

    public static final RegistryObject<Item> NOVICE_SMITHS_HAMMER = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"novice_smiths_hammer",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("novice_smiths_hammer"))
                    .rarity(Rarity.COMMON)
                    .component(DataComponents.MAX_STACK_SIZE,1)));

    public static final RegistryObject<Item> ADEPT_SMITHS_HAMMER = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"adept_smiths_hammer",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("adept_smiths_hammer"))
                    .rarity(Rarity.UNCOMMON)
                    .component(DataComponents.MAX_STACK_SIZE,1)));

    public static final RegistryObject<Item> MASTER_SMITHS_HAMMER = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"master_smiths_hammer",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("master_smiths_hammer"))
                    .rarity(Rarity.RARE)
                    .component(DataComponents.MAX_STACK_SIZE,1)));

    public static final RegistryObject<Item> EMINENT_SMITHS_HAMMER = IItemRegister.registerItem(SK_LVL_UP_ITEMS,"eminent_smiths_hammer",
            () -> new Item(new Item.Properties()
                    .setId(SK_LVL_UP_ITEMS.key("eminent_smiths_hammer"))
                    .rarity(Rarity.EPIC)
                    .component(DataComponents.MAX_STACK_SIZE,1)));

    public static void register(IEventBus eventBus) {
        SK_LVL_UP_ITEMS.register(eventBus);
    }
}
