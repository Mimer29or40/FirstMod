package com.mimer29or40.firstmod.handler;

import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SuppressWarnings( "EmptyMethod" )
public class CommonEventHandler
{
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onPlayerLogin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
    {
        //        event.player.addChatComponentMessage(new ChatComponentText(event.player.getDisplayName() + " just entered"));
    }

    @SubscribeEvent
    public void onPlayerLogout(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onEntityConstruct(EntityEvent.EntityConstructing event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void EntityUpdate(LivingEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void LivingJumpEvent(LivingEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onArrowLoose(ArrowLooseEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onBoneMeal(BonemealEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent event)
    {
        // NOOP
    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event)
    {
        // NOOP
    }
}