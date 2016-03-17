package io.cyb3rwarri0r8.commumod.blocks;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
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
        setUnlocalizedName("appleBlock");


        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypeGrass);
    }




    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }


}
