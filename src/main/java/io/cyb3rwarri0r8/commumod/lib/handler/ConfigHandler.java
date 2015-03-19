package io.cyb3rwarri0r8.commumod.lib.handler;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import io.cyb3rwarri0r8.commumod.lib.Reference;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by noah on 8/30/14.
 */
public class ConfigHandler
{
    public static Configuration configuration;
//    public static Boolean testValue = false;
    public static int IronOreGenAmount;
    public static int DiamondOreGenAmount;
    public static String friendUserName;
    public static String friendNickName;


    public static void init(File configFile)
    {

//        boolean configValue = false;
        if(configuration == null){
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }


    private static void loadConfiguration() {
    //TODO Flush the configuration file

        IronOreGenAmount = configuration.getInt("Iron Ore Generation Amount", Configuration.CATEGORY_GENERAL, 5, 0, 50, "This will change the amount of iron ore spawned into the world. The higher the amount the longer it will take to generate.");
        DiamondOreGenAmount = configuration.getInt("Diamond Ore Generation Amount", Configuration.CATEGORY_GENERAL, 5, 0, 50, "This will change the amount of diamond ore spanwned into the world.");
//        friendUserName = configuration.getString("Friends Username", Configuration.CATEGORY_GENERAL, "", "Enter your friends username for a cool tag added to their name");
//        friendNickName = configuration.getString("Friends Nickname", Configuration.CATEGORY_GENERAL, " ", "Enter a title to append to your friends username", "key");

        if (configuration.hasChanged())
        {
            configuration.save();
        }


    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
}
