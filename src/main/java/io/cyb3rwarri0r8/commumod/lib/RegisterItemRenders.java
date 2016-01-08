package io.cyb3rwarri0r8.commumod.lib;

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
import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.items.food_items.foodItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.util.HashMap;

public class RegisterItemRenders {

    public static String[] itemName = {
            "aradactiteAxe",
            "aradactiteHoe",
            "aradactiteIngot",
            "aradactitePick",
            "aradactiteShovel",
            "aradactiteSword",
            "cobaltIngot",
            "cobaltBoat",
            "enderDust",
            "plastic",
            "pureWaterBucket",
            "retawBucket",
            "ruby",
            "rubyAxe",
            "rubyHoe",
            "rubyPickaxe",
            "rubyShovel",
            "rubySword",
            "superbiumAxe",
            "superbiumDust",
            "superbiumHoe",
            "superbiumIngot",
            "superbiumPick",
            "superbiumShovel",
            "superbiumSword",
            "superCarrot",
            "ticTac",
            "ticTacCase"
    };

    public static Item[] items = {
            ModItems.aradactiteAxe,
            ModItems.aradactiteHoe,
            ModItems.aradactiteIngot,
            ModItems.aradactitePick,
            ModItems.aradactiteShovel,
            ModItems.aradactiteSword,
            ModItems.cobaltIngot,
            ModItems.cobaltBoat,
            ModItems.enderDust,
            ModItems.plastic,
            ModFluids.pureWaterBucket,
            ModFluids.retawBucket,
            ModItems.ruby,
            ModItems.rubyAxe,
            ModItems.rubyHoe,
            ModItems.rubyPick,
            ModItems.rubyShovel,
            ModItems.rubySword,
            ModItems.superbiumAxe,
            ModItems.superbiumDust,
            ModItems.superbiumHoe,
            ModItems.superbiumIngot,
            ModItems.superbiumPick,
            ModItems.superbiumShovel,
            ModItems.superbiumSword,
            foodItems.superCarrot,
            foodItems.ticTac,
            foodItems.ticTacCase,
            //FIXED Figure out how to add textures to armor
            ModItems.aradactiteHelmet,
            ModItems.aradactiteChestplate,
            ModItems.aradactiteLeggings,
            ModItems.aradactiteBoots,
            ModItems.blockSuperbium,
            ModItems.rubyHelmet,
            ModItems.rubyChestplate,
            ModItems.rubyLeggings,
            ModItems.rubyBoots,
            ModItems.superbiumHelmet,
            ModItems.superbiumChestPlate,
            ModItems.superbiumLeggings,
            ModItems.superbiumBoots

    };

    public static Item[] blocks = {
            Item.getItemFromBlock(ModBlocks.aradactiteBlock),
            Item.getItemFromBlock(ModBlocks.aradactiteOre),
            Item.getItemFromBlock(Commumod.cobaltOre),
            Item.getItemFromBlock(ModBlocks.hydrogenTNT),
            Item.getItemFromBlock(ModBlocks.minerShack),
            Item.getItemFromBlock(ModFluids.pureWaterBlock),
            Item.getItemFromBlock(ModFluids.retawBlock),
            Item.getItemFromBlock(ModBlocks.rubyBlock),
            Item.getItemFromBlock(ModBlocks.rubyOre),
            Item.getItemFromBlock(ModBlocks.superbiumBlock),
            Item.getItemFromBlock(ModBlocks.superbiumOre),
            Item.getItemFromBlock(ModBlocks.superbiumTNT),
            Item.getItemFromBlock(ModBlocks.purifier_idle),
            Item.getItemFromBlock(ModBlocks.appleBlock),
            Item.getItemFromBlock(ModBlocks.superbiumTNT),
            Item.getItemFromBlock(ModBlocks.hydrogenTNT),
            Item.getItemFromBlock(ModBlocks.appleBlock)
    };

    public static HashMap<Item,String> map = new HashMap<Item, String>();

    public RegisterItemRenders(){

    }

    public static void registerItemsToRender(){
        /*Set set = map.entrySet();
        for (Object aSet : set) {
            Map.Entry me = (Map.Entry) aSet;
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register((Item) me.getKey(), 0, new ModelResourceLocation(Reference.MODID + ":" + ((Item) me.getKey()).getUnlocalizedName(), "inventory"));
            FMLLog.info("Registering Model for " + me.getKey().toString() + " and " + me.getValue().toString());
        }*/
        for (Item item : items) {
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
        }
    }

    public static void registerBlockItemsToRender(){
        for (Item item : blocks){
            Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
        }
    }

    public static void addItemsToMap() {
        for (String anItemName : itemName) {
            for (Item item : items) {
                map.put(item, anItemName);
            }
        }
    }



}
