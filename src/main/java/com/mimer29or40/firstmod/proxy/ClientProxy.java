package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.render.block.BlockArrowRenderer;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static void initRenderingAndTextures()
    {
        RenderIDs.blockArrow = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockArrowRenderer());
    }
}
