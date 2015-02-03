package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.util.BlockStateUtils;
import com.mimer29or40.firstmod.util.IInfo;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class HUDHandler
{
    @SubscribeEvent
    public void onRenderGameOverlayPost(RenderGameOverlayEvent.Post event)
    {
        if(event.type == RenderGameOverlayEvent.ElementType.ALL)
        {
            Minecraft mc = Minecraft.getMinecraft();
            MovingObjectPosition pos = mc.objectMouseOver;
            if(pos != null)
            {
                IBlockState state = mc.theWorld.getBlockState(pos.getBlockPos());
                Block block = state.getBlock();
                if(block instanceof IInfo)
                    ((IInfo) block).renderInfoOnScreen(mc, event.resolution, mc.theWorld, pos.getBlockPos());

                ItemStack stack = mc.thePlayer.getCurrentEquippedItem();
                if(stack != null && stack.getItem() == ModItems.debug)
                    drawTextAtLocation(block.getUnlocalizedName() + BlockStateUtils.getStates(state), ScreenLocation.TOP_LEFT, event.resolution);
            }
        }
    }

    private static void drawTextAtCoord(Object text, int x, int y)
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        Minecraft.getMinecraft().fontRendererObj.drawString(String.valueOf(text), x, y, 0x00FFFFFF);

        GL11.glDisable(GL11.GL_BLEND);
    }

    private static void drawTextAtLocation(Object obj, ScreenLocation location, ScaledResolution res)
    {
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRendererObj;
        String text = String.valueOf(obj);

        int x,y;
        int textLength = fontRenderer.getStringWidth(text);
        int textHeight = 10;
        int centerOffset = 7;
        int inventoryOffset = 12;

        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

        switch(location)
        {
            case TOP:
                x = (res.getScaledWidth() - textLength) / 2;
                y = 10;
                break;
            case BOTTOM:
                x = (res.getScaledWidth() - textLength) / 2;
                y = res.getScaledHeight() - 10 - textHeight - inventoryOffset;
                break;
            case LEFT:
                x = 10;
                y = res.getScaledHeight() / 2;
                break;
            case RIGHT:
                x = res.getScaledWidth() - 10 - textLength;
                y = res.getScaledHeight() / 2;
                break;
            case TOP_LEFT:
                x = 10;
                y = 10;
                break;
            case TOP_RIGHT:
                x = res.getScaledWidth() - 10 - textLength;
                y = 10;
                break;
            case BOTTOM_LEFT:
                x = 10;
                y = res.getScaledHeight() - 10 - textHeight;
                break;
            case BOTTOM_RIGHT:
                x = res.getScaledWidth() - 10 - textLength;
                y = res.getScaledHeight() - 10 - textHeight;
                break;
            case CENTER:
                x = (res.getScaledWidth() - textLength) / 2;
                y = res.getScaledHeight() / 2 + centerOffset;
                break;
            default:
                x = (res.getScaledWidth() - textLength) / 2;
                y = res.getScaledHeight() / 2 + centerOffset;
        }

        fontRenderer.drawString(String.valueOf(text), x, y, 0x00FFFFFF);

        GL11.glDisable(GL11.GL_BLEND);
    }

    private enum ScreenLocation
    {
        TOP, BOTTOM, LEFT, RIGHT, TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT, CENTER
    }
}