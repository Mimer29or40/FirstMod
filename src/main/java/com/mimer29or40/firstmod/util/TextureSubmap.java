package com.mimer29or40.firstmod.util;

import com.mimer29or40.firstmod.util.helpers.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

public class TextureSubmap
{
    public int width, height;
    public IIcon icon;
    public IIcon icons[];

    public TextureSubmap(IIcon i, int w, int h)
    {
        icon = i;
        width = w;
        height = h;
        icons = new IIcon[width * height];

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void TexturesStitched(TextureStitchEvent.Post event)
    {
        for(int y = 0; y < width; y++)
        {
            for(int x = 0; x < height; x++)
            {
                icons[y * width + x] = new TextureVirtual(icon, width, height, x, y);
            }
        }
    }

    public IIcon getIcon(int x, int y)
    {
        x--; y--;
        return icons[y * width + x];
    }

    public void printInfo()
    {
        LogHelper.infoS("Icon Name: %s Width: %s Height: %s", icon.getIconName(), width, height);
    }
}