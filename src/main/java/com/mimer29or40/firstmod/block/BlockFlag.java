package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.world.IBlockAccess;

public class BlockFlag extends BlockFM
{
    public BlockFlag()
    {
        super();
        this.setBlockName(Names.Blocks.FLAG);
        this.setBlockTextureName(Names.Blocks.FLAG);
//        this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.0F, 0.75F);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
}