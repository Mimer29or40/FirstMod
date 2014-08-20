package com.mimer29or40.firstmod.client.render.Tile;

import com.mimer29or40.firstmod.handler.ClientTickHandler;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.*;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

public class TileCrystalRenderer extends TileEntitySpecialRenderer
{
    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float pticks)
    {
        boolean renderTop = true;
        boolean renderBottom = true;

        double TOP = 0.8D;
        double BOTTOM = 0D;
        double CENTER_XZ = 0.5D;
        double CENTER_X = 0.5D;
        double CENTER_Y = 0.5D;
        double CENTER_Z = 0.5D;
        double MINX1 = 0.35;
        double MINZ1 = 0.35;
        double MAXX1 = 0.65;
        double MAXZ1 = 0.65;
        double MINX2 = 0.4D;
        double MINZ2 = 0.4D;
        double MAXX2 = 0.6D;
        double MAXZ2 = 0.6D;

        double SCALE = 1D;

        Vector3 top = new Vector3(CENTER_XZ, TOP, CENTER_XZ);
        Vector3 bottom = new Vector3(CENTER_XZ, BOTTOM, CENTER_XZ);
        Vector3 southEast = new Vector3(MAXX1, CENTER_Y, MAXZ1);
        Vector3 northEast = new Vector3(MAXX1, CENTER_Y, MINZ1);
        Vector3 northWest = new Vector3(MINX1, CENTER_Y, MINZ1);
        Vector3 southWest = new Vector3(MINX1, CENTER_Y, MAXZ1);
        Vector3 eastFace = new Vector3(MAXX2, BOTTOM, CENTER_Z);
        Vector3 southFace = new Vector3(CENTER_X, BOTTOM, MAXZ2);
        Vector3 northFace = new Vector3(CENTER_X, BOTTOM, MINZ2);
        Vector3 westFace = new Vector3(MINX2, BOTTOM, CENTER_Z);

        Box topEastFace = new Box(top, southEast, eastFace, northEast);
        Box topWestFace = new Box(top, northWest, westFace, southWest);
        Box topNorthFace = new Box(top, northEast, northFace, northWest);
        Box topSouthFace = new Box(top, southWest, southFace, southEast);
        Box bottomNorthEast = new Box(bottom, northFace, northEast, eastFace);
        Box bottomSouthEast = new Box(bottom, eastFace, southEast, southFace);
        Box bottomSouthWest = new Box(bottom, southFace, southWest, westFace);
        Box bottomNorthWest = new Box(bottom, westFace, northWest, northFace);

        this.bindTexture(ResourceLocationHelper.getResourceLocation(Textures.CRYSTAL_TEXTURE));

        float worldTime = ClientTickHandler.ticksInGame;
        float angle = (worldTime) * 2 % 359;

        Tessellator tessellator = Tessellator.instance;
        GL11.glPushMatrix();
//        GL11.glScaled(SCALE, SCALE, SCALE);

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
            default:
                GL11.glTranslated(x, y, z);
                GL11.glRotatef(0F, 0F, 0F, 0F);
                break;
        }

        GL11.glTranslatef(0.5F, 0F, 0.5F);
        GL11.glRotatef(pticks * 1.5F, 0F, 1F, 0F);
        GL11.glTranslatef(-0.5F, 0F, -0.5F);

        tessellator.startDrawingQuads();

        if (renderTop)
        {
            RenderHelper.addFaceFromBox(tessellator, topEastFace);
            RenderHelper.addFaceFromBox(tessellator, topWestFace);
            RenderHelper.addFaceFromBox(tessellator, topNorthFace);
            RenderHelper.addFaceFromBox(tessellator, topSouthFace);
        }

        if (renderBottom)
        {
            RenderHelper.addFaceFromBox(tessellator, bottomNorthEast);
            RenderHelper.addFaceFromBox(tessellator, bottomSouthEast);
            RenderHelper.addFaceFromBox(tessellator, bottomSouthWest);
            RenderHelper.addFaceFromBox(tessellator, bottomNorthWest);
        }

        tessellator.draw();
        GL11.glPopMatrix();
    }
}