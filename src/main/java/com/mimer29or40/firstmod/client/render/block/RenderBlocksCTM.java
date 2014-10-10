package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.util.TextureSubmap;
import com.mimer29or40.firstmod.util.helpers.CTMHelper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

public class RenderBlocksCTM extends RenderBlocks
{
    Tessellator tessellator;
    double[] X = new double[52];
    double[] Y = new double[52];
    double[] Z = new double[52];
    double[] U = new double[52];
    double[] V = new double[52];
    int[]    L = new int[52];
    float[]  R = new float[52];
    float[]  G = new float[52];
    float[]  B = new float[52];
    TextureSubmap test;
    boolean       isOpaque;
    int           bx, by, bz;

    RenderBlocksCTM()
    {
        super();
        resetVertices();
    }

    @Override
    public boolean renderStandardBlock(Block block, int x, int y, int z)
    {
        bx = x;
        by = y;
        bz = z;

        tessellator = Tessellator.instance;
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        tessellator.addTranslation(x, y, z);

        boolean res = super.renderStandardBlock(block, x, y, z);

        tessellator.addTranslation(- x, - y, - z);

        return res;
    }

    void setupSides(int a, int b, int c, int d, int xa, int xb, int xc, int xd, int e)
    {
        L[a] = brightnessBottomLeft;
        L[b] = brightnessBottomRight;
        L[c] = brightnessTopRight;
        L[d] = brightnessTopLeft;
        L[e] = (brightnessBottomLeft + brightnessTopLeft + brightnessTopRight + brightnessBottomRight) / 4;
        L[xa] = (L[a] + L[b]) / 2;
        L[xb] = (L[b] + L[c]) / 2;
        L[xc] = (L[c] + L[d]) / 2;
        L[xd] = (L[d] + L[a]) / 2;


        R[a] = colorRedBottomLeft;
        R[b] = colorRedBottomRight;
        R[c] = colorRedTopRight;
        R[d] = colorRedTopLeft;
        R[e] = (colorRedBottomLeft + colorRedTopLeft + colorRedTopRight + colorRedBottomRight) / 4;
        R[xa] = (R[a] + R[b]) / 2;
        R[xb] = (R[b] + R[c]) / 2;
        R[xc] = (R[c] + R[d]) / 2;
        R[xd] = (R[d] + R[a]) / 2;


        G[a] = colorGreenBottomLeft;
        G[b] = colorGreenBottomRight;
        G[c] = colorGreenTopRight;
        G[d] = colorGreenTopLeft;
        G[e] = (colorGreenBottomLeft + colorGreenTopLeft + colorGreenTopRight + colorGreenBottomRight) / 4;
        G[xa] = (G[a] + G[b]) / 2;
        G[xb] = (G[b] + G[c]) / 2;
        G[xc] = (G[c] + G[d]) / 2;
        G[xd] = (G[d] + G[a]) / 2;

        B[a] = colorBlueBottomLeft;
        B[b] = colorBlueBottomRight;
        B[c] = colorBlueTopRight;
        B[d] = colorBlueTopLeft;
        B[e] = (colorBlueBottomLeft + colorBlueTopLeft + colorBlueTopRight + colorBlueBottomRight) / 4;
        B[xa] = (B[a] + B[b]) / 2;
        B[xb] = (B[b] + B[c]) / 2;
        B[xc] = (B[c] + B[d]) / 2;
        B[xd] = (B[d] + B[a]) / 2;
    }

    void side(int a, int b, int c, int d, int iconIndex, CTMHelper.Rotation rotation, boolean inside)
    {
        IIcon icon = test.getIcon(iconIndex);

        double maxU = icon.getMaxU();
        double minU = icon.getMinU();
        double maxV = icon.getMaxV();
        double minV = icon.getMinV();

        double[] newUV = CTMHelper.Rotation.flipUV(rotation, minU, maxU, minV, maxV);

        if (inside)
        {
            a += 26;
            b += 26;
            c += 26;
            d += 26;
        }

        U[a] = newUV[0];
        U[b] = newUV[0];
        U[c] = newUV[1];
        U[d] = newUV[1];

        V[a] = newUV[2];
        V[b] = newUV[3];
        V[c] = newUV[3];
        V[d] = newUV[2];

        vert(a);
        vert(b);
        vert(c);
        vert(d);
    }

    void vert(int index)
    {
        if (enableAO)
        {
            tessellator.setColorOpaque_F(R[index], G[index], B[index]);
            tessellator.setBrightness(L[index]);
        }

        tessellator.addVertexWithUV(X[index], Y[index], Z[index], U[index], V[index]);
    }

    @Override
    public void renderFaceXNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 4);

        setupSides(1, 0, 4, 5, 8, 12, 16, 13, 21);
        side(1, 8, 21, 13, tex[0], CTMHelper.Rotation.None, false);
        side(13, 21, 16, 5, tex[1], CTMHelper.Rotation.None, false);
        side(8, 0, 12, 21, tex[2], CTMHelper.Rotation.None, false);
        side(21, 12, 4, 16, tex[3], CTMHelper.Rotation.None, false);
        if (! isOpaque) //TODO texture is black on inside
        {
            enableAO = false;
            side(13, 21, 8, 1, tex[0], CTMHelper.Rotation.FlipHorizontal, true);
            side(5, 16, 21, 13, tex[1], CTMHelper.Rotation.FlipHorizontal, true);
            side(21, 12, 0, 8, tex[2], CTMHelper.Rotation.FlipHorizontal, true);
            side(16, 4, 12, 21, tex[3], CTMHelper.Rotation.FlipHorizontal, true);
            enableAO = true;
        }
    }

    @Override
    public void renderFaceXPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 5);

        setupSides(3, 2, 6, 7, 10, 14, 18, 15, 23);
        side(6, 18, 23, 14, tex[0], CTMHelper.Rotation.None, false);
        side(14, 23, 10, 2, tex[1], CTMHelper.Rotation.None, false);
        side(18, 7, 15, 23, tex[2], CTMHelper.Rotation.None, false);
        side(23, 15, 3, 10, tex[3], CTMHelper.Rotation.None, false);
        if (! isOpaque)
        {
            enableAO = false;
            side(14, 23, 18, 6, tex[0], CTMHelper.Rotation.FlipHorizontal, true);
            side(2, 10, 23, 14, tex[1], CTMHelper.Rotation.FlipHorizontal, true);
            side(23, 15, 7, 18, tex[2], CTMHelper.Rotation.FlipHorizontal, true);
            side(10, 3, 15, 23, tex[3], CTMHelper.Rotation.FlipHorizontal, true);
            enableAO = true;
        }
    }

    @Override
    public void renderFaceZNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 2);

        setupSides(2, 3, 0, 1, 10, 11, 8, 9, 20);
        side(2, 10, 20, 9, tex[0], CTMHelper.Rotation.None, false);
        side(9, 20, 8, 1, tex[1], CTMHelper.Rotation.None, false);
        side(10, 3, 11, 20, tex[2], CTMHelper.Rotation.None, false);
        side(20, 11, 0, 8, tex[3], CTMHelper.Rotation.None, false);
        if (! isOpaque)
        {
            enableAO = false;
            side(9, 20, 10, 2, tex[0], CTMHelper.Rotation.FlipHorizontal, true);
            side(1, 8, 20, 9, tex[1], CTMHelper.Rotation.FlipHorizontal, true);
            side(20, 11, 3, 10, tex[2], CTMHelper.Rotation.FlipHorizontal, true);
            side(8, 0, 11, 20, tex[3], CTMHelper.Rotation.FlipHorizontal, true);
            enableAO = true;
        }
    }

    @Override
    public void renderFaceZPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 3);

        setupSides(4, 7, 6, 5, 19, 18, 17, 16, 25);
        side(5, 16, 25, 17, tex[0], CTMHelper.Rotation.None, false);
        side(17, 25, 18, 6, tex[1], CTMHelper.Rotation.None, false);
        side(16, 4, 19, 25, tex[2], CTMHelper.Rotation.None, false);
        side(25, 19, 7, 18, tex[3], CTMHelper.Rotation.None, false);
        if (! isOpaque)
        {
            enableAO = false;
            side(17, 25, 16, 5, tex[0], CTMHelper.Rotation.FlipHorizontal, true);
            side(6, 18, 25, 17, tex[1], CTMHelper.Rotation.FlipHorizontal, true);
            side(25, 19, 4, 16, tex[2], CTMHelper.Rotation.FlipHorizontal, true);
            side(18, 7, 19, 25, tex[3], CTMHelper.Rotation.FlipHorizontal, true);
            enableAO = true;
        }
    }

    @Override
    public void renderFaceYNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 0);

        setupSides(0, 3, 7, 4, 11, 15, 19, 12, 24);
        side(4, 12, 24, 19, tex[2], CTMHelper.Rotation.FlipVertical, false);
        side(19, 24, 15, 7, tex[3], CTMHelper.Rotation.FlipVertical, false);
        side(12, 0, 11, 24, tex[0], CTMHelper.Rotation.FlipVertical, false);
        side(24, 11, 3, 15, tex[1], CTMHelper.Rotation.FlipVertical, false);
        if (! isOpaque)
        {
            enableAO = false;
            side(19, 24, 12, 4, tex[2], CTMHelper.Rotation.FlipBoth, true);
            side(7, 15, 24, 19, tex[3], CTMHelper.Rotation.FlipBoth, true);
            side(24, 11, 0, 12, tex[0], CTMHelper.Rotation.FlipBoth, true);
            side(15, 3, 11, 24, tex[1], CTMHelper.Rotation.FlipBoth, true);
            enableAO = true;
        }
    }

    @Override
    public void renderFaceYPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 1);

        setupSides(2, 1, 5, 6, 9, 13, 17, 14, 22);
        side(1, 13, 22, 9, tex[0], CTMHelper.Rotation.None, false);
        side(9, 22, 14, 2, tex[1], CTMHelper.Rotation.None, false);
        side(13, 5, 17, 22, tex[2], CTMHelper.Rotation.None, false);
        side(22, 17, 6, 14, tex[3], CTMHelper.Rotation.None, false);
        if (! isOpaque)
        {
            enableAO = false;
            side(9, 22, 13, 1, tex[0], CTMHelper.Rotation.FlipHorizontal, true);
            side(2, 14, 22, 9, tex[1], CTMHelper.Rotation.FlipHorizontal, true);
            side(22, 17, 5, 13, tex[2], CTMHelper.Rotation.FlipHorizontal, true);
            side(14, 6, 17, 22, tex[3], CTMHelper.Rotation.FlipHorizontal, true);
            enableAO = true;
        }
    }

    void resetVertices()
    {
        X[0] = 0;
        Z[0] = 0;
        Y[0] = 0;

        X[1] = 0;
        Z[1] = 0;
        Y[1] = 1;

        X[2] = 1;
        Z[2] = 0;
        Y[2] = 1;

        X[3] = 1;
        Z[3] = 0;
        Y[3] = 0;

        X[4] = 0;
        Z[4] = 1;
        Y[4] = 0;

        X[5] = 0;
        Z[5] = 1;
        Y[5] = 1;

        X[6] = 1;
        Z[6] = 1;
        Y[6] = 1;

        X[7] = 1;
        Z[7] = 1;
        Y[7] = 0;

        X[8] = 0;
        Z[8] = 0;
        Y[8] = 0.5;

        X[9] = 0.5;
        Z[9] = 0;
        Y[9] = 1;

        X[10] = 1;
        Z[10] = 0;
        Y[10] = 0.5;

        X[11] = 0.5;
        Z[11] = 0;
        Y[11] = 0;

        X[12] = 0;
        Z[12] = 0.5;
        Y[12] = 0;

        X[13] = 0;
        Z[13] = 0.5;
        Y[13] = 1;

        X[14] = 1;
        Z[14] = 0.5;
        Y[14] = 1;

        X[15] = 1;
        Z[15] = 0.5;
        Y[15] = 0;

        X[16] = 0;
        Z[16] = 1;
        Y[16] = 0.5;

        X[17] = 0.5;
        Z[17] = 1;
        Y[17] = 1;

        X[18] = 1;
        Z[18] = 1;
        Y[18] = 0.5;

        X[19] = 0.5;
        Z[19] = 1;
        Y[19] = 0;

        X[20] = 0.5;
        Z[20] = 0;
        Y[20] = 0.5;

        X[21] = 0;
        Z[21] = 0.5;
        Y[21] = 0.5;

        X[22] = 0.5;
        Z[22] = 0.5;
        Y[22] = 1;

        X[23] = 1;
        Z[23] = 0.5;
        Y[23] = 0.5;

        X[24] = 0.5;
        Z[24] = 0.5;
        Y[24] = 0;

        X[25] = 0.5;
        Z[25] = 1;
        Y[25] = 0.5;

        for (int i = 0; i < 26; i++)
        {
            if (X[i] == 0)
            {
                X[i + 26] = 0.0001;
            }
            else if (X[i] == 0.5)
            {
                X[i + 26] = 0.5;
            }
            else
            {
                X[i + 26] = 0.9999;
            }

            if (Z[i] == 0)
            {
                Z[i + 26] = 0.0001;
            }
            else if (Z[i] == 0.5)
            {
                Z[i + 26] = 0.5;
            }
            else
            {
                Z[i + 26] = 0.9999;
            }

            if (Y[i] == 0)
            {
                Y[i + 26] = 0.0001;
            }
            else if (Y[i] == 0.5)
            {
                Y[i + 26] = 0.5;
            }
            else
            {
                Y[i + 26] = 0.9999;
            }
        }
    }
}