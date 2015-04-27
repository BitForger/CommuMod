package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteArmor extends ItemArmor {
    public ItemAradactiteArmor(ArmorMaterial material, int ArmorType, String name) {
        super(material, 0, ArmorType);
        setCreativeTab(main.modTab);
        setUnlocalizedName(name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/"+name, "inventory"));

    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
    {
        if (stack.getItem() == ModItems.aradactiteHelmet || stack.getItem() == ModItems.aradactiteChestplate || stack.getItem() == ModItems.aradactiteBoots){
            return Reference.MODID + ":" + "textures/models/armor/aradactiteLayer_1.png";
        }else if(stack.getItem() == ModItems.aradactiteLeggings){
            return Reference.MODID + ":" + "textures/models/armor/aradactiteLayer_2.png";
        }else {
            System.out.println("Error: Texture not found! Check spelling!");
            return null;
        }
    }
}
