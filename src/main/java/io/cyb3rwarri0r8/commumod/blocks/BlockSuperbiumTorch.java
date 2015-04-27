package io.cyb3rwarri0r8.commumod.blocks;


import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.mojang.authlib.properties.Property;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.Iterator;
import java.util.Random;


/**
 * Created by noah on 7/24/14.
 */
public class BlockSuperbiumTorch extends Block {
    public static final PropertyDirection FACING_PROP = PropertyDirection.create("facing", new Predicate()
    {
        private static final String __OBFID = "CL_00002054";
        public boolean func_176601_a(EnumFacing p_176601_1_)
        {
            return p_176601_1_ != EnumFacing.DOWN;
        }
        public boolean apply(Object p_apply_1_)
        {
            return this.func_176601_a((EnumFacing)p_apply_1_);
        }
    });
    private static final String __OBFID = "CL_00000325";

    protected BlockSuperbiumTorch(Material material)
    {
        super(Material.circuits);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING_PROP, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
    {
        return null;
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean isFullCube()
    {
        return false;
    }

    private boolean func_176594_d(World worldIn, BlockPos p_176594_2_)
    {
        if (World.doesBlockHaveSolidTopSurface(worldIn, p_176594_2_))
        {
            return true;
        }
        else
        {
            Block block = worldIn.getBlockState(p_176594_2_).getBlock();
            return block.canPlaceTorchOnTop(worldIn, p_176594_2_);
        }
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        Iterator iterator = FACING_PROP.getAllowedValues().iterator();
        EnumFacing enumfacing;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            enumfacing = (EnumFacing)iterator.next();
        }
        while (!this.func_176595_b(worldIn, pos, enumfacing));

        return true;
    }

    private boolean func_176595_b(World worldIn, BlockPos p_176595_2_, EnumFacing p_176595_3_)
    {
        BlockPos blockpos1 = p_176595_2_.offset(p_176595_3_.getOpposite());
        boolean flag = p_176595_3_.getAxis().isHorizontal();
        return flag && worldIn.isSideSolid(blockpos1, p_176595_3_, true) || p_176595_3_.equals(EnumFacing.UP) && this.func_176594_d(worldIn, blockpos1);
    }

    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (this.func_176595_b(worldIn, pos, facing))
        {
            return this.getDefaultState().withProperty(FACING_PROP, facing);
        }
        else
        {
            Iterator iterator = EnumFacing.Plane.HORIZONTAL.iterator();
            EnumFacing enumfacing1;

            do
            {
                if (!iterator.hasNext())
                {
                    return this.getDefaultState();
                }

                enumfacing1 = (EnumFacing)iterator.next();
            }
            while (!worldIn.isSideSolid(pos.offset(enumfacing1.getOpposite()), enumfacing1, true));

            return this.getDefaultState().withProperty(FACING_PROP, enumfacing1);
        }
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        this.func_176593_f(worldIn, pos, state);
    }

    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
        this.func_176592_e(worldIn, pos, state);
    }

    protected boolean func_176592_e(World worldIn, BlockPos p_176592_2_, IBlockState p_176592_3_)
    {
        if (!this.func_176593_f(worldIn, p_176592_2_, p_176592_3_))
        {
            return true;
        }
        else
        {
            EnumFacing enumfacing = (EnumFacing)p_176592_3_.getValue(FACING_PROP);
            EnumFacing.Axis axis = enumfacing.getAxis();
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            boolean flag = false;

            if (axis.isHorizontal() && !worldIn.isSideSolid(p_176592_2_.offset(enumfacing1), enumfacing1, true))
            {
                flag = true;
            }
            else if (axis.isVertical() && !this.func_176594_d(worldIn, p_176592_2_.offset(enumfacing1)))
            {
                flag = true;
            }

            if (flag)
            {
                this.dropBlockAsItem(worldIn, p_176592_2_, p_176592_3_, 0);
                worldIn.setBlockToAir(p_176592_2_);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    protected boolean func_176593_f(World worldIn, BlockPos p_176593_2_, IBlockState p_176593_3_)
    {
        if (p_176593_3_.getBlock() == this && this.func_176595_b(worldIn, p_176593_2_, (EnumFacing)p_176593_3_.getValue(FACING_PROP)))
        {
            return true;
        }
        else
        {
            if (worldIn.getBlockState(p_176593_2_).getBlock() == this)
            {
                this.dropBlockAsItem(worldIn, p_176593_2_, p_176593_3_, 0);
                worldIn.setBlockToAir(p_176593_2_);
            }

            return false;
        }
    }

    /**
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit.
     *
     * @param start The start vector
     * @param end The end vector
     */
    public MovingObjectPosition collisionRayTrace(World worldIn, BlockPos pos, Vec3 start, Vec3 end)
    {
        EnumFacing enumfacing = (EnumFacing)worldIn.getBlockState(pos).getValue(FACING_PROP);
        float f = 0.15F;

        if (enumfacing == EnumFacing.EAST)
        {
            this.setBlockBounds(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
        }
        else if (enumfacing == EnumFacing.WEST)
        {
            this.setBlockBounds(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
        }
        else if (enumfacing == EnumFacing.SOUTH)
        {
            this.setBlockBounds(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
        }
        else if (enumfacing == EnumFacing.NORTH)
        {
            this.setBlockBounds(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
        }
        else
        {
            f = 0.1F;
            this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
        }

        return super.collisionRayTrace(worldIn, pos, start, end);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta)
        {
            case 1:
                iblockstate = iblockstate.withProperty(FACING_PROP, EnumFacing.EAST);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(FACING_PROP, EnumFacing.WEST);
                break;
            case 3:
                iblockstate = iblockstate.withProperty(FACING_PROP, EnumFacing.SOUTH);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(FACING_PROP, EnumFacing.NORTH);
                break;
            case 5:
            default:
                iblockstate = iblockstate.withProperty(FACING_PROP, EnumFacing.UP);
        }

        return iblockstate;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING_PROP);
        double d0 = (double)pos.getX() + 0.5D;
        double d1 = (double)pos.getY() + 0.7D;
        double d2 = (double)pos.getZ() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;

        if (enumfacing.getAxis().isHorizontal())
        {
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
        }
        else
        {
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        byte b0 = 0;
        int i;

        switch (BlockSuperbiumTorch.SwitchEnumFacing.field_176609_a[((EnumFacing)state.getValue(FACING_PROP)).ordinal()])
        {
            case 1:
                i = b0 | 1;
                break;
            case 2:
                i = b0 | 2;
                break;
            case 3:
                i = b0 | 3;
                break;
            case 4:
                i = b0 | 4;
                break;
            case 5:
            case 6:
            default:
                i = b0 | 5;
        }

        return i;
    }

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING_PROP});
    }

    static final class SwitchEnumFacing
    {
        static final int[] field_176609_a = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00002053";

        static
        {
            try
            {
                field_176609_a[EnumFacing.EAST.ordinal()] = 1;
            }
            catch (NoSuchFieldError var6)
            {
                ;
            }

            try
            {
                field_176609_a[EnumFacing.WEST.ordinal()] = 2;
            }
            catch (NoSuchFieldError var5)
            {
                ;
            }

            try
            {
                field_176609_a[EnumFacing.SOUTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                field_176609_a[EnumFacing.NORTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                field_176609_a[EnumFacing.DOWN.ordinal()] = 5;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                field_176609_a[EnumFacing.UP.ordinal()] = 6;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
}
