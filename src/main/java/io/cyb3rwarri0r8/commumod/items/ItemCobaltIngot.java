package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by noah on 9/28/14.
 */
public class ItemCobaltIngot extends Item {

    public ItemCobaltIngot()
    {
        super();
        setUnlocalizedName("cobaltIngot");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/cobaltIngot", "inventory"));
        setCreativeTab(main.modTab);
    }
}
