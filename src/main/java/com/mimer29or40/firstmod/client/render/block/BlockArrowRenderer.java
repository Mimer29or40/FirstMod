package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.block.BlockArrow;
import com.mimer29or40.firstmod.reference.RenderIDs;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

@SideOnly(Side.CLIENT)
public class BlockArrowRenderer implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {

    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        if (block instanceof BlockArrow)
        {
            switch (blockAccess.getBlockMetadata(x, y, z)) {
                case 0:
                    renderer.uvRotateSouth = 3;
                    renderer.uvRotateEast = 3;
                    renderer.uvRotateWest = 3;
                    renderer.uvRotateNorth = 3;
                    break;
                case 1:
                    break;
                case 2:
                    renderer.uvRotateNorth = 2;
                    renderer.uvRotateSouth = 1;
                    break;
                case 3:
                    renderer.uvRotateNorth = 1;
                    renderer.uvRotateSouth = 2;
                    renderer.uvRotateTop = 3;
                    renderer.uvRotateBottom = 3;
                    break;
                case 4:
                    renderer.uvRotateEast = 1;
                    renderer.uvRotateWest = 2;
                    renderer.uvRotateTop = 2;
                    renderer.uvRotateBottom = 1;
                    break;
                case 5:
                    renderer.uvRotateEast = 2;
                    renderer.uvRotateWest = 1;
                    renderer.uvRotateTop = 1;
                    renderer.uvRotateBottom = 2;
                    break;
            }

            renderer.renderStandardBlock(block, x, y, z);
            renderer.uvRotateSouth = 0;
            renderer.uvRotateEast = 0;
            renderer.uvRotateWest = 0;
            renderer.uvRotateNorth = 0;
            renderer.uvRotateTop = 0;
            renderer.uvRotateBottom = 0;
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return false;
    }

    @Override
    public int getRenderId()
    {
        return RenderIDs.blockArrow;
    }
}