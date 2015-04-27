package io.cyb3rwarri0r8.commumod.items.food_items;



import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by noah on 5/29/14.
 */
public class foodItems {

    public static Item superCarrot = new FoodSuperCarrot(5, 5, false);
    public static Item ticTac = new FoodTicTac(3,3,false);
    public static Item ticTacCase = new FoodTicTacCase();



    public static void loadFood()
    {
        RegisterHelper.registerItem(superCarrot);
        GameRegistry.addRecipe(new ItemStack(superCarrot),
                "XXX",
                "XYX",
                "XXX",
                'X', Blocks.gold_block, 'Y', Items.apple
        );

        RegisterHelper.registerItem(ticTac);
        GameRegistry.addRecipe(new ItemStack(ticTac),
                "   ",
                " Y ",
                " X ",
                'Y', Items.dye, 'X', Items.sugar
        );

        RegisterHelper.registerItem(ticTacCase);
        GameRegistry.addShapelessRecipe(new ItemStack(ticTacCase), ModItems.plastic,ModItems.plastic,ModItems.plastic,ModItems.plastic);
    }
}
