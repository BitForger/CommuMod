package io.cyb3rwarri0r8.commumod.lib;


/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.entity.EntityMiner;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

import java.util.Iterator;
import java.util.List;

public class ModRecipeHandler {
    public static void removeRecipes(){
        LanguageRegistry.instance().addStringLocalization("itemGroup.modTab", "en_US", "CommuMod");
        EntityRegistry.addSpawn(EntityMiner.class, 2, 1, 3, EnumCreatureType.CREATURE, BiomeGenBase.extremeHills);

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> Leash = recipes.iterator();

        while (Leash.hasNext()) {
            ItemStack is = Leash.next().getRecipeOutput();
            if (is != null && is.getItem() == Items.golden_axe | is.getItem() == Items.golden_hoe | is.getItem() == Items.golden_pickaxe
                    | is.getItem() == Items.golden_shovel | is.getItem() == Items.golden_sword /*| is.getItem() == Items.diamond_axe
                    | is.getItem() == Items.diamond_hoe | is.getItem() == Items.diamond_pickaxe | is.getItem() == Items.diamond_shovel
                    | is.getItem() == Items.diamond_sword | is.getItem() == Items.iron_axe*/)
                Leash.remove();


        }
    }
}
