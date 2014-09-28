package io.kaminocoding.commumod.blocks;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.kaminocoding.commumod.entity.TileEntityPurifier;
import io.kaminocoding.commumod.help.Reference;
import io.kaminocoding.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by noah on 9/9/14.
 */
public class BlockPurifier extends BlockContainer
{
    @SideOnly(Side.CLIENT)
    private IIcon top;

    @SideOnly(Side.CLIENT)
    private IIcon front;

    private static boolean isBurning;

    private final boolean isIsBurning;
    private final Random rand = new Random();

    public BlockPurifier(boolean isActive)
    {
        super(Material.rock);
        isIsBurning = isActive;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register)
    {
        this.blockIcon = register.registerIcon(Reference.MODID + ":purifier_side");
        this.front = register.registerIcon(this.isIsBurning ? Reference.MODID + ":purifier_frontActive" : Reference.MODID + ":purifier_frontIdle");
        this.top = register.registerIcon(Reference.MODID + ":purifier_top");
    }

    public IIcon getIcon(int side, int meta)
    {
        if(side == 1)
        {
            return top;
        }
        else if (side == 3)
        {
            return front;
        }
        else
        {
            return this.blockIcon;
        }
    }

    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        FMLLog.info("Attempting to open GUI for purifier");
        player.openGui(main.instance, 0, world, x, y, z);
        return true;
    }

    public Item getItemDropped(int par1, Random rand, int par3)
    {
        return Item.getItemFromBlock(ModBlocks.purifier_idle);
    }

    public Item getItem(World world, int par2, int par3, int par4)
    {
        return Item.getItemFromBlock(ModBlocks.purifier_idle);
    }

    @SideOnly(Side.CLIENT)
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.direction(world, x, y, z);
    }

    private void direction(World world, int x, int y, int z) {
        if ( !world.isRemote )
        {
            Block direction = world.getBlock(x, y, z - 1);
            Block direction1 = world.getBlock(x, y, z + 1);
            Block direction2 = world.getBlock(x - 1, y, z);
            Block direction3 = world.getBlock(x + 1, y, z);

            byte byte0 = 3;

            if (direction.func_149730_j() && direction.func_149730_j())
            {
                byte0 = 3;
            }
            if (direction1.func_149730_j() && direction1.func_149730_j())
            {
                byte0 = 2;
            }
            if (direction2.func_149730_j() && direction2.func_149730_j())
            {
                byte0 = 5;
            }
            if (direction3.func_149730_j() && direction3.func_149730_j())
            {
                byte0 = 4;
            }
            world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
        }
    }

    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack)
    {
        int direction = MathHelper.floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D ) & 3;

        if( direction == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);

        }
        if( direction == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }
        if( direction == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);

        }
        if( direction == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);

        }
        if (itemStack.hasDisplayName())
        {
            ((TileEntityPurifier) world.getTileEntity(x, y, z)).furnaceName(itemStack.getDisplayName());
        }

    }

    public static void updateBlockState(boolean burning, World world, int x, int y, int z)
    {
        int direction = world.getBlockMetadata(x, y, z);
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        isBurning = true;

        if (burning)
        {
            world.setBlock(x, y, z, ModBlocks.purifier_active);
        }
        else
        {
            world.setBlock(x, y, z, ModBlocks.purifier_idle);
        }

        isBurning = false;

        world.setBlockMetadataWithNotify(x, y, z, direction, 2);

        if(tileEntity != null)
        {
            tileEntity.validate();
            world.setTileEntity(x, y, z, tileEntity);
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int meta)
    {
        if (!isBurning)
        {
            TileEntityPurifier tileEntityPurifier = (TileEntityPurifier)world.getTileEntity(x, y, z);

            if (tileEntityPurifier != null)
            {
                for (int i1 = 0; i1 < tileEntityPurifier.getSizeInventory(); ++i1)
                {
                    ItemStack itemstack = tileEntityPurifier.getStackInSlot(i1);

                    if (itemstack != null)
                    {
                        float f = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.rand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.rand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int j1 = this.rand.nextInt(21) + 10;

                            if (j1 > itemstack.stackSize)
                            {
                                j1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= j1;
                            EntityItem entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.rand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.rand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.rand.nextGaussian() * f3);
                            world.spawnEntityInWorld(entityitem);
                        }
                    }
                }

                world.func_147453_f(x, y, z, block);
            }
        }

        super.breakBlock(world, x, y, z, block, meta);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random rand)
    {
        if (this.isIsBurning)
        {
            int l = world.getBlockMetadata(x, y, z);
            float f = (float)x + 0.5F;
            float f1 = (float)y + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)z + 0.5F;
            float f3 = 0.52F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;

            if (l == 4)
            {
                world.spawnParticle("smoke", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 5)
            {
                world.spawnParticle("smoke", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 2)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 - f3), 0.0D, 0.0D, 0.0D);
            }
            else if (l == 3)
            {
                world.spawnParticle("smoke", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
                world.spawnParticle("flame", (double)(f + f4), (double)f1, (double)(f2 + f3), 0.0D, 0.0D, 0.0D);
            }
        }
    }


    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileEntityPurifier();
    }
}
