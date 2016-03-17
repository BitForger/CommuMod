package io.cyb3rwarri0r8.commumod.items;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;

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
        setCreativeTab(Commumod.modTab);


    }
}
