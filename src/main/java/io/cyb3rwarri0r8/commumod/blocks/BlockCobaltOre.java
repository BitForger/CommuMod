package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;


/**
 * Created by noah on 9/8/14.
 */
public class BlockCobaltOre extends Block
{
    public BlockCobaltOre(Material material)
    {
        super(material);
        setUnlocalizedName("cobaltOre");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.cobaltOre), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));

        setCreativeTab(main.modTab);
        setStepSound(soundTypePiston);
        setHardness(2.5F);
        setResistance(5.5F);
        setHarvestLevel("pickaxe",1);
    }



}
