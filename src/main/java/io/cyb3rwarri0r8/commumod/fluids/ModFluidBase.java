package io.cyb3rwarri0r8.commumod.fluids;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.commumod.entity.render.EntityDropParticleFX;
import io.cyb3rwarri0r8.commumod.lib.IconRegistry;
import io.cyb3rwarri0r8.commumod.lib.helpers.StringHelper;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

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

    public ModFluidBase(Fluid fluid, Material material, String name) {

        super(fluid, material);

        this.name = StringHelper.titleCase(name);

        setRenderPass(1);
        setBlockName(modName + ".fluid." + name);
        displacements.put(this, false);
    }

    public ModFluidBase(String modName, Fluid fluid, Material material, String name) {

        super(fluid, material);

        this.name = StringHelper.titleCase(name);
        this.modName = modName;

        setRenderPass(1);
        setBlockName(modName + ".fluid." + name);
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

    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z)
    {
        return false;
    }

    public boolean preInit() {

        return true;
    }

    public ModFluidBase setDisplaceFluids(boolean a) {

        this.shouldDisplaceFluids = a;
        return this;
    }

    @Override
    public void registerBlockIcons(IIconRegister ir) {

        IconRegistry.addIcon("Fluid" + name, modName + ":fluid/Fluid_" + name + "_Still", ir);
        IconRegistry.addIcon("Fluid" + name + "1", modName + ":fluid/Fluid_" + name + "_Flow", ir);
    }

    @Override
    public IIcon getIcon(int side, int meta) {

        return side <= 1 ? IconRegistry.getIcon("Fluid" + name) : IconRegistry.getIcon("Fluid" + name, 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand) {

        super.randomDisplayTick(world, x, y, z, rand);

        double px = x + rand.nextFloat();
        double py = y - 1.05D;
        double pz = z + rand.nextFloat();

        if (density < 0) {
            py = y + 2.10D;
        }
        if (rand.nextInt(20) == 0 && world.isSideSolid(x, y + densityDir, z, densityDir == -1 ? ForgeDirection.UP : ForgeDirection.DOWN)
                && !world.getBlock(x, y + 2 * densityDir, z).getMaterial().blocksMovement()) {
            EntityFX fx = new EntityDropParticleFX(world, px, py, pz, particleRed, particleGreen, particleBlue, densityDir);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect(fx);
        }
    }

    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {

        if (!shouldDisplaceFluids && world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {

        if (!shouldDisplaceFluids && world.getBlock(x, y, z).getMaterial().isLiquid()) {
            return false;
        }
        return super.displaceIfPossible(world, x, y, z);
    }

}
