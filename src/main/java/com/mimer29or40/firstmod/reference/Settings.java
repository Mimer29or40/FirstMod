package com.mimer29or40.firstmod.reference;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.util.Setting;
import net.minecraftforge.common.config.Configuration;

public class Settings
{
    // General Category
    public static final String  CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;
    // Render Category
    public static final String  CATEGORY_RENDER  = "render";
    public static       Setting Debug            = new Setting(ConfigurationHandler.SettingType.Boolean, CATEGORY_GENERAL, "Debug", "Enable some debug settings", false);
}