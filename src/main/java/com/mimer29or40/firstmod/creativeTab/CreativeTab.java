package com.mimer29or40.firstmod.creativeTab;

import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
    public static final CreativeTabs FM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase())
    {
        @Override
        public Item getTabIconItem() {
            return ModItems.torch;
        }
    };
}