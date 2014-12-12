package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.creativeTab.CreativeTab;
import com.mimer29or40.firstmod.reference.Textures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FMItem
        extends Item
{
    public FMItem(String name)
    {
        super();
        this.setCreativeTab(CreativeTab.FM_TAB);
        this.setUnlocalizedName(name);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}