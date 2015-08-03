package io.cyb3rwarri0r8.commumod.lib.helpers;


import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.PurifierRecipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;


public class RegisterHelper {

    public static void registerBlock(Block block)
    {
        GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void regToolRecipe(Item item, Item x, Item y, String toolType)
    {
        if (toolType == "pickaxe")
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
            System.out.println("Error: Invalid Armor type!");
        }
    }

    // ********************************************************************************************

    public static void registerEntity(Class entityClass, String name)
    {

        long seed = name.hashCode();
        Random rand = new Random(seed);
//        int primaryColor = rand.nextInt() * 16777215;
//        int secondaryColor = rand.nextInt() * 16777215;
        int entityID = rand.nextInt() * 54;

        EntityRegistry.registerModEntity(entityClass, name, entityID, Commumod.instance, 64, 1, true);

    }

    // ********************************************************************************************
    public static void addPurifying(Item input, ItemStack output, float xp)
    {
        PurifierRecipes.smelting().addRecipe(input, output, xp);
    }

    // ********************************************************************************************
    public static void addBlockRecipe(Item item, ItemStack output)
    {
        GameRegistry.addRecipe(output,
                "XXX",
                "XXX",
                "XXX",
                'X', item
        );


    }

    // *********************************************************************************************
    public static void addStickRecipe(Item item, ItemStack output)
    {
        GameRegistry.addRecipe(output,
                "X",
                "X",
                'X', item
        );
    }

}
