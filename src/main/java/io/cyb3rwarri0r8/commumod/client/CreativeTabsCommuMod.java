package io.cyb3rwarri0r8.commumod.client;


import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by noah on 5/16/14.
 */
public class CreativeTabsCommuMod extends CreativeTabs {
    public CreativeTabsCommuMod(String tabLabel)
    {
        super(tabLabel);
    }
    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(ModBlocks.superbiumOre);
    }
}
