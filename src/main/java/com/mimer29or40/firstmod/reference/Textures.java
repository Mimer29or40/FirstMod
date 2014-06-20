package com.mimer29or40.firstmod.reference;

import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final String BLOCK_RESOURCE_LOCATION = RESOURCE_PREFIX + "textures/blocks";

    public static final String TEST = BLOCK_RESOURCE_LOCATION + "/Test.png";

    private static ResourceLocation getResourceLocation(String location)
    {
        return new ResourceLocation(Reference.MOD_ID.toLowerCase(), location);
    }
}