package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by noah on 5/14/14.
 */
public class ItemSuperbiumSword extends ItemSword {

    public ItemSuperbiumSword(ToolMaterial material)
    {

        super(material);
        setUnlocalizedName("superbiumSword");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);


    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
    {
        super.onUpdate(stack, world, entity, par4, par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == stack){
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5, 3));
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 5, 3));

            }
        }
    }

    @Override
    public boolean hasEffect(ItemStack item)
    {
        return true;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List list, boolean b) {
        list.add("Adds amazing buffs");
        super.addInformation(itemStack, entityPlayer, list, b);
    }
}
