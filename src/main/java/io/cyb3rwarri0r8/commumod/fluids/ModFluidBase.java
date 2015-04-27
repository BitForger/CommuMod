package io.cyb3rwarri0r8.commumod.fluids;


import io.cyb3rwarri0r8.commumod.entity.render.EntityDropParticleFX;

import io.cyb3rwarri0r8.commumod.lib.helpers.StringHelper;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.EntityFX;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;

import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2014 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public abstract class ModFluidBase extends BlockFluidClassic{
    String name = "";
    String modName = "cofh";
    protected float particleRed = 1.0F;
    protected float particleGreen = 1.0F;
    protected float particleBlue = 1.0F;
    protected boolean shouldDisplaceFluids = false;

    protected boolean[] isOptimalFlowDirection = new boolean[4];
    protected int[] flowCost = new int[4];

    protected FluidStack stack;

    public ModFluidBase(Fluid fluid, Material material, String name) {

        super(fluid, material);

        this.name = StringHelper.titleCase(name);


        setUnlocalizedName(modName + ".fluid." + name);
        displacements.put(this, false);
    }

    public ModFluidBase(String modName, Fluid fluid, Material material, String name) {

        super(fluid, material);

        this.name = StringHelper.titleCase(name);
        this.modName = modName;
        //TODO fix the renderpass

        setUnlocalizedName(modName + ".fluid." + name);
        displacements.put(this, false);
    }

    public ModFluidBase setParticleColor(int c) {

        return setParticleColor(((c >> 16) & 255) / 255f, ((c >> 8) & 255) / 255f, ((c >> 0) & 255) / 255f);
    }

    public ModFluidBase setParticleColor(float particleRed, float particleGreen, float particleBlue) {

        this.particleRed = particleRed;
        this.particleGreen = particleGreen;
        this.particleBlue = particleBlue;

        return this;
    }

    public boolean preInit() {

        return true;
    }

    public ModFluidBase setDisplaceFluids(boolean a) {

        this.shouldDisplaceFluids = a;
        return this;
    }




    @Override
    public boolean canDisplace(IBlockAccess world, BlockPos blockPos) {

        if (!shouldDisplaceFluids && world.getBlockState(blockPos).getBlock().getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, blockPos);
    }

    @Override
    public boolean displaceIfPossible(World world, BlockPos blockPos) {

        if (!shouldDisplaceFluids && world.getBlockState(blockPos).getBlock().getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, blockPos);
    }




}
