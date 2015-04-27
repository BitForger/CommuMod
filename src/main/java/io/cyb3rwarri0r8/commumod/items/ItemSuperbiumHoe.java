package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemHoe;

/**
 * Created by noah on 5/27/14.
 */
public class ItemSuperbiumHoe extends ItemHoe {
    public ItemSuperbiumHoe(ToolMaterial material) {
        super(material);
        setUnlocalizedName("superbiumHoe");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumHoe", "inventory"));
        setCreativeTab(main.modTab);
    }
}
