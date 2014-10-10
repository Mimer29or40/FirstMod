package com.mimer29or40.firstmod.util.helpers;

import com.mimer29or40.firstmod.block.BlockCTM;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class CTMHelper {
    static int[][] submapCords  = {
            // ctm1
            {0,
             1,
             8,
             9},
            // 1,1     | 0  1| 2  3| 4  5| 6  7|
            {6,
             17,
             8,
             9},
            // 2,1     | 8  9|10 11|12 13|14 15|
            {0,
             7,
             8,
             25},
            // 3,1     |16 17|     |     |     |
            {0,
             1,
             24,
             15},
            // 4,1     |24 25|     |     |     |
            {16,
             1,
             14,
             9},
            // 1,2
            {6,
             3,
             8,
             25},
            // 2,2
            {6,
             17,
             24,
             15},
            // 3,2
            {2,
             17,
             14,
             9},
            // 4,2
            {0,
             7,
             24,
             11},
            // 1,3
            {16,
             7,
             14,
             25},
            // 2,3
            {16,
             1,
             10,
             15},
            // 3,3
            {6,
             3,
             24,
             11},
            // 4,3
            {2,
             3,
             14,
             25},
            // 1,4
            {2,
             17,
             10,
             15},
            // 2,4
            {16,
             7,
             10,
             11},
            // 3,4
            {2,
             3,
             10,
             11},
            // 4,4

            // ctm2
            {6,
             5,
             8,
             25},
            // 1,1     | 0  1| 2  3| 4  5| 6  7|
            {4,
             17,
             14,
             9},
            // 2,1     | 8  9|10 11|12 13|14 15|
            {0,
             7,
             24,
             13},
            // 3,1     |16 17|     |     |     |
            {16,
             1,
             12,
             15},
            // 4,1     |24 25|     |     |     |
            {6,
             5,
             24,
             11},
            // 1,2
            {2,
             5,
             14,
             25},
            // 2,2
            {6,
             3,
             24,
             13},
            // 3,2
            {4,
             3,
             14,
             25},
            // 4,2
            {2,
             17,
             12,
             15},
            // 1,3
            {4,
             17,
             10,
             15},
            // 2,3
            {16,
             7,
             10,
             13},
            // 3,3
            {16,
             7,
             12,
             11},
            // 4,3
            {6,
             5,
             24,
             13},
            // 1,4
            {4,
             5,
             14,
             25},
            // 2,4
            {4,
             17,
             12,
             15},
            // 3,4
            {16,
             7,
             12,
             13},
            // 4,4

            // ctm3
            {2,
             5,
             10,
             11},
            // 1,1     | 0  1| 2  3| 4  5| 6  7|
            {2,
             3,
             10,
             13},
            // 2,1     | 8  9|10 11|12 13|14 15|
            {2,
             3,
             12,
             11},
            // 3,1     |16 17|     |     |     |
            {4,
             3,
             10,
             11},
            // 4,1     |24 25|     |     |     |
            {2,
             5,
             10,
             13},
            // 1,2
            {2,
             5,
             12,
             11},
            // 2,2
            {4,
             5,
             10,
             11},
            // 3,2
            {2,
             3,
             12,
             13},
            // 4,2
            {4,
             3,
             10,
             13},
            // 1,3
            {4,
             3,
             12,
             11},
            // 2,3
            {2,
             5,
             12,
             13},
            // 3,3
            {4,
             5,
             10,
             13},
            // 4,3
            {4,
             5,
             12,
             11},
            // 1,4
            {4,
             3,
             12,
             13},
            // 2,4
            {4,
             5,
             12,
             13}
            // 3,4
    };
    static int[]   textureNames = {
            // -ctm1.png
            0,
            // (1,1)
            1,
            // (2,1)
            3,
            // (3,1)
            5,
            // (4,1)
            7,
            // (1,2)
            13,
            // (2,2)
            15,
            // (3,2)
            17,
            // (4,2)
            35,
            // (1,3)
            37,
            // (2,3)
            57,
            // (3,3)
            135,
            // (4,3)
            137,
            // (1,4)
            157,
            // (2,4)
            357,
            // (3,4)
            1357,
            // (4,4)
            // -ctm2.png
            123,
            // (1,1)
            178,
            // (2,1)
            345,
            // (3,1)
            567,
            // (4,1)
            1235,
            // (1,2)
            1237,
            // (2,2)
            1345,
            // (3,2)
            1378,
            // (4,2)
            1567,
            // (1,3)
            1578,
            // (2,3)
            3457,
            // (3,3)
            3567,
            // (4,3)
            12345,
            // (1,4)
            12378,
            // (2,4)
            15678,
            // (3,4)
            34567,
            // (4,4)
            // -ctm3.png,
            12357,
            // (1,1)
            13457,
            // (2,1)
            13567,
            // (3,1)
            13578,
            // (4,1)
            123457,
            // (1,2)
            123567,
            // (2,2)
            123578,
            // (3,2)
            134567,
            // (4,2)
            134578,
            // (1,3)
            135678,
            // (2,3)
            1234567,
            // (3,3)
            1234578,
            // (4,3)
            1235678,
            // (1,4)
            1345678,
            // (2,4)
            12345678,
            // (3,4)
    };

    // [8][1][2]
    // [7][X][3]
    // [6][5][5]
    private static int getTexture(IBlockAccess world, int x, int y, int z, int side)
    {
        if (world == null) return 0;

        int texture = 0;
        BlockCTM block = (BlockCTM) world.getBlock(x, y, z);
        int blockMeta = world.getBlockMetadata(x, y, z);

        boolean b[] = new boolean[9];
        for (int i = 1; i <= 8; i++)
            b[i] = isPresent(world, x, y, z, side, i, block, blockMeta);

        { // -ctm1
            // No Connections
            if (!b[1] && !b[3] && !b[5] && !b[7])
                texture = 0;
                // Single Connections
            else if (b[1] && !b[3] && !b[5] && !b[7])
                texture = 1;
            else if (!b[1] && b[3] && !b[5] && !b[7])
                texture = 3;
            else if (!b[1] && !b[3] && b[5] && !b[7])
                texture = 5;
            else if (!b[1] && !b[3] && !b[5] && b[7])
                texture = 7;
                // Double Connections
            else if (b[1] && b[3] && !b[5] && !b[7])
                texture = 13;
            else if (!b[1] && b[3] && b[5] && !b[7])
                texture = 35;
            else if (!b[1] && !b[3] && b[5] && b[7])
                texture = 57;
            else if (b[1] && !b[3] && !b[5] && b[7])
                texture = 17;
            else if (b[1] && !b[3] && b[5] && !b[7])
                texture = 15;
            else if (!b[1] && b[3] && !b[5] && b[7])
                texture = 37;
                // Triple Connections
            else if (b[1] && b[3] && b[5] && !b[7])
                texture = 135;
            else if (!b[1] && b[3] && b[5] && b[7])
                texture = 357;
            else if (b[1] && !b[3] && b[5] && b[7])
                texture = 157;
            else if (b[1] && b[3] && !b[5] && b[7])
                texture = 137;
                // Quad Connections
            else if (b[1] && b[3] && b[5] && b[7])
                texture = 1357;
        }


        if (block.isAdvCTM()) {
            { // -ctm2
                // Corner
                if (texture == 13 && b[2])
                    texture = 123;
                else if (texture == 17 && b[8])
                    texture = 178;
                else if (texture == 35 && b[4])
                    texture = 345;
                else if (texture == 57 && b[6])
                    texture = 567;
                    // Triple with 1
                else if (texture == 135 && b[2] && !b[4])
                    texture = 1235;
                else if (texture == 135 && !b[2] && b[4])
                    texture = 1345;
                else if (texture == 137 && !b[2] && b[8])
                    texture = 1378;
                else if (texture == 137 && b[2] && !b[8])
                    texture = 1237;
                else if (texture == 157 && b[6] && !b[8])
                    texture = 1567;
                else if (texture == 157 && !b[6] && b[8])
                    texture = 1578;
                else if (texture == 357 && b[4] && !b[6])
                    texture = 3457;
                else if (texture == 357 && !b[4] && b[6])
                    texture = 3567;
                    // Triple with 2
                else if (texture == 135 && b[2] && b[4])
                    texture = 12345;
                else if (texture == 137 && b[8] && b[2])
                    texture = 12378;
                else if (texture == 157 && b[6] && b[8])
                    texture = 15678;
                else if (texture == 357 && b[4] && b[6])
                    texture = 34567;
            }

            { // -ctm3
                // Quad with 1
                if (texture == 1357 && b[2] && !b[4] && !b[6] && !b[8])
                    texture = 12357;
                else if (texture == 1357 && !b[2] && b[4] && !b[6] && !b[8])
                    texture = 13457;
                else if (texture == 1357 && !b[2] && !b[4] && b[6] && !b[8])
                    texture = 13567;
                else if (texture == 1357 && !b[2] && !b[4] && !b[6] && b[8])
                    texture = 13578;
                    // Quad with 2
                else if (texture == 1357 && b[2] && b[4] && !b[6] && !b[8])
                    texture = 123457;
                else if (texture == 1357 && b[2] && !b[4] && b[6] && !b[8])
                    texture = 123567;
                else if (texture == 1357 && b[2] && !b[4] && !b[6] && b[8])
                    texture = 123578;
                else if (texture == 1357 && !b[2] && b[4] && b[6] && !b[8])
                    texture = 134567;
                else if (texture == 1357 && !b[2] && b[4] && !b[6] && b[8])
                    texture = 134578;
                else if (texture == 1357 && !b[2] && !b[4] && b[6] && b[8])
                    texture = 135678;
                    // Quad with 3
                else if (texture == 1357 && b[2] && b[4] && b[6] && !b[8])
                    texture = 1234567;
                else if (texture == 1357 && b[2] && b[4] && !b[6] && b[8])
                    texture = 1234578;
                else if (texture == 1357 && b[2] && !b[4] && b[6] && b[8])
                    texture = 1235678;
                else if (texture == 1357 && !b[2] && b[4] && b[6] && b[8])
                    texture = 1345678;
                    // All faces
                else if (texture == 1357 && b[2] && b[4] && b[6] && b[8])
                    texture = 12345678;
            }
        }
        return getIconNumber(texture);
    }

    private static boolean isPresent(IBlockAccess world, int x, int y, int z, int side, int location, Block block, int meta) {
        int x2 = x, y2 = y, z2 = z;
        int xPlane = 0, yPlane = 0, xOff = 0, yOff = 0, zOff = 0;

        switch (location) {
            case 1:
                yPlane++;
                break;
            case 2:
                xPlane++;
                yPlane++;
                break;
            case 3:
                xPlane++;
                break;
            case 4:
                xPlane++;
                yPlane--;
                break;
            case 5:
                yPlane--;
                break;
            case 6:
                xPlane--;
                yPlane--;
                break;
            case 7:
                xPlane--;
                break;
            case 8:
                xPlane--;
                yPlane++;
                break;
        }

        switch (side) {
            case 0:
                x2 += xPlane;
                z2 -= yPlane;
                yOff = -1;
                break;
            case 1:
                x2 += xPlane;
                z2 -= yPlane;
                yOff = 1;
                break;
            case 2:
                x2 -= xPlane;
                y2 += yPlane;
                zOff = -1;
                break;
            case 3:
                x2 += xPlane;
                y2 += yPlane;
                zOff = 1;
                break;
            case 4:
                z2 += xPlane;
                y2 += yPlane;
                xOff = -1;
                break;
            case 5:
                z2 -= xPlane;
                y2 += yPlane;
                xOff = 1;
                break;
        }
        return world.getBlock(x2, y2, z2).equals(block) && world.getBlockMetadata(x2, y2, z2) == meta && !((world.getBlock(x2 + xOff, y2 + yOff, z2 + zOff).equals(block) && world.getBlockMetadata(x2, y2, z2) == meta) || world.getBlock(x2 + xOff, y2 + yOff, z2 + zOff).isOpaqueCube());
    }

    private static int getIconNumber(int texture) {
        for (int i = 0; i <= textureNames.length; i++)
            if (textureNames[i] == texture)
                return i;
        return 0;
    }

    public static int[] getSubmapInfo(IBlockAccess world, int x, int y, int z, int side) {
        int index = getTexture(world, x, y, z, side);
        return submapCords[index];
    }

    public static enum Rotation {
        FlipVertical, FlipHorizontal, FlipBoth, None;

        public static double[] flipUV(Rotation rotation, double minU, double maxU, double minV, double maxV) {
            double[] uvMap = {minU, maxU, minV, maxV};

            switch (rotation) {
                case FlipVertical:
                    uvMap[2] = maxV;
                    uvMap[3] = minV;
                    break;
                case FlipHorizontal:
                    uvMap[0] = maxU;
                    uvMap[1] = minU;
                    break;
                case FlipBoth:
                    uvMap[0] = maxU;
                    uvMap[1] = minU;
                    uvMap[2] = maxV;
                    uvMap[3] = minV;
                    break;
            }
            return uvMap;
        }
    }
}