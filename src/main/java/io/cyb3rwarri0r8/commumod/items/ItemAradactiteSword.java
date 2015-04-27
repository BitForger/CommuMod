package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteSword extends ItemSword {
    public ItemAradactiteSword(ToolMaterial material) {
        super(material);
        setUnlocalizedName("aradactiteSword");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/aradactiteSword", "inventory"));
        setCreativeTab(main.modTab);
    }
}
