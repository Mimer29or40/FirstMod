package com.mimer29or40.firstmod;

import com.mimer29or40.firstmod.client.handler.KeyInputEventHandler;
import com.mimer29or40.firstmod.handler.ClientTickHandler;
import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.handler.HUDHandler;
import com.mimer29or40.firstmod.init.ModBlocks;
import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.init.Recipes;
import com.mimer29or40.firstmod.proxy.ClientProxy;
import com.mimer29or40.firstmod.proxy.IProxy;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

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
        FMLCommonHandler.instance().bus().register(new ClientTickHandler());

        MinecraftForge.EVENT_BUS.register(new HUDHandler());

        proxy.registerKeyBindings();

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

        Recipes.init();

//        FMLCommonHandler.instance().bus().register(instance);
        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
        ClientProxy.init();

        LogHelper.info("Initialization Complete!");
        LogHelper.info("");
    }

    @Mod.EventHandler
    public void postInit(FMLInitializationEvent event)
    {
        LogHelper.info("");
        LogHelper.info("Post Initialization Started");

        for (String oreName : OreDictionary.getOreNames())
        {
            LogHelper.info(oreName);
        }

        LogHelper.info("Post Initialization Complete!");
        LogHelper.info("");
    }
}
