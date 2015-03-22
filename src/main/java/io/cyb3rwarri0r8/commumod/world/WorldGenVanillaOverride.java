package io.cyb3rwarri0r8.commumod.world;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * CommuMod - A Minecraft Modification
 * Copyright (C) 2015 Cyb3rWarri0r8
 * <p/>
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 * <p/>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */


public class WorldGenVanillaOverride implements IWorldGenerator {
    /** The world the BiomeDecorator is currently decorating */
    public World currentWorld;
    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;
    /** The X-coordinate of the chunk currently being decorated */
    public int chunk_X;
    /** The Z-coordinate of the chunk currently being decorated */
    public int chunk_Z;

    /**
     * Generate some world
     *
     * @param rand         the chunk specific {@link java.util.Random}.
     * @param chunkX         the chunk X coordinate of this chunk.
     * @param chunkZ         the chunk Z coordinate of this chunk.
     * @param world          : additionalData[0] The minecraft {@link net.minecraft.world.World} we're generating for.
     * @param chunkGenerator : additionalData[1] The {@link net.minecraft.world.chunk.IChunkProvider} that is generating.
     * @param chunkProvider  : additionalData[2] {@link net.minecraft.world.chunk.IChunkProvider} that is requesting the world generation.
     */
    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId)
        {
            case -1:
                generateNether(world, rand, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, rand, chunkX * 16, chunkZ * 16);
        }
    }

    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre(int genAttempts, WorldGenerator worldGenerator, int chunk_X, int chunk_Z)
    {
        for (int l = 0; l < genAttempts; ++l)
        {
            int i1 = this.chunk_X + this.randomGenerator.nextInt(16);
            int j1 = this.randomGenerator.nextInt(chunk_Z - chunk_X) + chunk_X;
            int k1 = this.chunk_Z + this.randomGenerator.nextInt(16);
            worldGenerator.generate(this.currentWorld, this.randomGenerator, i1, j1, k1);
        }
    }

    private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
    {
        /**
        * Generate Iron Ore
         */
        for (int i = 0; i < 4; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(64);
            int randPosZ = chunkZ + rand.nextInt(16);
            new WorldGenMinable(Blocks.iron_ore, 8).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        /**
         * Generate Gold Ore
         */
        for (int i = 0; i < 4; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(46);
            int randPosZ = chunkZ + rand.nextInt(16);
            new WorldGenMinable(Blocks.gold_ore, 6).generate(world, rand, randPosX, randPosY, randPosZ);
        }

        /**
         * Generate Diamond Ore
         */
        for (int i = 0; i < 4; i++)
        {
            int randPosX = chunkX + rand.nextInt(16);
            int randPosY = rand.nextInt(20);
            int randPosZ = chunkZ + rand.nextInt(16);
            new WorldGenMinable(Blocks.diamond_ore, 6).generate(world, rand, randPosX, randPosY, randPosZ);
        }
    }

    private void generateNether(World world, Random rand, int chunkX, int chunkZ)
    {

    }

    private void generate(World world, Random rand, int x, int y, int z)
    {

    }
}
