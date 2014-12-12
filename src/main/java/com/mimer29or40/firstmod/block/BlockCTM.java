package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.client.handler.CTMHandler;
import com.mimer29or40.firstmod.reference.RenderIDs;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCTM
        extends FMBlock
{
    public CTMHandler ctmHandler;
    public String     textureLocation;
    protected boolean isAlpha       = false;
    protected boolean isAdvancedCTM = false;

    public BlockCTM(String name, String texture)
    {
        this(name, Material.rock, texture);
    }

    public BlockCTM(String name, Material material, String texture)
    {
        super(name, material);
        textureLocation = texture;
        ctmHandler = new CTMHandler(this, textureLocation);
    }

    public BlockCTM setAlpha(boolean a)
    {
        this.isAlpha = a;
        return this;
    }

    public boolean isAdvCTM()
    {
        return this.isAdvancedCTM;
    }

    public BlockCTM setAdvCTM(boolean ctm)
    {
        this.isAdvancedCTM = ctm;
        return this;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return worldIn.getBlockState(pos).getBlock() != this && ! worldIn.getBlockState(pos).getBlock().isOpaqueCube();
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockCTM;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return isAlpha ? EnumWorldBlockLayer.TRANSLUCENT : EnumWorldBlockLayer.SOLID;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return isAlpha ? false : true;
    }
}