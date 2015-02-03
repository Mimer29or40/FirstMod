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

public abstract class BlockFacing
        extends FMBlock
{
    protected static final PropertyEnum FACING_PROP = PropertyEnum.create("facing", EnumFacing.class);

    public BlockFacing(String name, Material material)
    {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING_PROP, EnumFacing.UP));
    }

    public BlockFacing(String name)
    {
        this(name, Material.rock);
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
        return new BlockState(this, FACING_PROP);
    }

    @Override
    public String getStateName(IBlockState state)
    {
        return ((EnumFacing) state.getValue(FACING_PROP)).getName();
    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if(placer.isSneaking())
            return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING_PROP, facing.getOpposite());
        else
            return super.onBlockPlaced(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING_PROP, facing);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos)
    {
        return new ItemStack(getItem(world, pos), 1, 0);
    }
}
