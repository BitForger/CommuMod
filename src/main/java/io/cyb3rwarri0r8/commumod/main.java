package io.cyb3rwarri0r8.commumod;


import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.client.CreativeTabsCommuMod;
import io.cyb3rwarri0r8.commumod.entity.EntityMiner;
import io.cyb3rwarri0r8.commumod.entity.ModEntities;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.items.food_items.foodItems;
import io.cyb3rwarri0r8.commumod.lib.ModRecipeHandler;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.lib.handler.ConfigHandler;
import io.cyb3rwarri0r8.commumod.lib.handler.ModBucketHandler;
import io.cyb3rwarri0r8.commumod.lib.handler.ModEventHandler;
import io.cyb3rwarri0r8.commumod.lib.proxy.proxyCommon;
import io.cyb3rwarri0r8.commumod.world.modWorld;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipesTools;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.util.Iterator;
import java.util.List;


@Mod(modid = Reference.MODID, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)



public class main
{
    @SidedProxy(clientSide=Reference.CLIENT_PROXY, serverSide=Reference.COMMON_PROXY)
    public static proxyCommon proxy;

    // Create a new creative tab
    public static CreativeTabs modTab = new CreativeTabsCommuMod("modTab");
    // Configuration file
    public static Configuration configFile;


    @Mod.Instance(Reference.MODID)
    public static main instance;




    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {

        configFile = new Configuration(event.getSuggestedConfigurationFile());
        ConfigHandler.init(configFile.getConfigFile());

        ModItems.loadItems();

        ModBlocks.loadBlocks();

        ModFluids.init();

        ModBlocks.addBlockRecipes();

        foodItems.loadFood();

        modWorld.initWorldGen();

        ModEntities.init();

        /**
         * Run all proxy file initiation
         */
        proxy.registerRenderers();
        proxy.registerEntitySpawn();
        proxy.registerTileEntities();
        proxy.registerNetwork();
        proxy.preinit();


    }


    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

        ModRecipeHandler.removeRecipes();

    }

    @Mod.EventHandler
    public void load(FMLPostInitializationEvent event)
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