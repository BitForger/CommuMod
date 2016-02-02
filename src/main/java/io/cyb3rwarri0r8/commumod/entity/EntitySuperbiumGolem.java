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

import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.village.Village;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static net.minecraft.util.EnumParticleTypes.BLOCK_CRACK;

public class EntitySuperbiumGolem extends EntityGolem {

    private int attackTimer;
    private int holdRoseTick;
    Village village;

    public EntitySuperbiumGolem(World worldIn) {
        super(worldIn);
        this.setSize(1.4F, 2.9F);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(2, new EntityAIMoveTowardsTarget(this, 0.9D, 32.0F));
        this.tasks.addTask(3, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(4, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));

        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, false, true, IMob.mobSelector));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
    }

    @Override
    protected void updateAITick() {
        super.updateAITick();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.60D);
    }

    @Override
    protected int decreaseAirSupply(int p_70682_1_) {
        return p_70682_1_;
    }

    @Override
    protected void collideWithEntity(Entity p_82167_1_) {
        if( p_82167_1_ instanceof IMob && this.getRNG().nextInt(20) == 0) {
            this.setAttackTarget((EntityLivingBase)p_82167_1_);
        }

        super.collideWithEntity(p_82167_1_);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if ( this.attackTimer > 0 ) {
            -- this.attackTimer;
        }

        if ( this.holdRoseTick > 0 ) {
            -- this.holdRoseTick;
        }

        if ( this.motionX * this.motionY + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
            int i = MathHelper.floor_double(this.posX);
            int j = MathHelper.floor_double(this.posY - 0.20000000298023224D - this.getYOffset());
            int k = MathHelper.floor_double(this.posZ);
            BlockPos blockPos = new BlockPos(i, j, k);
            Block block = this.worldObj.getBlockState(blockPos).getBlock();

            if (block.getMaterial() != Material.air) {
                int stateId = Block.getIdFromBlock(block);
                IBlockState blockState = Block.getStateById(stateId);
                Object[] propertyNames = this.worldObj.getBlockState(blockPos).getPropertyNames().toArray();
                this.spawnRunningParticles();
            }
        }
    }

    @Override
    public boolean canAttackClass(Class p_70686_1_) {
        return  this.isPlayerCreated() && EntityPlayer.class.isAssignableFrom(p_70686_1_) ? false : super.canAttackClass(p_70686_1_);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tagCompound) {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setBoolean("PlayerCreated", this.isPlayerCreated());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tagCompund) {
        super.readEntityFromNBT(tagCompund);
        this.setPlayerCreated(tagCompund.getBoolean("PlayerCreated"));
    }

    @Override
    public boolean attackEntityAsMob(Entity p_70652_1_) {
        this.attackTimer = 10;
        this.worldObj.setEntityState(this, (byte)4);
        boolean flag = p_70652_1_.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));

        if ( flag ) {
            p_70652_1_.motionY += 0.4000000059604645D;
        }

        return flag;
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte b) {
        if (b == 4) {
            this.attackTimer = 10;
        }
        else if ( b == 11 ) {
            this.holdRoseTick = 400;
        }
        else super.handleHealthUpdate(b);
    }

    @SideOnly(Side.CLIENT)
    public int getAttackTimer() {
        return this.attackTimer;
    }

    public void setHoldingRose(boolean bool) {
        this.holdRoseTick = bool ? 400 : 0;
        this.worldObj.setEntityState(this, (byte)11);
    }

    @Override
    protected void dropFewItems(boolean p_70628_1_, int p_70628_2_) {
        int j = this.rand.nextInt(3);
        int k;

        for ( k = 0; k < j; ++k){
            this.dropItemWithOffset(Item.getItemFromBlock(Blocks.red_flower), 1, 0.0F);
        }

        k = 3 + this.rand.nextInt(3);

        for (int l = 0; l < k; ++l) {
            this.dropItem(ModItems.superbiumIngot, 1);
        }
    }

    public int getHoldRoseTick() {
        return this.holdRoseTick;
    }

    public boolean isPlayerCreated() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setPlayerCreated(boolean bool) {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (bool) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 1)));
        }
        else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | -2)));
        }
    }

    @Override
    public void onDeath(DamageSource cause) {
        if (!this.isPlayerCreated() && this.attackingPlayer != null) {
            this.village.setReputationForPlayer(this.attackingPlayer.getCommandSenderEntity().getName(), +5);
        }
        super.onDeath(cause);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }
}
