package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.block.tile.TileCrystal;
import com.mimer29or40.firstmod.client.render.particle.TestParticleFX;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.util.IInfo;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntityHeartFX;
import net.minecraft.client.particle.EntitySpellParticleFX;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.Random;

public class BlockCrystal extends BlockFMContainer implements IInfo
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
//        world.spawnParticle("spell", X, Y, Z, 0D, 0D, 0D);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z)
    {
        float x1 = 0.3F;
        float y1 = 0F;
        float z1 = 0.3F;

        float x2 = 0.7F;
        float y2 = 0.8F;
        float z2 = 0.7F;

        float y1s = 0.2F;
        float y2s = 1F;

        switch (ForgeDirection.getOrientation(world.getBlockMetadata(x,y,z)))
        {
            case DOWN:
                this.setBlockBounds(x1, y1s, z1, x2, y2s, z2);
                break;
            case UP:
                this.setBlockBounds(x1, y1, z1, x2, y2, z2);
                break;
            case NORTH:
                this.setBlockBounds(x1, z1, y1s, x2, z2, y2s);
                break;
            case SOUTH:
                this.setBlockBounds(x1, z1, y1, x2, z2, y2);
                break;
            case EAST:
                this.setBlockBounds(y1, x1, z1, y2, x2, z2);
                break;
            case WEST:
                this.setBlockBounds(y1s, x1, z1, y2s, x2, z2);
                break;
        }
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockCrystal;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        LogHelper.info("Side: " + ForgeDirection.getOrientation(side));
        world.setBlock(x, y, z, this, side, 3);
        return world.getBlockMetadata(x,y,z);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileCrystal();
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public void renderInfoOnScreen(Minecraft mc, ScaledResolution res, World world, int x, int y, int z) {
        ((TileCrystal) world.getTileEntity(x, y, z)).renderInfoOnScreen(mc, res, world, x, y, z);
    }
}