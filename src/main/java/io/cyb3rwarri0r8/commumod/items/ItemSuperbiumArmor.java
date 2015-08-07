package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by noah on 5/14/14.
 */
public class ItemSuperbiumArmor extends ItemArmor {
    public ItemSuperbiumArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType );

        setCreativeTab(Commumod.modTab);
        setUnlocalizedName(name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/"+name, "inventory"));


    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == ModItems.superbiumHelmet || stack.getItem() == ModItems.superbiumChestPlate || stack.getItem() == ModItems.superbiumBoots) {
            return Reference.MODID + ":" + "textures/models/armor/superbiumarmor_1.png";
        }else if(stack.getItem() == ModItems.superbiumLeggings) {
            return Reference.MODID + ":" + "textures/models/armor/superbiumarmor_2.png";
        }else {
            System.out.println("Error: Texture not found! Check spelling!");
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(player.capabilities.allowFlying == false){
            player.capabilities.allowFlying=true;
        }
    }

}
/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

// || = or