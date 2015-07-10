package io.cyb3rwarri0r8.commumod.items.food_items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
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
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);
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
