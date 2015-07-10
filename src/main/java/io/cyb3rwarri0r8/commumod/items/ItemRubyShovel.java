package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRubyShovel extends ItemSpade {
    public ItemRubyShovel(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubyShovel");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int slotId, boolean isEquipped)
    {
        super.onUpdate(itemStack,world,entity,slotId,isEquipped);
        if(!world.isRemote) {
            if (isEquipped && entity instanceof EntityPlayer) {
                ((EntityPlayer) entity).addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1, 2));
            }
        }

    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }
}
