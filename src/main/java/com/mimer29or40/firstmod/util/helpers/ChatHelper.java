package com.mimer29or40.firstmod.util.helpers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class ChatHelper
{
    public static void toPlayer(EntityPlayer player, Object object)
    {
        player.addChatComponentMessage(chatText(object));
    }

    public static void toAllPlayers(Object object)// TODO \/ throws null exception
    {
        for(Object name : MinecraftServer.getServer().getConfigurationManager().playerEntityList)
        {
            ((EntityPlayer) name).addChatComponentMessage(chatText(object));
        }
    }

    public static void toServer(Object object)
    {
        MinecraftServer.getServer().addChatMessage(chatText(object));
    }

    private static ChatComponentText chatText(Object object)
    {
        return new ChatComponentText(String.valueOf(object));
    }

    public static final class Format
    {
        public static final String BLACK         = "§0";
        public static final String DARK_BLUE     = "§1";
        public static final String DARK_GREEN    = "§2";
        public static final String DARK_AQUA     = "§3";
        public static final String DARK_RED      = "§4";
        public static final String DARK_PURPLE   = "§5";
        public static final String GOLD          = "§6";
        public static final String GRAY          = "§7";
        public static final String DARK_GRAY     = "§8";
        public static final String BLUE          = "§9";
        public static final String GREEN         = "§a";
        public static final String AQUA          = "§b";
        public static final String RED           = "§c";
        public static final String LIGHT_PURPLE  = "§d";
        public static final String YELLOW        = "§e";
        public static final String WHITE         = "§f";
        public static final String OBFUSCATED    = "§k";
        public static final String BOLD          = "§l";
        public static final String STRIKETHROUGH = "§m";
        public static final String UNDERLINE     = "§n";
        public static final String ITALIC        = "§o";
        public static final String RESET         = "§r";
        public static final String EXTRA_LINE    = "\n";
    }
}