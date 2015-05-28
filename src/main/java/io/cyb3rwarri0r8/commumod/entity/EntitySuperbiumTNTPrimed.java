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
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by noah on 6/7/14.
 */
public class EntitySuperbiumTNTPrimed extends EntityTNTPrimed{

    /**
     * How long the fusee is
     */
    public int fusee;
    private EntityLivingBase superbiumTNTPlacedBy;


    public EntitySuperbiumTNTPrimed(World par1World)
    {
        super(par1World);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);

    }

    public EntitySuperbiumTNTPrimed(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase)
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
        this.superbiumTNTPlacedBy = par8EntityLivingBase;
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
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private void explode()
    {
        float f = 0.0F;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, f, true);
        BlockPos blockPos = new BlockPos(this.posX, this.posY, this.posZ);
        for(int posX2 = (int)posX- 5; posX2 < (int)posX + 5; posX2++)
        {
            for(int posY2 = (int)posY - 5; posY2 < (int)posY + 0; posY2++)
            {
                for(int posZ2 = (int)posZ - 5; posZ2 < (int)posZ + 5; posZ2++)
                {
                    BlockPos blockPos1 = new BlockPos(posX2,posY2,posZ2);
                    if(worldObj.getBlockState(blockPos1).getBlock() != Blocks.bedrock && worldObj.getBlockState(blockPos1).getBlock() != Blocks.end_portal_frame && worldObj.getBlockState(blockPos1).getBlock() != Blocks.end_portal)
                    {

                        Block getblock = worldObj.getBlockState(blockPos1).getBlock();
                        worldObj.setBlockToAir(blockPos1);
                        Random random = new Random();
                        Double lol = 0.0;
                        Double lol2 = 0.0;
                        Double lol3 = random.nextDouble();
                        BlockPos blockPos2 = new BlockPos(lol, lol3, lol2);
                        EntityItem entityitem = new EntityItem(worldObj, posX2, posY2, posZ2, new ItemStack(getblock.getItemDropped(worldObj.getBlockState(blockPos2),random,0)));
                        worldObj.spawnEntityInWorld(entityitem);
                    }
                }
                //System.out.println("TEST1");
            }
            //System.out.println("TEST2");
        }
        //System.out.println("Test3");
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
    public EntityLivingBase getsuperbiumTNTPlacedBy()
    {
        return this.superbiumTNTPlacedBy;
    }

}
