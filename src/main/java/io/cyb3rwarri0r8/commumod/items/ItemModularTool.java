package io.cyb3rwarri0r8.commumod.items;


import io.cyb3rwarri0r8.commumod.lib.IModularTool;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemModularTool extends Item implements IModularTool {

    public ItemModularTool()
    {
        super();
        setHasSubtypes(true);
        setUnlocalizedName("modularTool");
        setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
        setCreativeTab(main.modTab);
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inventoryCrafting) {
        //Durability
        int ironDurability = ToolMaterial.IRON.getMaxUses();
        int finalDurability = ironDurability;

        // Loop through crafting grid
        for (int i = 0; i < 3; i++)
        {
            ItemStack headComponent = inventoryCrafting.getStackInRowAndColumn(i,0);
            if (headComponent.getItem() == Items.diamond | headComponent.getItem() == Items.emerald)
            {
                finalDurability += 150;
            }
            else if(headComponent.getItem() == Items.iron_ingot)
            {
                finalDurability = ironDurability;
            }
            else if(headComponent.getItem() == Item.getItemFromBlock(Blocks.gold_block))
            {
                finalDurability -= 100;
            }
            else if (headComponent.getItem() == Item.getItemFromBlock(Blocks.cobblestone))
            {
                finalDurability -= 25;
            }
            else if(headComponent.getItem() == Item.getItemFromBlock(Blocks.planks))
            {
                finalDurability -= 50;
            }
        }
        ItemStack result = new ItemStack(ModItems.modularTool);
        result.getItem().setMaxDamage(finalDurability);

        return result;

    }
}
