package com.darkskripe.mod_core.items_and_blocks.custom;

import com.darkskripe.mod_core.ModCore;
import com.darkskripe.mod_core.gui.custom.UpgradeSmithContainerMenu;
import com.darkskripe.mod_core.items_and_blocks.SkBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UpgradeSmithBlockEntity extends BlockEntity implements MenuProvider {
    private static final Component TITLE =
            Component.translatable("container." + ModCore.MODID + ".example_sided_inventory_block");

    private final ItemStackHandler inventory = new ItemStackHandler(4){
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> optionalInventory = LazyOptional.of(() -> this.inventory);

    private final ItemStackHandler topInventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            setChanged();
        }
    };

    private final LazyOptional<ItemStackHandler> topOptional = LazyOptional.of(() -> this.topInventory);





    public UpgradeSmithBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(SkBlockEntities.UPGRADE_SMITH_BLOCK_ENTITY.get(), pPos, pBlockState);
    }





    @Override
    protected void loadAdditional(CompoundTag nbt, HolderLookup.Provider lookup) {
        super.loadAdditional(nbt, lookup);
        CompoundTag customData = nbt.getCompound(ModCore.MODID);

        if(customData.contains("inventoty", Tag.TAG_COMPOUND)) {
            this.inventory.deserializeNBT(lookup,customData.getCompound("inventoty"));
        }
    }



    @Override
    protected void saveAdditional(CompoundTag nbt, HolderLookup.Provider lookUp) {
        super.saveAdditional(nbt,lookUp);
        var NbtData = new CompoundTag();
        NbtData.put("inventoty", this.inventory.serializeNBT(lookUp));
        nbt.put(ModCore.MODID, NbtData);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
       return this.optionalInventory.cast();
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.optionalInventory.invalidate();
    }

    @Override
    public void setChanged() {
        super.setChanged();

        if (this.level != null && this.level.isClientSide())
            this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public LazyOptional<ItemStackHandler> getTopOptional() {
        return this.topOptional;
    }

    public LazyOptional<ItemStackHandler> getOptionalInventory() {
        return this.optionalInventory;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return TITLE;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, @NotNull Inventory pPlayerInventory, @NotNull Player pPlayer) {
        return new UpgradeSmithContainerMenu(pContainerId, pPlayerInventory,this, ContainerLevelAccess.create(this.getLevel(), this.getBlockPos()),
                this.level);
    }
}
