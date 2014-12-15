package com.mimer29or40.firstmod.block;

import com.google.common.collect.ImmutableSet;
import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.BlockStateUtils;
import com.mimer29or40.firstmod.util.IInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class FMBlock
        extends Block
        implements IInfo
{
    public ImmutableSet< IBlockState > presetStates;
    protected String name;

    public FMBlock(String name, Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.FM_TAB);
        this.name = name;
        this.setUnlocalizedName(name);
        this.presetStates = BlockStateUtils.getValidStatesForProperties(this.getDefaultState(), this.getPresetProperties());
    }

    public FMBlock(String name)
    {
        this(name, Material.rock);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public IProperty[] getPresetProperties()
    {
        return null;
    }

    public boolean hasPresetProperties()
    {
        return getPresetProperties() != null;
    }

    public String getStateName(IBlockState state)
    {
        return name;
    }

    @Override
    @SideOnly( Side.CLIENT )
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
        if(this.hasPresetProperties())
        {
            for(IBlockState state : presetStates)
            {
                list.add(new ItemStack(item, 1, this.getMetaFromState(state)));
            }
        }
        else
        {
            list.add(new ItemStack(item, 1, 0));
        }
    }


    @Override
    public int damageDropped(IBlockState state)
    {
        return this.getMetaFromState(state);
    }

    @Override
    public void renderInfoOnScreen(Minecraft mc, ScaledResolution res, World world, BlockPos pos)
    {

    }
}