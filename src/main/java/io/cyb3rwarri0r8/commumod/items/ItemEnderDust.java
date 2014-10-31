package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.help.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.item.Item;

/**
 * Created by noah on 10/3/14.
 */
public class ItemEnderDust extends Item {
    public ItemEnderDust(){
        super();
        setUnlocalizedName("enderDust");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);
    }
}
