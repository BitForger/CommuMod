package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.ItemPickaxe;

/**
 * Created by noah on 8/8/14.
 */
public class ItemRubyPickaxe extends ItemPickaxe {
    public ItemRubyPickaxe(ToolMaterial material) {
        super(material);
        setUnlocalizedName("rubyPickaxe");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/rubyPickaxe", "inventory"));
        setCreativeTab(main.modTab);
    }
}
