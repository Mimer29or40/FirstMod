package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockArrow extends BlockFM
{
    @SideOnly(Side.CLIENT)
    protected IIcon top;
    @SideOnly(Side.CLIENT)
    protected IIcon bottom;

    public BlockArrow()
    {
        super();
        this.setBlockName(Names.Blocks.ARROW);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        top = IconHelper.forBlock(iconRegister, this, "_top");
        bottom = IconHelper.forBlock(iconRegister, this, "_bottom");
        blockIcon = IconHelper.forBlock(iconRegister, this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int s, int meta)
    {
        ForgeDirection side = ForgeDirection.getOrientation(s);
        switch (ForgeDirection.getOrientation(meta))
        {
            case DOWN:
                return side == ForgeDirection.DOWN ? this.top : side == ForgeDirection.UP ? this.bottom : this.blockIcon;
            case UP:
                return side == ForgeDirection.UP ? this.top : side == ForgeDirection.DOWN ? this.bottom : this.blockIcon;
            case NORTH:
                return side == ForgeDirection.NORTH ? this.top : side == ForgeDirection.SOUTH ? this.bottom : this.blockIcon;
            case SOUTH:
                return side == ForgeDirection.SOUTH ? this.top : side == ForgeDirection.NORTH ? this.bottom : this.blockIcon;
            case WEST:
                return side == ForgeDirection.WEST ? this.top : side == ForgeDirection.EAST ? this.bottom : this.blockIcon;
            case EAST:
                return side == ForgeDirection.EAST ? this.top : side == ForgeDirection.WEST ? this.bottom : this.blockIcon;
        }
        return this.blockIcon;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        world.setBlock(x, y, z, this, side, 3);
        return side;
    }
}