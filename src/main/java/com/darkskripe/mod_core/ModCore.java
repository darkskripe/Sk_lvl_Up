package com.darkskripe.mod_core;

import com.darkskripe.mod_core.creative_tabs.SkCreativeTabs;
import com.darkskripe.mod_core.gui.SkMenu;
import com.darkskripe.mod_core.items_and_blocks.SkBlockEntities;
import com.darkskripe.mod_core.items_and_blocks.SkObjectReg;
import com.darkskripe.mod_core.recipes.SkRecipeTypes;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import com.darkskripe.mod_core.villagers.SkVillagers;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ModCore.MODID)
public class ModCore
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "sk_lvl_up";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();



    public ModCore(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        LOGGER.info("Faza 1 ");

        SkObjectReg.register(modEventBus);
        SkVillagers.register(modEventBus);
        SkBlockEntities.register(modEventBus);
        SkMenu.register(modEventBus);
        SkCreativeTabs.register(modEventBus);
        SkComponents.register(modEventBus);
        SkRecipeTypes.registerRecipeTypes(modEventBus);

        // MenuScreensReg.registerScreens();
        LOGGER.info("Faza 1 SUCCES ");
        LOGGER.info("Faza 2 ");
        LOGGER.info("Faza 2 SUCCES ");



        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);


        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }



    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
