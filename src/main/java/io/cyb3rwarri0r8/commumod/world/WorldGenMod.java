package io.cyb3rwarri0r8.commumod.world;



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

import io.cyb3rwarri0r8.commumod.blocks.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by noah on 5/14/14.
 */
public class WorldGenMod implements IWorldGenerator
{
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimensionId())
        {
            case -1:
                generateNether(world, rand, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, rand, chunkX * 16, chunkZ * 16);
        }
//        String s = world.getBiomeGenForCoords(chunkX, chunkZ).biomeName;
//        if (s.startsWith("Extreme"))
//        {
//            generateInOcean(world, rand, chunkX, chunkZ);
//        }
    }

    /*private void generateInOcean(World world, Random rand, int chunkX, int chunkZ) {
        for(int i = 0; i < 4; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(65);
            int randPosZ = chunkZ + rand.nextInt(16);

            new WorldGenMinable(ModBlocks.cobaltOre, 100).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }*/

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        for(int i = 0; i < 4; i++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(60);
            int randPosZ = chunkZ + rand.nextInt(16);

            BlockPos blockPos = new BlockPos(randPosX, randPosY, randPosZ);

            new WorldGenMinable(ModBlocks.superbiumOre.getDefaultState(), 7).generate(world, rand, blockPos);
        }

        for (int j = 0; j < 4; j++) {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(256);
            int randPosZ = chunkZ + rand.nextInt(16);

            BlockPos blockPos = new BlockPos(randPosX, randPosY, randPosZ);

            new WorldGenMinable(ModBlocks.aradactiteOre.getDefaultState(), 15).generate(world, rand, blockPos);
        }

        for (int r = 0; r < 4; r++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(56);
            int randPosZ = chunkZ + rand.nextInt(16);

            BlockPos blockPos = new BlockPos(randPosX, randPosY, randPosZ);

            new WorldGenMinable(ModBlocks.rubyOre.getDefaultState(), 12).generate(world, rand, blockPos);
        }

        for (int f = 0; f < 4; f++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(70);
            int randPosZ = chunkZ + rand.nextInt(16);

            BlockPos blockPos = new BlockPos(randPosX, randPosY, randPosZ);

            new WorldGenMinable(ModBlocks.cobaltOre.getDefaultState(), 13).generate(world, rand, blockPos);
        }

    }

    private void generate(World world, Random random, int x, int y, int z)
    {


    }




    private void generateNether(World world, Random rand, int i, int j)
    {

    }

}
