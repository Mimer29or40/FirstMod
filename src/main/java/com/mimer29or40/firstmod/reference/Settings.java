package com.mimer29or40.firstmod.reference;

import net.minecraftforge.common.config.Configuration;

public class Settings
{
    // General Category
    public static final String CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;

    public static final String DEBUG_NAME = "Debug";
    public static boolean debug;
    public static final boolean DEBUG_DEFAULT = false;
    public static final String DEBUG_LABEL = "Enable some debug settings";

    // Render Category
    public static final String CATEGORY_RENDER = "render";

    public static final String RENDER_LIKE_GLASS_NAME = "Render frame like glass";
    public static boolean RENDER_LIKE_GLASS;
    public static final boolean RENDER_LIKE_GLASS_DEFAULT = true;
    public static final String RENDER_LIKE_GLASS_LABEL = "Decide whether or not to render the sides of the frame";

    public static final String RENDER_INSIDE_NAME = "Render frame from inside";
    public static boolean RENDER_INSIDE;
    public static final boolean RENDER_INSIDE_DEFAULT = false;
    public static final String RENDER_INSIDE_LABEL = "Decide whether or not to render the frames inside or outside faces";
}