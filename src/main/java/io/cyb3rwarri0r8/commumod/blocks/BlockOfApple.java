package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by noah on 10/12/14.
 */
public class BlockOfApple extends Block {
    public BlockOfApple() {
        super(Material.leaves);
        setBlockName("appleBlock");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypeGrass);
    }



    @Override
    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }


}
