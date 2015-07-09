package io.cyb3rwarri0r8.commumod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.entity.EntityHydrogenTNTPrimed;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by noah on 10/22/14.
 */
public class BlockHydrogenTNT extends Block {

    @SideOnly(Side.CLIENT)
    public IIcon top;
    @SideOnly(Side.CLIENT)
    public IIcon bottom;

    protected BlockHydrogenTNT() {
        super(Material.tnt);
        setCreativeTab(Commumod.modTab);
        setBlockName("hydrogenTNT");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setStepSound(soundTypeGrass);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 0 ? this.bottom : (p_149691_1_ == 1 ? this.top : this.blockIcon);
    }

    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);

        if (world.isBlockIndirectlyGettingPowered(x, y, z)) {
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
        }
    }


    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
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
            EntityHydrogenTNTPrimed hydrogenTNTPrimed = new EntityHydrogenTNTPrimed(p_149723_1_, (double)((float)p_149723_2_ + 0.5F), (double)((float)p_149723_3_ + 0.5F), (double)((float)p_149723_4_ + 0.5F), p_149723_5_.getExplosivePlacedBy());
            hydrogenTNTPrimed.fuse = p_149723_1_.rand.nextInt(hydrogenTNTPrimed.fuse / 4) + hydrogenTNTPrimed.fuse / 8;
            p_149723_1_.spawnEntityInWorld(hydrogenTNTPrimed);
        }
    }

    public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
    {
        this.func_150114_a(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase)null);
    }

    public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
    {
        if (!p_150114_1_.isRemote)
        {
            if ((p_150114_5_ & 1) == 1)
            {
                EntityHydrogenTNTPrimed hydrogenTNTPrimed = new EntityHydrogenTNTPrimed(p_150114_1_, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
                p_150114_1_.spawnEntityInWorld(hydrogenTNTPrimed);
                p_150114_1_.playSoundAtEntity(hydrogenTNTPrimed, "game.tnt.primed", 1.0F, 1.0F);
            }
        }
    }

    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_5_.getCurrentEquippedItem() != null && p_149727_5_.getCurrentEquippedItem().getItem() == Items.flint_and_steel)
        {
            this.func_150114_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1, p_149727_5_);
            p_149727_1_.setBlockToAir(p_149727_2_, p_149727_3_, p_149727_4_);
            p_149727_5_.getCurrentEquippedItem().damageItem(1, p_149727_5_);
            return true;
        }
        else
        {
            return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
        }
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        if (p_149670_5_ instanceof EntityArrow && !p_149670_1_.isRemote)
        {
            EntityArrow entityarrow = (EntityArrow)p_149670_5_;

            if (entityarrow.isBurning())
            {
                this.func_150114_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, entityarrow.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)entityarrow.shootingEntity : null);
                p_149670_1_.setBlockToAir(p_149670_2_, p_149670_3_, p_149670_4_);
            }
        }
    }

    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_side");
        this.top = p_149651_1_.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_top");
        this.bottom = p_149651_1_.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_bottom");
    }

}
