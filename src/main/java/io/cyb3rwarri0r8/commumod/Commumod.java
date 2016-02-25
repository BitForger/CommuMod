package io.cyb3rwarri0r8.commumod;

/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) 2016 Cyb3rWarri0r8
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

import io.cyb3rwarri0r8.commumod.blocks.BlockCobaltOre;
import io.cyb3rwarri0r8.commumod.blocks.BlockHydrogenTNT;
import io.cyb3rwarri0r8.commumod.blocks.BlockSuperbiumTNT;
import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.client.CreativeTabsCommuMod;
import io.cyb3rwarri0r8.commumod.entity.ModEntities;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.items.food_items.foodItems;
import io.cyb3rwarri0r8.commumod.lib.ModRecipeHandler;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.lib.RegisterItemRenders;
import io.cyb3rwarri0r8.commumod.lib.handler.ConfigHandler;
import io.cyb3rwarri0r8.commumod.lib.handler.ModBucketHandler;
import io.cyb3rwarri0r8.commumod.lib.handler.ModEventHandler;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import io.cyb3rwarri0r8.commumod.lib.proxy.proxyCommon;
import io.cyb3rwarri0r8.commumod.world.modWorld;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = Reference.MODID, name = "CommuMod", useMetadata = true, version = Reference.VERSION, updateJSON = "https://raw.githubusercontent.com/KaminoCoding/Update-Files/master/Commumod-Update.json", guiFactory = Reference.GUI_FACTORY_CLASS )
public class Commumod
{
    @SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.COMMON_PROXY)
    public static proxyCommon proxy;

    // Create a new creative tab
    public static CreativeTabs modTab = new CreativeTabsCommuMod("modTab");
    // Configuration file
    public static Configuration configFile;


    @Mod.Instance(Reference.MODID)
    public static Commumod instance;




    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        configFile = new Configuration(event.getSuggestedConfigurationFile());
        ConfigHandler.init(configFile.getConfigFile());



        /*
         * Run all proxy file initiation
         */
        // proxy.registerRenderers();
        proxy.registerEntitySpawn();
        proxyCommon.registerTileEntities();
        proxy.registerNetwork();



    }

    public static Block cobaltOre;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        // Superbium TNT
        ModBlocks.superbiumTNT = new BlockSuperbiumTNT();
        ModBlocks.hydrogenTNT = new BlockHydrogenTNT();
        // Cobalt Ore
        cobaltOre = new BlockCobaltOre(Material.rock);
        RegisterHelper.registerBlock(cobaltOre);

        ModRecipeHandler.removeRecipes();

        ModItems.loadItems();

        ModBlocks.loadBlocks();

        ModFluids.init();

        ModBlocks.addBlockRecipes();

        foodItems.loadFood();

        modWorld.initWorldGen();

        ModEntities.init();

        GameRegistry.registerBlock(ModBlocks.superbiumTNT, ModBlocks.superbiumTNT.getUnlocalizedName());
        GameRegistry.registerBlock(ModBlocks.hydrogenTNT, ModBlocks.hydrogenTNT.getUnlocalizedName());

//        RegisterItemRenders.addItemsToMap();

        if (event.getSide() == Side.CLIENT){
           RegisterItemRenders.init();
        }

        proxy.registerRenderers();
        proxy.preinit();
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {


        //Load the event handler here
        MinecraftForge.EVENT_BUS.register(new ModEventHandler());
        FMLCommonHandler.instance().bus().register(new ModEventHandler());
        //Load the bucket handler here
        ModBucketHandler.INSTANCE.buckets.put(ModFluids.pureWaterBlock, ModFluids.pureWaterBucket);
        ModBucketHandler.INSTANCE.buckets.put(ModFluids.retawBlock, ModFluids.retawBucket);
        MinecraftForge.EVENT_BUS.register(ModBucketHandler.INSTANCE);

    }


}