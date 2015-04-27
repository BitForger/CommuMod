package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemRedstone;

/**
 * Created by noah on 5/16/14.
 */
public class ItemSuperbiumDust extends ItemRedstone {
    public ItemSuperbiumDust()
    {
        super();
        setUnlocalizedName("superbiumDust");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumDust", "inventory"));
        setCreativeTab(main.modTab);


    }
}
