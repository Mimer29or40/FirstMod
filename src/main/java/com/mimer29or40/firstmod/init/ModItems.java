package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.item.ItemDebug;
import com.mimer29or40.firstmod.item.ItemMapleLeaf;
import com.mimer29or40.firstmod.item.ItemTorch;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.util.helpers.RegisterHelper;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static Item mapleLeaf;
    public static Item torch;
    public static Item debug;

    public static void init()
    {
        mapleLeaf = RegisterHelper.registerItem(new ItemMapleLeaf(), Names.Items.MAPLE_LEAF);
        torch = RegisterHelper.registerItem(new ItemTorch(), Names.Items.TORCH);
        debug = RegisterHelper.registerItem(new ItemDebug(), Names.Items.DEBUG);
    }
}