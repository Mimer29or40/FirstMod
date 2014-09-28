package com.mimer29or40.firstmod.item;

import com.mimer29or40.firstmod.block.BlockCTM;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.util.CTM;
import com.mimer29or40.firstmod.util.LogHelper;
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
        if (world.getBlock(x,y,z) instanceof BlockCTM && Settings.debug)
        {
            LogHelper.chat(player, CTM.convertToLocation(CTM.getTexture(world, x, y, z, side)).replace("_", ""));
            return true;
        }
        return false;
    }
}