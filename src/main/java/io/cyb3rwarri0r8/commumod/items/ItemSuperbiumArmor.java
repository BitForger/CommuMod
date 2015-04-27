package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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

        setCreativeTab(main.modTab);
        setUnlocalizedName(name);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/"+name, "inventory"));


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
        if(player.capabilities.allowFlying == false){
            player.capabilities.allowFlying=true;
        }
    }

}
// || = or