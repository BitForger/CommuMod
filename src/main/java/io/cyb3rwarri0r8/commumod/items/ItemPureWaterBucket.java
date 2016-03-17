package io.cyb3rwarri0r8.commumod.items;

/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
 */

import io.cyb3rwarri0r8.commumod.Commumod;
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
        setCreativeTab(Commumod.modTab);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(this, 0, new ModelResourceLocation("commumod:textures/items/pureWaterBucket", "inventory"));

    }
}
