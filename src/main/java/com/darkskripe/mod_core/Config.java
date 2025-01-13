package com.darkskripe.mod_core;

import com.darkskripe.mod_core.events.SkExperienceGain;
import com.darkskripe.mod_core.player_smith_lvl.smith_leveling.SkSmithLevels;
import com.darkskripe.mod_core.sword_smith_lvl.sword_classes.SwordClasses;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid =ModCore.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

//    private static final ForgeConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Whether to log the dirt block on common setup")
    ///           .define("logDirtBlock", true);

    private static final ForgeConfigSpec.FloatValue SWORD_EXP_COEF = BUILDER
            .comment("Coefficient that makes sword exp gaining harder(bigger value->harder)")
            .defineInRange("sword_experience_coef",1.5f,0,Float.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_I = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class I")
            .defineInRange("start_necessary_exp_class_I", 3, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_I = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class I")
            .defineInRange("exp_coef_class_I", 3, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_I = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 2 in sk smithing")
            .defineInRange("necessary_player_lvl_I", 1, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_I = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 2 in sk smithing")
            .defineInRange("necessary_smith_exp_I", 250, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_II = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class II")
            .defineInRange("start_necessary_exp_class_II", 35, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_II = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class II")
            .defineInRange("exp_coef_class_II", 3, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_II = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 3 in sk smithing")
            .defineInRange("necessary_player_lvl_II", 4, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_II = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 3 in sk smithing")
            .defineInRange("necessary_smith_exp_II", 500, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_III = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class III")
            .defineInRange("start_necessary_exp_class_III", 85, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_III = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class III")
            .defineInRange("exp_coef_class_III", 4, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_III = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 4 in sk smithing")
            .defineInRange("necessary_player_lvl_III", 10, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_III = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 4 in sk smithing")
            .defineInRange("necessary_smith_exp_III", 1400, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_IV = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class IV")
            .defineInRange("start_necessary_exp_class_IV", 170, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_IV = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class IV")
            .defineInRange("exp_coef_class_IV", 4, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_IV = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 5 in sk smithing")
            .defineInRange("necessary_player_lvl_IV", 13, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_IV = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 5 in sk smithing")
            .defineInRange("necessary_smith_exp_IV", 2200, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_V = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class V")
            .defineInRange("start_necessary_exp_class_V", 275, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_V = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class V")
            .defineInRange("exp_coef_class_V", 5, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_V = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 6 in sk smithing")
            .defineInRange("necessary_player_lvl_V", 15, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_V = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 6 in sk smithing")
            .defineInRange("necessary_smith_exp_V", 3300, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_VI = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class VI")
            .defineInRange("start_necessary_exp_class_VI", 460, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_VI = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class VI")
            .defineInRange("exp_coef_class_VI", 5, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_VI = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 7 in sk smithing")
            .defineInRange("necessary_player_lvl_VI", 17, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_VI = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 7 in sk smithing")
            .defineInRange("necessary_smith_exp_VI", 7000, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_VII = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class VII")
            .defineInRange("start_necessary_exp_class_VII", 700, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_VII = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class VII")
            .defineInRange("exp_coef_class_VII", 6, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_VII = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 8 in sk smithing")
            .defineInRange("necessary_player_lvl_VII", 20, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_VII = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 8 in sk smithing")
            .defineInRange("necessary_smith_exp_VII", 10000, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_VIII = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class VIII")
            .defineInRange("start_necessary_exp_class_VIII", 1050, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_VIII = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class VIII")
            .defineInRange("exp_coef_class_VIII", 6, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_VIII = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 9 in sk smithing")
            .defineInRange("necessary_player_lvl_VIII", 25, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_VIII = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 9 in sk smithing")
            .defineInRange("necessary_smith_exp_VIII", 25000, 0, Integer.MAX_VALUE);




    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_IX = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class IX")
            .defineInRange("start_necessary_exp_class_IX", 1500, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_IX = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class IX")
            .defineInRange("exp_coef_class_IX", 7, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_LVL_IX = BUILDER
            .comment("\nNecessary player lvl for reaching lvl 10 in sk smithing")
            .defineInRange("necessary_player_lvl_IX", 35, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue NECESSARY_PLAYER_SMITH_EXP_IX = BUILDER
            .comment("\nNecessary player smith exp for reaching lvl 10 in sk smithing")
            .defineInRange("necessary_smith_exp_IX", 50000, 0, Integer.MAX_VALUE);



    private static final ForgeConfigSpec.IntValue START_NECESSARY_EXP_CLASS_X = BUILDER
            .comment("\nNecessary exp with that sword starts leveling for class X")
            .defineInRange("start_necessary_exp_class_X", 2500, 0, Integer.MAX_VALUE);

    private static final ForgeConfigSpec.IntValue EXP_COEF_CLASS_X = BUILDER
            .comment("\nCoeficient for calculating next necessary exp for class X")
            .defineInRange("exp_coef_class_X", 10, 0, Integer.MAX_VALUE);



    //  public static final ForgeConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
    //          .comment("What you want the introduction message to be for the magic number")
    //          .define("magicNumberIntroduction", "The magic number is... ");



    // a list of strings that are treated as resource locations for items
    //   private static final ForgeConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
    //          .comment("A list of items to log on common setup.")
    //          .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), Config::validateItemName);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    //public static boolean logDirtBlock;
    //public static String magicNumberIntroduction;
    //public static Set<Item> items;

    //  private static boolean validateItemName(final Object obj)
    //  {
    //  return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(ResourceLocation.tryParse(itemName));
    //  }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        //   logDirtBlock = LOG_DIRT_BLOCK.get();
        //   magicNumberIntroduction = MAGIC_NUMBER_INTRODUCTION.get();

        // convert the list of strings into a set of items
        //    items = ITEM_STRINGS.get().stream()
        //            .map(itemName -> ForgeRegistries.ITEMS.getValue(ResourceLocation.tryParse(itemName)))
        //            .collect(Collectors.toSet());
        SkExperienceGain.swordExpCoef=SWORD_EXP_COEF.get();

        SwordClasses.CLASS_I.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_I.get());
        SwordClasses.CLASS_II.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_II.get());
        SwordClasses.CLASS_III.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_III.get());
        SwordClasses.CLASS_IV.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_IV.get());
        SwordClasses.CLASS_V.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_V.get());
        SwordClasses.CLASS_VI.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_VI.get());
        SwordClasses.CLASS_VII.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_VII.get());
        SwordClasses.CLASS_VIII.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_VIII.get());
        SwordClasses.CLASS_IX.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_IX.get());
        SwordClasses.CLASS_X.setStart_necessary_exp(START_NECESSARY_EXP_CLASS_X.get());

        SwordClasses.CLASS_I.setExp_coef(EXP_COEF_CLASS_I.get());
        SwordClasses.CLASS_II.setExp_coef(EXP_COEF_CLASS_II.get());
        SwordClasses.CLASS_III.setExp_coef(EXP_COEF_CLASS_III.get());
        SwordClasses.CLASS_IV.setExp_coef(EXP_COEF_CLASS_IV.get());
        SwordClasses.CLASS_V.setExp_coef(EXP_COEF_CLASS_V.get());
        SwordClasses.CLASS_VI.setExp_coef(EXP_COEF_CLASS_VI.get());
        SwordClasses.CLASS_VII.setExp_coef(EXP_COEF_CLASS_VII.get());
        SwordClasses.CLASS_VIII.setExp_coef(EXP_COEF_CLASS_VIII.get());
        SwordClasses.CLASS_IX.setExp_coef(EXP_COEF_CLASS_IX.get());
        SwordClasses.CLASS_X.setExp_coef(EXP_COEF_CLASS_X.get());

        SkSmithLevels.SMITH_LVL_I.setNecessary_player_level(NECESSARY_PLAYER_LVL_I.get());
        SkSmithLevels.SMITH_LVL_II.setNecessary_player_level(NECESSARY_PLAYER_LVL_II.get());
        SkSmithLevels.SMITH_LVL_III.setNecessary_player_level(NECESSARY_PLAYER_LVL_III.get());
        SkSmithLevels.SMITH_LVL_IV.setNecessary_player_level(NECESSARY_PLAYER_LVL_IV.get());
        SkSmithLevels.SMITH_LVL_V.setNecessary_player_level(NECESSARY_PLAYER_LVL_V.get());
        SkSmithLevels.SMITH_LVL_VI.setNecessary_player_level(NECESSARY_PLAYER_LVL_VI.get());
        SkSmithLevels.SMITH_LVL_VII.setNecessary_player_level(NECESSARY_PLAYER_LVL_VII.get());
        SkSmithLevels.SMITH_LVL_VIII.setNecessary_player_level(NECESSARY_PLAYER_LVL_VIII.get());
        SkSmithLevels.SMITH_LVL_IX.setNecessary_player_level(NECESSARY_PLAYER_LVL_IX.get());

        SkSmithLevels.SMITH_LVL_I.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_I.get());
        SkSmithLevels.SMITH_LVL_II.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_II.get());
        SkSmithLevels.SMITH_LVL_III.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_III.get());
        SkSmithLevels.SMITH_LVL_IV.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_IV.get());
        SkSmithLevels.SMITH_LVL_V.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_V.get());
        SkSmithLevels.SMITH_LVL_VI.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_VI.get());
        SkSmithLevels.SMITH_LVL_VII.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_VII.get());
        SkSmithLevels.SMITH_LVL_VIII.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_VIII.get());
        SkSmithLevels.SMITH_LVL_IX.setNecessary_smith_exp(NECESSARY_PLAYER_SMITH_EXP_IX.get());

    }
}
