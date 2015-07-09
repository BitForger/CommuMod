package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


/**
 * Created by noah on 5/14/14.
 */
public class ItemSuperbiumArmor extends ItemArmor {
    public ItemSuperbiumArmor(ArmorMaterial material, int armorType, String name) {
        super(material, 0, armorType );

        setCreativeTab(Commumod.modTab);
        setUnlocalizedName(name);
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));


    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
        if (stack.getItem() == ModItems.superbiumHelmet || stack.getItem() == ModItems.superbiumChestPlate || stack.getItem() == ModItems.superbiumBoots) {
            return Reference.MODID + ":" + "textures/models/armor/superbiumarmor_1.png";
        }else if(stack.getItem() == ModItems.superbiumLeggings) {
            return Reference.MODID + ":" + "textures/models/armor/superbiumarmor_2.png";
        }else {
            System.out.println("Error: Texture not found! Check spelling!");
            return null;
        }
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        if(!player.capabilities.allowFlying) player.capabilities.allowFlying = true;
    }

}
// || = or