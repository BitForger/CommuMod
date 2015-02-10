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
public class CraftingHandler implements IRecipe{

    @Override
    public boolean matches(InventoryCrafting p_77569_1_, World p_77569_2_) {
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
        ItemStack result = new ItemStack(ModItems.modularTool);
        result.getItem().setMaxDamage(finalDurability);

        return result;

    }

    @Override
    public int getRecipeSize() {
        return 0;
    }

    @Override
    public ItemStack getRecipeOutput() {
        return null;
    }
}
