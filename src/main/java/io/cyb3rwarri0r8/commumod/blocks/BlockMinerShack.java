package io.cyb3rwarri0r8.commumod.blocks;


/*
 *  CommuMod - A Minecraft Modification
 *  Copyright (C) ${YEAR} Cyb3rWarri0r8
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

import io.cyb3rwarri0r8.commumod.Commumod;
import io.cyb3rwarri0r8.commumod.lib.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
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
        setUnlocalizedName("minerShack");
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(ModBlocks.minerShack), 0, new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5), "inventory"));


    }



    @Override
    public void onBlockPlacedBy(World world, BlockPos blockPos, IBlockState blockState, EntityLivingBase entity, ItemStack itemStack) {
        super.onBlockPlacedBy(world, blockPos, blockState, entity, itemStack);
        world.setBlockToAir(blockPos);
        // build walls
        world.setBlockState(blockPos, Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 1, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 2, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 3, 0), Blocks.cobblestone.getDefaultState());

        // ---------------------------------------
        world.setBlockState(blockPos.add(1, 0, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1, 1, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1, 2, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1, 3, 0), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(2, 0, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2, 1, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2, 2, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2, 3, 0), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(3,0,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3, 1, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3, 2, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3, 3, 0), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(4, 0, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4, 1, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4, 2, 0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4, 3, 0), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        // +++++++++++++++++Wall+++++++++++++++++++++++
        // --------------------------------------------
        world.setBlockState(blockPos.add(0, 0, 1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 1, 1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 2, 1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 3, 1), Blocks.cobblestone.getDefaultState());

        // ---------------------------------------
        world.setBlockState(blockPos.add(0, 0, 1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0, 1, 1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,1), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(0,0,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,1,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,2), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(0,0,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,1,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,3), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(0,0,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,1,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,4), Blocks.cobblestone.getDefaultState());
        // --------------------------------------------
        // +++++++++++++++++Wall+++++++++++++++++++++++
        // --------------------------------------------
        world.setBlockState(blockPos.add(0,0,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,1,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,5), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(0,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(0,3,6), Blocks.cobblestone.getDefaultState());

        // --------------------------------------------
        world.setBlockState(blockPos.add(1,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,3,6), Blocks.cobblestone.getDefaultState());

        // ------------------------------------------------
        world.setBlockState(blockPos.add(2,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,3,6), Blocks.cobblestone.getDefaultState());

        // ------------------------------------------------
        world.setBlockState(blockPos.add(3,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,3,6), Blocks.cobblestone.getDefaultState());

        // ------------------------------------------------
        world.setBlockState(blockPos.add(4,0,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,0,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,0,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,0,0), Blocks.cobblestone.getDefaultState());

        // ------------------------------------------------
        world.setBlockState(blockPos.add(4,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,3,6), Blocks.cobblestone.getDefaultState());

        // ------------------------------------------------
        // ++++++++++++++++++Wall++++++++++++++++++++++++++
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,1,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,0), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,0), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,1,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,1), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,1,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,2), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,3), Blocks.spruce_door.getDefaultState());
//        world.setBlockState(x + 5, y + 1, z + 3, b.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,3), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,4), Blocks.spruce_door.getDefaultState());
//        world.setBlockState(x + 5, y + 1, z + 4, b.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,4), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,1,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,5), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,5), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(5,0,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,1,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,2,6), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(5,3,6), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        // +++++++++++++++Ceiling++++++++++++++++++++++++++
        // ------------------------------------------------
        world.setBlockState(blockPos.add(1,3,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,3,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,3,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,3,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(1,3,5), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(2,3,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,3,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,3,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,3,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(2,3,5), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(3,3,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,3,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,3,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,3,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(3,3,5), Blocks.cobblestone.getDefaultState());
        // ------------------------------------------------
        world.setBlockState(blockPos.add(4,3,1), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,3,2), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,3,3), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,3,4), Blocks.cobblestone.getDefaultState());
        world.setBlockState(blockPos.add(4,3,5), Blocks.cobblestone.getDefaultState());

    }
}
