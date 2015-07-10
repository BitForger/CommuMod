package io.cyb3rwarri0r8.commumod.blocks;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by noah on 8/8/14.
 */
public class BlockRubyOre extends Block {
    public BlockRubyOre(Material material){
        super(material);
        setBlockName("rubyOre");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypePiston);
        setHardness(3.0F);
        setResistance(5.0F);
        setHarvestLevel("pickaxe",0);


    }

    @Override
    public Item getItemDropped(int meta, Random random, int fortune){
        return ModItems.ruby;
    }
}
