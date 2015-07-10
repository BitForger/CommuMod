package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.item.ItemSword;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteSword extends ItemSword {
    public ItemAradactiteSword(ToolMaterial material) {
        super(material);
        setUnlocalizedName("aradactiteSword");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
