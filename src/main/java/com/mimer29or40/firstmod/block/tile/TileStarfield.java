package com.mimer29or40.firstmod.block.tile;

public class TileStarfield extends TileFM
{
    @Override
	public void updateEntity()
    {
	    if(worldObj.isDaytime())
            return;

        double radius = 512;
  		int iter = 2;
  		for(int i = 0; i < iter; i++)
        {
            double x = xCoord + 0.5 + (Math.random() - 0.5) * radius;
            double y = yCoord + 256;
            double z = zCoord + 0.5 + (Math.random() - 0.5) * radius;

            float w = 0.6F;
            float c = 1F - w;

            float r = w + (float) Math.random() * c;
            float g = w + (float) Math.random() * c;
            float b = w + (float) Math.random() * c;

            float s = 20F + (float) Math.random() * 20F;
            int m = 50;

//            Botania.proxy.sparkleFX(worldObj, x, y, z, r, g, b, s, m);
        }
   	}
}