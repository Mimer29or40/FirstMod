package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.settings.Keybindings;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static void init()
    {
        RenderIDs.blockArrow = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockFrame = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockCrystal = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockCTM = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
