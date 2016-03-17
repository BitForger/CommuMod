package io.cyb3rwarri0r8.commumod.client.container;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.entity.TileEntityPurifier;
import io.cyb3rwarri0r8.commumod.lib.PurifierRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerPurifier extends Container{

    private TileEntityPurifier tileEntity;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerPurifier(InventoryPlayer player, TileEntityPurifier tileEntity) {
        this.tileEntity = tileEntity;
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnaceOutput(player.player,tileEntity,2,116,35));
        int i;
        for ( i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                this.addSlotToContainer(new Slot(player,j+i*9+9,8+j*18,84+i*18));
            }
        }
        for ( i = 0; i < 9; i++)
        {
            this.addSlotToContainer(new Slot(player, i, 8+i*18,142));
        }
    }


    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();
	    for ( ICrafting crafter : this.crafters ) {
		    ICrafting craft = ( ICrafting ) crafter;
		    if ( this.lastCookTime != this.tileEntity.furnaceCookTime ) {
			    craft.sendProgressBarUpdate( this, 0, this.tileEntity.furnaceCookTime );
		    }
		    if ( this.lastBurnTime != this.tileEntity.furnaceBurnTime ) {
			    craft.sendProgressBarUpdate( this, 1, this.tileEntity.furnaceBurnTime );
		    }

		    if ( this.lastItemBurnTime != this.tileEntity.currentBurnTime ) {
			    craft.sendProgressBarUpdate( this, 2, this.tileEntity.currentBurnTime );
		    }

	    }

        this.lastBurnTime = this.tileEntity.furnaceBurnTime;
        this.lastCookTime = this.tileEntity.furnaceCookTime;
        this.lastItemBurnTime = this.tileEntity.currentBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {

        if(par1 == 0)
        {
            this.tileEntity.furnaceCookTime = par2;
        }

        if(par1 == 1)
        {
            this.tileEntity.furnaceBurnTime = par2;
        }

        if(par1 == 2)
        {
            this.tileEntity.currentBurnTime = par2;
        }


    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.tileEntity.isUseableByPlayer(player);
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int par2)
    {
        ItemStack itemStack = null;
        Slot slot = (Slot) this.inventorySlots.get(par2);
        if(slot != null && slot.getHasStack())
        {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if(par2 == 2)
            {
                if(!this.mergeItemStack(itemStack1,3,39,true)){
                    return null;
                }
                slot.onSlotChange(itemStack1,itemStack);

            }else if(par2 != 1 && par2 != 0)
            {
                if(PurifierRecipes.smelting().getSmeltingResult(itemStack1) != null)
                {
                    if(!this.mergeItemStack(itemStack1,0,1,false)){
                        return null;
                    }
                }
            }else if(TileEntityPurifier.isItemFuel(itemStack1))
            {
                if(!this.mergeItemStack(itemStack1,1,2,false)){
                    return null;
                }
            }else if(par2 >=3 && par2 < 30)
            {
                if(!this.mergeItemStack(itemStack1,30,39,false))
                {
                    return null;
                }else if(par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemStack1,3,30,false))
                {
                    return null;
                }
            }else if(!this.mergeItemStack(itemStack1, 3, 39, false)){
                return null;
            }
            if(itemStack1.stackSize == 0)
            {
                slot.putStack(null);
            }else{
                slot.onSlotChanged();
            }
            if(itemStack1.stackSize == itemStack.stackSize)
            {
                return null;
            }
            slot.onPickupFromSlot(player, itemStack1);
        }
        return itemStack;
    }
}
