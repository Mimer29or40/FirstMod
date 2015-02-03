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
        if(config == null) // Create the configuration object from the given configuration file
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        Settings.Debug.setValue(getBoolean(Settings.Debug));

        if(config.hasChanged()) config.save();
    }

    private static int getInt(Setting.I setting)
    {
        return config.getInt(setting.getName(), setting.getCategory(), setting.getDefult(), setting.getMin(), setting.getMax(), setting.getLabel());
    }

    private static float getFloat(Setting.F setting)
    {
        return config.getFloat(setting.getName(), setting.getCategory(), setting.getDefult(), setting.getMin(), setting.getMax(), setting.getLabel());
    }

    private static boolean getBoolean(Setting.B setting)
    {
        return config.getBoolean(setting.getName(), setting.getCategory(), setting.getDefult(), setting.getLabel());
    }

    private static String getString(Setting.S setting)
    {
        return config.getString(setting.getName(), setting.getCategory(), setting.getDefult(), setting.getLabel());
    }

    @SubscribeEvent
    public void onConfigurationChangeEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.modID.equals(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    public static enum SettingType
    {
        Int, Float, Boolean, String, Unknown
    }
}