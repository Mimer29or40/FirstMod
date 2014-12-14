package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.client.handler.ClientEventHandler;
import com.mimer29or40.firstmod.client.handler.HUDHandler;
import com.mimer29or40.firstmod.client.handler.KeyInputEventHandler;
import com.mimer29or40.firstmod.client.helpers.ModelHelper;
import com.mimer29or40.firstmod.client.settings.Keybindings;
import com.mimer29or40.firstmod.item.FMItem;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class ClientProxy
        extends CommonProxy
{
    private static ArrayList< ModelBlockEntry > blocksToRegister = new ArrayList();
    private static ArrayList< ModelItemEntry >  itemsToRegister  = new ArrayList();

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

        registerRenderers();

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    private void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

    @Override
    public void registerRenderers()
    {
        for(ModelBlockEntry modelBlockEntry : blocksToRegister)
        {
            ModelHelper.registerBlock(modelBlockEntry.block, modelBlockEntry.metadata, Reference.MOD_ID + ":" + modelBlockEntry.name);
        }
        for(ModelItemEntry modelItemEntry : itemsToRegister)
        {
            ModelHelper.registerItem(modelItemEntry.item, modelItemEntry.metadata, Reference.MOD_ID + ":" + modelItemEntry.name);
        }
    }

    @Override
    public void registerBlockForMeshing(FMBlock block, int metadata, String name)
    {
        blocksToRegister.add(new ModelBlockEntry(block, metadata, name));
    }

    @Override
    public void registerItemForMeshing(FMItem item, int metadata, String name)
    {
        itemsToRegister.add(new ModelItemEntry(item, metadata, name));
    }

    private static class ModelBlockEntry
    {
        public FMBlock block;
        public int     metadata;
        public String  name;

        public ModelBlockEntry(FMBlock block, int metadata, String name)
        {
            this.block = block;
            this.metadata = metadata;
            this.name = name;
        }
    }

    private static class ModelItemEntry
    {
        public FMItem item;
        public int    metadata;
        public String name;

        public ModelItemEntry(FMItem item, int metadata, String name)
        {
            this.item = item;
            this.metadata = metadata;
            this.name = name;
        }
    }
}
