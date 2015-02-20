package io.cyb3rwarri0r8.commumod.items;




import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;

public class ItemModularPickaxe extends Item {

    public ItemModularPickaxe()
    {
        super();

        setUnlocalizedName("modularPickaxe");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);
    }




}
