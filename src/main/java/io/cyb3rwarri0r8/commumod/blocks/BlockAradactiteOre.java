package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;


/**
 * Created by noah on 5/17/14.
 */
public class BlockAradactiteOre extends Block {

    public BlockAradactiteOre()
    {
        super(Material.rock);
        setUnlocalizedName("aradactiteOre");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.aradactiteOre), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));

        setCreativeTab(main.modTab);
        setStepSound(soundTypePiston);
        setHardness(3.0F);
        setResistance(8.5F);
        setHarvestLevel("pickaxe", 1);

    }



}
