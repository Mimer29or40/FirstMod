package com.mimer29or40.firstmod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Random;

public class GeneralClient
{
    public static Random random = new Random();

    public static IIcon getMissingIcon() //TODO Fix this
    {
        return ((TextureMap) Minecraft.getMinecraft().getTextureManager().getTexture(TextureMap.locationBlocksTexture)).getAtlasSprite("missingno");
    }

    static HashMap<String, ResourceLocation> resource = new HashMap<String, ResourceLocation>();

    public static void bind(String textureName)
    {
        ResourceLocation res = resource.get(textureName);

        if (res == null)
        {
            res = new ResourceLocation(textureName);
            resource.put(textureName, res);
        }
        Minecraft.getMinecraft().getTextureManager().bindTexture(res);
    }
}