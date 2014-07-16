package com.mimer29or40.firstmod.reference;

import net.minecraftforge.common.config.Configuration;

public class Settings
{
    // General Category
    public static final String CATEGORY_GENERAL = Configuration.CATEGORY_GENERAL;

    public static final String BOOLEAN_NAME = "Boolean Config";
    public static boolean booleanValue;
    public static final boolean BOOLEAN_DEFAULT = true;
    public static final String BOOLEAN_LABEL = "Example boolean value";

    public static final String INT_NAME = "Int Config";
    public static int intValue;
    public static final int INT_DEFAULT = 25;
    public static final int INT_MIN = 0;
    public static final int INT_MAX = 50;
    public static final String INT_LABEL = "Example int value";

    public static final String STRING_NAME = "String Config";
    public static String stringValue;
    public static final String STRING_DEFAULT = "Two by Two";
    public static final String STRING_LABEL = "Example string value";

    public static final String FLOAT_NAME = "Float Config";
    public static float floatValue;
    public static final float FLOAT_DEFAULT = 5.0F;
    public static final float FLOAT_MIN = 1.0F;
    public static final float FLOAT_MAX = 10.0F;
    public static final String FLOAT_LABEL = "Example float Value";

    public static final String RENDER_LIKE_GLASS_NAME = "Render frame like glass";
    public static boolean RENDER_LIKE_GLASS;
    public static final boolean RENDER_LIKE_GLASS_DEFAULT = false;
    public static final String RENDER_LIKE_GLASS_LABEL = "Decided whether or not to render the sides of the frame";

    // Test Category
    public static final String CATEGORY_TEST = "test";
}