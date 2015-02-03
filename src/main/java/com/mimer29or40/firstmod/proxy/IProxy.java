package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.item.FMItem;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy
{
    public void preInit(FMLPreInitializationEvent event);

    public void init(FMLInitializationEvent event);

    public void postInit(FMLPostInitializationEvent event);

    public void registerRenderers();

    public void registerBlockForMeshing(FMBlock block, int metadata, String name);

    public void registerItemForMeshing(FMItem item, int metadata, String name);
}
