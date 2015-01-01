package io.cyb3rwarri0r8.commumod.blocks;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.commumod.fluids.ModFluidBase;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.lib.helpers.ServerHelper;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;

/**
 * Created by noah on 10/29/14.
 */
public class BlockRetaw extends ModFluidBase
{
    @SideOnly(Side.CLIENT)
    private IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    private IIcon flowingIcon;

    private static boolean effect = true;
    private static boolean enableSourceCondense = true;
    private static boolean enableSourceFloat = true;
    private static int maxGlowstoneHeight = 120;
    public int LEVELS = 6;

    public static final Material materialRetaw = new MaterialLiquid(MapColor.emeraldColor);

    public BlockRetaw(Fluid fluid, Material material) {
        super(ModFluids.retaw, materialRetaw, Reference.MODID + ":" + "retaw");
        setBlockName("retaw");
        setHardness(1F);
        setQuantaPerBlock(LEVELS);
        setTickRate(20);
    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        this.flowingIcon = register.registerIcon(Reference.MODID + ":retaw_flow");
        this.stillIcon = register.registerIcon(Reference.MODID + ":retaw_still");
        ModFluids.pureWater.setStillIcon(stillIcon);
        ModFluids.pureWater.setFlowingIcon(flowingIcon);
    }
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 0 || side == 1)? stillIcon : flowingIcon;
    }



    @Override
    public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.canDisplace(world, x, y, z);
    }

    @Override
    public boolean displaceIfPossible(World world, int x, int y, int z) {
        if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
        return super.displaceIfPossible(world, x, y, z);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
        if (!effect) {
            return;
        }
        if (entity instanceof EntityLivingBase) {
            if (entity.motionY < -0.2) {
                entity.motionY *= 0.5;
                if (entity.fallDistance > 20) {
                    entity.fallDistance = 20;
                } else {
                    entity.fallDistance *= 0.95;
                }
            }
        }
        if (ServerHelper.isClientWorld(world)) {
            return;
        }
        if (world.getTotalWorldTime() % 8 == 0 && entity instanceof EntityLivingBase && !((EntityLivingBase) entity).isEntityUndead()) {
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 6 * 20, 0));
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.jump.id, 6 * 20, 0));
        }
    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rand) {
        if (world.getBlockMetadata(x, y, z) == 0) {
            if (rand.nextInt(3) == 0) {
                if (shouldSourceBlockCondense(world, x, y, z)) {
                    world.setBlock(x, y, z, Blocks.glowstone);
                    return;
                }
                if (shouldSourceBlockFloat(world, x, y, z)) {
                    world.setBlock(x, y + densityDir, z, this, 0, 3);
                    world.setBlockToAir(x, y, z);
                    return;
                }
            }
        } else if (y + densityDir > maxGlowstoneHeight) {
            int quantaRemaining = quantaPerBlock - world.getBlockMetadata(x, y, z);
            int expQuanta = -101;
            int y2 = y - densityDir;
            if (world.getBlock(x, y2, z) == this || world.getBlock(x - 1, y2, z) == this || world.getBlock(x + 1, y2, z) == this
                    || world.getBlock(x, y2, z - 1) == this || world.getBlock(x, y2, z + 1) == this) {
                expQuanta = quantaPerBlock - 1;
            } else {
                int maxQuanta = -100;
                maxQuanta = getLargerQuanta(world, x - 1, y, z, maxQuanta);
                maxQuanta = getLargerQuanta(world, x + 1, y, z, maxQuanta);
                maxQuanta = getLargerQuanta(world, x, y, z - 1, maxQuanta);
                maxQuanta = getLargerQuanta(world, x, y, z + 1, maxQuanta);
                expQuanta = maxQuanta - 1;
            }
            // decay calculation
            if (expQuanta != quantaRemaining) {
                quantaRemaining = expQuanta;
                if (expQuanta <= 0) {
                    world.setBlockToAir(x, y, z);
                } else {
                    world.setBlockMetadataWithNotify(x, y, z, quantaPerBlock - expQuanta, 3);
                    world.scheduleBlockUpdate(x, y, z, this, tickRate);
                    world.notifyBlocksOfNeighborChange(x, y, z, this);
                }
            }
            return;
        }
        super.updateTick(world, x, y, z, rand);
    }
    protected boolean shouldSourceBlockCondense(World world, int x, int y, int z) {
        return enableSourceCondense
                && (y + densityDir > maxGlowstoneHeight || y + densityDir > world.getHeight() || y + densityDir > maxGlowstoneHeight * 0.8F
                && !canDisplace(world, x, y + densityDir, z));
    }
    protected boolean shouldSourceBlockFloat(World world, int x, int y, int z) {
        return enableSourceFloat && (world.getBlock(x, y + densityDir, z) == this && world.getBlockMetadata(x, y + densityDir, z) != 0);
    }

}
