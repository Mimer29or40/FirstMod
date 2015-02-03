package com.mimer29or40.firstmod;

import com.mimer29or40.firstmod.proxy.IProxy;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Settings;
import com.mimer29or40.firstmod.util.helpers.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class FirstMod
{
    @Mod.Instance(Reference.MOD_ID)
    public static FirstMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit(event);

        if(Boolean.valueOf(String.valueOf(Settings.Debug.getValue())))
        {
            for(String oreName : OreDictionary.getOreNames())
            {
                LogHelper.debug(oreName);
            }
        }
    }
}
