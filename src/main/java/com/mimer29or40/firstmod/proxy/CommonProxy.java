package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.handler.LivingUpdateEventHandler;
import com.mimer29or40.firstmod.handler.PlayerInteractEventHandler;
import com.mimer29or40.firstmod.handler.WorldTickEventHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public abstract class CommonProxy implements IProxy
{
    @Override
    public void registerEventHandlers()
    {
        FMLCommonHandler.instance().bus().register(new WorldTickEventHandler());
        MinecraftForge.EVENT_BUS.register(new LivingUpdateEventHandler());
        MinecraftForge.EVENT_BUS.register(new PlayerInteractEventHandler());
    }

    @Override
    public void registerTileEntities()
    {

    }
}
