package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.handler.ClientEventHandler;
import com.mimer29or40.firstmod.client.handler.HUDHandler;
import com.mimer29or40.firstmod.client.handler.KeyInputEventHandler;
import com.mimer29or40.firstmod.client.settings.Keybindings;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        registerKeyBindings();

        FMLCommonHandler.instance().bus().register(new ClientEventHandler());

        MinecraftForge.EVENT_BUS.register(new HUDHandler());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

//        RenderingRegistry.registerBlockHandler(new CTMRender());

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
