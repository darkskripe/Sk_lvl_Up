package com.darkskripe.mod_core.recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record UpgradeSmithRecipeInput (ItemStack template, ItemStack base, ItemStack addition) implements RecipeInput {
    @Override
    public ItemStack getItem(int p_343148_) {
        return switch (p_343148_) {
            case 0 -> this.template;
            case 1 -> this.base;
            case 2 -> this.addition;
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + p_343148_);
        };
    }

    @Override
    public int size() {
        return 3;
    }

    @Override
    public boolean isEmpty() {
        return this.template.isEmpty() && this.base.isEmpty() && this.addition.isEmpty();
    }
}
