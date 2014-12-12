package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.client.handler.ClientEventHandler;
import com.mimer29or40.firstmod.client.handler.HUDHandler;
import com.mimer29or40.firstmod.client.handler.KeyInputEventHandler;
import com.mimer29or40.firstmod.client.helpers.ModelHelper;
import com.mimer29or40.firstmod.client.settings.Keybindings;
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
    private static ArrayList< ModelEntry > blocksToRegister = new ArrayList();

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
    protected void registerRenderers()
    {
        for(ModelEntry modelEntry : blocksToRegister)
        {
            ModelHelper.registerBlock(modelEntry.block, modelEntry.metadata, Reference.MOD_ID + ":" + modelEntry.name);
        }
    }

    @Override
    protected void registerBlockForMeshing(FMBlock block, int metadata, String name)
    {
        blocksToRegister.add(new ModelEntry(block, metadata, name));
    }

    private static class ModelEntry
    {
        public FMBlock block;
        public int     metadata;
        public String  name;

        public ModelEntry(FMBlock block, int metadata, String name)
        {
            this.block = block;
            this.metadata = metadata;
            this.name = name;
        }
    }
}
