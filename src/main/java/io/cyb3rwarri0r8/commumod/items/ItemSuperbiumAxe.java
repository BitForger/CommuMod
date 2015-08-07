package io.cyb3rwarri0r8.commumod.items;


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

import io.cyb3rwarri0r8.commumod.entity.EntityAxe;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by noah on 5/13/14.
 */
public class ItemSuperbiumAxe extends ItemAxe {

    public ItemSuperbiumAxe(ToolMaterial material)
    {

        super(material);
        setUnlocalizedName("superbiumAxe");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumAxe", "inventory"));
        setCreativeTab(Commumod.modTab);

    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityAxe(world, player ));
        }return itemStack;
    }

}
