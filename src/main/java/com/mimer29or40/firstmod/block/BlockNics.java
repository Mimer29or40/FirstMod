package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.world.World;

import java.util.Random;

public class BlockNics extends BlockFM
{
    public BlockNics()
    {
        super();
        setBlockName(Names.Blocks.NICS);
        setBlockTextureName(Names.Blocks.NICS);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World world, int x, int y, int z, Random p_149734_5_)
    {
        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFlameFX(world, x+.5, y+1, z+.5, 0D, 2D, 0D).multipleParticleScaleBy(1F));
    }
}