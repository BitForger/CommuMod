package io.cyb3rwarri0r8.commumod.lib.handler;



/*
 * CommuMod - A Minecraft Modification
 * Copyright (c) 2016. noahk (Cyb3rWarri0r8/Endergriefer153/Starwarsman)
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
