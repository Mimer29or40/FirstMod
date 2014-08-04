package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.block.BlockFrame;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.util.Drawing;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class BlockFrameRenderer implements ISimpleBlockRenderingHandler
{

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        Drawing.drawBlock(block, metadata, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        if (block instanceof BlockFrame)
        {
            renderer.setRenderFromInside(Settings.RENDER_INSIDE);
            renderer.renderStandardBlock(block, x, y, z);
        }
        return true;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return RenderIDs.blockFrame;
    }
}