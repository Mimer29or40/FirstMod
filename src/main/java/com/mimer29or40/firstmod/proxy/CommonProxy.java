package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.handler.CommonEventHandler;
import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.init.ModBlocks;
import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.init.Recipes;
import com.mimer29or40.firstmod.item.FMItem;
import com.mimer29or40.firstmod.util.helpers.LogHelper;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
        implements IProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModBlocks.init();

        FMLCommonHandler.instance().bus().register(new CommonEventHandler());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler(event.getSuggestedConfigurationFile()));
    }

    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(FirstMod.instance);

        Recipes.init();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("First Mod Server has finished initializing");
    }

    public void registerRenderers()
    {
        // NOOP
    }

    public void registerBlockForMeshing(FMBlock block, int metadata, String name)
    {
        // NOOP
    }

    public void registerItemForMeshing(FMItem item, int metadata, String name)
    {
        // NOOP
    }
}
