package io.cyb3rwarri0r8.commumod.lib;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

public class IRecipeModularPickaxe implements IRecipe{

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        ItemStack item1 = crafting.getStackInRowAndColumn(0,0);
        ItemStack item2 = crafting.getStackInRowAndColumn(1,0);
        ItemStack item3 = crafting.getStackInRowAndColumn(2,0);
        ItemStack stick1 = crafting.getStackInRowAndColumn(1,1);
        ItemStack stick2 = crafting.getStackInRowAndColumn(1,2);

        if((stick1.getItem() == ModItems.diamondToolRod && stick2.getItem() == ModItems.diamondToolRod)
        || (stick1.getItem() == ModItems.ironToolRod    && stick2.getItem() == ModItems.ironToolRod)
        || (stick1.getItem() == ModItems.goldToolRod    && stick2.getItem() == ModItems.goldToolRod)
        || (stick1.getItem() == ModItems.stoneToolRod   && stick2.getItem() == ModItems.stoneToolRod))
        {
            if((item1.getItem() == Items.iron_ingot                          && item2.getItem() == Items.iron_ingot                          && item3.getItem() == Items.iron_ingot)
            || (item1.getItem() == Items.emerald                             && item2.getItem() == Items.emerald                             && item3.getItem() == Items.emerald)
            || (item1.getItem() == Items.diamond                             && item2.getItem() == Items.diamond                             && item3.getItem() == Items.diamond)
            || (item1.getItem() == Item.getItemFromBlock(Blocks.gold_block)  && item2.getItem() == Item.getItemFromBlock(Blocks.gold_block)  && item3.getItem() == Item.getItemFromBlock(Blocks.gold_block)
            || (item1.getItem() == Item.getItemFromBlock(Blocks.cobblestone) && item2.getItem() == Item.getItemFromBlock(Blocks.cobblestone) && item3.getItem() == Item.getItemFromBlock(Blocks.cobblestone))))

            {
                return true;
            }
        }
        return false;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        //Durability
        int ironDurability = Item.ToolMaterial.IRON.getMaxUses();
        int finalDurability = ironDurability;

        // Loop through crafting grid
        for (int i = 0; i < 3; i++)
        {
            ItemStack headComponent = inventoryCrafting.getStackInRowAndColumn(i,0);
            if (headComponent.getItem() == Items.diamond | headComponent.getItem() == Items.emerald)
            {
                finalDurability += 150;
            }
            else if(headComponent.getItem() == Items.iron_ingot)
            {
                finalDurability = ironDurability;
            }
            else if(headComponent.getItem() == Item.getItemFromBlock(Blocks.gold_block))
            {
                finalDurability -= 100;
            }
            else if (headComponent.getItem() == Item.getItemFromBlock(Blocks.cobblestone))
            {
                finalDurability -= 25;
            }
            else if(headComponent.getItem() == Item.getItemFromBlock(Blocks.planks))
            {
                finalDurability -= 50;
            }
        }
        ItemStack result = new ItemStack(ModItems.modularPickaxe);
        result.getItem().setMaxDamage(finalDurability);

        return result;

    }

    @Override
    public int getRecipeSize() {
        return 9;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return new ItemStack(ModItems.modularPickaxe);
    }

    @Override
    public ItemStack[] getRemainingItems(InventoryCrafting p_179532_1_) {
        return new ItemStack[0];
    }


    public ItemStack[] func_179532_b(InventoryCrafting p_179532_1_) {
        return new ItemStack[0];
    }

}
