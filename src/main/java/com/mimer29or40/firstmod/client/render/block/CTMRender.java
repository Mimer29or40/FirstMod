package com.mimer29or40.firstmod.client.render.block;

import com.mimer29or40.firstmod.block.BlockCTM;
import com.mimer29or40.firstmod.client.handler.CTMHandler;
import com.mimer29or40.firstmod.reference.RenderIDs;
import com.mimer29or40.firstmod.util.CTMBlock;
import com.mimer29or40.firstmod.util.Drawing;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.opengl.GL11;

public class CTMRender implements ISimpleBlockRenderingHandler {
    RenderBlocksCTM rendererCTM = new RenderBlocksCTM();

    public CTMRender() {
        if (RenderIDs.blockCTM == 0)
            RenderIDs.blockCTM = RenderingRegistry.getNextAvailableRenderId();
    }

    @Override
    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
        CTMHandler ctmHandler = ((BlockCTM) block).ctmHandler;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        Drawing.drawBlock(block, ctmHandler.getIcon(0, metadata), renderer);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }

    @Override
    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
        CTMBlock ctmBlock = ((BlockCTM) block).ctmHandler.ctmBlock;
        rendererCTM.blockAccess = world;
        rendererCTM.renderMaxX = 1.0;
        rendererCTM.renderMaxY = 1.0;
        rendererCTM.renderMaxZ = 1.0;
        rendererCTM.isOpaque = block.isOpaqueCube();
        rendererCTM.test = ctmBlock.test;
        return rendererCTM.renderStandardBlock(block, x, y, z);
    }

    @Override
    public boolean shouldRender3DInInventory(int modelId) {
        return true;
    }

    @Override
    public int getRenderId() {
        return RenderIDs.blockCTM;
    }
}