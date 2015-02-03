package com.mimer29or40.firstmod.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockLogBase
        extends BlockAxis
{
    public BlockLogBase(String name)
    {
        super(name, Material.wood);

        this.setHarvestLevel("axe", 0);

        this.setHardness(2.0F);
        this.setResistance(5.0F);
        this.setStepSound(Block.soundTypeWood);
    }
}
