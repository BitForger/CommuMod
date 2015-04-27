package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

/**
 * Created by noah on 10/3/14.
 */
public class ItemEnderDust extends Item {
    public ItemEnderDust(){
        super();
        setUnlocalizedName("enderDust");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/enderDust", "inventory"));
        setCreativeTab(main.modTab);
    }
}
