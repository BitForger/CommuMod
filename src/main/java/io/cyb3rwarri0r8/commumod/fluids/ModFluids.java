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
import io.cyb3rwarri0r8.commumod.lib.helpers.ModModelHelper;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.HashSet;
import java.util.Set;

public class ModFluids {

	public static Set<IFluidBlock> fluidBlocks = new HashSet<>();

    public static Fluid pureWater;
    public static Fluid retaw;

    public static Item pureWaterBucket;
    public static Item retawBucket;

    /***************************************************************************************
     ************************Water/Liquid blocks********************************************
     ***************************************************************************************/
    public static BlockFluidClassic pureWaterBlock;
    public static BlockFluidClassic retawBlock;

    public static void init()
    {
//        pureWater = new FluidPureWater("pureWater");
//        FluidRegistry.registerFluid(pureWater);

//        pureWaterBlock = new BlockPureWater(ModFluids.pureWater, Material.water);
//        GameRegistry.registerBlock(pureWaterBlock, pureWaterBlock.getUnlocalizedName().substring(5));





	    pureWater = createFluid("pureWater", "commumod:blocks/pureWater", true).setLuminosity(10).setDensity(100).setViscosity(100);
	    pureWaterBlock = registerFluidBlock(new BlockFluidClassic(pureWater, new MaterialLiquid( MapColor.adobeColor)));

	    pureWaterBucket = new ItemPureWaterBucket(pureWaterBlock);
	    FluidContainerRegistry.registerFluidContainer(ModFluids.pureWater, new ItemStack(pureWaterBucket), FluidContainerRegistry.EMPTY_BUCKET);

	    RegisterHelper.registerItem(pureWaterBucket);
	    RegisterHelper.addPurifying(Items.water_bucket, new ItemStack(ModFluids.pureWaterBucket, 1), 35F);
        /**********************************************************************************/

//        retaw = new FluidRetaw("retaw");
//        FluidRegistry.registerFluid(retaw);

//        retawBlock = new BlockRetaw(ModFluids.retaw, ModBlocks.materialRetaw);
//        GameRegistry.registerBlock(retawBlock, retawBlock.getUnlocalizedName().substring(5));

		retaw = createFluid( "retaw", "commumod:blocks/retaw", true ).setDensity( -1600 ).setGaseous( true ).setLuminosity( 10 ).setViscosity( 100 );
		retawBlock = registerFluidBlock( new BlockFluidClassic( retaw, new MaterialLiquid( MapColor.adobeColor ) ) );
	    retawBucket = new ItemRetawBucket(retawBlock);
	    RegisterHelper.registerItem(retawBucket);

	    FluidContainerRegistry.registerFluidContainer(ModFluids.retaw, new ItemStack(retawBucket), new ItemStack(Items.bucket));

	    GameRegistry.addRecipe(new ItemStack(ModFluids.retawBucket), "XXX", "XYX", "XXX",
			    'X', ModItems.enderDust, 'Y', ModFluids.pureWaterBucket
	    );

	    reigsterModels();
    }

    private static Fluid createFluid(String name, String textureName, boolean hasFlowIcon) {
        ResourceLocation still = new ResourceLocation(textureName + "_still");
        ResourceLocation flowing = hasFlowIcon ? new ResourceLocation(textureName + "_flow") : still;

        Fluid fluid = new Fluid(name, still, flowing);
        if (!FluidRegistry.registerFluid(fluid)) {
            throw new IllegalStateException(String.format("Unable to register fluid %s", fluid.getID()));
        }

        return fluid;
    }

	private static <T extends Block & IFluidBlock > T registerFluidBlock( T block) {
		String fluidName = block.getFluid().getUnlocalizedName();
		block.setUnlocalizedName(fluidName);
		GameRegistry.registerBlock(block, fluidName);

		fluidBlocks.add(block);

		return block;
	}

	public static void reigsterModels() {
		ModModelHelper modelHelper = new ModModelHelper();
		modelHelper.registerFluidModels();
	}

    public static void initBlocks()
    {

    }
}