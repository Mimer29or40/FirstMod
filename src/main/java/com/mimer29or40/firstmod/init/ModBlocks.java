package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.block.*;
import com.mimer29or40.firstmod.block.tile.TileArrow;
import com.mimer29or40.firstmod.block.tile.TileCrystal;
import com.mimer29or40.firstmod.block.tile.TileStarfield;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Textures;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final Block flag = new BlockFlag();
    public static final Block frame = new BlockFrame();
    public static final Block arrow = new BlockArrow();
    public static final Block crystal = new BlockCrystal();
    public static final Block starfield = new BlockStarfield();
    public static final Block nics = new BlockNics();

    public static void init()
    {
        GameRegistry.registerBlock(flag, Names.Blocks.FLAG);
        GameRegistry.registerBlock(frame, Names.Blocks.FRAME);
        GameRegistry.registerBlock(arrow, Names.Blocks.ARROW);
        GameRegistry.registerBlock(crystal, Names.Blocks.CRYSTAL);
        GameRegistry.registerBlock(starfield, Names.Blocks.STARFIELD);
        GameRegistry.registerBlock(nics, Names.Blocks.NICS);

        registerTile(TileStarfield.class, Names.Blocks.STARFIELD);
        registerTile(TileCrystal.class, Names.Blocks.CRYSTAL);
        registerTile(TileArrow.class, Names.Blocks.ARROW);
    }

    private static void registerTile(Class<? extends TileEntity> clazz, String key) {
        GameRegistry.registerTileEntityWithAlternatives(clazz, Textures.RESOURCE_PREFIX + key, key);
    }
}