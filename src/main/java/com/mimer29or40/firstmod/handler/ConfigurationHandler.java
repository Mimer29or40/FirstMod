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

    public static void loadConfig(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (config == null)
        {
            LogHelper.info("Creating config......");
            config = new Configuration(configFile);
        }
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            LogHelper.info("Loading Config......");
            loadConfiguration();
        }
    }

    public void loadConfiguration()
    {
        Settings.testConfigValue = config.getBoolean(Settings.TEST_CONFIG, Configuration.CATEGORY_GENERAL, Settings.TEST_CONFIG_DEFAULT_VALUE, Settings.TEST_CONFIG_LABEL);

        if (config.hasChanged())
        {
            LogHelper.info("Config changed. Saving....");
            config.save();
        }
        else
        {
            LogHelper.info("Config hasn't changed");
        }
    }
}