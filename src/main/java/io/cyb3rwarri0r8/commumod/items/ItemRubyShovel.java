package io.cyb3rwarri0r8.commumod.items;


import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubyShovel extends ItemSpade {
    public ItemRubyShovel(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubyShovel");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }

    @Override
    public void onUpdate(ItemStack itemStack, World world, Entity entity, int par4, boolean par5)
    {
        if(!world.isRemote){
        super.onUpdate(itemStack,world,entity,par4,par5);
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack equipped = player.getCurrentEquippedItem();
            if (equipped == itemStack)
            {
                player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 5, 4));
            }

        }
        }
    }

    @Override
    public boolean hasEffect(ItemStack par1ItemStack) {
        return true;
    }


}
