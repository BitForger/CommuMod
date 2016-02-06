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

import io.cyb3rwarri0r8.commumod.items.food_items.foodItems;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityMiner extends EntityMob {
    public EntityMiner(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIWander(this, 0.67D));
        this.tasks.addTask(5, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIMoveTowardsTarget(this, 1.0D, 2.0F));

        this.targetTasks.addTask( 1, new EntityAIHurtByTarget( this, true ) );
        this.targetTasks.addTask( 2, new EntityAINearestAttackableTarget( this, EntitySuperbiumGolem.class, 1, false, true, IMob.mobSelector ) );
        this.targetTasks.addTask( 2, new EntityAINearestAttackableTarget( this, EntityAradactiteGolem.class, 1, false, true, IMob.mobSelector ) );
//        this.addRandomArmor();
//        this.setSprinting(false);
    }


    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
//        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.67D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, ( byte ) 0 );
        this.getDataWatcher().addObject(13, ( byte ) 0 );
        this.getDataWatcher().addObject(14, ( byte ) 0 );
    }


    public void onKillEntity(EntityLivingBase par1EntityLivingBase)
    {
        super.onKillEntity(par1EntityLivingBase);

        if ((this.worldObj.getDifficulty().equals(EnumDifficulty.NORMAL) || this.worldObj.getDifficulty().equals(EnumDifficulty.HARD) || this.worldObj.getDifficulty().equals(EnumDifficulty.EASY) || this.worldObj.getDifficulty().equals(EnumDifficulty.PEACEFUL)) && par1EntityLivingBase instanceof EntityVillager)
        {
            if (this.rand.nextBoolean())
            {
                return;
            }

            EntityMiner entityminer = new EntityMiner(this.worldObj);
            entityminer.copyLocationAndAnglesFrom(par1EntityLivingBase);
            this.worldObj.removeEntity(par1EntityLivingBase);
//            entityminer.on((IEntityLivingData) null);

            BlockPos blockPos = new BlockPos(this.posX, this.posY, this.posZ);
            this.worldObj.spawnEntityInWorld(entityminer);
            this.worldObj.playAuxSFXAtEntity(null, 1016, blockPos, 0);
        }
    }

    protected Item getDropItem()
    {
        return foodItems.superCarrot;

    }

    protected void dropRareDrop(int par1)
    {
        switch (this.rand.nextInt(3))
        {
            case 0:
                this.dropItem(Items.diamond, 1);
                break;
            case 1:
                this.dropItem(Items.diamond_pickaxe, 1);
                break;
            case 2:
                this.dropItem(Items.diamond_sword, 1);
        }
    }


    protected String getLivingSound()
    {
        return "mob.villager.idle";
    }


    protected void addRandomArmor()
    {
        this.setCurrentItemOrArmor(0, new ItemStack(ModItems.aradactiteAxe));
    }


}