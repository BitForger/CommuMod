package io.cyb3rwarri0r8.commumod.items.food_items;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class FoodTicTacCase extends Item {
    public FoodTicTacCase()
    {
        super();
        setUnlocalizedName("ticTacCase");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/ticTacCase", "inventory"));
        setMaxDamage(20);
        setCreativeTab(Commumod.modTab);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer) {
//        itemStack.damageItem(1,entityPlayer);
//        entityPlayer.getFoodStats().setFoodLevel(entityPlayer.getFoodStats().getFoodLevel() + 2);
        final int maxDamage = 20;
        final int maxFood = 20;
        final int currentFood = entityPlayer.getFoodStats().getFoodLevel();

        if(!world.isRemote)
        {
            if(currentFood < maxFood)
            {
                entityPlayer.getFoodStats().setFoodLevel(currentFood + 2);
                itemStack.damageItem(1, entityPlayer);
                if(itemStack.getItemDamage() == 19)
                {
                    return itemStack;
                }
            }
            else if(currentFood >= maxFood)
            {
                return itemStack;
            }
        }
        else {
            return itemStack;
        }
        return itemStack;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean b) {
        list.add("A case full of tic tacs");
        super.addInformation(itemStack, entityPlayer, list, b);
    }
}
