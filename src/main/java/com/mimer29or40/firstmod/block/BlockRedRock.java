package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.material.Material;

public class BlockRedRock extends BlockFM {
    public BlockRedRock() {
        this(Material.rock);
    }

    public BlockRedRock(Material material) {
        super(material);
        setBlockName(Names.Blocks.REDROCK);
        setBlockTextureName(Names.Blocks.REDROCK);
    }
}