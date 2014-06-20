package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.blocks.BlockTest;
import com.mimer29or40.firstmod.blocks.FMBlocks;
import com.mimer29or40.firstmod.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static final FMBlocks test = new BlockTest();

    public static void init()
    {
        GameRegistry.registerBlock(test, "tile." + Names.Block.TEST);
    }
}
