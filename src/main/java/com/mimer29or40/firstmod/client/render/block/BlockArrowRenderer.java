package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.block.BlockArrow;
import com.mimer29or40.firstmod.block.tile.TileArrow;
import com.mimer29or40.firstmod.block.tile.TileCrystal;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.*;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class BlockArrowRenderer implements ISimpleBlockRenderingHandler
{
    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
    {
//        GL11.glPushMatrix();
//        GL11.glTranslatef(-0.5F, -0.4F, -0.5F);
//        GL11.glScalef(1.7F, 1.7F, 1.7F);
//        TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileArrow(), 0.0D, 0.0D, 0.0D, 0.0F);
//        GL11.glPopMatrix();
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        Drawing.drawBlock(block, 1, renderer);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess blockAccess, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
    {
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId)
    {
        return true;
    }

    @Override
    public int getRenderId()
    {
        return RenderIDs.blockArrow;
    }
}