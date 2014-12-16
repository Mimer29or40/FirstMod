package com.mimer29or40.firstmod.block;

import com.google.common.collect.ImmutableSet;
import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.util.BlockStateUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

@SuppressWarnings( "unchecked" )
public class FMBlock
        extends Block
{
    public final ImmutableSet< IBlockState > presetStates;

    public FMBlock(String name, Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.FM_TAB);
        this.setUnlocalizedName(name);
        this.setHardness(1.5F);
        this.setResistance(10.0F);
        this.presetStates = BlockStateUtils.getValidStatesForProperties(this.getDefaultState(), this.getPresetProperties());
    }

    public FMBlock(String name)
    {
        this(name, Material.rock);
    }

    public IProperty[] getPresetProperties()
    {
        return null;
    }

    public boolean hasPresetProperties()
    {
        return this.getPresetProperties() != null;
    }

    public String getStateName(IBlockState state)
    {
        return this.getUnlocalizedName();
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }

    @Override
    @SideOnly( Side.CLIENT )
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        if(this.hasPresetProperties())
        {
            for(IBlockState state : presetStates)
                list.add(new ItemStack(item, 1, this.getMetaFromState(state)));
        }
        else
        {
            list.add(new ItemStack(item, 1, 0));
        }
    }
}