package com.mimer29or40.firstmod.blocks;

import com.mimer29or40.firstmod.creativetab.CreativeTabFirstMod;
import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTest extends FMBlocks
{
    public BlockTest()
    {
        super(Material.iron);
        setHardness(5.0F);
        setResistance(10.0F);
        setStepSound(soundTypeMetal);
        setCreativeTab(CreativeTabFirstMod.FIRSTMOD_TAB);
        setBlockName(Names.Block.TEST);
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {

        return 0;
    }

    @Override
    public float getBlockHardness(World world, int x, int y, int z) {

        return 5;
    }

    @Override
    public float getExplosionResistance(Entity entity, World world, int x, int y, int z, double explosionX, double explosionY, double explosionZ) {

        return 6;
    }

    @Override
    public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {

        return false;
    }

    @Override
    public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {

        return true;
    }
}