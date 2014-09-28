package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.block.*;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final Block flag = new BlockFlag();
    public static final Block frame = new BlockFrame();
    public static final Block arrow = new BlockArrow();
    public static final Block crystal = new BlockCrystal();
    public static final Block nics = new BlockNics();
    public static final Block ctm = new BlockCTM();

    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
        GameRegistry.registerBlock(frame, Names.Blocks.FRAME);
        GameRegistry.registerBlock(arrow, Names.Blocks.ARROW);
        GameRegistry.registerBlock(crystal, Names.Blocks.CRYSTAL);
        GameRegistry.registerBlock(nics, Names.Blocks.NICS);
        GameRegistry.registerBlock(ctm, Names.Blocks.CTM);
    }
}