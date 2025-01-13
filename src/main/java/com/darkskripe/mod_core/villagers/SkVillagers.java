package com.darkskripe.mod_core.villagers;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.items_and_blocks.SkBlocks;
import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SkVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, ModCore.MODID);

    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, ModCore.MODID);

    public static final RegistryObject<PoiType> SKRIPERYA_UPGRADER_POI = POI_TYPES.register("skriperya_upgrader_poi",
            () -> new PoiType(ImmutableSet.copyOf(SkBlocks.UPGRADE_SMITH_BLOCK.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> SK_UPGRADER_SMITH =
            VILLAGER_PROFESSIONS.register("skriperya_upgrader_smith", () -> new VillagerProfession("skriperya_upgrader_smith",
                    holder -> holder.get() == SKRIPERYA_UPGRADER_POI.get(), holder -> holder.get() == SKRIPERYA_UPGRADER_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.VILLAGER_WORK_ARMORER));



    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}
