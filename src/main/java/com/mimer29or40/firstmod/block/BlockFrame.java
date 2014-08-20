package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.util.IconHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class BlockFrame extends BlockFM
{
    private IIcon top;
    private IIcon bottom;
    private IIcon north;
    private IIcon east;
    private IIcon south;
    private IIcon west;

    public BlockFrame()
    {
        super();
        this.setBlockName(Names.Blocks.FRAME);
        this.setBlockTextureName(Names.Blocks.FRAME);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess blockAccess, int x, int y, int z, int side)
    {
        return blockAccess.getBlock(x, y, z)!=this || !Settings.RENDER_LIKE_GLASS;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockFrame;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        top = IconHelper.forBlock(iconRegister, this, "_top");
        bottom = IconHelper.forBlock(iconRegister, this, "_bottom");
        north = IconHelper.forBlock(iconRegister, this, "_north");
        east = IconHelper.forBlock(iconRegister, this, "_east");
        south = IconHelper.forBlock(iconRegister, this, "_south");
        west = IconHelper.forBlock(iconRegister, this, "_west");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return side == 0 ? this.bottom : side == 1 ? this.top : side == 2 ? this.north : side == 3 ? this.south : side == 4 ? this.west : side == 5 ? this.east : this.blockIcon;
    }
}