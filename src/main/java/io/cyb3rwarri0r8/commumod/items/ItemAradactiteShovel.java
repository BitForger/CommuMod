package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.item.ItemSpade;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteShovel extends ItemSpade {
    public ItemAradactiteShovel(ToolMaterial material) {
        super(material);
        setUnlocalizedName("aradactiteShovel");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
