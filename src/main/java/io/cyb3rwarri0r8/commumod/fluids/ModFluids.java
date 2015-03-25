package io.cyb3rwarri0r8.commumod.fluids;


import io.cyb3rwarri0r8.commumod.blocks.BlockPureWater;
import io.cyb3rwarri0r8.commumod.blocks.BlockRetaw;
import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import io.cyb3rwarri0r8.commumod.items.ItemPureWaterBucket;
import io.cyb3rwarri0r8.commumod.items.ItemRetawBucket;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.lib.Reference;
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

    /**************************************************************************************
     ************************Water/Liquid blocks********************************************/
    public static Block pureWaterBlock;
    public static Block retawBlock;

    public static void init()
    {
        pureWater = new FluidPureWater("pureWater");
        FluidRegistry.registerFluid(pureWater);

        retaw = new FluidRetaw("retaw");
        FluidRegistry.registerFluid(retaw);





        pureWaterBlock = new BlockPureWater(ModFluids.pureWater, Material.water);
        GameRegistry.registerBlock(pureWaterBlock, Reference.MODID + ":" + pureWaterBlock.getUnlocalizedName().substring(5));

        pureWaterBucket = new ItemPureWaterBucket(pureWaterBlock);
        FluidContainerRegistry.registerFluidContainer(ModFluids.pureWater, new ItemStack(pureWaterBucket), new ItemStack(Items.bucket));
        RegisterHelper.addPurifying(Items.water_bucket, new ItemStack(ModFluids.pureWaterBucket, 1), 35F);
        RegisterHelper.registerItem(pureWaterBucket);
        /**********************************************************************************/


        retawBlock = new BlockRetaw(ModFluids.retaw, ModBlocks.materialRetaw);
        GameRegistry.registerBlock(retawBlock, Reference.MODID + ":" + retawBlock.getUnlocalizedName().substring(5));

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
