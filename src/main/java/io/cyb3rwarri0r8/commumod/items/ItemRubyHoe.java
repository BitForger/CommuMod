package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.item.ItemHoe;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubyHoe extends ItemHoe
{
    public ItemRubyHoe(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubyHoe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }
}
