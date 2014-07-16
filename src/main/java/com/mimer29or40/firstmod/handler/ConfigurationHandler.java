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

        Settings.booleanValue = config.getBoolean(
                Settings.BOOLEAN_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.BOOLEAN_DEFAULT,
                Settings.BOOLEAN_LABEL);
        Settings.intValue = config.getInt(
                Settings.INT_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.INT_DEFAULT,
                Settings.INT_MIN,
                Settings.INT_MAX,
                Settings.INT_LABEL);
        Settings.stringValue = config.getString(
                Settings.STRING_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.STRING_DEFAULT,
                Settings.STRING_LABEL);
        Settings.floatValue = config.getFloat(
                Settings.FLOAT_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.FLOAT_DEFAULT,
                Settings.FLOAT_MIN,
                Settings.FLOAT_MAX,
                Settings.FLOAT_LABEL);
        Settings.RENDER_LIKE_GLASS = config.getBoolean(
                Settings.RENDER_LIKE_GLASS_NAME,
                Settings.CATEGORY_GENERAL,
                Settings.RENDER_LIKE_GLASS_DEFAULT,
                Settings.RENDER_LIKE_GLASS_LABEL);

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