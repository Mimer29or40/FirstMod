package com.mimer29or40.firstmod;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.init.ModBlocks;
import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.proxy.ClientProxy;
import com.mimer29or40.firstmod.proxy.IProxy;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FirstMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static FirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        LogHelper.info("");
        LogHelper.info("Pre Initialization Started");

        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        ModItems.init();

        ModBlocks.init();

        LogHelper.info("Pre Initialization Complete!");
        LogHelper.info("");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("");
        LogHelper.info("Initialization Started");

        FMLCommonHandler.instance().bus().register(instance);
        ClientProxy.initRenderers();

        LogHelper.info("Initialization Complete!");
        LogHelper.info("");
    }

    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event)
    {
        LogHelper.info("");
        LogHelper.info("Post Initialization Started");

        LogHelper.info("Post Initialization Complete!");
        LogHelper.info("");
    }
}
