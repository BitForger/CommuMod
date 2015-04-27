package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemSuperbiumIngot extends Item {

    public ItemSuperbiumIngot()
    {
        super();
        setUnlocalizedName("superbiumIngot");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumIngot", "inventory"));
        setCreativeTab(main.modTab);

    }

}
