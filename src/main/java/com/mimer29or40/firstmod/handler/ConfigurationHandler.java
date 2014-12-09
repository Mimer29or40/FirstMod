package com.mimer29or40.firstmod.handler;

import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.util.Setting;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigurationHandler
{
    public static Configuration config;

    public ConfigurationHandler(File configFile)
    {
        if (config == null) // Create the configuration object from the given configuration file
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Settings.Debug.setValue(getBoolean(Settings.Debug));
        Settings.RenderLikeGlass.setValue(getBoolean(Settings.RenderLikeGlass));
        Settings.RenderInside.setValue(getBoolean(Settings.RenderInside));

        if (config.hasChanged()) config.save();
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

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equals(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    public static enum SettingType
    {
        Int, Float, Boolean, String, Unknown
    }
}