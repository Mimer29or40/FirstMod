package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.FMBlock;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.helpers.ChatHelper;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemDebug
        extends FMItem
{
    public ItemDebug()
    {
        super(Names.Items.DEBUG);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        if(block instanceof FMBlock)
        {
            ChatHelper.toPlayer(player, state.toString());
            // ChatHelper.toAllPlayers("Everybody");
            ChatHelper.toPlayer(player, block.getUnlocalizedName() + "_" + ((FMBlock) block).getStateName(state));
        }
        else
        {
            ChatHelper.toPlayer(player, block.getUnlocalizedName());
        }
        return true;
    }

}