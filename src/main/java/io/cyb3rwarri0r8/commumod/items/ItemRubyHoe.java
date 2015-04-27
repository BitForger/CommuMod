package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemHoe;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubyHoe extends ItemHoe
{
    public ItemRubyHoe(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubyHoe");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/rubyHoe", "inventory"));
        setCreativeTab(main.modTab);

    }
}
