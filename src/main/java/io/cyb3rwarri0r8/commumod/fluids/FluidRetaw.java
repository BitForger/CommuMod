package io.cyb3rwarri0r8.commumod.fluids;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraftforge.fluids.Fluid;

/**
 * Created by noah on 10/29/14.
 */
public class FluidRetaw extends Fluid {

    public static final int LEVELS = 8;
    public static final Material materialRetawFluid = new MaterialLiquid(MapColor.emeraldColor);

    public FluidRetaw(String string) {
        super(string);
        setUnlocalizedName(string);
        setViscosity(300);
        setDensity(-500);


    }
}
