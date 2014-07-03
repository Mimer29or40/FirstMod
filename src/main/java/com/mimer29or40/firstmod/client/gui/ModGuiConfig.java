package com.mimer29or40.firstmod.client.gui;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Settings;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

public class ModGuiConfig extends GuiConfig
{
    public ModGuiConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigurationHandler.config.getCategory(Settings.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID,
                false,
                false,
                GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }
}