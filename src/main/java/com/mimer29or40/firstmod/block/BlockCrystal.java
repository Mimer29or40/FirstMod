package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.helpers.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BlockCrystal extends BlockFM
{
    public BlockCrystal()
    {
        super();
        this.setBlockName(Names.Blocks.CRYSTAL);
        setLightLevel(10);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random p_149734_5_)
    {
        double X = x + 0.5D;
        double Y = y + 0.5D;
        double Z = z + 0.5D;
        double DX = 0D;
        double DY = 0D;
        double DZ = 0D;
        double height = 0.8D;

        int meta = world.getBlockMetadata(x, y, z);

        switch (ForgeDirection.getOrientation(meta)) {
            case DOWN:
                Y = y + 1D - height;
                DY = -0.1D;
                break;
            case UP:
                Y = y + height;
                DY = 0.1D;
                break;
            case NORTH:
                Z = z + 1D - height;
                DZ = -0.1D;
                break;
            case SOUTH:
                Z = z + height;
                DZ = 0.1D;
                break;
            case WEST:
                X = x + 1D - height;
                DX = -0.1D;
                break;
            case EAST:
                X = x + height;
                DX = 0.1D;
                break;
        }
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFlameFX(world, X, Y, Z, DX, DY, DZ));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = IconHelper.forBlock(iconRegister, this);
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        world.setBlock(x, y, z, this, side, 3);
        return world.getBlockMetadata(x,y,z);
    }
}