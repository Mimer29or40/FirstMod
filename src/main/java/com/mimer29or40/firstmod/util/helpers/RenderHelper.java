package com.mimer29or40.firstmod.util.helpers;

import com.mimer29or40.firstmod.util.Vector3;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.util.ResourceLocation;

public class RenderHelper
{
    public static void addVertexFromVectorWithUV(Tessellator tessellator, Vector3 vector3, double u, double v)
    {
        tessellator.addVertexWithUV(vector3.x, vector3.y, vector3.z, u, v);
    }

    public static void bindTexture(ResourceLocation p_147499_1_)
    {
        TextureManager texturemanager = field_147501_a.field_147553_e;

        if (texturemanager != null)
        {
            texturemanager.bindTexture(p_147499_1_);
        }
    }
    protected static TileEntityRendererDispatcher field_147501_a;
}