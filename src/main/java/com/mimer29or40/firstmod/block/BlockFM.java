package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.helpers.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public abstract class BlockFM extends Block
{
    public BlockFM(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTab.FM_TAB);
    }

    public BlockFM()
    {
        this(Material.rock);
        this.setCreativeTab(CreativeTab.FM_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = IconHelper.forBlock(iconRegister, this);
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        return this.getIcon(side, world.getBlockMetadata(x, y, z));
    }
}