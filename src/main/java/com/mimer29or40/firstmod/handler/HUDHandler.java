package com.mimer29or40.firstmod.handler;

import com.mimer29or40.firstmod.block.BlockCrystal;
import com.mimer29or40.firstmod.util.IInfo;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public final class HUDHandler
{
    @SubscribeEvent
    public void onDrawScreen(RenderGameOverlayEvent.Post event)
    {
        if (event.type == RenderGameOverlayEvent.ElementType.ALL)
        {
            Minecraft mc = Minecraft.getMinecraft();
            MovingObjectPosition pos = mc.objectMouseOver;
            if (pos != null)
            {
                Block block = mc.theWorld.getBlock(pos.blockX, pos.blockY, pos.blockZ);
                if (block instanceof IInfo)
                {
                    ((IInfo) block).renderInfoOnScreen(mc, event.resolution, mc.theWorld, pos.blockX, pos.blockY, pos.blockZ);
                }
            }

        }
    }

    public static void drawText(String text, int x, int y, String name, ScaledResolution res) {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        Minecraft mc = Minecraft.getMinecraft();
//        int x = res.getScaledWidth() / 2 - mc.fontRenderer.getStringWidth(name) / 2;
//        int y = res.getScaledHeight() / 2 + 10;

        mc.fontRenderer.drawStringWithShadow(text, x, y, 0x00FFFFFF);
        GL11.glDisable(GL11.GL_BLEND);
    }

//    public static void renderManaBar(int x, int y, int color, float alpha, int mana, int maxMana) {
//        Minecraft mc = Minecraft.getMinecraft();
//
//        GL11.glColor4f(1F, 1F, 1F, alpha);
//        mc.renderEngine.bindTexture(manaBar);
//        RenderHelper.drawTexturedModalRect(x, y, 0, 0, 0, 102, 5);
//
//        int manaPercentage = Math.max(0, (int) ((double) mana / (double) maxMana * 100));
//
//        if(manaPercentage == 0 && mana > 0)
//            manaPercentage = 1;
//
//        RenderHelper.drawTexturedModalRect(x + 1 + manaPercentage, y + 1, 0, 0, 5, 100 - manaPercentage, 3);
//
//        Color color_ = new Color(color);
//        GL11.glColor4ub((byte) color_.getRed(), (byte) color_.getGreen(),(byte) color_.getBlue(), (byte) (255F * alpha));
//        RenderHelper.drawTexturedModalRect(x + 1, y + 1, 0, 0, 5, manaPercentage, 3);
//    }
}