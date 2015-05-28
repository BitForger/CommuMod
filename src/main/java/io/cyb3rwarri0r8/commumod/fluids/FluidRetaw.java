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
