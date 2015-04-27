package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.entity.EntityAxe;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumAxe", "inventory"));
        setCreativeTab(main.modTab);

    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

        if (!world.isRemote) {
            world.spawnEntityInWorld(new EntityAxe(world, player ));
        }return itemStack;
    }

}
