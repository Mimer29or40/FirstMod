package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.helpers.LogHelper;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockArrow
        extends FMBlock
{
    public static final PropertyEnum FACING_PROP = PropertyEnum.create("axis", EnumFacing.class);

    public BlockArrow()
    {
        super(Names.Blocks.ARROW);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING_PROP, EnumFacing.UP));
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(this.getDefaultState().withProperty(FACING_PROP, state.getValue(FACING_PROP)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(FACING_PROP, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING_PROP)).ordinal();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { FACING_PROP });
    }

    @Override
    public String getStateName(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING_PROP)).getName();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        LogHelper.info(getStateName(getDefaultState().withProperty(FACING_PROP, facing)));
        return getDefaultState().withProperty(FACING_PROP, facing);
    }
}