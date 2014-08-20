package com.mimer29or40.firstmod.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.ClientTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class ClientTickHandler
{
    public static int ticksInGame = 0;

    @SubscribeEvent
    public void ClientTickEnd(ClientTickEvent event)
    {
        if (event.phase == Phase.END)
        {
            GuiScreen gui = Minecraft.getMinecraft().currentScreen;
            if (gui == null || !gui.doesGuiPauseGame())
            {
                ticksInGame++;
            }
        }
    }
}