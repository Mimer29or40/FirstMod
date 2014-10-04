package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.util.helpers.CTMHelper;
import com.mimer29or40.firstmod.util.TextureSubmap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;

public class RenderBlocksCTM extends RenderBlocks {

    RenderBlocksCTM() {
        super();
        resetVertices();
    }

    Tessellator tessellator;
    double[] X = new double[26];
    double[] Y = new double[26];
    double[] Z = new double[26];
    double[] U = new double[26];
    double[] V = new double[26];
    int[] L = new int[26];
    float[] R = new float[26];
    float[] G = new float[26];
    float[] B = new float[26];
    TextureSubmap submap[] = new TextureSubmap[3];
    boolean isOpaque;

    int bx, by, bz;

    @Override
    public boolean renderStandardBlock(Block block, int x, int y, int z)
    {
        bx = x; by = y; bz = z;

        tessellator = Tessellator.instance;
        tessellator.setColorOpaque_F(1.0F, 1.0F, 1.0F);
        tessellator.addTranslation(x, y, z);

        boolean res = super.renderStandardBlock(block, x, y, z);

        tessellator.addTranslation(-x, -y, -z);

        return res;
    }

    void setupSides(int a, int b, int c, int d, int xa, int xb, int xc, int xd, int e) {
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

    void side(int a, int b, int c, int d, int iconIndex[], CTMHelper.Rotation rotation, boolean inside)
    {
        IIcon icon = submap[iconIndex[0]].getIcon(iconIndex[1], iconIndex[2]);
//        switch (iconIndex[0])
//        {
//            case 1:
//                icon = submapBasic.getIcon(iconIndex[1], iconIndex[2]);
//                break;
//            case 2:
//                icon = submapAdv1.getIcon(iconIndex[1], iconIndex[2]);
//                break;
//            case 3:
//                icon = submapAdv2.getIcon(iconIndex[1], iconIndex[2]);
//                break;
//            default:
//                icon = submapBasic.getIcon(iconIndex[1], iconIndex[2]);
//        }

        double maxU = icon.getMaxU();
        double minU = icon.getMinU();
        double maxV = icon.getMaxV();
        double minV = icon.getMinV();

        double[] newUV = CTMHelper.Rotation.rotateUV(rotation, minU, maxU, minV, maxV);

        if (inside)
        {
            a += 8;
            b += 8;
            c += 8;
            d += 8;
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

    void vert(int index) {
        if (enableAO) {
            tessellator.setColorOpaque_F(R[index], G[index], B[index]);
            tessellator.setBrightness(L[index]);
        }

        tessellator.addVertexWithUV(X[index], Y[index], Z[index], U[index], V[index]);
    }

    @Override
    public void renderFaceXNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 4);

        setupSides(1, 0, 4, 5, 14, 19, 17, 23, 9);
        side(1, 0, 4, 5, tex, CTMHelper.Rotation.None, false);
        if (!isOpaque)
            side(5,4,0,1,tex, CTMHelper.Rotation.FlipHorizontal, true);
    }

    @Override
    public void renderFaceXPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 5);

        setupSides(3, 2, 6, 7, 15, 25, 16, 21, 11);
        side(6, 7, 3, 2, tex, CTMHelper.Rotation.None, false);
        if (!isOpaque)
            side(2, 3, 7, 6, tex, CTMHelper.Rotation.FlipHorizontal, true);
    }

    @Override
    public void renderFaceZNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 2);

        setupSides(2, 3, 0, 1, 15, 18, 14, 22, 8);
        side(2, 3, 0, 1, tex, CTMHelper.Rotation.None, false);
        if (!isOpaque)
            side(1, 0, 3, 2, tex, CTMHelper.Rotation.FlipHorizontal, true);
    }


    @Override
    public void renderFaceZPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 3);

        setupSides(4, 7, 6, 5, 20, 16, 24, 17, 10);
        side(5, 4, 7, 6, tex, CTMHelper.Rotation.None, false);
        if (!isOpaque)
            side(6, 7, 4, 5, tex, CTMHelper.Rotation.FlipHorizontal, true);
    }

    @Override
    public void renderFaceYNeg(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 0);

        setupSides(3, 7, 4, 0, 18, 21, 20, 19, 13);
        side(3, 7, 4, 0, tex, CTMHelper.Rotation.FlipHorizontal, false);
        if (!isOpaque)
            side(0, 4, 7, 3, tex, CTMHelper.Rotation.None, true);
    }

    @Override
    public void renderFaceYPos(Block block, double x, double y, double z, IIcon icon)
    {
        int tex[] = CTMHelper.getSubmapInfo(blockAccess, bx, by, bz, 1);

        setupSides(2, 1, 5, 6, 22, 23, 24, 25, 12);
        side(1, 5, 6, 2, tex, CTMHelper.Rotation.None, false);
        if (!isOpaque)
            side(2, 6, 5, 1, tex, CTMHelper.Rotation.FlipHorizontal, true);
    }

    void resetVertices()
    {
        X[0] = 0;
        Z[0] = 0;
        Y[0] = 0;

        X[8] = 0.0001;
        Z[8] = 0.0001;
        Y[8] = 0.0001;

        X[1] = 0;
        Z[1] = 0;
        Y[1] = 1;

        X[9] = 0.0001;
        Z[9] = 0.0001;
        Y[9] = 0.9999;

        X[2] = 1;
        Z[2] = 0;
        Y[2] = 1;

        X[10] = 0.9999;
        Z[10] = 0.0001;
        Y[10] = 0.9999;

        X[3] = 1;
        Z[3] = 0;
        Y[3] = 0;

        X[11] = 0.9999;
        Z[11] = 0.0001;
        Y[11] = 0.0001;

        X[4] = 0;
        Z[4] = 1;
        Y[4] = 0;

        X[12] = 0.0001;
        Z[12] = 0.9999;
        Y[12] = 0.0001;

        X[5] = 0;
        Z[5] = 1;
        Y[5] = 1;

        X[13] = 0.0001;
        Z[13] = 0.9999;
        Y[13] = 0.9999;

        X[6] = 1;
        Z[6] = 1;
        Y[6] = 1;

        X[14] = 0.9999;
        Z[14] = 0.9999;
        Y[14] = 0.9999;

        X[7] = 1;
        Z[7] = 1;
        Y[7] = 0;

        X[15] = 0.9999;
        Z[15] = 0.9999;
        Y[15] = 0.0001;
    }
}