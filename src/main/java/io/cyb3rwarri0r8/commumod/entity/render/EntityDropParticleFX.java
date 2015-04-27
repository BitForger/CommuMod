package io.cyb3rwarri0r8.commumod.entity.render;


import io.cyb3rwarri0r8.commumod.lib.helpers.MathHelper;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockState;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


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
@SideOnly(Side.CLIENT)
public class EntityDropParticleFX extends EntityFX {

    private int bobTimer;

    public EntityDropParticleFX(World world, double x, double y, double z, float particleRed, float particleGreen, float particleBlue) {

        this(world, x, y, z, particleRed, particleGreen, particleBlue, -1);
    }

    public EntityDropParticleFX(World world, double x, double y, double z, float particleRed, float particleGreen, float particleBlue, int gravityMod) {

        super(world, x, y, z, 0.0D, 0.0D, 0.0D);
        this.motionX = this.motionY = this.motionZ = 0.0D;

        this.particleRed = particleRed;
        this.particleGreen = particleGreen;
        this.particleBlue = particleBlue;

        this.setParticleTextureIndex(113);
        this.setSize(0.01F, 0.01F);
        this.particleGravity = -0.06F * gravityMod;
        this.bobTimer = 40;
        this.particleMaxAge = (int) (48.0D / (Math.random() * 0.8D + 0.2D));
        this.motionX = this.motionY = this.motionZ = 0.0D;
    }

    @Override
    public void onUpdate() {

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        this.motionY -= this.particleGravity;

        if (this.bobTimer-- > 0) {
            this.motionX *= 0.02D;
            this.motionY *= 0.02D;
            this.motionZ *= 0.02D;
            this.setParticleTextureIndex(113);
        } else {
            this.setParticleTextureIndex(112);
        }
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.particleMaxAge-- <= 0) {
            this.setDead();
        }
        if (this.onGround) {
            this.setParticleTextureIndex(114);
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
        BlockPos blockPos = new BlockPos(this.posX, this.posY, this.posZ);
        if (this.particleGravity > 0) {
            Material material = this.worldObj.getBlockState(blockPos).getBlock().getMaterial();

            if (material.isLiquid() || material.isSolid()) {
                int liquidStateId = BlockLiquid.getStateId(worldObj.getBlockState(blockPos));
                BlockState state = (BlockState) BlockLiquid.getStateById(liquidStateId);
                double d0 = MathHelper.floor(this.posY)
                        + 1
                        - BlockLiquid.getLiquidHeightPercent((Integer) state.getBaseState().getValue(BlockLiquid.LEVEL));
                if (this.posY < d0) {
                    this.setDead();
                }
            }
        } else {
            Material material = this.worldObj.getBlockState(blockPos).getBlock().getMaterial();

            if (material.isLiquid() || material.isSolid()) {
                int liquidStateId = BlockLiquid.getStateId(worldObj.getBlockState(blockPos));
                BlockState state = (BlockState) BlockLiquid.getStateById(liquidStateId);
                double d0 = MathHelper.ceil(this.posY)
                        + 1
                        - BlockLiquid.getLiquidHeightPercent((Integer) state.getBaseState().getValue(BlockLiquid.LEVEL));
                if (this.posY > d0) {
                    this.setDead();
                }
            }
        }
    }

}
