package io.cyb3rwarri0r8.commumod.items;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.FMLLog;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteArmor extends ItemArmor {
    public ItemAradactiteArmor(ArmorMaterial material, int ArmorType, String name) {
        super(material, 0, ArmorType);
        setCreativeTab(Commumod.modTab);
        setUnlocalizedName(name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/"+name, "inventory"));

    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (stack.getItem() == ModItems.aradactiteHelmet
                || stack.getItem() == ModItems.aradactiteChestplate
                || stack.getItem() == ModItems.aradactiteBoots){

            return Reference.MODID + ":" + "textures/models/armor/aradactiteLayer_1.png";

        }
        else if(stack.getItem() == ModItems.aradactiteLeggings){

            return Reference.MODID + ":" + "textures/models/armor/aradactiteLayer_2.png";

        }
        else {
            FMLLog.severe("Error: Texture not found! Check spelling!");
            return null;
        }
    }

}
