package com.mimer29or40.firstmod.block;

import net.minecraft.block.material.Material;

public class BlockCTMGlass extends BlockCTM
{
    public BlockCTMGlass(String texture)
    {
        this(Material.glass, texture);
    }

    public BlockCTMGlass(Material material, String texture)
    {
        super(material, texture);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}