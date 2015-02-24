package io.cyb3rwarri0r8.commumod.lib;


import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class IRecipeModularPickaxe implements IRecipe{

    @Override
    public boolean matches(InventoryCrafting crafting, World world) {
        ItemStack item1 = crafting.getStackInRowAndColumn(0,0);
        ItemStack item2 = crafting.getStackInRowAndColumn(1,0);
        ItemStack item3 = crafting.getStackInRowAndColumn(2,0);
        ItemStack stick1 = crafting.getStackInRowAndColumn(1,1);
        ItemStack stick2 = crafting.getStackInRowAndColumn(1,2);

        if(stick1.getItem() == ModItems.diamondToolRod | stick1.getItem() == ModItems.goldToolRod | stick1.getItem() == ModItems.ironToolRod | stick1.getItem() == ModItems.stoneToolRod
                && stick2.getItem() == ModItems.diamondToolRod | stick2.getItem() == ModItems.stoneToolRod | stick2.getItem() == ModItems.ironToolRod | stick2.getItem() == ModItems.goldToolRod)
        {
            if(item1.getItem() == Items.iron_ingot | item1.getItem() == Items.emerald | item1.getItem() == Items.diamond | item1.getItem() == Item.getItemFromBlock(Blocks.gold_block) | item1.getItem() == Item.getItemFromBlock(Blocks.stone)
                    && item2.getItem() == Items.iron_ingot | item2.getItem() == Items.emerald | item2.getItem() == Items.diamond | item2.getItem() == Item.getItemFromBlock(Blocks.gold_block) | item2.getItem() == Item.getItemFromBlock(Blocks.stone)
                    && item3.getItem() == Items.iron_ingot | item3.getItem() == Items.emerald | item3.getItem() == Items.diamond | item3.getItem() == Item.getItemFromBlock(Blocks.gold_block) | item3.getItem() == Item.getItemFromBlock(Blocks.stone))
            {
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
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

}
