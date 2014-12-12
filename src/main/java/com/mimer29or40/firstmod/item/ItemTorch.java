package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.helpers.ChatHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemTorch
        extends FMItem
{
    public ItemTorch()
    {
        super(Names.Items.TORCH);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlockState(pos).getBlock();
        if(block instanceof FMBlock)
        {
            //            ChatHelper.toPlayer(player, String.format("Block: %s Hit: (%s,%s,%s)", block.getUnlocalizedName(), hitX, hitY, hitZ));
            ChatHelper.toAllPlayers("Everbody");
            return true;
        }
        return false;
    }

}