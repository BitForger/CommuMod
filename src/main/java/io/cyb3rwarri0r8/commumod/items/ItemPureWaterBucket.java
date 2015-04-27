package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

/**
 * Created by noah on 10/27/14.
 */
public class ItemPureWaterBucket extends ItemBucket {

    public ItemPureWaterBucket(Block block) {
        super(block);
        setUnlocalizedName("pureWaterBucket");
        setContainerItem(Items.bucket);
        setCreativeTab(main.modTab);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/pureWaterBucket", "inventory"));

    }
}
