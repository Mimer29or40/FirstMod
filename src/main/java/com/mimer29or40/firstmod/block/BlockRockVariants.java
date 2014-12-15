package com.mimer29or40.firstmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IStringSerializable;

public class BlockRockVariants
        extends FMBlock
{
    protected static final PropertyEnum VARIANT_PROP = PropertyEnum.create("variant", RockType.class);

    public BlockRockVariants(String name, Material material)
    {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT_PROP, RockType.SMOOTH));
    }

    public BlockRockVariants(String name)
    {
        this(name, Material.rock);
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(this.getDefaultState().withProperty(VARIANT_PROP, state.getValue(VARIANT_PROP)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT_PROP, RockType.values()[meta]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((RockType) state.getValue(VARIANT_PROP)).ordinal();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, VARIANT_PROP);
    }

    @Override
    public String getStateName(IBlockState state)
    {
        return super.getStateName(state) + "_" + ((RockType) state.getValue(VARIANT_PROP)).getName();
    }

//    @Override
//    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
//    {
//        return getDefaultState().withProperty(VARIANT_PROP, facing);
//    }

    @Override
    public IProperty[] getPresetProperties()
    {
        return new IProperty[] { VARIANT_PROP };
    }

    public static enum RockType
            implements IStringSerializable
    {
        COBBLE,
        COBBLE_MOSSY,
        SMOOTH,
        BRICKS,
        BRICKS_MOSSY,
        SLAB,
        SLAB_SIDE,
        CARVED;

        @Override
        public String getName()
        {
            return this.name().toLowerCase();
        }

        @Override
        public String toString()
        {
            return getName();
        }
    }
}
