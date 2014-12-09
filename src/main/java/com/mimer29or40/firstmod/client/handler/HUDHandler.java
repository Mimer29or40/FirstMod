package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.util.IInfo;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class HUDHandler
{
    public static void drawText(String text, int x, int y, String name, ScaledResolution res)
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        Minecraft mc = Minecraft.getMinecraft();
        //        int x = res.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(name) / 2;
        //        int y = res.getScaledHeight() / 2 + 10;

        mc.fontRendererObj.drawString(text, x, y, 0x00FFFFFF);
        GL11.glDisable(GL11.GL_BLEND);
    }

    @SubscribeEvent
    public void onDrawScreen(RenderGameOverlayEvent.Post event)
    {
        if (event.type == RenderGameOverlayEvent.ElementType.ALL)
        {
            Minecraft mc = Minecraft.getMinecraft();
            MovingObjectPosition pos = mc.objectMouseOver;
            if (pos != null)
            {
                Block block = mc.theWorld.getBlockState(pos.func_178782_a()).getBlock();
                if (block instanceof IInfo)
                {
                    ((IInfo) block).renderInfoOnScreen(mc, event.resolution, mc.theWorld, pos.func_178782_a());
                }
            }

        }
    }
}