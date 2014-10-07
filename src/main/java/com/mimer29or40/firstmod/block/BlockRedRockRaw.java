package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.material.Material;

public class BlockRedRockRaw extends BlockFM {
    public BlockRedRockRaw() {
        this(Material.rock);
    }

    public BlockRedRockRaw(Material material) {
        super(material);
        setBlockName(Names.Blocks.REDROCK_RAW);
        setBlockTextureName(Names.Blocks.REDROCK_RAW);
    }
}