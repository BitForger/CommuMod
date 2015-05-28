package io.cyb3rwarri0r8.commumod.lib.handler;



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

import io.cyb3rwarri0r8.commumod.client.container.ContainerPurifier;
import io.cyb3rwarri0r8.commumod.client.gui.GuiPurifier;
import io.cyb3rwarri0r8.commumod.entity.TileEntityPurifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by noah on 9/23/14.
 */
public class ModGuiHandler implements IGuiHandler {

    public ModGuiHandler()
    {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos blockPos = new BlockPos(x, y, z);
        if(ID == 0)
        {
            TileEntityPurifier tileEntity = (TileEntityPurifier) world.getTileEntity(blockPos);
            return new ContainerPurifier(player.inventory, tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos blockPos = new BlockPos(x, y, z);

        if(ID == 0)
        {
            TileEntityPurifier tileEntity = (TileEntityPurifier) world.getTileEntity(blockPos);
            return new GuiPurifier(player.inventory, tileEntity);
        }
        return null;
    }
}
