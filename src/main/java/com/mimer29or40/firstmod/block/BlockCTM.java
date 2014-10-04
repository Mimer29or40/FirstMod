package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.client.handler.CTMHandler;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockCTM extends BlockFM
{
    public CTMHandler ctmHandler;
    public String textureLocation;
    public boolean isAlpha = false;
    public boolean isAdvancedCTM = false;

    public BlockCTM(String texture)
    {
        this(Material.rock, texture);
    }

    public BlockCTM(Material material, String texture)
    {
        super(material);
        textureLocation = texture;
        ctmHandler = new CTMHandler(this, textureLocation);
    }

    public BlockCTM setAlpha(boolean a)
    {
        this.isAlpha = a;
        return this;
    }

    public BlockCTM setAdvCTM(boolean ctm)
    {
        this.isAdvancedCTM = ctm;
        return this;
    }

    public boolean isAdvCTM()
    {
        return this.isAdvancedCTM;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return isAlpha ? 1 : 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta) {
        return ctmHandler.getIcon(side,meta);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        return ctmHandler.getIcon(side, world.getBlockMetadata(x, y, z));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        ctmHandler.registerBlockIcons(iconRegister, this);
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return blockAccess.getBlock(x, y, z) != this && !blockAccess.getBlock(x, y, z).isOpaqueCube();
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockCTM;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return true;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}