package io.cyb3rwarri0r8.commumod.entity;


import io.cyb3rwarri0r8.commumod.items.food_items.foodItems;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

/**
 * Created by noah on 5/27/14.
 */
public class EntityMiner extends EntityMob {
    public EntityMiner(World par1World) {
        super(par1World);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(5, new EntityAIAttackOnCollide(this, 1.0D, true));
        this.tasks.addTask(6, new EntityAIMoveTowardsTarget(this, 1.0D, 2.0F));
        this.addRandomArmor();
        this.setSprinting(false);
    }

    public boolean isAIEnabled()
    {
        return true;
    }



    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
        getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.0D);
        getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.2D);
        getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2.0D);
    }

    protected void entityInit()
    {
        super.entityInit();
        this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
    }


    public void onKillEntity(EntityLivingBase par1EntityLivingBase)
    {
        super.onKillEntity(par1EntityLivingBase);

        if ((this.worldObj.difficultySetting == EnumDifficulty.NORMAL || this.worldObj.difficultySetting == EnumDifficulty.HARD || this.worldObj.difficultySetting == EnumDifficulty.EASY || this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) && par1EntityLivingBase instanceof EntityVillager)
        {
            if (this.rand.nextBoolean())
            {
                return;
            }

            EntityMiner entityminer = new EntityMiner(this.worldObj);
            entityminer.copyLocationAndAnglesFrom(par1EntityLivingBase);
            this.worldObj.removeEntity(par1EntityLivingBase);
            entityminer.onSpawnWithEgg((IEntityLivingData)null);


            this.worldObj.spawnEntityInWorld(entityminer);
            this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1016, (int)this.posX, (int)this.posY, (int)this.posZ, 0);
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