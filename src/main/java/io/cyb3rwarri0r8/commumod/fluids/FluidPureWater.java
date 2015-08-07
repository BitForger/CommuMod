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




}
