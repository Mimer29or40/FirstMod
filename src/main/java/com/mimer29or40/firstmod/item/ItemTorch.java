package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.BlockFM;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.helpers.ChatHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTorch extends ItemFM
{
    public ItemTorch() {
        super();
        this.setUnlocalizedName(Names.Items.TORCH);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
        if (block instanceof BlockFM)
        {
            ChatHelper.toPlayer(player, String.format("Block: %s Hit: (%s,%s,%s)", block.getUnlocalizedName(), hitX, hitY, hitZ));
            ChatHelper.toAll("Everbody");
            return true;
        }
        return false;
    }

}