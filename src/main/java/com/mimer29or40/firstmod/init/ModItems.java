package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.item.FMItem;
import com.mimer29or40.firstmod.item.ItemDebug;
import com.mimer29or40.firstmod.item.ItemMapleLeaf;
import com.mimer29or40.firstmod.item.ItemTorch;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraft.client.resources.model.ModelBakery;
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
        mapleLeaf = registerItem(new ItemMapleLeaf(), Names.Items.MAPLE_LEAF);
        torch = registerItem(new ItemTorch(), Names.Items.TORCH);
        debug = registerItem(new ItemDebug(), Names.Items.DEBUG);
    }

    private static Item registerItem(FMItem item, String name)
    {
        GameRegistry.registerItem(item, name);

        ModelBakery.addVariantName(item, Reference.MOD_ID + ":" + name);
        FirstMod.proxy.registerItemForMeshing(item, 0, name); //TODO Make metadata work

        return item;
    }
}