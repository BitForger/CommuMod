package io.cyb3rwarri0r8.commumod.lib.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.cyb3rwarri0r8.commumod.items.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import java.util.Random;


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
            event.displayname = event.username + " my sk8tr bro";
        }
        else if(event.username.equals("tekmeister1"))
        {
            event.displayname = event.username + " the Mod Dev";
        }
        else if(event.username.equals("UltraX7"))
        {
            event.displayname = event.username + " the mega awesome texturer/inspirer";
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
