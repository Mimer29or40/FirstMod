package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.block.*;
import com.mimer29or40.firstmod.item.ItemBlockWithVariants;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static Block flag;
    public static Block frame;
    public static Block arrow;
    public static Block crystal;
    public static Block nics;
    public static Block redrock_raw;
    public static Block redrock;

    public static Block ctm_test       = new BlockCTMGlass(Names.Blocks.CTM_TEST, "ctm/test").setAdvCTM(true);
    public static Block window         = new BlockCTMGlass(Names.Blocks.WINDOW, "ctm/Window").setAlpha(true).setAdvCTM(true);
    public static Block clear_glass    = new BlockCTMGlass("clear_glass", "ctm/clear").setAdvCTM(true);
    public static Block redrock_smooth = new BlockCTM(Names.Blocks.REDROCK_SMOOTH, "ctm/redrock_smooth").setAdvCTM(true);

    public static void init()
    {
        flag = registerBlock(new BlockFlag(), Names.Blocks.FLAG);
        frame = registerBlock(new BlockFrame(), Names.Blocks.FRAME);
        arrow = registerBlock(new BlockArrow(), Names.Blocks.ARROW);
        crystal = registerBlock(new BlockCrystal(), Names.Blocks.CRYSTAL);
        nics = registerBlock(new BlockNics(), Names.Blocks.NICS);
        redrock_raw = registerBlock(new BlockRedRockRaw(), Names.Blocks.REDROCK_RAW);
        redrock = registerBlock(new BlockRedRockRaw(), Names.Blocks.REDROCK);

        //        GameRegistry.registerBlock(ctm_test, Names.Blocks.CTM_TEST);
        //        GameRegistry.registerBlock(window, Names.Blocks.WINDOW);
        //        GameRegistry.registerBlock(clear_glass, "clear_glass");
        //        GameRegistry.registerBlock(redrock_smooth, Names.Blocks.REDROCK_SMOOTH);
    }

    private static Block registerBlock(FMBlock block, String name)
    {
        if(block.hasPresetProperties())
        {
            GameRegistry.registerBlock(block, ItemBlockWithVariants.class, name);

            for(IBlockState state : block.presetStates)
            {
                String stateName = block.getStateName(state);

                ModelBakery.addVariantName(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + stateName);
                FirstMod.proxy.registerBlockForMeshing(block, block.getMetaFromState(state), stateName);
            }
        }
        else
        {
            GameRegistry.registerBlock(block, name);

            ModelBakery.addVariantName(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + name);
            FirstMod.proxy.registerBlockForMeshing(block, 0, name);
        }

        return block;
    }
}