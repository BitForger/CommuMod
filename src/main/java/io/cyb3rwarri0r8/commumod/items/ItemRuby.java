package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.item.Item;

/**
 * Created by noah on 6/13/14.
 */
public class ItemRuby extends Item {

    public ItemRuby()
    {
        super();
        setUnlocalizedName("ruby");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);

    }

}
