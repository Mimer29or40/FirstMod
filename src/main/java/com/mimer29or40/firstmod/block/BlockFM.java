package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public abstract class BlockFM extends Block
{
    public BlockFM(String name, Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.FM_TAB);
        this.setUnlocalizedName(name);
    }

    public BlockFM(String name)
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
}