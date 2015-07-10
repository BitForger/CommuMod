package io.cyb3rwarri0r8.commumod.items;

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

/**
 * Created by noah on 10/29/14.
 */
public class ItemRetawBucket extends ItemBucket {
    public ItemRetawBucket(Block block)
    {
        super(block);
        setUnlocalizedName("retawBucket");
        setContainerItem(Items.bucket);
        setCreativeTab(Commumod.modTab);
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
    }
}
