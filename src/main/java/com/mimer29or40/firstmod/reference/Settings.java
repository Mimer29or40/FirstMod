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

    // Test Category
    public static final String CATEGORY_TEST = "test";

    public static final String INT_NAME = "Int Config";
    public static int intValue;
    public static final int INT_DEFAULT = 25;
    public static final int INT_MIN = 0;
    public static final int INT_MAX = 50;
    public static final String INT_LABEL = "Example int value";

}