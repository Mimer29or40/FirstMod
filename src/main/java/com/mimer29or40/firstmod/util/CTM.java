package com.mimer29or40.firstmod.util;

import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;

public class CTM
{
    private static boolean advancedTextures = false;
//    [8][1][2] Locations of blocks
//    [7][ ][3]
//    [6][5][5]
    public static int getTexture(IBlockAccess world, int x, int y, int z, int side)
    {
        if (world == null)
            return 0;

        int texture = 0;
        Block block = world.getBlock(x, y, z);
        int blockMeta = world.getBlockMetadata(x, y, z);

        boolean b[] = new boolean[8];
        for (int i = 0; i <= 7; i++)
            b[i] = isPresent(world, x, y, z, side, i, block, blockMeta);

        // Simple Connections
        // No Connections
        if (!b[0] && !b[2] && !b[4] && !b[6])
            texture = 0;
        // Single Connections
        else if (b[0] && !b[2] && !b[4] && !b[6])
            texture = 1;
        else if (!b[0] && b[2] && !b[4] && !b[6])
            texture = 3;
        else if (!b[0] && !b[2] && b[4] && !b[6])
            texture = 5;
        else if (!b[0] && !b[2] && !b[4] && b[6])
            texture = 7;
        // Double Connections
        else if (b[0] && b[2] && !b[4] && !b[6])
            texture = 13;
        else if (!b[0] && b[2] && b[4] && !b[6])
            texture = 35;
        else if (!b[0] && !b[2] && b[4] && b[6])
            texture = 57;
        else if (b[0] && !b[2] && !b[4] && b[6])
            texture = 17;
        else if (b[0] && !b[2] && b[4] && !b[6])
            texture = 15;
        else if (!b[0] && b[2] && !b[4] && b[6])
            texture = 37;
        // Triple Connections
        else if (b[0] && b[2] && b[4] && !b[6])
            texture = 135;
        else if (!b[0] && b[2] && b[4] && b[6])
            texture = 357;
        else if (b[0] && !b[2] && b[4] && b[6])
            texture = 157;
        else if (b[0] && b[2] && !b[4] && b[6])
            texture = 137;
        // Quad Connections
        else if (b[0] && b[2] && b[4] && b[6])
            texture = 1357;

        // Wonky Connection
        if (advancedTextures)
        {
            // Corner
            if (texture == 13 && b[1])
                texture = 123;
            else if (texture == 35 && b[3])
                texture = 345;
            else if (texture == 57 && b[5])
                texture = 567;
            else if (texture == 17 && b[7])
                texture = 178;
                // Triple with 1
            else if (texture == 135 && b[1] && !b[3])
                texture = 1235;
            else if (texture == 357 && b[3] && !b[5])
                texture = 3457;
            else if (texture == 157 && b[5] && !b[7])
                texture = 1567;
            else if (texture == 137 && b[7] && !b[1])
                texture = 1378;
            else if (texture == 135 && b[3] && !b[1])
                texture = 1345;
            else if (texture == 357 && b[5] && !b[3])
                texture = 3567;
            else if (texture == 157 && b[7] && !b[5])
                texture = 1578;
            else if (texture == 137 && b[1] && !b[7])
                texture = 1237;
                // Triple with 2
            else if (texture == 135 && b[1] && b[3])
                texture = 12345;
            else if (texture == 357 && b[3] && b[5])
                texture = 34567;
            else if (texture == 157 && b[5] && b[7])
                texture = 15678;
            else if (texture == 137 && b[7] && b[1])
                texture = 12378;

            // Even Wonkier Connection
            // Quad with 1
            if (texture == 1357 && b[1] && !b[3] && !b[5] && !b[7])
                texture = 12357;
            else if (texture == 1357 && !b[1] && b[3] && !b[5] && !b[7])
                texture = 13457;
            else if (texture == 1357 && !b[1] && !b[3] && b[5] && !b[7])
                texture = 13567;
            else if (texture == 1357 && !b[1] && !b[3] && !b[5] && b[7])
                texture = 13578;
                // Quad with 2
            else if (texture == 1357 && b[1] && b[3] && !b[5] && !b[7])
                texture = 123457;
            else if (texture == 1357 && !b[1] && b[3] && b[5] && !b[7])
                texture = 134567;
            else if (texture == 1357 && !b[1] && !b[3] && b[5] && b[7])
                texture = 135678;
            else if (texture == 1357 && b[1] && !b[3] && !b[5] && b[7])
                texture = 123578;
            else if (texture == 1357 && b[1] && !b[3] && b[5] && !b[7])
                texture = 123567;
            else if (texture == 1357 && !b[1] && b[3] && !b[5] && b[7])
                texture = 134578;
                // Quad with 3
            else if (texture == 1357 && b[1] && b[3] && b[5] && !b[7])
                texture = 1234567;
            else if (texture == 1357 && !b[1] && b[3] && b[5] && b[7])
                texture = 1345678;
            else if (texture == 1357 && b[1] && !b[3] && b[5] && b[7])
                texture = 1235678;
            else if (texture == 1357 && b[1] && b[3] && !b[5] && b[7])
                texture = 1234578;
                // All faces
            else if (texture == 1357 && b[1] && b[3] && b[5] && b[7])
                texture = 12345678;
        }
        return convertToInt(texture);
    }

    private static boolean isPresent(IBlockAccess world, int x, int y, int z, int side, int location, Block block, int meta)
    {
        int x2 = x, y2 = y, z2 = z;
        int xPlane = 0, yPlane = 0;

        switch(location)
        {
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

        switch(side)
        {
            case 0:
                x2 += xPlane;
                z2 -= yPlane;
                break;
            case 1:
                x2 += xPlane;
                z2 -= yPlane;
                break;
            case 2:
                x2 -= xPlane;
                y2 += yPlane;
                break;
            case 3:
                x2 += xPlane;
                y2 += yPlane;
                break;
            case 4:
                z2 += xPlane;
                y2 += yPlane;
                break;
            case 5:
                z2 -= xPlane;
                y2 += yPlane;
                break;
        }
        return world.getBlock(x2, y2, z2).equals(block) && world.getBlockMetadata(x2, y2, z2) == meta;
    }

    public static String convertToLocation(int val)
    {
        switch (val)
        {
            case 0:
                return "";
            case 1:
                return "_1";
            case 2:
                return "_3";
            case 3:
                return "_5";
            case 4:
                return "_7";
            case 5:
                return "_13";
            case 6:
                return "_15";
            case 7:
                return "_17";
            case 8:
                return "_35";
            case 9:
                return "_37";
            case 10:
                return "_57";
            case 11:
                return "_135";
            case 12:
                return "_137";
            case 13:
                return "_157";
            case 14:
                return "_357";
            case 15:
                return "_1357";
            // Wonky
            case 16:
                return "_123";
            case 17:
                return "_345";
            case 18:
                return "_567";
            case 19:
                return "_178";
            case 20:
                return "_1235";
            case 21:
                return "_3457";
            case 22:
                return "_1567";
            case 23:
                return "_1378";
            case 24:
                return "_1345";
            case 25:
                return "_3567";
            case 26:
                return "_1578";
            case 27:
                return "_1237";
            case 28:
                return "_12345";
            case 29:
                return "_34567";
            case 30:
                return "_15678";
            case 31:
                return "_12378";
            case 32:
                return "_12357";
            case 33:
                return "_13457";
            case 34:
                return "_13567";
            case 35:
                return "_13578";
            case 36:
                return "_123457";
            case 37:
                return "_134567";
            case 38:
                return "_135678";
            case 39:
                return "_123578";
            case 40:
                return "_123567";
            case 41:
                return "_134578";
            case 42:
                return "_1234567";
            case 43:
                return "_1345678";
            case 44:
                return "_1235678";
            case 45:
                return "_1234578";
            case 46:
                return "_12345678";
            default:
                return "";
        }
    }

    public static int convertToInt(int location)
    {
        switch (location)
        {
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
            case 5:
                return 3;
            case 7:
                return 4;
            case 13:
                return 5;
            case 15:
                return 6;
            case 17:
                return 7;
            case 35:
                return 8;
            case 37:
                return 9;
            case 57:
                return 10;
            case 135:
                return 11;
            case 137:
                return 12;
            case 157:
                return 13;
            case 357:
                return 14;
            case 1357:
                return 15;
            case 123:
                return 16;
            case 345:
                return 17;
            case 567:
                return 18;
            case 178:
                return 19;
            case 1235:
                return 20;
            case 3457:
                return 21;
            case 1567:
                return 22;
            case 1378:
                return 23;
            case 1345:
                return 24;
            case 3567:
                return 25;
            case 1578:
                return 26;
            case 1237:
                return 27;
            case 12345:
                return 28;
            case 34567:
                return 29;
            case 15678:
                return 30;
            case 12378:
                return 31;
            case 12357:
                return 32;
            case 13457:
                return 33;
            case 13567:
                return 34;
            case 13578:
                return 35;
            case 123457:
                return 36;
            case 134567:
                return 37;
            case 135678:
                return 38;
            case 123578:
                return 39;
            case 123567:
                return 40;
            case 134578:
                return 41;
            case 1234567:
                return 42;
            case 1345678:
                return 43;
            case 1235678:
                return 44;
            case 1234578:
                return 45;
            case 12345678:
                return 46;
            default:
                return 0;
        }
    }

    static int submap[][] =
    {
            {1,1},
            {1,2},
            {1,3},
            {1,4},
            {2,1},
            {2,2},
            {2,3},
            {2,4},
            {3,1},
            {3,2},
            {3,3},
            {3,4},
            {4,1},
            {4,2},
            {4,3},
            {4,4}
    };

    public static int[] getSubmapIndices(IBlockAccess world, int x, int y, int z, int side)
    {
        int index = getTexture(world, x, y, z, side);

        return submap[index];
    }
}