package io.cyb3rwarri0r8.commumod.lib.helpers;



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

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.PurifierRecipes;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class RegisterHelper {

    public static void registerBlock(Block block)
    {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5), Reference.MODID);
    }

    // ********************************************************************************************

    public static void regToolRecipe(Item item, Item x, Item y, String toolType)
    {
        if (toolType.equals("pickaxe"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "XXX",
                    " Y ",
                    " Y ",
                    'X', x, 'Y', y
            );
        }
        else if (toolType.equals("axe"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "XX ",
                    "XY ",
                    " Y ",
                    'X', x, 'Y', y
            );
        }
        else if (toolType.equals("shovel"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "X",
                    "Y",
                    "Y",
                    'X', x, 'Y', y
            );
        }
        else if (toolType.equals("hoe"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "XX",
                    " Y",
                    " Y",
                    'X', x, 'Y', y
            );
        }
        else if (toolType.equals("sword"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "X",
                    "X",
                    "Y",
                    'X', x, 'Y', y
            );
        }
        else
        {
            System.out.println("Error: Cannot register recipe!");
        }
    }

    // ********************************************************************************************

    public static void regArmorRecipe(Item item, Item x, String armortype)
    {
        if (armortype.equals("helmet"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "XXX",
                    "X X",
                    'X', x
            );
        }else if (armortype.equals("chestplate"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "X X",
                    "XXX",
                    "XXX",
                    'X', x
            );
        }else if (armortype.equals("leggings"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "XXX",
                    "X X",
                    "X X",
                    'X', x
            );
        } else if (armortype.equals("boots"))
        {
            GameRegistry.addRecipe(new ItemStack(item), 
                    "X X",
                    "X X",
                    'X', x
            );
        } else
        {
            FMLLog.severe("Error: Invalid Armor type: ", armortype);
        }
    }

    // ********************************************************************************************

    public static void registerEntity(Class entityClass, String name, int id)
    {
            long seed = name.hashCode();
            Random rand = new Random(seed);
            int primaryColor = rand.nextInt() * 16777215;
            int secondaryColor = rand.nextInt() * 16777215;
            EntityRegistry.registerModEntity(entityClass, name, id, Commumod.instance, 50, 1, false, primaryColor, secondaryColor);
    }

    public static void addPurifying(Item input, ItemStack output, float xp)
    {
        PurifierRecipes.smelting().addRecipe(input, output, xp);
    }

    public static void addBlockRecipe(Item item, ItemStack output)
    {
        GameRegistry.addRecipe(output,
                "XXX",
                "XXX",
                "XXX",
                'X', item
        );


    }

    public static void addStickRecipe(Item item, ItemStack output)
    {
        GameRegistry.addRecipe(output,
                "X",
                "X",
                'X', item
        );
    }

}
