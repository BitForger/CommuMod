package io.cyb3rwarri0r8.commumod.blocks;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by noah on 8/22/14.
 */
public class BlockRuby extends Block
{
    public BlockRuby(Material material)
    {
        super(material);
        setUnlocalizedName("rubyBlock");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
                Item.getItemFromBlock(ModBlocks.rubyBlock),
                0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5),
                        "inventory"));
        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypePiston);
        setHardness(3.0F);
        setResistance(15F);
        setHarvestLevel("pickaxe",1);
    }


}
