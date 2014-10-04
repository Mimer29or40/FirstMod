package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.render.block.CTMRender;
import com.mimer29or40.firstmod.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static void init()
    {
        RenderingRegistry.registerBlockHandler(new CTMRender());
    }

    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
