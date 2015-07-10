package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactitePick extends ItemPickaxe {
    public ItemAradactitePick(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("aradactitePick");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
