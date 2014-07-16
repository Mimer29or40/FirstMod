package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.block.BlockArrow;
import com.mimer29or40.firstmod.block.BlockFM;
import com.mimer29or40.firstmod.block.BlockFlag;
import com.mimer29or40.firstmod.block.BlockFrame;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockFM flag = new BlockFlag();
    public static final BlockFM frame = new BlockFrame();
    public static final BlockFM arrow = new BlockArrow();

    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
        GameRegistry.registerBlock(frame, Names.Blocks.FRAME);
        GameRegistry.registerBlock(arrow, Names.Blocks.ARROW);
    }
}