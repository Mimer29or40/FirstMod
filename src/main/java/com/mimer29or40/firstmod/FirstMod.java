package com.mimer29or40.firstmod;

import com.mimer29or40.firstmod.configuration.ConfigurationHandler;
import com.mimer29or40.firstmod.init.ModBlocks;
import com.mimer29or40.firstmod.reference.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid= Reference.MOD_ID,name=Reference.MOD_NAME,version="1.7.2-0.1")
public class FirstMod
{
    @Mod.Instance("FirstMod")
    public static FirstMod instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());

        ModBlocks.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event)
    {

    }
}
