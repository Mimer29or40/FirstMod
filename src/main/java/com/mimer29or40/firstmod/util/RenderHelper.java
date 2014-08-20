package com.mimer29or40.firstmod.util;

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

    public static void addFaceFromBoxWithUV(Tessellator tessellator, Box box, double u1, double v1, double u2, double v2, boolean flipped)
    {
        if (!flipped) {
            addVertexFromVectorWithUV(tessellator, box.one, u1, v1);
            addVertexFromVectorWithUV(tessellator, box.two, u1, v2);
            addVertexFromVectorWithUV(tessellator, box.three, u2, v2);
            addVertexFromVectorWithUV(tessellator, box.four, u2, v1);
        }
        else
        {
            addVertexFromVectorWithUV(tessellator, box.one, u1, v1);
            addVertexFromVectorWithUV(tessellator, box.four, u2, v1);
            addVertexFromVectorWithUV(tessellator, box.three, u2, v2);
            addVertexFromVectorWithUV(tessellator, box.two, u1, v2);
        }
    }

    public static void addFaceFromBoxWithUV(Tessellator tessellator, Box box, double u1, double v1, double u2, double v2)
    {
        addFaceFromBoxWithUV(tessellator, box, u1, v1, u2, v2, false);
    }

    public static void addFaceFromBox(Tessellator tessellator, Box box)
    {
        addFaceFromBoxWithUV(tessellator, box, 0, 0, 1, 1);
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