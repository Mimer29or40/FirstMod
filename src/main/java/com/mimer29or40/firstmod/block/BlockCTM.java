package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;

public class BlockCTM extends BlockFM
{
    public BlockCTM()
    {
        this(Material.rock);
    }

    public BlockCTM(Material material)
    {
        super(material);
        this.setBlockName(Names.Blocks.CTM);
        this.setBlockTextureName(Names.Blocks.CTM);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = IconHelper.forDir(iconRegister, "ctm", Textures.Block.CTM.CTM_TEXTURES.substring(0, Textures.Block.CTM.CTM_TEXTURES.length() - 1));
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return blockAccess.getBlock(x, y, z)!=this;
    }
}