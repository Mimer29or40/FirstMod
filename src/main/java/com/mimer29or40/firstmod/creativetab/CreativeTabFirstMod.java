package com.mimer29or40.firstmod.creativetab;

import com.mimer29or40.firstmod.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabFirstMod
{
    public static final CreativeTabs FIRSTMOD_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem() {
            return Items.apple;
        }

        @Override
        @SideOnly(Side.CLIENT)
        public String getTranslatedTabLabel()
        {
            return "First Mod";
        }
    };

}
