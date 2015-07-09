package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by noah on 8/8/14.
 */
public class ItemRubyPickaxe extends ItemPickaxe {
    public ItemRubyPickaxe(ToolMaterial material) {
        super(material);
        setUnlocalizedName("rubyPickaxe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
    }
}
