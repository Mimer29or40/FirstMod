package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockArrow extends BlockFM
{
    public BlockArrow()
    {
        super(Names.Blocks.ARROW);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        worldIn.setBlockState(pos, this.getStateFromMeta(meta));
        return this.getStateFromMeta(meta);
    }
}