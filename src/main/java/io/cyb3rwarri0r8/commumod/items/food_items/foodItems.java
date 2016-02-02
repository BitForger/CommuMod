package io.cyb3rwarri0r8.commumod.items.food_items;



/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class foodItems {

    public static Item superCarrot = new FoodSuperCarrot(5, 5, false);
    public static Item ticTac = new FoodTicTac(3,3,false);
    public static Item ticTacCase = new FoodTicTacCase();



    public static void loadFood()
    {
        RegisterHelper.registerItem(superCarrot);
        GameRegistry.addRecipe(new ItemStack(superCarrot),
                "XXX",
                "XYX",
                "XXX",
                'X', Blocks.gold_block, 'Y', Items.apple
        );

        RegisterHelper.registerItem(ticTac);
        GameRegistry.addRecipe(new ItemStack(ticTac),
                "   ",
                " Y ",
                " X ",
                'Y', Items.dye, 'X', Items.sugar
        );

        RegisterHelper.registerItem(ticTacCase);
        GameRegistry.addShapelessRecipe(new ItemStack(ticTacCase), ModItems.plastic,ModItems.plastic,ModItems.plastic,ModItems.plastic);
    }
}
