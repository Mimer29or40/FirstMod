package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFrame
        extends FMBlock
{
    public BlockFrame()
    {
        super(Names.Blocks.FRAME);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @SideOnly( Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
}