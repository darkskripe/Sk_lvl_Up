package com.darkskripe.mod_core.gui.custom;

import com.darkskripe.mod_core.gui.SkMenu;
import com.darkskripe.mod_core.items_and_blocks.SkBlocks;
import com.darkskripe.mod_core.items_and_blocks.custom.UpgradeSmithBlockEntity;
import com.darkskripe.mod_core.recipes.UpgradeSmithRecipeInput;
import com.darkskripe.mod_core.util.EntityBlockItemCombinerMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeAccess;
import net.minecraft.world.item.crafting.RecipePropertySet;
import net.minecraft.world.item.crafting.SmithingRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class UpgradeSmithContainerMenu extends EntityBlockItemCombinerMenu {
    private final UpgradeSmithBlockEntity blockEntity;
    private final ContainerLevelAccess levelAccess;


    // Client Constructor
    public UpgradeSmithContainerMenu(int containerId, Inventory playerInv, FriendlyByteBuf additionalData) {
        this(containerId, playerInv, playerInv.player.level().getBlockEntity(additionalData.readBlockPos()),ContainerLevelAccess.NULL,playerInv.player.level());
    }

    // Server Constructor
    public UpgradeSmithContainerMenu(int containerId, Inventory playerInv, BlockEntity blockEntity, ContainerLevelAccess levelAccess, Level level) {
        super(SkMenu.UPGRADE_SMITH_CONTAINER_MENU.get(), containerId,playerInv,levelAccess,createInputSlotDefinitions(),blockEntity);
        if (blockEntity instanceof UpgradeSmithBlockEntity be) {
            this.blockEntity = be;
        } else {
            throw new IllegalStateException("Incorrect block entity class (%s) passed into ExampleMenu!"
                    .formatted(blockEntity.getClass().getCanonicalName()));
        }
        this.levelAccess = ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos());

        createPlayerHotbar(playerInv);
        createPlayerInventory(playerInv);
    }

    //adds slots for crafting
    private static ItemCombinerMenuSlotDefinition createInputSlotDefinitions() {
        return ItemCombinerMenuSlotDefinition.create()
                .withSlot(0, 8, 48, UpgradeSmithContainerHelper::getWeapon)
                .withSlot(1, 26, 48, UpgradeSmithContainerHelper::getHammer)
                .withSlot(2, 44, 48, UpgradeSmithContainerHelper::getMaterial)
                .withResultSlot(3, 98, 48)
                .build();
    }


    private void createPlayerInventory(Inventory playerInv) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                addSlot(new Slot(playerInv,
                        9 + column + (row * 9),
                        8 + (column * 18),
                        84 + (row * 18)));
            }
        }
    }

    private void createPlayerHotbar(Inventory playerInv) {
        for (int column = 0; column < 9; column++) {
            addSlot(new Slot(playerInv,
                    column,
                    8 + (column * 18),
                    142));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player pPlayer, int pIndex) {
        Slot fromSlot = getSlot(pIndex);
        ItemStack fromStack = fromSlot.getItem();

        if (fromStack.getCount() <= 0)
            fromSlot.set(ItemStack.EMPTY);

        if (!fromSlot.hasItem())
            return ItemStack.EMPTY;

        ItemStack copyFromStack = fromStack.copy();

        if (pIndex < 36) {
            // We are inside of the player's inventory
            if (!moveItemStackTo(fromStack, 36, 39, false))
                return ItemStack.EMPTY;
        } else if (pIndex < 39) {
            // We are inside of the block entity inventory
            if (!moveItemStackTo(fromStack, 0, 36, false))
                return ItemStack.EMPTY;
        } else {
            System.err.println("Invalid slot index: " + pIndex);
            return ItemStack.EMPTY;
        }

        fromSlot.setChanged();
        fromSlot.onTake(pPlayer, fromStack);

        return copyFromStack;
    }

    @Override
    protected void onTake(Player p_150601_, ItemStack p_150602_) {

    }

    @Override
    protected boolean isValidBlock(BlockState p_39788_) {
        return false;
    }


    @Override
    protected<T extends BlockEntity> void createInputSlots(ItemCombinerMenuSlotDefinition p_267172_, T blockEntity) {
        if(blockEntity instanceof UpgradeSmithBlockEntity be) {
        for (final ItemCombinerMenuSlotDefinition.SlotDefinition itemcombinermenuslotdefinition$slotdefinition : p_267172_.getSlots()) {
                     be.getOptionalInventory().ifPresent(inventory ->addSlot(
                             new SlotItemHandler(
                                     inventory,
                                     itemcombinermenuslotdefinition$slotdefinition.slotIndex(),
                                     itemcombinermenuslotdefinition$slotdefinition.x(),
                                     itemcombinermenuslotdefinition$slotdefinition.y()
                             ) {
                                 @Override
                                 public boolean mayPlace(ItemStack p_39818_) {
                                     return itemcombinermenuslotdefinition$slotdefinition.mayPlace().test(p_39818_);
                                 }
                             }
                             )
                     );
                 }
        }
    }



    @Override
    protected <T extends BlockEntity>void createResultSlot(ItemCombinerMenuSlotDefinition p_267000_, T blockEntity) {
        if(blockEntity instanceof UpgradeSmithBlockEntity be) {
        be.getOptionalInventory().ifPresent(inventory->addSlot(
                             new SlotItemHandler(
                                     inventory, p_267000_.getResultSlot().slotIndex(), p_267000_.getResultSlot().x(), p_267000_.getResultSlot().y()) {
                                   @Override
                                   public boolean mayPlace(ItemStack p_365170_) {
                                       return false;
                                   }
                                   @Override
                                   public boolean mayPickup(Player p_361935_) {
                                       return true;
                                   }

                                  @Override
                                  public void onTake(Player p_365786_, ItemStack p_370147_) {

                                  }
                            }
                            )
                     );
        }
    }



    @Override
    public void createResult() {
        UpgradeSmithRecipeInput upgradeSmithRecipeInput=this.createRecipeInput();

    }


    private UpgradeSmithRecipeInput createRecipeInput() {
        return new UpgradeSmithRecipeInput(this.inputSlots.getItem(0), this.inputSlots.getItem(1), this.inputSlots.getItem(2));
    }

    @Override
    public boolean stillValid(@NotNull Player pPlayer) {
        return stillValid(this.levelAccess, pPlayer, SkBlocks.UPGRADE_SMITH_BLOCK.get());
    }

    public UpgradeSmithBlockEntity getBlockEntity() {
        return this.blockEntity;
    }

}
