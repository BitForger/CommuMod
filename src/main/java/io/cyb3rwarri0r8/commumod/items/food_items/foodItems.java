package io.cyb3rwarri0r8.commumod.items.food_items;


import cpw.mods.fml.common.registry.GameRegistry;
import io.cyb3rwarri0r8.commumod.lib.RegisterHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by noah on 5/29/14.
 */
public class foodItems {

    public static Item superCarrot = new FoodSuperCarrot(5, 5, false);



    public static void loadFood()
    {
        RegisterHelper.registerItem(superCarrot);
        GameRegistry.addRecipe(new ItemStack(superCarrot), new Object[]{
                "XXX",
                "XYX",
                "XXX",
                'X', Blocks.gold_block, 'Y', Items.apple,
        });
    }
}
