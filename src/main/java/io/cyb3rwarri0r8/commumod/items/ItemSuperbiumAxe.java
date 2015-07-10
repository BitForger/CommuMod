package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.entity.EntityAxe;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by noah on 5/13/14.
 */
public class ItemSuperbiumAxe extends ItemAxe {

    public ItemSuperbiumAxe(ToolMaterial material)
    {

        super(material);
        setUnlocalizedName("superbiumAxe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(Commumod.modTab);

    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityAxe(world, player ));
        }return itemStack;
    }

}
