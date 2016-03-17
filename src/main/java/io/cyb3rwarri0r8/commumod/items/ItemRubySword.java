package io.cyb3rwarri0r8.commumod.items;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemSword;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubySword extends ItemSword
{
    public ItemRubySword(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubySword");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/rubySword", "inventory"));
        setCreativeTab(Commumod.modTab);

    }
}
