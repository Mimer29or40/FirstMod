package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.material.Material;

public class BlockFirst extends BlockFirstMod
{
    public BlockFirst()
    {
        super(Material.rock);
        this.setBlockName(Names.Block.FIRST_BLOCK);
        this.setHardness(0.5F);
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return true;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }


}
