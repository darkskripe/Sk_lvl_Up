package com.darkskripe.mod_core.recipes;

import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.Optional;

public interface UpgradeSmithRecipe extends Recipe<UpgradeSmithRecipeInput> {
    @Override
    default RecipeType<UpgradeSmithRecipe> getType() {
        return SkRecipeTypes.UPGRADE_SMITH_RECIPE_TYPE.get();
    }

    @Override
    RecipeSerializer<? extends UpgradeSmithRecipe> getSerializer();

    default boolean matches(UpgradeSmithRecipeInput p_363830_, Level p_369755_) {
        return Ingredient.testOptionalIngredient(this.templateIngredient(), p_363830_.template())
                && Ingredient.testOptionalIngredient(this.baseIngredient(), p_363830_.base())
                && Ingredient.testOptionalIngredient(this.additionIngredient(), p_363830_.addition());
    }

    Optional<Ingredient> templateIngredient();

    Optional<Ingredient> baseIngredient();

    Optional<Ingredient> additionIngredient();

    @Override
    default RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.SMITHING;
    }
}
