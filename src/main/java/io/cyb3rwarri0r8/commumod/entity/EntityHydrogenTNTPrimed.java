package io.cyb3rwarri0r8.commumod.entity;


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

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

/**
 * Created by noah on 10/22/14.
 */
public class EntityHydrogenTNTPrimed extends EntityTNTPrimed
{
    public int fusee;
    private EntityLivingBase hydrogenTNTPlacedBy;


    public EntityHydrogenTNTPrimed(World p_i1729_1_) {
        super(p_i1729_1_);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        BlockPos blockPos = new BlockPos(this.posX, this.posY, this.posZ);
        blockPos.up((int) (this.height / 2.0F));
    }

    public EntityHydrogenTNTPrimed(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
    {
        this(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.fusee = 100;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
        this.hydrogenTNTPlacedBy = par8EntityLivingBase;
    }

    protected void entityInit() {}

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fusee-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private void explode()
    {
        float f = 0.0F;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
        for(int posX2 = (int)posX- 5; posX2 < (int)posX + 10; posX2++)
        {
            for(int posY2 = (int)posY - 5; posY2 < (int)posY + 0; posY2++)
            {
                for(int posZ2 = (int)posZ - 5; posZ2 < (int)posZ + 10; posZ2++)
                {
                    BlockPos blockPos = new BlockPos(posX2, posY2, posZ2);
                    if(worldObj.getBlockState(blockPos).getBlock() != Blocks.bedrock && worldObj.getBlockState(blockPos).getBlock() != Blocks.end_portal_frame && worldObj.getBlockState(blockPos).getBlock() != Blocks.end_portal)
                    {


                        Block getblock = worldObj.getBlockState(blockPos).getBlock();
                        worldObj.setBlockToAir(blockPos);
                        Random random = new Random();
                        int lol = 0;
                        int lol2 = 0;
                        int blockStateId = Block.getStateId(worldObj.getBlockState(blockPos));
                        IBlockState state = (IBlockState) Block.getStateById(blockStateId);
                        List<EntityMob> entities = this.worldObj.getEntitiesWithinAABB(EntityMob.class, AxisAlignedBB.fromBounds(this.posX - 5, this.posY - 5, this.posZ - 5, this.posX + 5, this.posY + 5, this.posZ + 5));
                        worldObj.setBlockState(blockPos, state);

                        for(int i = 0; i <= entities.size() - 1; i++)
                        {

                            EntityMob entityMob = (EntityMob) entities.get(i);
                            entityMob.attackEntityFrom(DamageSource.causePlayerDamage(this.worldObj.getClosestPlayer(this.posX, this.posY, this.posZ, 0.0D)),2000F);
                        }



                    }

                }

            }

        }

    }



    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setByte("Fusee", (byte)this.fusee);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.fusee = par1NBTTagCompound.getByte("Fusee");
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    /**
     * returns null or the entityliving it was placed or ignited by
     */
    public EntityLivingBase getHydrogenTNTPlacedBy()
    {
        return this.hydrogenTNTPlacedBy;
    }

}
