package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import net.minecraft.item.Item;

public class FMItem
        extends Item
{
    public FMItem(String name)
    {
        super();
        this.setCreativeTab(CreativeTab.FM_TAB);
        this.setUnlocalizedName(name);
    }
}