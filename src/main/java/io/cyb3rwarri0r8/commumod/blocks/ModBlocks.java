package io.cyb3rwarri0r8.commumod.blocks;


import io.cyb3rwarri0r8.commumod.items.ModItems;
import io.cyb3rwarri0r8.commumod.lib.helpers.RegisterHelper;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by noah on 5/14/14.
 */
public class ModBlocks {
    public static Block superbiumOre;
    public static Block superbiumBlock;
    // Aradactite
    public static Block aradactiteOre;
    public static Block aradactiteBlock;
    // Superbium TNT
    public static Block superbiumTNT;
    // Hydrogen TNT
    public static Block hydrogenTNT;
    // Miner shack
    public static Block minerShack;
    // Superbium torch
    public static Block superbiumTorch;

    // Ruby
    public static Block rubyOre;
    public static Block rubyBlock;

    public static Block purifier_idle;
    public static Block purifier_active;

    //Cobalt
    public static Block cobaltOre;

    public static Block appleBlock;

    public static Material materialRetaw = new MaterialLiquid(MapColor.emeraldColor);





    public static void loadBlocks()
    {
        //Load all necessary blocks here...
        superbiumOre = new BlockSuperbiumOre();
        RegisterHelper.registerBlock(superbiumOre);


        // ******************************************************************************


        superbiumBlock = new BlockSuperbiumBlock(Material.rock);
        RegisterHelper.registerBlock(superbiumBlock);



        // ******************************************************************************


        //Aradactite
        aradactiteOre = new BlockAradactiteOre();
        RegisterHelper.registerBlock(aradactiteOre);


        // Aradactite block
        aradactiteBlock = new BlockAradactiteBlock(Material.anvil);
        RegisterHelper.registerBlock(aradactiteBlock);



        // Superbium TNT
        superbiumTNT = new BlockSuperbiumTNT();
        RegisterHelper.registerBlock(superbiumTNT);

        // Instant structures generation
        minerShack = new BlockMinerShack(Material.rock);
        RegisterHelper.registerBlock(minerShack);
        // ******************************************************************************
        // Superbium torch
        superbiumTorch = new BlockSuperbiumTorch();
        RegisterHelper.registerBlock(superbiumTorch);

        // ******************************************************************************
        // Ruby ore
        rubyOre = new BlockRubyOre(Material.rock);
        RegisterHelper.registerBlock(rubyOre);

        rubyBlock = new BlockRuby(Material.rock);
        RegisterHelper.registerBlock(rubyBlock);




        cobaltOre = new BlockCobaltOre(Material.rock);
        RegisterHelper.registerBlock(cobaltOre);

        purifier_idle = new BlockPurifier(false).setUnlocalizedName("purifierIdle").setCreativeTab(main.modTab);
        RegisterHelper.registerBlock(purifier_idle);




        purifier_active = new BlockPurifier(true).setUnlocalizedName("purifierActive");
        RegisterHelper.registerBlock(purifier_active);

        appleBlock = new BlockOfApple();
        RegisterHelper.registerBlock(appleBlock);


        hydrogenTNT = new BlockHydrogenTNT();
        RegisterHelper.registerBlock(hydrogenTNT);






    }

    public static void addBlockRecipes()
    {
        RegisterHelper.addBlockRecipe(ModItems.superbiumIngot, new ItemStack(superbiumBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.superbiumIngot, 9), superbiumBlock);

        RegisterHelper.addBlockRecipe(ModItems.aradactiteIngot, new ItemStack(aradactiteBlock));
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.aradactiteIngot, 9), aradactiteBlock);

        GameRegistry.addRecipe(new ItemStack(superbiumTNT, 2),
                "XYX",
                "YZY",
                "XYX",
                'X', ModItems.superbiumDust, 'Y', Items.stick, 'Z', Items.gunpowder
        );

        GameRegistry.addRecipe(new ItemStack(superbiumTorch, 4),
            "Y",
            "X",
            'Y', ModItems.superbiumDust, 'X', Items.stick
    );

        RegisterHelper.addBlockRecipe(ModItems.ruby, new ItemStack(rubyBlock));

        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ruby, 9), rubyBlock);

        GameRegistry.addRecipe(new ItemStack(purifier_idle,1),
                "XXX",
                "X X",
                "XXX",
                'X', ModItems.cobaltIngot
        );

        RegisterHelper.addBlockRecipe(Items.apple, new ItemStack(appleBlock));

        GameRegistry.addShapelessRecipe(new ItemStack(Items.apple,9), new ItemStack(appleBlock));

        GameRegistry.addRecipe(new ItemStack(hydrogenTNT,1),
                "XYX",
                "YXY",
                "XYX",
                'X', ModItems.enderDust, 'Y', Blocks.sand
        );

    }



}
