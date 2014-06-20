package com.mimer29or40.firstmod.util;

public class NameHelper
{
    public static String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
