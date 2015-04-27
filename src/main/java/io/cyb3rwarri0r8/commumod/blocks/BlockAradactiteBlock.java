package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by noah on 5/25/14.
 */
public class BlockAradactiteBlock extends Block {
    public BlockAradactiteBlock(Material material)
    {
        super(Material.anvil);
        this.setUnlocalizedName("aradactiteBlock");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.aradactiteBlock), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));

        this.setCreativeTab(main.modTab);
        this.setStepSound(soundTypePiston);
        setHardness(3.5F);
        setResistance(5.5F);
        setHarvestLevel("pickaxe", 1);
    }
}
