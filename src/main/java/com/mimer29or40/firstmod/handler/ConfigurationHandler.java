package com.mimer29or40.firstmod.handler;

import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static  Configuration config;

    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equals(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        LogHelper.info("Loading Config...");

        Settings.debug = config.getBoolean(
                Settings.DEBUG_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.DEBUG_DEFAULT,
                Settings.DEBUG_LABEL);
        Settings.RENDER_LIKE_GLASS = config.getBoolean(
                Settings.RENDER_LIKE_GLASS_NAME,
                Settings.CATEGORY_RENDER,
                Settings.RENDER_LIKE_GLASS_DEFAULT,
                Settings.RENDER_LIKE_GLASS_LABEL);
        Settings.RENDER_INSIDE = config.getBoolean(
                Settings.RENDER_INSIDE_NAME,
                Settings.CATEGORY_RENDER,
                Settings.RENDER_INSIDE_DEFAULT,
                Settings.RENDER_INSIDE_LABEL);

        if (config.hasChanged())
        {
            LogHelper.info("Change detected. Saving...");
            config.save();
        }
        else
        {
            LogHelper.info("No change detected");
        }
    }
}