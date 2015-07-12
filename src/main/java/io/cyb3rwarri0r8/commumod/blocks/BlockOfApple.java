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

import io.cyb3rwarri0r8.commumod.lib.Reference;
import io.cyb3rwarri0r8.commumod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by noah on 10/12/14.
 */
public class BlockOfApple extends Block {
    public BlockOfApple() {
        super(Material.leaves);
        setUnlocalizedName("appleBlock");


        setCreativeTab(main.modTab);
        setStepSound(soundTypeGrass);
    }




    public Item getItemDropped(int meta, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this);
    }


}
