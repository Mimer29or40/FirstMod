package com.mimer29or40.firstmod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.world.World;

public interface IInfo
{
    public void renderInfoOnScreen(Minecraft mc, ScaledResolution res, World world, int x, int y, int z);
}
