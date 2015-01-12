package io.cyb3rwarri0r8.commumod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.commumod.fluids.ModFluids;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


/**
 * Created by noah on 10/27/14.
 */
public class BlockPureWater extends BlockFluidClassic
{
    @SideOnly(Side.CLIENT)
    private IIcon stillIcon;
    @SideOnly(Side.CLIENT)
    private IIcon flowingIcon;

    public BlockPureWater(Fluid fluid, Material material)
    {
        super(fluid, material);
        setBlockName("pureWater");

    }

    @Override
    public void registerBlockIcons(IIconRegister register) {
        this.flowingIcon = register.registerIcon(Reference.MODID + ":pureWater_flow");
        this.stillIcon = register.registerIcon(Reference.MODID + ":pureWater_still");
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
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
            if(entity.motionZ <= 1 && entity.motionZ <= 3)
            {
                entity.motionZ = entity.motionZ * 1.1D;
            }
            else if(entity.motionX <= 1 && entity.motionX <= 3)
            {
                entity.motionX = entity.motionX * 1.1D;
            }
            /*else{
                entity.motionX = entity.motionX*1.1D;
                entity.motionZ = entity.motionZ*1.1D;
            }*/
    }


}
