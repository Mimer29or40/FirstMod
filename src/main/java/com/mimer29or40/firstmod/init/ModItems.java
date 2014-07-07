package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.item.ItemFM;
import com.mimer29or40.firstmod.item.ItemMapleLeaf;
import com.mimer29or40.firstmod.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
    public static final ItemFM mapleLeaf = new ItemMapleLeaf();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, Names.Items.MAPLE_LEAF);
    }
}