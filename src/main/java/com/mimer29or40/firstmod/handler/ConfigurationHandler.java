package com.mimer29or40.firstmod.handler;

import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.helpers.LogHelper;
import com.mimer29or40.firstmod.util.Setting;
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

        Settings.Debug.setValue(getBoolean(Settings.Debug));
        Settings.RenderLikeGlass.setValue(getBoolean(Settings.RenderLikeGlass));
        Settings.RenderInside.setValue(getBoolean(Settings.RenderInside));


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

    private static int getInt(Setting setting)
    {
        return config.getInt(setting.name, setting.category, (Integer) setting.getDefault(), (Integer) setting.getMin(), (Integer) setting.getMax(), setting.label);
    }

    private static float getFloat(Setting setting)
    {
        return config.getFloat(setting.name, setting.category, (Float) setting.getDefault(), (Float) setting.getMin(), (Float) setting.getMax(), setting.label);
    }

    private static boolean getBoolean(Setting setting)
    {
        return config.getBoolean(setting.name, setting.category, (Boolean) setting.getDefault(), setting.label);
    }

    private static String getString(Setting setting)
    {
        return config.getString(setting.name, setting.category, (String) setting.getDefault(), setting.label);
    }

    public static enum SettingType
    {
        Int, Float, Boolean, String, Unknown
    }
}