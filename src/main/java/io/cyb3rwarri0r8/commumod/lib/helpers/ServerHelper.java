package io.cyb3rwarri0r8.commumod.lib.helpers;


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

import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C08PacketPlayerBlockPlacement;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.common.FMLCommonHandler;

/**
 * Created by noah on 10/31/14.
 */
public final class ServerHelper {
    private ServerHelper() {
    }
    public static final boolean isClientWorld(World world) {
        return world.isRemote;
    }
    public static final boolean isServerWorld(World world) {
        return !world.isRemote;
    }
    public static final boolean isSinglePlayerServer() {
        return FMLCommonHandler.instance().getMinecraftServerInstance() != null;
    }
    public static final boolean isMultiPlayerServer() {
        return FMLCommonHandler.instance().getMinecraftServerInstance() == null;
    }
    /**
     * This function circumvents a miserable failing.
     */
    public static final void sendItemUsePacket(ItemStack stack, EntityPlayer player, World world, BlockPos blockPos, int hitSide, float hitX, float hitY,
                                               float hitZ) {
        if (isServerWorld(world)) {
            return;
        }
        NetHandlerPlayClient netClientHandler = (NetHandlerPlayClient) FMLClientHandler.instance().getClientPlayHandler();
        netClientHandler.addToSendQueue(new C08PacketPlayerBlockPlacement(blockPos, hitSide, player.inventory.getCurrentItem(), hitX, hitY, hitZ));
    }
}
