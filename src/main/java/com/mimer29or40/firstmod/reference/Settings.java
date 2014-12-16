package com.mimer29or40.firstmod.reference;

import com.mimer29or40.firstmod.util.Setting;
import net.minecraftforge.common.config.Configuration;

public class Settings
{
    // General Category
    public static final String    CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;
    public static final Setting.B Debug            = new Setting.B(CATEGORY_GENERAL, "Debug", "Enable some debug settings", false);
    // Render Category
    public static final String    CATEGORY_RENDER  = "render";
}