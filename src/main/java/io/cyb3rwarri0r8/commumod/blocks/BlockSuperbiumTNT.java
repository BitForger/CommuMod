package io.cyb3rwarri0r8.commumod.blocks;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.entity.EntitySuperbiumTNTPrimed;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;


public class BlockSuperbiumTNT extends Block {



    public static final PropertyBool EXPLODE_PROP = PropertyBool.create("explode");


    private static final String __OBFID = "CL_00000324";

    public BlockSuperbiumTNT()
    {
        super(Material.tnt);
        setCreativeTab(Commumod.modTab);
        setUnlocalizedName("superbiumTNT");
        this.setDefaultState(this.getDefaultState());
        setStepSound(soundTypeGrass);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World p_149726_1_, BlockPos blockPos, IBlockState blockState) {
        super.onBlockAdded(p_149726_1_, blockPos, blockState);

        if (p_149726_1_.isBlockPowered(blockPos)) {
            this.onBlockDestroyedByPlayer(p_149726_1_, blockPos, blockState.withProperty(EXPLODE_PROP, true));
            p_149726_1_.setBlockToAir(blockPos);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World p_149695_1_, BlockPos blockPos, IBlockState blockState, Block neighborBlock)
    {
        if (p_149695_1_.isBlockPowered(blockPos))
        {
            this.onBlockDestroyedByPlayer(p_149695_1_, blockPos, blockState.withProperty(EXPLODE_PROP, true));
            p_149695_1_.setBlockToAir(blockPos);
        }
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World p_149723_1_, int p_149723_2_, int p_149723_3_, int p_149723_4_, Explosion p_149723_5_)
    {
        if (!p_149723_1_.isRemote)
        {
            EntitySuperbiumTNTPrimed entitysuperbiumtntprimed = new EntitySuperbiumTNTPrimed(p_149723_1_, (double)((float)p_149723_2_ + 0.5F), (double)((float)p_149723_3_ + 0.5F), (double)((float)p_149723_4_ + 0.5F), p_149723_5_.getExplosivePlacedBy());
            entitysuperbiumtntprimed.fuse = p_149723_1_.rand.nextInt(entitysuperbiumtntprimed.fuse / 4) + entitysuperbiumtntprimed.fuse / 8;
            p_149723_1_.spawnEntityInWorld(entitysuperbiumtntprimed);
        }
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
    public void onBlockDestroyedByPlayer(World p_149664_1_, BlockPos blockPos, IBlockState blockState)
    {
        this.func_180692_a(p_149664_1_, blockPos, blockState, null);
    }

    public void func_180692_a(World worldIn, BlockPos p_180692_2_, IBlockState p_180692_3_, EntityLivingBase p_180692_4_)
    {
        if (!worldIn.isRemote)
        {
            if ((Boolean) p_180692_3_.getValue(EXPLODE_PROP))
            {
                EntityTNTPrimed entitytntprimed = new EntityTNTPrimed(worldIn, (double)((float)p_180692_2_.getX() + 0.5F), (double)((float)p_180692_2_.getY() + 0.5F), (double)((float)p_180692_2_.getZ() + 0.5F), p_180692_4_);
                worldIn.spawnEntityInWorld(entitytntprimed);
                worldIn.playSoundAtEntity(entitytntprimed, "game.tnt.primed", 1.0F, 1.0F);
            }
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (playerIn.getCurrentEquippedItem() != null)
        {
            Item item = playerIn.getCurrentEquippedItem().getItem();

            if (item == Items.flint_and_steel || item == Items.fire_charge)
            {
                this.func_180692_a(worldIn, pos, state.withProperty(EXPLODE_PROP, true), playerIn);
                worldIn.setBlockToAir(pos);

                if (item == Items.flint_and_steel)
                {
                    playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
                }
                else if (!playerIn.capabilities.isCreativeMode)
                {
                    --playerIn.getCurrentEquippedItem().stackSize;
                }

                return true;
            }
        }

        return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, BlockPos blockPos, IBlockState blockState, Entity p_149670_5_)
    {
        if (p_149670_5_ instanceof EntityArrow && !p_149670_1_.isRemote)
        {
            EntityArrow entityarrow = (EntityArrow)p_149670_5_;

            if (entityarrow.isBurning())
            {
                this.func_180692_a(p_149670_1_, blockPos, blockState, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase) entityarrow.shootingEntity : null);
                p_149670_1_.setBlockToAir(blockPos);
            }
        }
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }




}
