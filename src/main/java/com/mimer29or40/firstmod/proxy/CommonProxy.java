package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.handler.CommonEventHandler;
import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.init.ModBlocks;
import com.mimer29or40.firstmod.init.ModItems;
import com.mimer29or40.firstmod.init.Recipes;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.server.MinecraftServer;

public class CommonProxy implements IProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
        ModItems.init();
        ModBlocks.init();

        FMLCommonHandler.instance().bus().register(new CommonEventHandler());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler(event.getSuggestedConfigurationFile()));
    }

    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(FirstMod.instance);

        Recipes.init();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        // NOOP
    }

    public boolean isTheClientPlayer(EntityLivingBase entity)
    {
        return false;
    }

    public long getWorldElapsedTicks()
    {
        return MinecraftServer.getServer().worldServers[0].getTotalWorldTime();
    }

    //    public void setSparkleFXNoClip(boolean noclip) {
    //        // NO-OP
    //    }
    //
    //    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m) {
    //        sparkleFX(world, x, y, z, r, g, b, size, m, false);
    //    }
    //
    //    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake) {
    //        // NO-OP
    //    }
    //
    //    public void setWispFXDistanceLimit(boolean limit) {
    //        // NO-OP
    //    }
    //
    //    public void setWispFXDepthTest(boolean depth) {
    //        // NO-OP
    //    }
    //
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size) {
    //        wispFX(world, x, y, z, r, g, b, size, 0F);
    //    }
    //
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity) {
    //        wispFX(world, x, y, z, r, g, b, size, gravity, 1F);
    //    }
    //
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float gravity, float maxAgeMul) {
    //        wispFX(world, x, y, z, r, g, b, size, 0, -gravity, 0, maxAgeMul);
    //    }
    //
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz) {
    //        wispFX(world, x, y, z, r, g, b, size, motionx, motiony, motionz, 1F);
    //    }
    //
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul) {
    //        // NO-OP
    //    }
    //
    //    public void lightningFX(World world, Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, int colorOuter, int colorInner) {
    //        lightningFX(world, vectorStart, vectorEnd, ticksPerMeter, System.nanoTime(), colorOuter, colorInner);
    //    }
    //
    //    public void lightningFX(World world, Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner) {
    //        // NO-OP
    //    }
}
