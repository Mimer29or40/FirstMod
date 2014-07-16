package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.BlockArrow;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTorch extends ItemFM {
    public ItemTorch() {
        super();
        this.setUnlocalizedName(Names.Items.TORCH);
    }

    @Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
        Block block = world.getBlock(x, y, z);
//        LogHelper.info("Item: " + stack + " X: " + x + " Y: " + y + " Z: " + z + " Block: " + block);
        if (block instanceof BlockArrow)
        {
            if (player.isSneaking())
            {
                world.setBlockMetadataWithNotify(x, y, z, side, 3);
            }
            else
            {
                switch (world.getBlockMetadata(x, y, z)) {
                    case 0:
                        world.setBlockMetadataWithNotify(x, y, z, 1, 3);
                        break;
                    case 1:
                        world.setBlockMetadataWithNotify(x, y, z, 2, 3);
                        break;
                    case 2:
                        world.setBlockMetadataWithNotify(x, y, z, 3, 3);
                        break;
                    case 3:
                        world.setBlockMetadataWithNotify(x, y, z, 4, 3);
                        break;
                    case 4:
                        world.setBlockMetadataWithNotify(x, y, z, 5, 3);
                        break;
                    case 5:
                        world.setBlockMetadataWithNotify(x, y, z, 0, 3);
                        break;
                }
            }
        }
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        return stack;
    }
}