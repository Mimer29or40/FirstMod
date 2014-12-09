package com.mimer29or40.firstmod.reference;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.util.Setting;
import net.minecraftforge.common.config.Configuration;

public class Settings
{
    // General Category
    public static final String CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;
    // Render Category
    public static final String CATEGORY_RENDER = "render";
    public static Setting Debug = new Setting(ConfigurationHandler.SettingType.Boolean, CATEGORY_GENERAL, "Debug", "Enable some debug settings", false);
    public static Setting RenderLikeGlass = new Setting(ConfigurationHandler.SettingType.Boolean, CATEGORY_RENDER, "Render frame like glass", "Decide whether or not to render the sides of the frame", true);

    public static Setting RenderInside = new Setting(ConfigurationHandler.SettingType.Boolean, CATEGORY_RENDER, "Render from from inside", "Decide whether or not to render the frames inside or outside faces", false);
}