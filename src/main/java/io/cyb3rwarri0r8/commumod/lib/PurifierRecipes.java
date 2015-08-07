package io.cyb3rwarri0r8.commumod.lib;

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

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by noah on 10/3/14.
 */
public class PurifierRecipes{
    private static final PurifierRecipes recipesBase = new PurifierRecipes();

    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    private PurifierRecipes()
    {

    }


    public static PurifierRecipes smelting(){
        return recipesBase;
    }

    public void lists(ItemStack itemStack, ItemStack itemStack2, float xp)
    {
        this.getSmeltingList().put(itemStack, itemStack2);
        experienceList.put(itemStack2, Float.valueOf(xp));

    }

    public void addLists(Item item, ItemStack itemStack, float xp)
    {
        this.lists(new ItemStack(item, 1, 32767), itemStack, xp);
    }

    public void addRecipe(Item item, ItemStack itemStack, float xp)
    {
        this.addLists(item, itemStack, xp);
    }


    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack p_151395_1_)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.canBeSmelted(p_151395_1_, (ItemStack) entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean canBeSmelted(ItemStack itemStack, ItemStack itemStack1)
    {
        return itemStack1.getItem() == itemStack.getItem() && (itemStack1.getItemDamage() == 32767 || itemStack.getItemDamage() == itemStack.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float giveXP(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.canBeSmelted(p_151398_1_, (ItemStack) entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}
