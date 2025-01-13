package com.darkskripe.mod_core.gui.custom;

import com.darkskripe.mod_core.sword_smith_lvl.UsableWeaponClasses;
import com.darkskripe.mod_core.util.SkTags;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class UpgradeSmithContainerHelper {
    public static boolean getWeapon(@NotNull ItemStack itemStack) {
        return UsableWeaponClasses.isInUsedWeaponClasses(itemStack.getItem());
    }

    public static boolean getHammer(@NotNull ItemStack itemStack) {
        return itemStack.is(SkTags.Items.SMITHS_HAMMER);
    }

    public static boolean getMaterial(@NotNull ItemStack itemStack) {
        return itemStack.is(SkTags.Items.SWORD_REBORN_COIN)||itemStack.is(SkTags.Items.ASPECT_COIN);
    }



}
