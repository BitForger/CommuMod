package io.cyb3rwarri0r8.commumod.items;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 8/23/14.
 */
public class ItemRubyArmor extends ItemArmor {

    public ItemRubyArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType);
        setCreativeTab(Commumod.modTab);
        setUnlocalizedName(name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/"+name, "inventory"));

    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == ModItems.rubyHelmet || stack.getItem() == ModItems.rubyChestplate || stack.getItem() == ModItems.rubyBoots) {
            return Reference.MODID + ":" + "textures/models/armor/rubyarmor_1.png";
        } else if (stack.getItem() == ModItems.rubyLeggings) {
            return Reference.MODID + ":" + "textures/models/armor/rubyarmor_2.png";
        } else {
            System.out.println("Error: Texture not found!");
            return null;
        }
    }

}
