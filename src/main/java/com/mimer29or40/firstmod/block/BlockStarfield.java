package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.util.IconHelper;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import com.mimer29or40.firstmod.block.tile.TileStarfield;

public class BlockStarfield extends BlockFMContainer
{
    IIcon[] icons;

    public BlockStarfield() {
        super(Material.iron);
        setHardness(5F);
        setResistance(2000F);
        setStepSound(soundTypeMetal);
        setBlockName(Names.Blocks.STARFIELD);

        setBlockBounds(0F, 0F, 0F, 1F, 0.25F, 1F);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        icons = new IIcon[3];
        for(int i = 0; i < icons.length; i++)
            icons[i] = IconHelper.forBlock(iconRegister, this, i);
    }

    @Override
    public IIcon getIcon(int side, int meta)
    {
        return icons[Math.min(2, side)];
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta)
    {
        return new TileStarfield();
    }
}