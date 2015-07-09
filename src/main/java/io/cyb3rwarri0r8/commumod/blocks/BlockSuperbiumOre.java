package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;


public class BlockSuperbiumOre extends Block {

    public BlockSuperbiumOre()
    {
        super(Material.rock);
        this.setBlockName("superbiumOre");
        this.setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        this.setCreativeTab(Commumod.modTab);
        this.setStepSound(soundTypePiston);
        setHardness(4.0F);
        setResistance(10.0F);
        setHarvestLevel("pickaxe", 0);


    }
    @Override
    public Item getItemDropped(int metadata, Random rand, int fortune)
    {
       return ModItems.superbiumDust;
    }
}
