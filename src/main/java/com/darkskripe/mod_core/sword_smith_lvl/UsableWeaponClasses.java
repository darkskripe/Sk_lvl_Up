package com.darkskripe.mod_core.sword_smith_lvl;

import com.darkskripe.mod_core.ModCore;
import net.minecraft.world.item.*;

import java.util.ArrayList;
import java.util.List;

public class UsableWeaponClasses {
    private static List<Class<?>> usable_weapons_classes=new ArrayList<>();

    static {
        usable_weapons_classes.add(SwordItem.class);
        usable_weapons_classes.add(TridentItem.class);
        usable_weapons_classes.add(MaceItem.class);
    }

    public static void addClass(Class<?> weapon_class) {
        usable_weapons_classes.add(weapon_class);
    }

    public static boolean isInUsedWeaponClasses(Object item) {
        return usable_weapons_classes.contains(item.getClass())||usable_weapons_classes.contains(item.getClass().getSuperclass());
    }





}
