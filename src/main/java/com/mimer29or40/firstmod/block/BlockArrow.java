package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.proxy.ClientProxy;
import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import javax.imageio.metadata.IIOMetadataController;

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
        this.setBlockTextureName(Names.Blocks.ARROW);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        top = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_top");
        bottom = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) + "_bottom");
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        switch (meta)
        {
            case 0:
                return side == 0 ? this.getTopIcon() : side == 1 ? this.getBottomIcon() : this.getSideIcon();
            case 1:
                return side == 1 ? this.getTopIcon() : side == 0 ? this.getBottomIcon() : this.getSideIcon();
            case 2:
                return side == 2 ? this.getTopIcon() : side == 3 ? this.getBottomIcon() : this.getSideIcon();
            case 3:
                return side == 3 ? this.getTopIcon() : side == 2 ? this.getBottomIcon() : this.getSideIcon();
            case 4:
                return side == 4 ? this.getTopIcon() : side == 5 ? this.getBottomIcon() : this.getSideIcon();
            case 5:
                return side == 5 ? this.getTopIcon() : side == 4 ? this.getBottomIcon() : this.getSideIcon();
        }
        return this.getSideIcon();
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon()
    {
        return this.top;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getBottomIcon()
    {
        return this.bottom;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon()
    {
        return this.blockIcon;
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockArrow;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        world.setBlock(x, y, z, this, side, 1);
        return side;
    }
}