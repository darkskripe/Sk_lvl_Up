package com.darkskripe.mod_core.util;

import com.darkskripe.mod_core.items_and_blocks.custom.UpgradeSmithBlockEntity;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.awt.*;

public abstract class EntityBlockItemCombinerMenu extends AbstractContainerMenu {
    private static final int INVENTORY_SLOTS_PER_ROW = 9;
    private static final int INVENTORY_ROWS = 3;
    private static final int INPUT_SLOT_START = 0;
    protected final ContainerLevelAccess access;
    protected final Player player;
    protected final BlockEntity blockEntity;
    protected final net.minecraft.world.Container inputSlots;
    protected final ResultContainer resultSlots = new ResultContainer() {
        @Override
        public void setChanged() {
            EntityBlockItemCombinerMenu.this.slotsChanged(this);
        }
    };
    private final int resultSlotIndex;

    protected boolean mayPickup(Player p_39798_, boolean p_39799_) {
        return true;
    }

    protected abstract void onTake(Player p_150601_, ItemStack p_150602_);

    protected abstract boolean isValidBlock(BlockState p_39788_);

    public EntityBlockItemCombinerMenu(@Nullable MenuType<?> menuType, int containerId, Inventory playerInventory, ContainerLevelAccess levelAccess, ItemCombinerMenuSlotDefinition itemCombinerMenuSlotDefinition,BlockEntity blockEntity) {
        super(menuType, containerId);
        this.access = levelAccess;
        this.player = playerInventory.player;
        this.blockEntity=blockEntity;
        this.inputSlots = this.createContainer(itemCombinerMenuSlotDefinition.getNumOfInputSlots());
        this.resultSlotIndex = itemCombinerMenuSlotDefinition.getResultSlotIndex();

        this.createInputSlots(itemCombinerMenuSlotDefinition,blockEntity);
        this.createResultSlot(itemCombinerMenuSlotDefinition,blockEntity);
        this.addStandardInventorySlots(playerInventory, 8, 84);
    }

    protected abstract<T extends BlockEntity> void createInputSlots(ItemCombinerMenuSlotDefinition p_267172_, T blockEntity);
   // {
   //     for (final ItemCombinerMenuSlotDefinition.SlotDefinition itemcombinermenuslotdefinition$slotdefinition : p_267172_.getSlots()) {
   //         entityBlockInv.ifPresent(inventory ->addSlot(
   //                 new Slot(
   //                         this.inputSlots,
   //                         itemcombinermenuslotdefinition$slotdefinition.slotIndex(),
   //                         itemcombinermenuslotdefinition$slotdefinition.x(),
   //                         itemcombinermenuslotdefinition$slotdefinition.y()
   //                 ) {
   //                     @Override
   //                     public boolean mayPlace(ItemStack p_39818_) {
   //                         return itemcombinermenuslotdefinition$slotdefinition.mayPlace().test(p_39818_);
   //                     }
   //                 }
   //                 )
   //         );
   //     }
   // }




    protected abstract<T extends BlockEntity> void createResultSlot(ItemCombinerMenuSlotDefinition p_267000_,T blockEntity);
   // {
   //     entityBlockInv.ifPresent(inventory->addSlot(
   //             new Slot(
   //                     this.resultSlots, p_267000_.getResultSlot().slotIndex(), p_267000_.getResultSlot().x(), p_267000_.getResultSlot().y()) {
   //                   @Override
   //                   public boolean mayPlace(ItemStack p_365170_) {
   //                       return false;
   //                   }
   //                   @Override
   //                   public boolean mayPickup(Player p_361935_) {
   //                       return EntityBlockItemCombinerMenu.this.mayPickup(p_361935_, this.hasItem());
   //                   }

    //                  @Override
    //                  public void onTake(Player p_365786_, ItemStack p_370147_) {
    //                    EntityBlockItemCombinerMenu.this.onTake(p_365786_, p_370147_);
    //                  }
    //            }
    //            )
   //     );
   // }

    public abstract void createResult();

    private SimpleContainer createContainer(int p_267204_) {
        return new SimpleContainer(p_267204_) {
            @Override
            public void setChanged() {
                super.setChanged();
                EntityBlockItemCombinerMenu.this.slotsChanged(this);
            }
        };
    }

    @Override
    public void slotsChanged(Container p_39778_) {
        super.slotsChanged(p_39778_);
        if (p_39778_ == this.inputSlots) {
            this.createResult();
        }
    }

    @Override
    public void removed(Player p_39790_) {
        super.removed(p_39790_);
      //  this.access.execute((p_39796_, p_39797_) -> this.clearContainer(p_39790_, this.inputSlots));
    }

    @Override
    public boolean stillValid(Player p_39780_) {
        return this.access.evaluate((p_327088_, p_327089_) -> !this.isValidBlock(p_327088_.getBlockState(p_327089_)) ? false : p_39780_.canInteractWithBlock(p_327089_, 4.0), true);
    }

    @Override
    public ItemStack quickMoveStack(Player p_39792_, int p_39793_) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(p_39793_);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            int i = this.getInventorySlotStart();
            int j = this.getUseRowEnd();
            if (p_39793_ == this.getResultSlot()) {
                if (!this.moveItemStackTo(itemstack1, i, j, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemstack1, itemstack);
            } else if (p_39793_ >= 0 && p_39793_ < this.getResultSlot()) {
                if (!this.moveItemStackTo(itemstack1, i, j, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (this.canMoveIntoInputSlots(itemstack1) && p_39793_ >= this.getInventorySlotStart() && p_39793_ < this.getUseRowEnd()) {
                if (!this.moveItemStackTo(itemstack1, 0, this.getResultSlot(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_39793_ >= this.getInventorySlotStart() && p_39793_ < this.getInventorySlotEnd()) {
                if (!this.moveItemStackTo(itemstack1, this.getUseRowStart(), this.getUseRowEnd(), false)) {
                    return ItemStack.EMPTY;
                }
            } else if (p_39793_ >= this.getUseRowStart() && p_39793_ < this.getUseRowEnd() && !this.moveItemStackTo(itemstack1, this.getInventorySlotStart(), this.getInventorySlotEnd(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(p_39792_, itemstack1);
        }

        return itemstack;
    }

    protected boolean canMoveIntoInputSlots(ItemStack p_39787_) {
        return true;
    }

    public int getResultSlot() {
        return this.resultSlotIndex;
    }

    private int getInventorySlotStart() {
        return this.getResultSlot() + 1;
    }

    private int getInventorySlotEnd() {
        return this.getInventorySlotStart() + 27;
    }

    private int getUseRowStart() {
        return this.getInventorySlotEnd();
    }

    private int getUseRowEnd() {
        return this.getUseRowStart() + 9;
    }


}
