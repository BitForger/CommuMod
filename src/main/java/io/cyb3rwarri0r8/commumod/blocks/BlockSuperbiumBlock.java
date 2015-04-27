package io.cyb3rwarri0r8.commumod.blocks;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;


/**
 * Created by noah on 5/16/14.
 */
public class BlockSuperbiumBlock extends Block {
    public BlockSuperbiumBlock(Material material) {
        super(material);
        this.setUnlocalizedName("superbiumBlock");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.superbiumBlock), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));

        this.setCreativeTab(main.modTab);
        this.setStepSound(soundTypeMetal);
        setHardness(4.0F);
        setResistance(80F);
        setHarvestLevel("pickaxe", 1);
    }

}
