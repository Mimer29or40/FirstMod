package com.mimer29or40.firstmod.util.helpers;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.item.FMItem;
import com.mimer29or40.firstmod.item.ItemBlockWithVariants;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class RegisterHelper
{
    public static Block registerBlock(FMBlock block, String name)
    {
        if(block.hasPresetProperties())
        {
            GameRegistry.registerBlock(block, ItemBlockWithVariants.class, name);
            for(IBlockState state : block.presetStates)
            {
                String stateName = block.getStateName(state);
                ModelBakery.addVariantName(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + name + "_" + stateName);
                FirstMod.proxy.registerBlockForMeshing(block, block.getMetaFromState(state), name + "_" + stateName);
            }
        }
        else
        {
            GameRegistry.registerBlock(block, name);
            ModelBakery.addVariantName(Item.getItemFromBlock(block), Reference.MOD_ID + ":" + name);
            FirstMod.proxy.registerBlockForMeshing(block, 0, name);
        }
        return block;
    }

    public static Item registerItem(FMItem item, String name)
    {
        GameRegistry.registerItem(item, name);
        ModelBakery.addVariantName(item, Reference.MOD_ID + ":" + name);
        FirstMod.proxy.registerItemForMeshing(item, 0, name); //TODO Make metadata work
        return item;
    }
}
