package com.darkskripe.mod_core.events;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.sword_smith_lvl.UsableWeaponClasses;
import com.darkskripe.mod_core.sword_smith_lvl.component.SkComponents;
import com.darkskripe.mod_core.sword_smith_lvl.sword_classes.SwordClasses;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Objects;

@Mod.EventBusSubscriber(modid = ModCore.MODID)

public class SkToolTips {

    @SubscribeEvent
    public static void addToolTip(ItemTooltipEvent event) {
        String freeSpaceComponent="components.sk_lvl_up.tooltip.free_space";
        List<Component> tooltip = event.getToolTip();
        ItemStack stack=event.getItemStack();

        if(UsableWeaponClasses.isInUsedWeaponClasses(stack.getItem())&&stack.getComponents().has(SkComponents.SWORD_CLASS.get())) {
            tooltip.add(Component.translatable(freeSpaceComponent));
            if(Screen.hasShiftDown()) {
                int swordClassInt=stack.getComponents().get(SkComponents.SWORD_CLASS.get());
                String swordClassName = getSwordClassName(swordClassInt);
                int currentLevel=getSwordLevel(stack);

                tooltip.add(Component.translatable("components.sk_lvl_up.tooltip.sword_class", swordClassName).setStyle(Style.EMPTY.withItalic(true).withColor(TextColor.parseColor(getSwordClassColor(swordClassInt)).getOrThrow())));
                if (SwordClasses.SWORD_CLASSES.get(swordClassInt).getMax_lvl()==currentLevel) {
                    tooltip.add(Component.translatable("components.sk_lvl_up.tooltip.sword_lvl_max_level",currentLevel).setStyle(Style.EMPTY.withItalic(true)));
                }else tooltip.add(Component.translatable("components.sk_lvl_up.tooltip.sword_lvl",currentLevel).setStyle(Style.EMPTY.withItalic(true)));
                tooltip.add(Component.translatable("components.sk_lvl_up.tooltip.sword_current_exp",getCurrentExp(stack),getNecessaryExp(swordClassInt,currentLevel)).setStyle(Style.EMPTY.withItalic(true)));

            }else tooltip.add(Component.translatable("components.sk_lvl_up.tooltip.press_shift"));
            tooltip.add(Component.translatable(freeSpaceComponent));
        }

    }
    private static int getNecessaryExp(int swordClass,int currentLevel) {
        int firstExp=SwordClasses.SWORD_CLASSES.get(swordClass).getStart_necessary_exp();
        if(currentLevel==1)return firstExp;
        else return firstExp+Math.round(SwordClasses.SWORD_CLASSES.get(swordClass).getExp_coef()*1.035f*currentLevel);
    }

    private static float getCurrentExp(ItemStack stack) {
        return stack.getComponents().get(SkComponents.SWORD_CURRENT_EXP.get());
    }

    private static int getSwordLevel(ItemStack stack) {
        return stack.getComponents().get(SkComponents.SWORD_CURRENT_LVL.get());
    }

    private static String getSwordClassColor(int swordClass) {
        return SwordClasses.SWORD_CLASSES.get(swordClass).getColor();
    }

    private static String getSwordClassName(int swordClass) {
       return SwordClasses.SWORD_CLASSES.get(swordClass).getName();
    }
}
