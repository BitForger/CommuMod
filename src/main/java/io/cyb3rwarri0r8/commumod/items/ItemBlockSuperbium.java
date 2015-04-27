package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;

/**
 * Created by noah on 5/16/14.
 */
public class ItemBlockSuperbium extends net.minecraft.item.Item {
    public ItemBlockSuperbium()
    {
        super();
        setUnlocalizedName("itemSuperbiumBlock");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumBlock", "inventory"));

    }
}
