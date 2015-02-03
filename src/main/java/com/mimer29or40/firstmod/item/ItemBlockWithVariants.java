package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.FMBlock;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockWithVariants
        extends ItemBlock
{
    public ItemBlockWithVariants(Block block)
    {
        super(block);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        FMBlock block = (FMBlock) this.block;

        if(block.hasPresetProperties())
        {
            return super.getUnlocalizedName() + "." + block.getStateName(block.getStateFromMeta(stack.getMetadata()));
        }
        else
        {
            return super.getUnlocalizedName();
        }
    }
}
