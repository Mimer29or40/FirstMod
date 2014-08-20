package com.mimer29or40.firstmod.block.tile;

import com.mimer29or40.firstmod.client.render.particle.TestParticleFX;
import com.mimer29or40.firstmod.handler.ClientTickHandler;
import com.mimer29or40.firstmod.handler.HUDHandler;
import com.mimer29or40.firstmod.util.IInfo;
import com.mimer29or40.firstmod.util.LogHelper;
import com.mimer29or40.firstmod.util.Vector3;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.particle.EntityAuraFX;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.particle.EntityFlameFX;
import net.minecraft.client.particle.EntitySmokeFX;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TileCrystal extends TileFM implements IInfo
{
    @Override
    public void renderInfoOnScreen(Minecraft mc, ScaledResolution res, World world, int x, int y, int z)
    {
        String text = String.format("Angle: %s",ClientTickHandler.ticksInGame * 2 % 360);
        int width = (res.getScaledWidth()/2) - (text.length()/2)-15;
        int height = res.getScaledHeight()/2-15;
        HUDHandler.drawText(text, width, height,"Test Info", res);
    }
}

/*largesmoke
portal
reddust
largeexplode (like shearing mooshrooms)
explode (when a mob dies)
largeexplosion (a bunch of largeexplode panforticles)
note
bubble
flame
crit
smoke (torches)
heart
splash
snowballpoof (thanks BlueberryKush!)
suspended(thanks GrygrFlzr for the rest)
depthsuspend
townaura
magicCrit
mobSpell
spell
instantSpell
enchantmenttable
lava
footstep
cloud
dripLava
dripWater
snowshovel
slime
iconcrack_ (after the underscore, put an item's id)
tilecrack_ (same here, except with block ids)*/
