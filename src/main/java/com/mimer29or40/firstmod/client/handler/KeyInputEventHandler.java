package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.client.settings.Keybindings;
import com.mimer29or40.firstmod.reference.Key;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class KeyInputEventHandler
{
    private static Key getPressedKeybinding()
    {
        if (Keybindings.charge.isPressed())
        {
            return Key.CHARGE;
        }
        else if (Keybindings.release.isPressed())
        {
            return Key.RELEASE;
        }
        return Key.UNKNOWN;
    }

    @SubscribeEvent
    public void handleKeyInputEvent(InputEvent.KeyInputEvent event)
    {
        //TODO Do Stuff
    }
}