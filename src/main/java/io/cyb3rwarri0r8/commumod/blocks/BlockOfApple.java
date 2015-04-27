package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by noah on 10/12/14.
 */
public class BlockOfApple extends Block {
    public BlockOfApple() {
        super(Material.leaves);
        setUnlocalizedName("appleBlock");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.appleBlock), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));

        setCreativeTab(main.modTab);
        setStepSound(soundTypeGrass);
    }




    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }


}
