package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemSpade;

/**
 * Created by noah on 5/26/14.
 */
public class ItemSuperbiumShovel extends ItemSpade {
    public ItemSuperbiumShovel(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("superbiumShovel");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumShovel", "inventory"));
        setCreativeTab(main.modTab);
    }
}
