package com.mimer29or40.firstmod.client.render.Tile;

import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileArrowRenderer extends TileEntitySpecialRenderer
{
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float pticks)
    {
        Vector3 topNorthWest = new Vector3(0.375D, 1D, 0.375);
        Vector3 topNorthEast = new Vector3(0.625D, 1D, 0.375);
        Vector3 topSouthEast = new Vector3(0.625D, 1D, 0.625);
        Vector3 topSouthWest = new Vector3(0.375D, 1D, 0.625);
        Vector3 mid1NorthWest = new Vector3(0D, 0.5625D, 0D);
        Vector3 mid1NorthEast = new Vector3(1D, 0.5625D, 0D);
        Vector3 mid1SouthEast = new Vector3(1D, 0.5625D, 1D);
        Vector3 mid1SouthWest = new Vector3(0D, 0.5625D, 1D);
        Vector3 mid2NorthWest = new Vector3(0D, 0.4375D, 0D);
        Vector3 mid2NorthEast = new Vector3(1D, 0.4375D, 0D);
        Vector3 mid2SouthEast = new Vector3(1D, 0.4375D, 1D);
        Vector3 mid2SouthWest = new Vector3(0D, 0.4375D, 1D);
        Vector3 innerNorthWest = new Vector3(0.375D, 0.5D, 0.375);
        Vector3 innerNorthEast = new Vector3(0.625D, 0.5D, 0.375);
        Vector3 innerSouthEast = new Vector3(0.625D, 0.5D, 0.625);
        Vector3 innerSouthWest = new Vector3(0.375D, 0.5D, 0.625);
        Vector3 bottomNorthWest = new Vector3(0.375D, 0D, 0.375);
        Vector3 bottomNorthEast = new Vector3(0.625D, 0D, 0.375);
        Vector3 bottomSouthEast = new Vector3(0.625D, 0D, 0.625);
        Vector3 bottomSouthWest = new Vector3(0.375D, 0D, 0.625);

        Box top = new Box(topNorthEast, topSouthEast, topSouthWest, topNorthWest);
        Box slopeNorth = new Box(topNorthEast, mid1NorthEast, mid1NorthWest, topNorthWest);
        Box slopeSouth = new Box(topSouthWest, mid1SouthWest, mid1SouthEast, topSouthEast);
        Box slopeEast = new Box(topSouthEast, mid1SouthEast, mid1NorthEast, topNorthEast);
        Box slopeWest = new Box(topNorthWest, mid1NorthWest, mid1SouthWest, topSouthWest);
        Box faceNorth = new Box(mid1NorthEast, mid2NorthEast, mid2NorthWest, mid1NorthWest);
        Box faceSouth = new Box(mid1SouthWest, mid2SouthWest, mid2SouthEast, mid1SouthEast);
        Box faceEast = new Box(mid1SouthEast, mid2SouthEast, mid2NorthEast, mid1NorthEast);
        Box faceWest = new Box(mid1NorthWest, mid2NorthWest, mid2SouthWest, mid1SouthWest);
        Box shaftNorth = new Box(innerNorthEast, bottomNorthEast, bottomNorthWest, innerNorthWest);
        Box shaftSouth = new Box(innerSouthWest, bottomSouthWest, bottomSouthEast, innerSouthEast);
        Box shaftEast = new Box(innerSouthEast, bottomSouthEast, bottomNorthEast, innerNorthEast);
        Box shaftWest = new Box(innerNorthWest, bottomNorthWest, bottomSouthWest, innerSouthWest);
        Box underArrow = new Box(mid2NorthEast, mid2SouthEast, mid2SouthWest, mid2NorthWest);
        Box bottom = new Box(bottomNorthEast, bottomSouthEast, bottomSouthWest, bottomNorthWest);

        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(999999);
        tessellator.setBrightness(tileentity.getBlockType().getMixedBrightnessForBlock(Minecraft.getMinecraft().theWorld,(int)x,(int)y,(int)z));
        tessellator.setColorOpaque_F(1F, 1F, 1F);
        GL11.glPushMatrix();
//        GL11.glDisable(GL11.GL_DEPTH_TEST);
//        GL11.glDepthMask(false);
//        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
//        GL11.glDisable(GL11.GL_ALPHA_TEST);

        switch (ForgeDirection.getOrientation(tileentity.blockMetadata))
        {
            case DOWN:
                GL11.glTranslated(x, y+1, z+1);
                GL11.glRotatef(180F, 1F, 0F, 0F);
                break;
            case UP:
                GL11.glTranslated(x,y,z);
                break;
            case NORTH:
                GL11.glTranslated(x, y, z+1);
                GL11.glRotatef(270F, 1F, 0F, 0F);
                break;
            case SOUTH:
                GL11.glTranslated(x, y+1, z);
                GL11.glRotatef(90F, 1F, 0F, 0F);
                break;
            case EAST:
                GL11.glTranslated(x, y, z+1);
                GL11.glRotatef(270F, 0F, 0F, 1F);
                GL11.glRotatef(180F, 0F, 1F, 0F);
                break;
            case WEST:
                GL11.glTranslated(x+1, y, z);
                GL11.glRotatef(90F, 0F, 0F, 1F);
                break;
        }

        tessellator.startDrawingQuads();

        this.bindTexture(ResourceLocationHelper.getResourceLocation(Textures.ARROW_TOP_TEXTURE));

        RenderHelper.addFaceFromBoxWithUV(tessellator, top, 0.4375D, 0.4375D, 0.5625D, 0.5625D, true);

        tessellator.draw();

        tessellator.startDrawingQuads();

        this.bindTexture(ResourceLocationHelper.getResourceLocation(Textures.ARROW_TEXTURE));

        RenderHelper.addFaceFromBoxWithUV(tessellator, slopeNorth, 0.4375D, 0D, 0.5625D, 0.4375D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, slopeSouth, 0.4375D, 0D, 0.5625D, 0.4375D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, slopeEast, 0.4375D, 0D, 0.5625D, 0.4375D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, slopeWest, 0.4375D, 0D, 0.5625D, 0.4375D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, faceNorth, 0D, 0.4375D, 1D, 0.5625D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, faceSouth, 0D, 0.4375D, 1D, 0.5625D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, faceEast, 0D, 0.4375D, 1D, 0.5625D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, faceWest, 0D, 0.4375D, 1D, 0.5625D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, shaftNorth, 0.375D, 0.5625D, 0.625D, 1D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, shaftSouth, 0.375D, 0.5625D, 0.625D, 1D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, shaftEast, 0.375D, 0.5625D, 0.625D, 1D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, shaftWest, 0.375D, 0.5625D, 0.625D, 1D);
        RenderHelper.addFaceFromBoxWithUV(tessellator, underArrow, 0.375D, 0.5625D, 0.625D, 0.625D);

        tessellator.draw();

        tessellator.startDrawingQuads();

        this.bindTexture(ResourceLocationHelper.getResourceLocation(Textures.ARROW_BOTTOM_TEXTURE));

        RenderHelper.addFaceFromBoxWithUV(tessellator, bottom, 0.4375D, 0.4375D, 0.5625D, 0.5625D);

        tessellator.draw();
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glPopMatrix();
    }
}