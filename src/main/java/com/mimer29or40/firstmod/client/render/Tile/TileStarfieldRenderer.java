package com.mimer29or40.firstmod.client.render.Tile;

import java.awt.Color;
import java.nio.FloatBuffer;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;


public class TileStarfieldRenderer extends TileEntitySpecialRenderer {

    private static final ResourceLocation END_SKY = new ResourceLocation("textures/environment/end_sky.png");
    private static final ResourceLocation END_PORTAL = new ResourceLocation("textures/entity/end_portal.png");
    private static final Random RAND = new Random(31100L);
    FloatBuffer floatBuffer = GLAllocation.createDirectFloatBuffer(16);
    private static final String __OBFID = "CL_00000972";

    @Override
    public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float par4)
    {
        float f1 = (float)field_147501_a.field_147560_j;
        float f2 = (float)field_147501_a.field_147561_k;
        float f3 = (float)field_147501_a.field_147558_l;
        GL11.glDisable(GL11.GL_LIGHTING);
        RAND.setSeed(31100L);
        float f4 = 0.24F;

        for(int i = 0; i < 16; ++i)
        {
            GL11.glPushMatrix();
            float f5 = (float)(16 - i);
            float f6 = 0.0625F;
            float f7 = 1.0F / (f5 + 1.0F);

            if(i == 0)
            {
                bindTexture(END_SKY);
                f7 = 0.1F;
                f5 = 65.0F;
                f6 = 0.125F;
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }

            if(i == 1)
            {
                bindTexture(END_PORTAL);
                GL11.glEnable(GL11.GL_BLEND);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                f6 = 0.5F;
            }

            float f8 = (float)(-(y + (double)f4));
            float f9 = f8 + ActiveRenderInfo.objectY;
            float f10 = f8 + f5 + ActiveRenderInfo.objectY;
            float f11 = f9 / f10;
            f11 += (float)(y + (double)f4);
            GL11.glTranslatef(f1, f11, f3);
            GL11.glTexGeni(GL11.GL_S, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_T, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_R, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_OBJECT_LINEAR);
            GL11.glTexGeni(GL11.GL_Q, GL11.GL_TEXTURE_GEN_MODE, GL11.GL_EYE_LINEAR);
            GL11.glTexGen(GL11.GL_S, GL11.GL_OBJECT_PLANE, getParams(1.0F, 0.0F, 0.0F, 0.0F));
            GL11.glTexGen(GL11.GL_T, GL11.GL_OBJECT_PLANE, getParams(0.0F, 0.0F, 1.0F, 0.0F));
            GL11.glTexGen(GL11.GL_R, GL11.GL_OBJECT_PLANE, getParams(0.0F, 0.0F, 0.0F, 1.0F));
            GL11.glTexGen(GL11.GL_Q, GL11.GL_EYE_PLANE, getParams(0.0F, 1.0F, 0.0F, 0.0F));
            GL11.glEnable(GL11.GL_TEXTURE_GEN_S);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_T);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_R);
            GL11.glEnable(GL11.GL_TEXTURE_GEN_Q);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, (float)(Minecraft.getSystemTime() % 20000L) / 20000.0F, 0.0F);
            GL11.glScalef(f6, f6, f6);
            GL11.glTranslatef(0.5F, 0.5F, 0.0F);
            GL11.glRotatef((float)(i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(-0.5F, -0.5F, 0.0F);
            GL11.glTranslatef(-f1, -f3, -f2);
            f9 = f8 + ActiveRenderInfo.objectY;
            GL11.glTranslatef(ActiveRenderInfo.objectX * f5 / f9, ActiveRenderInfo.objectZ * f5 / f9, -f2);
            Tessellator tessellator = Tessellator.instance;
            tessellator.startDrawingQuads();

            Color color = Color.getHSBColor((float) ((Minecraft.getSystemTime() / 20F) % 360) / 360F, 1F, 1F);
            f11 = (float) color.getRed() / 255F;
            float f12 = (float) color.getGreen() / 255F;
            float f13 = (float) color.getBlue() / 255F;

            tessellator.setColorRGBA_F(f11 * f7, f12 * f7, f13 * f7, 1.0F);
            tessellator.addVertex(x, y + (double)f4, z);
            tessellator.addVertex(x, y + (double)f4, z + 1.0D);
            tessellator.addVertex(x + 1.0D, y + (double)f4, z + 1.0D);
            tessellator.addVertex(x + 1.0D, y + (double)f4, z);
            tessellator.draw();
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
        }

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_S);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_T);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_R);
        GL11.glDisable(GL11.GL_TEXTURE_GEN_Q);
        GL11.glEnable(GL11.GL_LIGHTING);
    }

    private FloatBuffer getParams(float par1, float par2, float par3, float par4)
    {
        floatBuffer.clear();
        floatBuffer.put(par1).put(par2).put(par3).put(par4);
        floatBuffer.flip();
        return floatBuffer;
    }
}