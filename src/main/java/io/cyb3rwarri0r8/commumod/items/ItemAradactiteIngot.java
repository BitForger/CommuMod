package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.Item;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteIngot extends Item {
    public ItemAradactiteIngot()
    {
        super();
        setUnlocalizedName("aradactiteIngot");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
