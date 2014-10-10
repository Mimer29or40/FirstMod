package com.mimer29or40.firstmod.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

@SideOnly(Side.CLIENT)
public class ClientEventHandler
{
    public static int ticksInGame = 0;

    @SubscribeEvent
    public void clientTickEnd(ClientTickEvent event)
    {
        if (event.phase == Phase.END)
        {
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if (gui == null || ! gui.doesGuiPauseGame())
            {
                ticksInGame++;
            }
        }
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event)
    {

    }
}