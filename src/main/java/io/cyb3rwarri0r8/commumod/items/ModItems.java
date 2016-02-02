

package io.cyb3rwarri0r8.commumod.items;

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

import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.entity.EntityCobaltBoat;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashMap;


public class ModItems {
    public HashMap<Integer, String> modItems;

    public static Item superbiumIngot;


    public static Item blockSuperbium;

    //Add Tools
    public static Item superbiumPick;
    public static Item superbiumAxe;
    public static Item superbiumShovel;
    public static Item superbiumHoe;
    public static Item superbiumSword;

    public static Item superbiumHelmet;
    public static Item superbiumChestPlate;
    public static Item superbiumLeggings;
    public static Item superbiumBoots;
    // Add dust that is returned when mined out
    public static Item superbiumDust;
    //Tool material
    static Item.ToolMaterial SUPERBIUM_TOOL_MATERIAL = EnumHelper.addToolMaterial("superbiumToolMaterial", 2, 1200, 8, 10.0F, 50);
    static ItemArmor.ArmorMaterial SUPERBIUM_ARMOR_TUTORIAL = EnumHelper.addArmorMaterial("superbiumArmorMaterial", "superbiumArmor", 30, new int[]{3,6,5,3}, 30);

    //===================================================================================
    //Aradactite
    // Aradactite Material
    //TODO FIX nameing
    static Item.ToolMaterial aradactiteToolMaterial = EnumHelper.addToolMaterial("aradactiteToolMaterial", 3, 800, 5, 6.0F, 30);
    static ItemArmor.ArmorMaterial aradactiteArmorMaterial = EnumHelper.addArmorMaterial("aradactiteArmorMaterial", "aradactiteArmor", 25, new int[]{2,4,3,3}, 15);
    // =================================
    public static Item aradactiteIngot;
    // --------------------------------
    public static Item aradactitePick;
    public static Item aradactiteAxe;
    public static Item aradactiteShovel;
    public static Item aradactiteHoe;
    public static Item aradactiteSword;
    // --------------------------------
    // Armor
    public static Item aradactiteHelmet;
    public static Item aradactiteChestplate;
    public static Item aradactiteLeggings;
    public static Item aradactiteBoots;
    // ==================================================================================
    // Ruby
    public static Item ruby;
    static Item.ToolMaterial RUBY_TOOL_MATERIAL = EnumHelper.addToolMaterial("rubyToolMaterial",3,1800,5.0F,8.25F,100);
    public static Item rubyPick;
    public static Item rubyAxe;
    public static Item rubyShovel;
    public static Item rubyHoe;
    public static Item rubySword;
    //Ruby Armor
    static ItemArmor.ArmorMaterial RUBY_ARMOR_MATERIAL = EnumHelper.addArmorMaterial("rubyArmorMaterial", "rubyArmor", 700,new int[]{2,3,3,3},15);
    public static Item rubyChestplate;
    public static Item rubyHelmet;
    public static Item rubyLeggings;
    public static Item rubyBoots;

    public static Item cobaltBoat;
    public static Item cobaltIngot;

    public static Item enderDust;



    public static Item appleBlock;
    public static Item plastic;

    public static Item goldToolRod;
    public static Item stoneToolRod;
    public static Item ironToolRod;
    public static Item diamondToolRod;

    public static Item modularPickaxe;
    static Item.ToolMaterial MODULAR_PICK_MATERIAL = EnumHelper.addToolMaterial("modularPickMaterial",500, 1000, 4.0F, 5.0F, 75);

    public ModItems() {
        modItems = new HashMap<Integer,String>();
    }


    public static void loadItems() {
        //Load all necessary items
        superbiumIngot = new ItemSuperbiumIngot();
        RegisterHelper.registerItem(superbiumIngot);
        //*******************************************************************************
        superbiumDust = new ItemSuperbiumDust();
        RegisterHelper.registerItem(superbiumDust);
        GameRegistry.addSmelting(superbiumDust, new ItemStack(superbiumIngot), 400F);
        // ******************************************************************************
        // First Pick
        superbiumPick = new ItemSuperbiumPick(SUPERBIUM_TOOL_MATERIAL);
        RegisterHelper.registerItem(superbiumPick);
        //Recipe
        GameRegistry.addRecipe(new ItemStack(superbiumPick),
                "XXX",
                " Y ",
                " Y ",
                'X', superbiumIngot, 'Y', Items.stick
        );

        // ******************************************************************************
        // First Axe
        superbiumAxe = new ItemSuperbiumAxe(SUPERBIUM_TOOL_MATERIAL);
        RegisterHelper.registerItem(superbiumAxe);
        //Recipe
        GameRegistry.addRecipe(new ItemStack(superbiumAxe),
                "XX",
                "XY",
                " Y",
                'X', superbiumIngot, 'Y', Items.stick
        );

        // ******************************************************************************
        // First Sword
        superbiumSword = new ItemSuperbiumSword(SUPERBIUM_TOOL_MATERIAL);
        RegisterHelper.registerItem(superbiumSword);
        // Recipe
        GameRegistry.addRecipe(new ItemStack(superbiumSword),
                "X",
                "X",
                "Y",
                'X', superbiumIngot, 'Y', Items.stick
        );
        //*******************************************************************************
        superbiumShovel = new ItemSuperbiumShovel(SUPERBIUM_TOOL_MATERIAL);
        RegisterHelper.registerItem(superbiumShovel);
        RegisterHelper.regToolRecipe(superbiumShovel, superbiumIngot, Items.stick, "shovel");
        // ******************************************************************************
        superbiumHoe = new ItemSuperbiumHoe(SUPERBIUM_TOOL_MATERIAL);
        RegisterHelper.registerItem(superbiumHoe);
        RegisterHelper.regToolRecipe(superbiumHoe, superbiumIngot, Items.stick, "hoe");
        //Armor
        superbiumHelmet = new ItemSuperbiumArmor(SUPERBIUM_ARMOR_TUTORIAL, 0, "superbiumHelmet");
        RegisterHelper.registerItem(superbiumHelmet);
        RegisterHelper.regArmorRecipe(superbiumHelmet, superbiumIngot, "helmet");
        // ******************************************************************************
        superbiumChestPlate = new ItemSuperbiumArmor(SUPERBIUM_ARMOR_TUTORIAL, 1, "superbiumChestplate");
        RegisterHelper.registerItem(superbiumChestPlate);
        RegisterHelper.regArmorRecipe(superbiumChestPlate, superbiumIngot, "chestplate");
        // ******************************************************************************
        superbiumLeggings = new ItemSuperbiumArmor(SUPERBIUM_ARMOR_TUTORIAL, 2, "superbiumLeggings");
        RegisterHelper.registerItem(superbiumLeggings);
        RegisterHelper.regArmorRecipe(superbiumLeggings, superbiumIngot, "leggings");
        // ******************************************************************************
        superbiumBoots = new ItemSuperbiumArmor(SUPERBIUM_ARMOR_TUTORIAL, 3, "superbiumBoots");
        RegisterHelper.registerItem(superbiumBoots);
        RegisterHelper.regArmorRecipe(superbiumBoots, superbiumIngot, "boots");
        // Superbium block
        // ******************************************************************************
        blockSuperbium = new ItemBlockSuperbium();
        RegisterHelper.registerItem(blockSuperbium);
        // ******************************************************************************
        //Aradactite blocks
        //=================
        //aradactite ore
        aradactiteIngot = new ItemAradactiteIngot();
        RegisterHelper.registerItem(aradactiteIngot);
        GameRegistry.addSmelting(ModBlocks.aradactiteOre, new ItemStack(aradactiteIngot), 10);
        // Aradactite tools
        aradactitePick = new ItemAradactitePick(aradactiteToolMaterial);
        RegisterHelper.registerItem(aradactitePick);
        GameRegistry.addRecipe(new ItemStack(aradactitePick),
                "XXX",
                " Y ",
                " Y ",
                'X', aradactiteIngot, 'Y', Items.stick
        );
        // ******************************************************************************
        aradactiteAxe = new ItemAradactiteAxe(aradactiteToolMaterial);
        RegisterHelper.registerItem(aradactiteAxe);
        GameRegistry.addRecipe(new ItemStack(aradactiteAxe),
                "XX",
                "XY",
                " Y",
                'X', aradactiteIngot, 'Y', Items.stick
        );
        // ******************************************************************************
        aradactiteShovel = new ItemAradactiteShovel(aradactiteToolMaterial);
        RegisterHelper.registerItem(aradactiteShovel);
        GameRegistry.addRecipe(new ItemStack(aradactiteShovel),
                "X",
                "Y",
                "Y",
                'X', aradactiteIngot, 'Y', Items.stick
        );
        // ******************************************************************************
        aradactiteHoe = new ItemAradactiteHoe(aradactiteToolMaterial);
        RegisterHelper.registerItem(aradactiteHoe);
        GameRegistry.addRecipe(new ItemStack(aradactiteHoe),
                "XX",
                " Y",
                " Y",
                'X', aradactiteIngot, 'Y', Items.stick
        );
        // ******************************************************************************
        aradactiteSword = new ItemAradactiteSword(aradactiteToolMaterial);
        RegisterHelper.registerItem(aradactiteSword);
        GameRegistry.addRecipe(new ItemStack(aradactiteSword),
                "X",
                "X",
                "Y",
                'X', aradactiteIngot, 'Y', Items.stick
        );
        // Aradactite Armor
        aradactiteHelmet = new ItemAradactiteArmor(aradactiteArmorMaterial, 0, "aradactiteHelmet");
        RegisterHelper.registerItem(aradactiteHelmet);
        RegisterHelper.regArmorRecipe(aradactiteHelmet, aradactiteIngot, "helmet");
        // ******************************************************************************
        aradactiteChestplate = new ItemAradactiteArmor(aradactiteArmorMaterial, 1, "aradactiteChestplate");
        RegisterHelper.registerItem(aradactiteChestplate);
        RegisterHelper.regArmorRecipe(aradactiteChestplate, aradactiteIngot, "chestplate");
        // ******************************************************************************
        aradactiteLeggings = new ItemAradactiteArmor(aradactiteArmorMaterial, 2, "aradactiteLeggings");
        RegisterHelper.registerItem(aradactiteLeggings);
        RegisterHelper.regArmorRecipe(aradactiteLeggings, aradactiteIngot, "leggings");
        // ******************************************************************************
        aradactiteBoots = new ItemAradactiteArmor(aradactiteArmorMaterial, 3, "aradactiteBoots");
        RegisterHelper.registerItem(aradactiteBoots);
        RegisterHelper.regArmorRecipe(aradactiteBoots, aradactiteIngot, "boots");
        // ==============================================================================
        // ******************************************************************************
        // Ruby items
        ruby = new ItemRuby();
        RegisterHelper.registerItem(ruby);
        // Ruby tools
        rubyPick = new ItemRubyPickaxe(RUBY_TOOL_MATERIAL);
        RegisterHelper.registerItem(rubyPick);
        RegisterHelper.regToolRecipe(rubyPick, ruby, Items.stick, "pickaxe");

        rubyAxe = new ItemRubyAxe(RUBY_TOOL_MATERIAL);
        RegisterHelper.registerItem(rubyAxe);
        RegisterHelper.regToolRecipe(rubyAxe, ruby, Items.stick, "axe");

        rubyShovel = new ItemRubyShovel(RUBY_TOOL_MATERIAL);
        RegisterHelper.registerItem(rubyShovel);
        RegisterHelper.regToolRecipe(rubyShovel, ruby, Items.stick, "shovel");

        rubyHoe = new ItemRubyHoe(RUBY_TOOL_MATERIAL);
        RegisterHelper.registerItem(rubyHoe);
        RegisterHelper.regToolRecipe(rubyHoe, ruby, Items.stick, "hoe");

        rubySword = new ItemRubySword(RUBY_TOOL_MATERIAL);
        RegisterHelper.registerItem(rubySword);
        RegisterHelper.regToolRecipe(rubySword, ruby, Items.stick, "sword");

        /* Armor */

        rubyHelmet = new ItemRubyArmor(RUBY_ARMOR_MATERIAL, 0, "rubyHelmet");
        RegisterHelper.registerItem(rubyHelmet);
        RegisterHelper.regArmorRecipe(rubyHelmet, ruby, "helmet");

        rubyChestplate = new ItemRubyArmor(RUBY_ARMOR_MATERIAL, 1, "rubyChestplate");
        RegisterHelper.registerItem(rubyChestplate);
        RegisterHelper.regArmorRecipe(rubyChestplate, ruby, "chestplate");

        rubyLeggings = new ItemRubyArmor(RUBY_ARMOR_MATERIAL, 2, "rubyLeggings");
        RegisterHelper.registerItem(rubyLeggings);
        RegisterHelper.regArmorRecipe(rubyLeggings, ruby, "leggings");

        rubyBoots = new ItemRubyArmor(RUBY_ARMOR_MATERIAL, 3, "rubyBoots");
        RegisterHelper.registerItem(rubyBoots);
        RegisterHelper.regArmorRecipe(rubyBoots, ruby, "boots");
        /* *********************************************************************************************************************************************
        ===============================================COBALT===========================================================================================
        ************************************************************************************************************************************************
         */
        cobaltIngot = new ItemCobaltIngot();
        RegisterHelper.registerItem(cobaltIngot);
        GameRegistry.addSmelting(Item.getItemFromBlock(Commumod.cobaltOre), new ItemStack(cobaltIngot, 1), 1F);

        cobaltBoat = new ItemCobaltBoat().setUnlocalizedName("cobaltBoat");
        RegisterHelper.registerItem(cobaltBoat);
        EntityRegistry.registerModEntity(EntityCobaltBoat.class, "cobaltBoat", EntityRegistry.findGlobalUniqueEntityId(), Commumod.instance, 80, 3, false);
        GameRegistry.addRecipe(new ItemStack(cobaltBoat, 1),
                "X X",
                "XXX",
                'X', ModItems.cobaltIngot
        );

        enderDust = new ItemEnderDust();
        RegisterHelper.registerItem(enderDust);
        RegisterHelper.addPurifying(Items.ender_pearl, new ItemStack(ModItems.enderDust, 6), 15F);


        plastic = new ItemPlastic();
        RegisterHelper.registerItem(plastic);
        RegisterHelper.addPurifying(Items.coal, new ItemStack(plastic), 20F);

        goldToolRod = new ItemGoldToolRod();
        RegisterHelper.registerItem(goldToolRod);
        RegisterHelper.addStickRecipe(Items.gold_ingot, new ItemStack(goldToolRod, 2));

        stoneToolRod = new ItemStoneToolRod();
        RegisterHelper.registerItem(stoneToolRod);
        RegisterHelper.addStickRecipe(Item.getItemFromBlock(Blocks.stone), new ItemStack(stoneToolRod,2));

        ironToolRod = new ItemIronToolRod();
        RegisterHelper.registerItem(ironToolRod);
        RegisterHelper.addStickRecipe(Items.iron_ingot, new ItemStack(ironToolRod, 2));

        diamondToolRod = new ItemDiamondToolRod();
        RegisterHelper.registerItem(diamondToolRod);
        RegisterHelper.addStickRecipe(Items.diamond, new ItemStack(diamondToolRod, 2));

        modularPickaxe = new ItemModularPickaxe(MODULAR_PICK_MATERIAL);
        RegisterHelper.registerItem(modularPickaxe);


    }
}
