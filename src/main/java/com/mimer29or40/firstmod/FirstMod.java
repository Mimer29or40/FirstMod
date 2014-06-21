package com.mimer29or40.firstmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="firstMod",name="First Mod",version="1.7.2-0.1")
public class FirstMod
{
    @Mod.Instance("firstmod")
    public static FirstMod instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

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
