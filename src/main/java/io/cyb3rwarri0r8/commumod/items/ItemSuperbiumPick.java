package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemSuperbiumPick extends ItemPickaxe {

    public ItemSuperbiumPick(ToolMaterial material)
    {
        super(material);
        setUnlocalizedName("superbiumPick");
        setCreativeTab(main.modTab);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/superbiumPick", "inventory"));
    }

    @Override
    public void addInformation(ItemStack par1, EntityPlayer par2, List par3, boolean par4)
    {

    }
}
