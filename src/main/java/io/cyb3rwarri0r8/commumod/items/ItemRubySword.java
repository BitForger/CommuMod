package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.item.ItemSword;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubySword extends ItemSword
{
    public ItemRubySword(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubySword");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }
}
