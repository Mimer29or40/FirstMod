package com.mimer29or40.firstmod.block;

import com.mimer29or40.firstmod.reference.Names;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockCrystal extends BlockFM
{
    public BlockCrystal()
    {
        super(Names.Blocks.CRYSTAL);
        setLightLevel(10);
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
//    {
//        double x = pos.getX();
//        double y = pos.getY();
//        double z = pos.getZ();
//        double X = x + 0.5D;
//        double Y = y + 0.5D;
//        double Z = z + 0.5D;
//        double DX = 0D;
//        double DY = 0D;
//        double DZ = 0D;
//        double height = 0.8D;
//
//        int meta = worldIn.getBlockState(pos).getBlock().getMetaFromState(state)
//
//        switch (EnumFacing.getFront(meta))
//        {
//            case DOWN:
//                Y = y + 1D - height;
//                DY = - 0.1D;
//                break;
//            case UP:
//                Y = y + height;
//                DY = 0.1D;
//                break;
//            case NORTH:
//                Z = z + 1D - height;
//                DZ = - 0.1D;
//                break;
//            case SOUTH:
//                Z = z + height;
//                DZ = 0.1D;
//                break;
//            case WEST:
//                X = x + 1D - height;
//                DX = - 0.1D;
//                break;
//            case EAST:
//                X = x + height;
//                DX = 0.1D;
//                break;
//        }
//        Minecraft.getMinecraft().effectRenderer.addEffect(new EntityFlameFX(worldIn, X, Y, Z, DX, DY, DZ));
//    }

    @Override
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        worldIn.setBlockState(pos, this.getStateFromMeta(meta));
        return this.getStateFromMeta(meta);
    }
}