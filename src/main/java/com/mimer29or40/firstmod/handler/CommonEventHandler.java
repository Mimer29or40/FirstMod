package com.mimer29or40.firstmod.handler;

import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class CommonEventHandler
{
    @SubscribeEvent
    public void onRenderTick(TickEvent.RenderTickEvent event)
    {

    }

    @SubscribeEvent
    public void onPlayerLogin(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
    {
        //        event.player.addChatComponentMessage(new ChatComponentText(event.player.getDisplayName() + " just entered"));
    }

    @SubscribeEvent
    public void onPlayerLogout(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent event)
    {

    }

    @SubscribeEvent
    public void onEntityConstruct(EntityEvent.EntityConstructing event)
    {

    }

    @SubscribeEvent
    public void EntityUpdate(LivingEvent event)
    {

    }

    @SubscribeEvent
    public void LivingJumpEvent(LivingEvent event)
    {

    }

    @SubscribeEvent
    public void onPlayerJoinWorld(EntityJoinWorldEvent event)
    {
    }

    @SubscribeEvent
    public void onLivingAttack(LivingAttackEvent event)
    {

    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event)
    {

    }

    @SubscribeEvent
    public void onLivingHurt(LivingHurtEvent event)
    {

    }

    @SubscribeEvent
    public void onLivingFall(LivingFallEvent event)
    {

    }

    @SubscribeEvent
    public void onArrowLoose(ArrowLooseEvent event)
    {

    }

    @SubscribeEvent
    public void onAttackEntity(AttackEntityEvent event)
    {

    }

    @SubscribeEvent
    public void onBoneMeal(BonemealEvent event)
    {

    }

    @SubscribeEvent
    public void onFillBucket(FillBucketEvent event)
    {

    }

    @SubscribeEvent
    public void onPlayerInteract(PlayerInteractEvent event)
    {

    }

    @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent event)
    {

    }

    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event)
    {

    }
}