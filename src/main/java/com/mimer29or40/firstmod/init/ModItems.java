package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.item.FMItem;
import com.mimer29or40.firstmod.item.ItemMapleLeaf;
import com.mimer29or40.firstmod.item.ItemTorch;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static FMItem mapleLeaf = new ItemMapleLeaf();
    public static FMItem torch     = new ItemTorch();

    public static void init()
    {
//        mapleLeaf
        GameRegistry.registerItem(mapleLeaf, Names.Items.MAPLE_LEAF);
        GameRegistry.registerItem(torch, Names.Items.TORCH);
    }
}