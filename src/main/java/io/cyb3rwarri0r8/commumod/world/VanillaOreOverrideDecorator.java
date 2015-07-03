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

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;

import java.util.Random;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.*;

public class VanillaOreOverrideDecorator {

    /** The world the BiomeDecorator is currently decorating */
    public World currentWorld;
    /** The Biome Decorator's random number generator. */
    public Random randomGenerator;
    /** The BlockPos for the decorator */
    public BlockPos blockPos;
    public ChunkProviderSettings chunkProviderSettings;
    public WorldGenerator ironGen;
    /** Field that holds gold WorldGenMinable */
    public WorldGenerator goldGen;
    public WorldGenerator field_180299_p;
    public WorldGenerator field_180298_q;

    public VanillaOreOverrideDecorator(){}

    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre1(int spawnAttempts, WorldGenerator worldGenerator, int par3, int oreHeight)
    {
        int l;

        if (oreHeight < par3)
        {
            l = par3;
            par3 = oreHeight;
            oreHeight = l;
        }
        else if (oreHeight == par3)
        {
            if (par3 < 255)
            {
                ++oreHeight;
            }
            else
            {
                --par3;
            }
        }

        for (l = 0; l < spawnAttempts; ++l)
        {
            BlockPos blockpos = this.blockPos.add(this.randomGenerator.nextInt(16), this.randomGenerator.nextInt(oreHeight - par3) + par3, this.randomGenerator.nextInt(16));
            worldGenerator.generate(this.currentWorld, this.randomGenerator, blockpos);
        }
    }

    protected void generateOres()
    {
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Pre(currentWorld, randomGenerator, blockPos));
        if (VanillaOverrideTerrainGen.generateOre(currentWorld, randomGenerator, ironGen, blockPos, IRON))
            this.genStandardOre1(this.chunkProviderSettings.ironCount, this.ironGen, this.chunkProviderSettings.ironMinHeight, this.chunkProviderSettings.ironMaxHeight);
        if (VanillaOverrideTerrainGen.generateOre(currentWorld, randomGenerator, goldGen, blockPos, GOLD))
            this.genStandardOre1(this.chunkProviderSettings.goldCount, this.goldGen, this.chunkProviderSettings.goldMinHeight, this.chunkProviderSettings.goldMaxHeight);
        if (VanillaOverrideTerrainGen.generateOre(currentWorld, randomGenerator, field_180298_q, blockPos, DIAMOND))
            this.genStandardOre1(this.chunkProviderSettings.diamondCount, this.field_180298_q, this.chunkProviderSettings.diamondMinHeight, this.chunkProviderSettings.diamondMaxHeight);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, blockPos));
    }

}
