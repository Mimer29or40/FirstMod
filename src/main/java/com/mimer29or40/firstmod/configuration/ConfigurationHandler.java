package com.mimer29or40.firstmod.configuration;

import com.mimer29or40.firstmod.reference.Config;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigurationHandler
{
    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        Configuration configuration = new Configuration(configFile);

        try
        {
            // Load the configuration file
            configuration.load();

            // Read in properties from configuration file
            Config.TEST_CONFIG_VALUE = configuration.get(Configuration.CATEGORY_GENERAL, Config.TEST_CONFIG, Config.TEST_CONFIG_DEFAULT_VALUE, Config.TEST_CONFIG_LABEL).getBoolean(Config.TEST_CONFIG_DEFAULT_VALUE);
        }
        catch (Exception e)
        {
            // Log the exception
        }
        finally
        {
            // Save the configuration file
            configuration.save();
        }
    }
}