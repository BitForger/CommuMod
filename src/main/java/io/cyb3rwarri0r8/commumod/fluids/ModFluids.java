package io.cyb3rwarri0r8.commumod.fluids;


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

import io.cyb3rwarri0r8.commumod.blocks.BlockPureWater;
import io.cyb3rwarri0r8.commumod.blocks.BlockRetaw;
import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.items.ItemPureWaterBucket;
import io.cyb3rwarri0r8.commumod.items.ItemRetawBucket;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by noah on 10/27/14.
 */
public class ModFluids {

    public static Fluid pureWater;
    public static Fluid retaw;

    public static Item pureWaterBucket;
    public static Item retawBucket;

    /***************************************************************************************
     ************************Water/Liquid blocks********************************************
     ***************************************************************************************/
    public static Block pureWaterBlock;
    public static Block retawBlock;

    public static void init()
    {
        pureWater = new FluidPureWater("pureWater");
        FluidRegistry.registerFluid(pureWater);

        retaw = new FluidRetaw("retaw");
        FluidRegistry.registerFluid(retaw);

        pureWaterBlock = new BlockPureWater(ModFluids.pureWater, Material.water);
        GameRegistry.registerBlock(pureWaterBlock, pureWaterBlock.getUnlocalizedName().substring(5));

        pureWaterBucket = new ItemPureWaterBucket(pureWaterBlock);
        FluidContainerRegistry.registerFluidContainer(ModFluids.pureWater, new ItemStack(pureWaterBucket), new ItemStack(Items.bucket));
        RegisterHelper.addPurifying(Items.water_bucket, new ItemStack(ModFluids.pureWaterBucket, 1), 35F);
        RegisterHelper.registerItem(pureWaterBucket);
        /**********************************************************************************/


        retawBlock = new BlockRetaw(ModFluids.retaw, ModBlocks.materialRetaw);
        GameRegistry.registerBlock(retawBlock, retawBlock.getUnlocalizedName().substring(5));

        retawBucket = new ItemRetawBucket(retawBlock);

        FluidContainerRegistry.registerFluidContainer(ModFluids.retaw, new ItemStack(retawBucket), new ItemStack(Items.bucket));

        RegisterHelper.registerItem(retawBucket);

        GameRegistry.addRecipe(new ItemStack(ModFluids.retawBucket), "XXX", "XYX", "XXX",
                'X', ModItems.enderDust, 'Y', ModFluids.pureWaterBucket
        );




    }

    public static void initBlocks()
    {

    }
}
