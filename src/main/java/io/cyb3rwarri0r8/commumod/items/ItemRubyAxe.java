package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by noah on 8/22/14.
 */
public class ItemRubyAxe extends ItemAxe
{
    public ItemRubyAxe(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("rubyAxe");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/rubyAxe", "inventory"));
        setCreativeTab(main.modTab);

    }

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
        if (!world.isRemote)
        {
            world.createExplosion(entityPlayer,1.0D,1.0D,1.0D,1.0F,true);

        }
        return itemStack;
    }
}
