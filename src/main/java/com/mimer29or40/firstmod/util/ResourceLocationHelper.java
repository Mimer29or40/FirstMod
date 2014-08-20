package com.mimer29or40.firstmod.util;

import com.mimer29or40.firstmod.reference.Reference;
import net.minecraft.util.ResourceLocation;

public class ResourceLocationHelper
{
    public static ResourceLocation getResourceLocation(String modId, String path)
    {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path)
    {
        if (path.startsWith(Reference.MOD_ID + ":"))
            path.replace(":", "");
        return getResourceLocation(Reference.MOD_ID.toLowerCase(), path);
    }
}