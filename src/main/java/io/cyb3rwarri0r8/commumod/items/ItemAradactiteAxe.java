package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemAxe;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteAxe extends ItemAxe {
    public ItemAradactiteAxe(ToolMaterial material) {
        super(material);
        setUnlocalizedName("aradactiteAxe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
