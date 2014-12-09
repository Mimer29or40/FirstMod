package com.mimer29or40.firstmod.client.gui;

import com.mimer29or40.firstmod.handler.ConfigurationHandler;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Settings;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigGUI extends GuiConfig
{
    private static Map<Class<? extends FirstModEntry>, String> sections = new HashMap<Class<? extends FirstModEntry>, String>();

    public ConfigGUI(GuiScreen parentScreen)
    {
        super(parentScreen, getConfigCategorys(), Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.toString()));
    }

    private static List<IConfigElement> getConfigCategorys()
    {
        sections.put(GeneralCategory.class, Settings.CATEGORY_GENERAL);
        sections.put(RenderCategory.class, Settings.CATEGORY_RENDER);

        List<IConfigElement> list = new ArrayList<IConfigElement>();
        list.add(new DummyConfigElement.DummyCategoryElement(sections.get(GeneralCategory.class), "info.firstmod.config.section.general", GeneralCategory.class));
        list.add(new DummyConfigElement.DummyCategoryElement(sections.get(RenderCategory.class), "info.firstmod.config.section.render", RenderCategory.class));

        return list;
    }

    private static class FirstModEntry extends GuiConfigEntries.CategoryEntry
    {
        public FirstModEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
        {
            super(owningScreen, owningEntryList, configElement);
        }

        @Override
        protected GuiScreen buildChildScreen() {
            String category = sections.get(this.getClass());
            return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigurationHandler.config.getCategory(category.toLowerCase()))).getChildElements(), Reference.MOD_ID, category, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.config.getConfigFile().getAbsolutePath()));
        }
    }

    public static class GeneralCategory extends FirstModEntry
    {
        public GeneralCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
        {
            super(owningScreen, owningEntryList, configElement);
        }
    }

    public static class RenderCategory extends FirstModEntry
    {
        public RenderCategory(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement)
        {
            super(owningScreen, owningEntryList, configElement);
        }
    }
}