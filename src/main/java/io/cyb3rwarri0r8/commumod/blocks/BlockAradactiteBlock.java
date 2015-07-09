package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by noah on 5/25/14.
 */
public class BlockAradactiteBlock extends Block {
    public BlockAradactiteBlock(Material material)
    {
        super(Material.anvil);
        this.setBlockName("aradactiteBlock");
        this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        this.setCreativeTab(Commumod.modTab);
        this.setStepSound(soundTypePiston);
        setHardness(3.5F);
        setResistance(5.5F);
        setHarvestLevel("pickaxe", 1);
    }
}
