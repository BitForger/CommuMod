package io.cyb3rwarri0r8.commumod.world;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.DIAMOND;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.GOLD;
import static net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.IRON;

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
            this.genStandardOre1(this.chunkProviderSettings.field_177849_ah, this.ironGen, this.chunkProviderSettings.field_177832_ai, this.chunkProviderSettings.field_177834_aj);
        if (VanillaOverrideTerrainGen.generateOre(currentWorld, randomGenerator, goldGen, blockPos, GOLD))
            this.genStandardOre1(this.chunkProviderSettings.field_177830_al, this.goldGen, this.chunkProviderSettings.field_177840_am, this.chunkProviderSettings.field_177842_an);
        if (VanillaOverrideTerrainGen.generateOre(currentWorld, randomGenerator, field_180298_q, blockPos, DIAMOND))
            this.genStandardOre1(this.chunkProviderSettings.field_177812_at, this.field_180298_q, this.chunkProviderSettings.field_177826_au, this.chunkProviderSettings.field_177824_av);
        MinecraftForge.ORE_GEN_BUS.post(new OreGenEvent.Post(currentWorld, randomGenerator, blockPos));
    }

}
