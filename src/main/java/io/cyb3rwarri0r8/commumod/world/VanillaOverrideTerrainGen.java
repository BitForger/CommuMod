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
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.Random;

public abstract class VanillaOverrideTerrainGen {
    public static boolean generateOre(World world, Random rand, WorldGenerator generator, BlockPos pos, OreGenEvent.GenerateMinable.EventType type)
    {
        OreGenEvent.GenerateMinable event = new OreGenEvent.GenerateMinable(world, rand, generator, pos, type);
        MinecraftForge.ORE_GEN_BUS.post(event);
        return event.getResult() != Event.Result.DENY;
    }
}
