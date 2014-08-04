package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.util.LogHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockCrystal extends BlockFM
{
    public BlockCrystal()
    {
        super();
        this.setBlockName(Names.Blocks.CRYSTAL);
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return this.blockIcon;
    }

    @Override
    public int getRenderType()
    {
        return RenderIDs.blockCrystal;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
        LogHelper.info("Side: " + ForgeDirection.getOrientation(side));
        world.setBlock(x, y, z, this, side, 3);
        return side;
    }
}