package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

/**
 * Created by noah on 5/17/14.
 */
public class BlockAradactiteOre extends Block {

    public BlockAradactiteOre()
    {
        super(Material.rock);
        setBlockName("aradactiteOre");
        setBlockTextureName(Reference.MODID + ":" +getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypePiston);
        setHardness(3.0F);
        setResistance(8.5F);
        setHarvestLevel("pickaxe", 1);

    }

    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
        return super.getIcon(p_149691_1_, p_149691_2_);
    }

}
