package io.cyb3rwarri0r8.commumod.lib.helpers;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.EventToolRecipeFailed;
import io.cyb3rwarri0r8.commumod.lib.PurifierRecipes;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.S42PacketCombatEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.EventBus;
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
        GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
        FMLLog.info( item.getUnlocalizedName().substring( 5 ) );
    }

    // ********************************************************************************************

    public static void regToolRecipe(Item item, Item x, Item y, String toolType)
    {
        switch ( toolType ) {
            case "pickaxe":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "XXX",
                        " Y ",
                        " Y ",
                        'X', x, 'Y', y
                );
                break;
            case "axe":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "XX ",
                        "XY ",
                        " Y ",
                        'X', x, 'Y', y
                );
                break;
            case "shovel":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "X",
                        "Y",
                        "Y",
                        'X', x, 'Y', y
                );
                break;
            case "hoe":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "XX",
                        " Y",
                        " Y",
                        'X', x, 'Y', y
                );
                break;
            case "sword":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "X",
                        "X",
                        "Y",
                        'X', x, 'Y', y
                );
                break;
            default:
                System.out.println( "Error: Cannot register recipe!" );
                break;
        }
    }

    // ********************************************************************************************

    public static void regArmorRecipe(Item item, Item x, String armortype)
    {
        switch ( armortype ) {
            case "helmet":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "XXX",
                        "X X",
                        'X', x
                );
                break;
            case "chestplate":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "X X",
                        "XXX",
                        "XXX",
                        'X', x
                );
                break;
            case "leggings":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "XXX",
                        "X X",
                        "X X",
                        'X', x
                );
                break;
            case "boots":
                GameRegistry.addRecipe( new ItemStack( item ),
                        "X X",
                        "X X",
                        'X', x
                );
                break;
            default:
                FMLLog.severe( "Error: Invalid Armor type: ", armortype );
	            MinecraftForge.EVENT_BUS.post( new EventToolRecipeFailed() );
                break;
        }
    }

    // ********************************************************************************************

    public static void registerEntity( Class entityClass, String name, int id )
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
