package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.render.block.BlockArrowRenderer;
import com.mimer29or40.firstmod.client.render.block.BlockFrameRenderer;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
    public static void initRenderers()
    {
        RenderIDs.blockArrow = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockFrame = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new BlockArrowRenderer());
        RenderingRegistry.registerBlockHandler(new BlockFrameRenderer());
    }
}
