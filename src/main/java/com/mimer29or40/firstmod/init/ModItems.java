package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.item.ItemFM;
import com.mimer29or40.firstmod.item.ItemMapleLeaf;
import com.mimer29or40.firstmod.item.ItemTorch;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemFM mapleLeaf = new ItemMapleLeaf();
    public static final ItemFM torch = new ItemTorch();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, Names.Items.MAPLE_LEAF);
        GameRegistry.registerItem(torch, Names.Items.TORCH);
    }
}