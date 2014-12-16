package com.mimer29or40.firstmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public abstract class BlockAxis
        extends FMBlock
{
    protected static final PropertyEnum AXIS_PROP = PropertyEnum.create("axis", EnumFacing.Axis.class);

    public BlockAxis(String name, Material material)
    {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(AXIS_PROP, EnumFacing.Axis.Y));
    }

    public BlockAxis(String name)
    {
        this(name, Material.rock);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(AXIS_PROP, EnumFacing.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing) state.getValue(AXIS_PROP)).ordinal();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, AXIS_PROP);
    }

    @Override
    public String getStateName(IBlockState state)
    {
        return ((EnumFacing.Axis) state.getValue(AXIS_PROP)).getName();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(AXIS_PROP, facing.getAxis());
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos)
    {
        return new ItemStack(getItem(world, pos), 1, 0);
    }
}
