package com.mimer29or40.firstmod.block;

import net.minecraft.block.material.Material;

public class BlockCTMGlass
        extends BlockCTM
{
    public BlockCTMGlass(String name, String texture)
    {
        this(name, Material.glass, texture);
    }

    public BlockCTMGlass(String name, Material material, String texture)
    {
        super(name, material, texture);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}