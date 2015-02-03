package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BlockLog // TODO Fix logs not showing in inventory
        extends BlockLogBase
{
    public static final PropertyEnum VARIANT_PROP = PropertyEnum.create("variant", LogType.class);

    public BlockLog()
    {
        super(Names.Blocks.LOG);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT_PROP, LogType.RED).withProperty(AXIS_PROP, EnumFacing.Axis.Y));
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(this.getDefaultState().withProperty(VARIANT_PROP, state.getValue(VARIANT_PROP)));
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        int axis = meta % 3;
        int type = (meta - axis) / 3;

        return this.getDefaultState().withProperty(VARIANT_PROP, LogType.values()[type]).withProperty(AXIS_PROP, EnumFacing.Axis.values()[axis]);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int baseMeta = ((LogType)state.getValue(VARIANT_PROP)).ordinal();
        return baseMeta * 3 + ((EnumFacing.Axis)state.getValue(AXIS_PROP)).ordinal();
    }

    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, AXIS_PROP, VARIANT_PROP);
    }

    @Override
    public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        int meta = 3 * ((LogType)state.getValue(VARIANT_PROP)).ordinal();
        return new ItemStack(getItem(world, pos), 1, meta);
    }

    @Override
    public String getStateName(IBlockState state)
    {
        return ((LogType) state.getValue(VARIANT_PROP)).getName();
    }

    @Override
    public IProperty[] getPresetProperties()
    {
        return new IProperty[] { VARIANT_PROP };
    }

    public static enum LogType implements IStringSerializable
    {
        RED,
        BLUE,
        GREEN,
        WHITE,
        BLACK;

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
