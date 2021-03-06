package com.mimer29or40.firstmod.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.IStringSerializable;

import java.util.Random;

public abstract class BlockRockVariants
        extends FMBlock
{
    protected static final PropertyEnum VARIANT_PROP = PropertyEnum.create("variant", RockType.class);

    public BlockRockVariants(String name)
    {
        super(name, Material.rock);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT_PROP, RockType.SMOOTH));
    }

    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(state.getBlock());
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
        return ((RockType) state.getValue(VARIANT_PROP)).getName();
    }

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
