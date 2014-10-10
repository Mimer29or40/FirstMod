package com.mimer29or40.firstmod.proxy;

import com.mimer29or40.firstmod.client.handler.ClientEventHandler;
import com.mimer29or40.firstmod.client.handler.HUDHandler;
import com.mimer29or40.firstmod.client.handler.KeyInputEventHandler;
import com.mimer29or40.firstmod.client.render.block.CTMRender;
import com.mimer29or40.firstmod.client.settings.Keybindings;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy
{
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);

        registerKeyBindings();

        FMLCommonHandler.instance().bus().register(new ClientEventHandler());

        MinecraftForge.EVENT_BUS.register(new HUDHandler());
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);

        RenderingRegistry.registerBlockHandler(new CTMRender());

        FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }

    void registerKeyBindings()
    {
        ClientRegistry.registerKeyBinding(Keybindings.charge);
        ClientRegistry.registerKeyBinding(Keybindings.release);
    }

    @Override
    public boolean isTheClientPlayer(EntityLivingBase entity)
    {
        return entity == Minecraft.getMinecraft().thePlayer;
    }

    @Override
    public long getWorldElapsedTicks()
    {
        return Minecraft.getMinecraft().theWorld == null ? 0 : Minecraft.getMinecraft().theWorld.getTotalWorldTime();
    }

    //    private static boolean noclipEnabled = false;
    //
    //    @Override
    //    public void setSparkleFXNoClip(boolean noclip)
    //    {
    //        noclipEnabled = noclip;
    //    }
    //
    //    @Override
    //    public void sparkleFX(World world, double x, double y, double z, float r, float g, float b, float size, int m, boolean fake)
    //    {
    //        if(!doParticle() && !fake)
    //            return;
    //
    //        FXSparkle sparkle = new FXSparkle(world, x, y, z, size, r, g, b, m);
    //        sparkle.fake = sparkle.noClip = fake;
    //        if(noclipEnabled)
    //            sparkle.noClip = true;
    //        Minecraft.getMinecraft().effectRenderer.addEffect(sparkle);
    //    }
    //
    //    private static boolean distanceLimit = true;
    //    private static boolean depthTest = true;
    //
    //    @Override
    //    public void setWispFXDistanceLimit(boolean limit)
    //    {
    //        distanceLimit = limit;
    //    }
    //
    //    @Override
    //    public void setWispFXDepthTest(boolean test)
    //    {
    //        depthTest = test;
    //    }
    //
    //    @Override
    //    public void wispFX(World world, double x, double y, double z, float r, float g, float b, float size, float motionx, float motiony, float motionz, float maxAgeMul)
    //    {
    //        if(!doParticle())
    //            return;
    //
    //        FXWisp wisp = new FXWisp(world, x, y, z, size, r, g, b, distanceLimit, depthTest, maxAgeMul);
    //        wisp.motionX = motionx;
    //        wisp.motionY = motiony;
    //        wisp.motionZ = motionz;
    //
    //        Minecraft.getMinecraft().effectRenderer.addEffect(wisp);
    //    }
    //
    //    private boolean doParticle()
    //    {
    ////        if(!ConfigHandler.useVanillaParticleLimiter)
    ////            return true;
    //
    //        float chance = 1F;
    //        if(Minecraft.getMinecraft().gameSettings.particleSetting == 1)
    //            chance = 0.6F;
    //        else if(Minecraft.getMinecraft().gameSettings.particleSetting == 2)
    //            chance = 0.2F;
    //
    //        return Math.random() < chance;
    //    }
    //
    //    @Override
    //    public void lightningFX(World world, Vector3 vectorStart, Vector3 vectorEnd, float ticksPerMeter, long seed, int colorOuter, int colorInner)
    //    {
    //        LightningHandler.spawnLightningBolt(world, vectorStart, vectorEnd, ticksPerMeter, seed, colorOuter, colorInner);
    //    }
}
