package io.cyb3rwarri0r8.commumod.fluids;

import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by noah on 10/27/14.
 */
public class FluidPureWater extends Fluid {
    public FluidPureWater(String fluidName) {
        super(fluidName);
        setUnlocalizedName(fluidName);
        setDensity(100);
        setTemperature(250);
        setViscosity(100);


    }
    @Override
    public IIcon getStillIcon()
    {
        return ModBlocks.pureWaterBlock.getIcon(0, 0);
    }
    @Override
    public IIcon getFlowingIcon()
    {
        return ModBlocks.pureWaterBlock.getIcon(1,0);
    }



}
