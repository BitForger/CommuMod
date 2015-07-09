package io.cyb3rwarri0r8.commumod.blocks;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;

/**
 * Created by noah on 8/22/14.
 */
public class BlockRuby extends Block
{
    public BlockRuby(Material material)
    {
        super(material);
        setBlockName("rubyBlock");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
        setStepSound(soundTypePiston);
        setHardness(3.0F);
        setResistance(15F);
        setHarvestLevel("pickaxe",1);
    }

    //Render block as icon
    @Override
    public IIcon getIcon(int par1, int par2)
    {
        return super.getIcon(par1, par2);
    }
}
