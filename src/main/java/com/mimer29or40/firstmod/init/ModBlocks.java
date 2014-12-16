package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.block.*;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.helpers.RegisterHelper;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static Block flag;
    public static Block frame;
    public static Block arrow;
    public static Block crystal;
    public static Block nics;
    public static Block redrock;
    public static Block log;

    //    public static Block ctm_test       = new BlockCTMGlass(Names.Blocks.CTM_TEST, "ctm/test").setAdvCTM(true);
    //    public static Block window         = new BlockCTMGlass(Names.Blocks.WINDOW, "ctm/Window").setAlpha(true).setAdvCTM(true);
    //    public static Block clear_glass    = new BlockCTMGlass("clear_glass", "ctm/clear").setAdvCTM(true);
    //    public static Block redrock_smooth = new BlockCTM(Names.Blocks.REDROCK_SMOOTH, "ctm/redrock_smooth").setAdvCTM(true);

    public static void init()
    {
        flag = RegisterHelper.registerBlock(new BlockFlag(), Names.Blocks.FLAG);
        frame = RegisterHelper.registerBlock(new BlockFrame(), Names.Blocks.FRAME);
        arrow = RegisterHelper.registerBlock(new BlockArrow(), Names.Blocks.ARROW);
        crystal = RegisterHelper.registerBlock(new BlockCrystal(), Names.Blocks.CRYSTAL);
        nics = RegisterHelper.registerBlock(new BlockNics(), Names.Blocks.NICS);
        redrock = RegisterHelper.registerBlock(new BlockRedRock(), Names.Blocks.REDROCK);
        log = RegisterHelper.registerBlock(new BlockLog(), Names.Blocks.LOG);

        //        GameRegistry.registerBlock(ctm_test, Names.Blocks.CTM_TEST);
        //        GameRegistry.registerBlock(window, Names.Blocks.WINDOW);
        //        GameRegistry.registerBlock(clear_glass, "clear_glass");
        //        GameRegistry.registerBlock(redrock_smooth, Names.Blocks.REDROCK_SMOOTH);
    }
}