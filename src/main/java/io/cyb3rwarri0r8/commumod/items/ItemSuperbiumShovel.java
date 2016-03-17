package io.cyb3rwarri0r8.commumod.items;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;

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
        setCreativeTab(Commumod.modTab);
    }
}
