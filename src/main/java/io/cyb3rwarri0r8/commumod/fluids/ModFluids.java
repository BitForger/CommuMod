package io.cyb3rwarri0r8.commumod.fluids;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

/**
 * Created by noah on 10/27/14.
 */
public class ModFluids {

    public static Fluid pureWater;
    public static Fluid retaw;
    public static void init()
    {
        pureWater = new FluidPureWater("pureWater");
        FluidRegistry.registerFluid(pureWater);

        retaw = new FluidRetaw("retaw");
        FluidRegistry.registerFluid(retaw);
    }
}
