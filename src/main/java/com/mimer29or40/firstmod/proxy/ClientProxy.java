package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.block.tile.TileArrow;
import com.mimer29or40.firstmod.block.tile.TileCrystal;
import com.mimer29or40.firstmod.block.tile.TileStarfield;
import com.mimer29or40.firstmod.client.render.Tile.TileArrowRenderer;
import com.mimer29or40.firstmod.client.render.Tile.TileCrystalRenderer;
import com.mimer29or40.firstmod.client.render.Tile.TileStarfieldRenderer;
import com.mimer29or40.firstmod.client.render.block.BlockArrowRenderer;
import com.mimer29or40.firstmod.client.render.block.BlockCrystalRenderer;
import com.mimer29or40.firstmod.client.render.block.BlockFrameRenderer;
import com.mimer29or40.firstmod.client.settings.Keybindings;
import com.mimer29or40.firstmod.handler.ClientTickHandler;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;

public class ClientProxy extends CommonProxy
{
    public static void init()
    {
        RenderIDs.blockArrow = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockFrame = RenderingRegistry.getNextAvailableRenderId();
        RenderIDs.blockCrystal = RenderingRegistry.getNextAvailableRenderId();

        RenderingRegistry.registerBlockHandler(new BlockArrowRenderer());
        RenderingRegistry.registerBlockHandler(new BlockFrameRenderer());
        RenderingRegistry.registerBlockHandler(new BlockCrystalRenderer());

        ClientRegistry.bindTileEntitySpecialRenderer(TileStarfield.class, new TileStarfieldRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileCrystal.class, new TileCrystalRenderer());
        ClientRegistry.bindTileEntitySpecialRenderer(TileArrow.class, new TileArrowRenderer());
    }

    @Override
    public void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }
}
