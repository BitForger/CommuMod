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

import io.cyb3rwarri0r8.commumod.items.ModItems;


import io.cyb3rwarri0r8.commumod.world.VanillaOreOverrideDecorator;
import net.minecraft.entity.player.EntityPlayer;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


/**
 * Created by noah on 10/23/14.
 */
public class ModEventHandler
{
    @SubscribeEvent
    public void onLivingUpdateEvent(LivingEvent.LivingUpdateEvent event)
    {
        if (event.entityLiving != null)
        {
            if(event.entityLiving instanceof EntityPlayer)
            {
                EntityPlayer player = ((EntityPlayer)event.entityLiving);
                if(player.inventory.armorItemInSlot(2) == null && player.capabilities.isCreativeMode == false){
                    if(player.capabilities.allowFlying == true){
                        player.capabilities.allowFlying = false;
                    }
                }else if(player.capabilities.isCreativeMode == false && player.inventory.armorItemInSlot(2).getItem() != ModItems.superbiumChestPlate){
                    if(player.capabilities.allowFlying == true){
                        player.capabilities.allowFlying = false;
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void onChunkPreLoaded(OreGenEvent.Pre event)
    {
        event.setCanceled(true);

    }

    @SubscribeEvent
    public void onUsernameLoaded(PlayerEvent.NameFormat event)
    {
        if(event.username.equals("Adm_Seakiller"))
        {
            event.displayname = event.username + " the Goalie Man";
        }
        else if(event.username.equals("nathanicus96"))
        {
            event.displayname = event.username + " my Sk8tr Bro";
        }
        else if(event.username.equals("tekmeister1"))
        {
            event.displayname = event.username + " the Mod Dev";
        }
        else if(event.username.equals("UltraX7"))
        {
            event.displayname = event.username + " the Mega Awesome Texturer/Inspirer";
        }
        else if(event.username.equals(ConfigHandler.friendUserName))
        {
            event.displayname = event.username + " " + ConfigHandler.friendNickName;
        }
        else if(event.username.equals(ConfigHandler.girlfriendUserName))
        {
            event.displayname = event.username + " " + ConfigHandler.girlfriendNickName;
        }
        else{
            event.displayname = event.username + " " + ConfigHandler.everyoneElsesNickname;
        }
    }

    /*@SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void textureHook(TextureStitchEvent.Post event) {
        if (event.map.getTextureType() == 0) {
            ModFluids.pureWater.setIcons(ModBlocks.pureWaterBlock.getIcon(0,0), ModBlocks.pureWaterBlock.getIcon(1, 0));

        }
    }*/

}
