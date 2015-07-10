package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.item.Item;

public class ItemSuperbiumIngot extends Item {

    public ItemSuperbiumIngot()
    {
        super();
        setUnlocalizedName("superbiumIngot");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }

}
