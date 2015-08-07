package io.cyb3rwarri0r8.commumod.items.food_items;

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

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by noah on 5/29/14.
 */
public class FoodSuperCarrot extends ItemFood {

    public FoodSuperCarrot(int hunger, float saturation, boolean isWolffood) {
        super(hunger, saturation, isWolffood);
        setUnlocalizedName("superCarrot");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superCarrot", "inventory"));
        setCreativeTab(main.modTab);
        setPotionEffect(Potion.heal.id, 5, 5, 5);
    }

    protected void onFoodEaten(ItemStack item, World world, EntityPlayer player)
    {
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 2400, 5));
        player.addPotionEffect(new PotionEffect(Potion.heal.id, 1200, 5));
        player.addPotionEffect(new PotionEffect(Potion.resistance.id, 1500, 4));
        player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1800, 3));
    }

    @Override
    public boolean hasEffect(ItemStack item)
    {
        return true;
    }
}
