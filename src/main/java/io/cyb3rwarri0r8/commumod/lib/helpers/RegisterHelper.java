package io.cyb3rwarri0r8.commumod.lib.helpers;


import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.commumod.lib.PurifierRecipes;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Random;


public class RegisterHelper {

    public static void registerBlock(Block block)
    {
        GameRegistry.registerBlock(block, Reference.MODID + " " + block.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void registerItem(Item item)
    {
        GameRegistry.registerItem(item, Reference.MODID + " " + item.getUnlocalizedName().substring(5));
    }

    // ********************************************************************************************

    public static void regToolRecipe(Item item, Item x, Item y, String toolType)
    {
        if (toolType == "pickaxe")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "XXX",
                    " Y ",
                    " Y ",
                    'X', x, 'Y', y,
            });
        }
        else if (toolType == "axe")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "XX ",
                    "XY ",
                    " Y ",
                    'X', x, 'Y', y,
            });
        }
        else if (toolType == "shovel")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    " X ",
                    " Y ",
                    " Y ",
                    'X', x, 'Y', y,
            });
        }
        else if (toolType == "hoe")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "XX ",
                    " Y ",
                    " Y ",
                    'X', x, 'Y', y,
            });
        }
        else if (toolType == "sword")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    " X ",
                    " X ",
                    " Y ",
                    'X', x, 'Y', y,
            });
        }
        else
        {
            System.out.println("Error: Cannot register recipe!");
        }
    }

    // ********************************************************************************************

    public static void regArmorRecipe(Item item, Item x, String armortype)
    {
        if (armortype == "helmet")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "XXX",
                    "X X",
                    'X', x
            });
        }else if (armortype == "chestplate")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "X X",
                    "XXX",
                    "XXX",
                    'X', x,
            });
        }else if (armortype == "leggings")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "XXX",
                    "X X",
                    "X X",
                    'X', x,
            });
        } else if (armortype == "boots")
        {
            GameRegistry.addRecipe(new ItemStack(item), new Object[]{
                    "X X",
                    "X X",
                    'X', x
            });
        } else
        {
            System.out.println("Error: Invalid Armor type!");
        }
    }

    // ********************************************************************************************

    public static void registerEntity(Class entityClass, String name)
    {

        int entityID = EntityRegistry.findGlobalUniqueEntityId();
        long seed = name.hashCode();
        Random rand = new Random(seed);
        int primaryColor = rand.nextInt() * 16777215;
        int secondaryColor = rand.nextInt() * 16777215;

        EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
        EntityRegistry.registerModEntity(entityClass, name, entityID, io.cyb3rwarri0r8.commumod.main.instance, 64, 1, true);
        EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));

    }

    public static void addPurifying(Item input, ItemStack output, float xp)
    {
        PurifierRecipes.smelting().addRecipe(input, output, xp);
    }

    public static void addBlockRecipe(Item item, ItemStack output)
    {
        GameRegistry.addRecipe(output, new Object[]{
                "XXX",
                "XXX",
                "XXX",
                'x',item
        });


    }

}
