package com.mimer29or40.firstmod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Random;

public class GeneralClient
{
    public static Random                              random   = new Random();
    static        HashMap< String, ResourceLocation > resource = new HashMap< String, ResourceLocation >();

    public static void bind(String textureName)
    {
        ResourceLocation res = resource.get(textureName);

        if(res == null)
        {
            res = new ResourceLocation(textureName);
            resource.put(textureName, res);
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(res);
    }
}