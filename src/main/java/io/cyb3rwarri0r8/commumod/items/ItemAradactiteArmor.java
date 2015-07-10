package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 5/18/14.
 */
public class ItemAradactiteArmor extends ItemArmor {
    public ItemAradactiteArmor(ArmorMaterial material, int ArmorType, String name) {
        super(material, 0, ArmorType);
        setCreativeTab(Commumod.modTab);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

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
