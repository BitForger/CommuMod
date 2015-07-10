package io.cyb3rwarri0r8.commumod.blocks;


import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.Commumod;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by noah on 6/14/14.
 */
public class BlockMinerShack extends Block {
    Blocks b;
    public BlockMinerShack(Material material)
    {
        super(material);
        setCreativeTab(Commumod.modTab);
        setBlockName("minerShack");
        setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));

    }



    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, x, y, z, entity, itemStack);
        world.setBlockToAir(x,y,z);
        // build walls
        world.setBlock(x, y, z, b.cobblestone);
        world.setBlock(x, y + 1, z, b.cobblestone);
        world.setBlock(x, y + 2, z, b.cobblestone);
        world.setBlock(x, y + 3, z, b.cobblestone);

        // ---------------------------------------
        world.setBlock(x + 1, y, z, b.cobblestone);
        world.setBlock(x + 1, y + 1, z, b.cobblestone);
        world.setBlock(x + 1, y + 2, z, b.cobblestone);
        world.setBlock(x + 1, y + 3, z, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x + 2, y, z, b.cobblestone);
        world.setBlock(x + 2, y + 1, z, b.cobblestone);
        world.setBlock(x + 2, y + 2, z, b.cobblestone);
        world.setBlock(x + 2, y + 3, z, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x + 3, y, z, b.cobblestone);
        world.setBlock(x + 3, y + 1, z, b.cobblestone);
        world.setBlock(x + 3, y + 2, z, b.cobblestone);
        world.setBlock(x + 3, y + 3, z, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x + 4, y, z, b.cobblestone);
        world.setBlock(x + 4, y + 1, z, b.cobblestone);
        world.setBlock(x + 4, y + 2, z, b.cobblestone);
        world.setBlock(x + 4, y + 3, z, b.cobblestone);

        // --------------------------------------------
        // +++++++++++++++++Wall+++++++++++++++++++++++
        // --------------------------------------------
        world.setBlock(x, y, z + 1, b.cobblestone);
        world.setBlock(x, y + 1, z + 1, b.cobblestone);
        world.setBlock(x, y + 2, z + 1, b.cobblestone);
        world.setBlock(x, y + 3, z + 1, b.cobblestone);

        // ---------------------------------------
        world.setBlock(x, y, z + 1, b.cobblestone);
        world.setBlock(x, y + 1, z + 1, b.cobblestone);
        world.setBlock(x, y + 2, z + 1, b.cobblestone);
        world.setBlock(x, y + 3, z + 1, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x, y, z + 2, b.cobblestone);
        world.setBlock(x, y + 1, z + 2, b.cobblestone);
        world.setBlock(x, y + 2, z + 2, b.cobblestone);
        world.setBlock(x, y + 3, z + 2, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x, y, z + 3, b.cobblestone);
        world.setBlock(x, y + 1, z + 3, b.cobblestone);
        world.setBlock(x, y + 2, z + 3, b.cobblestone);
        world.setBlock(x, y + 3, z + 3, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x, y, z + 4, b.cobblestone);
        world.setBlock(x, y + 1, z + 4, b.cobblestone);
        world.setBlock(x, y + 2, z + 4, b.cobblestone);
        world.setBlock(x, y + 3, z + 4, b.cobblestone);
        // --------------------------------------------
        // +++++++++++++++++Wall+++++++++++++++++++++++
        // --------------------------------------------
        world.setBlock(x, y, z + 5, b.cobblestone);
        world.setBlock(x, y + 1, z + 5, b.cobblestone);
        world.setBlock(x, y + 2, z + 5, b.cobblestone);
        world.setBlock(x, y + 3, z + 5, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x, y, z + 6, b.cobblestone);
        world.setBlock(x, y + 1, z + 6, b.cobblestone);
        world.setBlock(x, y + 2, z + 6, b.cobblestone);
        world.setBlock(x, y + 3, z + 6, b.cobblestone);

        // --------------------------------------------
        world.setBlock(x + 1, y, z + 6, b.cobblestone);
        world.setBlock(x + 1, y + 1, z + 6, b.cobblestone);
        world.setBlock(x + 1, y + 2, z + 6, b.cobblestone);
        world.setBlock(x + 1, y + 3, z + 6, b.cobblestone);

        // ------------------------------------------------
        world.setBlock(x + 2, y, z + 6, b.cobblestone);
        world.setBlock(x + 2, y + 1, z + 6, b.cobblestone);
        world.setBlock(x + 2, y + 2, z + 6, b.cobblestone);
        world.setBlock(x + 2, y + 3, z + 6, b.cobblestone);

        // ------------------------------------------------
        world.setBlock(x + 3, y, z + 6, b.cobblestone);
        world.setBlock(x + 3, y + 1, z + 6, b.cobblestone);
        world.setBlock(x + 3, y + 2, z + 6, b.cobblestone);
        world.setBlock(x + 3, y + 3, z + 6, b.cobblestone);

        // ------------------------------------------------
        world.setBlock(x + 4, y, z, b.cobblestone);
        world.setBlock(x + 4, y, z, b.cobblestone);
        world.setBlock(x + 4, y, z, b.cobblestone);
        world.setBlock(x + 4, y, z, b.cobblestone);

        // ------------------------------------------------
        world.setBlock(x + 4, y, z + 6, b.cobblestone);
        world.setBlock(x + 4, y + 1, z + 6, b.cobblestone);
        world.setBlock(x + 4, y + 2, z + 6, b.cobblestone);
        world.setBlock(x + 4, y + 3, z + 6, b.cobblestone);

        // ------------------------------------------------
        // ++++++++++++++++++Wall++++++++++++++++++++++++++
        // ------------------------------------------------
        world.setBlock(x + 5, y, z, b.cobblestone);
        world.setBlock(x + 5, y + 1, z, b.cobblestone);
        world.setBlock(x + 5, y + 2, z, b.cobblestone);
        world.setBlock(x + 5, y + 3, z, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 1, b.cobblestone);
        world.setBlock(x + 5, y + 1, z + 1, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 1, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 1, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 2, b.cobblestone);
        world.setBlock(x + 5, y + 1, z + 2, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 2, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 2, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 3, b.wooden_door);
//        world.setBlock(x + 5, y + 1, z + 3, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 3, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 3, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 4, b.wooden_door);
//        world.setBlock(x + 5, y + 1, z + 4, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 4, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 4, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 5, b.cobblestone);
        world.setBlock(x + 5, y + 1, z + 5, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 5, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 5, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 5, y, z + 6, b.cobblestone);
        world.setBlock(x + 5, y + 1, z + 6, b.cobblestone);
        world.setBlock(x + 5, y + 2, z + 6, b.cobblestone);
        world.setBlock(x + 5, y + 3, z + 6, b.cobblestone);
        // ------------------------------------------------
        // +++++++++++++++Ceiling++++++++++++++++++++++++++
        // ------------------------------------------------
        world.setBlock(x + 1, y + 3, z + 1, b.cobblestone);
        world.setBlock(x + 1, y + 3, z + 2, b.cobblestone);
        world.setBlock(x + 1, y + 3, z + 3, b.cobblestone);
        world.setBlock(x + 1, y + 3, z + 4, b.cobblestone);
        world.setBlock(x + 1, y + 3, z + 5, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 2, y + 3, z + 1, b.cobblestone);
        world.setBlock(x + 2, y + 3, z + 2, b.cobblestone);
        world.setBlock(x + 2, y + 3, z + 3, b.cobblestone);
        world.setBlock(x + 2, y + 3, z + 4, b.cobblestone);
        world.setBlock(x + 2, y + 3, z + 5, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 3, y + 3, z + 1, b.cobblestone);
        world.setBlock(x + 3, y + 3, z + 2, b.cobblestone);
        world.setBlock(x + 3, y + 3, z + 3, b.cobblestone);
        world.setBlock(x + 3, y + 3, z + 4, b.cobblestone);
        world.setBlock(x + 3, y + 3, z + 5, b.cobblestone);
        // ------------------------------------------------
        world.setBlock(x + 4, y + 3, z + 1, b.cobblestone);
        world.setBlock(x + 4, y + 3, z + 2, b.cobblestone);
        world.setBlock(x + 4, y + 3, z + 3, b.cobblestone);
        world.setBlock(x + 4, y + 3, z + 4, b.cobblestone);
        world.setBlock(x + 4, y + 3, z + 5, b.cobblestone);

    }
}
