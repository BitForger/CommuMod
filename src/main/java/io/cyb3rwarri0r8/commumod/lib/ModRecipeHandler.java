package io.cyb3rwarri0r8.commumod.lib;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import io.cyb3rwarri0r8.commumod.entity.EntityMiner;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Iterator;
import java.util.List;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class ModRecipeHandler {
    public static void removeRecipes(){
        LanguageRegistry.instance().addStringLocalization("itemGroup.modTab", "en_US", "CommuMod");
        EntityRegistry.addSpawn(EntityMiner.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.extremeHills);

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> Leash = recipes.iterator();

        while (Leash.hasNext()) {
            ItemStack is = Leash.next().getRecipeOutput();
            if (is != null && is.getItem() == Items.golden_axe | is.getItem() == Items.golden_hoe | is.getItem() == Items.golden_pickaxe
                    | is.getItem() == Items.golden_shovel | is.getItem() == Items.golden_sword /*| is.getItem() == Items.diamond_axe
                    | is.getItem() == Items.diamond_hoe | is.getItem() == Items.diamond_pickaxe | is.getItem() == Items.diamond_shovel
                    | is.getItem() == Items.diamond_sword | is.getItem() == Items.iron_axe*/)
                Leash.remove();


        };
    }
}
