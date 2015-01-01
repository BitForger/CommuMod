package io.cyb3rwarri0r8.commumod.items.food_items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2014 Cyb3rWarri0r8
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class FoodTicTac extends ItemFood {
    public FoodTicTac(int hunger, int saturation, boolean isWolfFood) {
        super(hunger, saturation, isWolfFood);
        setUnlocalizedName("ticTac");
        setCreativeTab(main.modTab);
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    }

    @Override
    protected void onFoodEaten(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
        entityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 3500, 3));
    }
}
