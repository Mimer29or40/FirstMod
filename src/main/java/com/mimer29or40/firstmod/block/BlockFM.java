package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

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
}