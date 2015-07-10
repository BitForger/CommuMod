package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemRedstone;

/**
 * Created by noah on 5/16/14.
 */
public class ItemSuperbiumDust extends ItemRedstone {
    public ItemSuperbiumDust()
    {
        super();
        setUnlocalizedName("superbiumDust");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);


    }
}
