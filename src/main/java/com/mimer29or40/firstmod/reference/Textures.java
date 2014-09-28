package com.mimer29or40.firstmod.reference;

import com.mimer29or40.firstmod.util.ResourceLocationHelper;
import net.minecraft.util.ResourceLocation;

public class Textures
{
    public static final String RESOURCE_PREFIX = Reference.MOD_ID.toLowerCase() + ":";

    public static final class Block
    {
        public static final String BLOCK_TEXTURES = "textures/blocks/";
        public static final ResourceLocation CRYSTAL = ResourceLocationHelper.getResourceLocation(BLOCK_TEXTURES + "crystal.png");
        public static final ResourceLocation ARROW = ResourceLocationHelper.getResourceLocation(BLOCK_TEXTURES + "arrow.png");
        public static final ResourceLocation ARROW_TOP = ResourceLocationHelper.getResourceLocation(BLOCK_TEXTURES + "arrow_top.png");
        public static final ResourceLocation ARROW_BOTTOM = ResourceLocationHelper.getResourceLocation(BLOCK_TEXTURES + "arrow_bottom.png");

        public static final class CTM
        {
            public static final String CTM_TEXTURES = BLOCK_TEXTURES + "ctm/";
            public static final ResourceLocation CTM = ResourceLocationHelper.getResourceLocation(CTM_TEXTURES + "ctm.png");
        }
    }

    public static final class Item
    {
        public static final String ITEM_TEXTURES = "textures/items/";
    }

    public static final class Gui
    {
        public static final String GUI_TEXTURES = "textures/gui/";
    }

    public static final class Mics
    {
        public static final String MISC_TEXTURES = "textures/misc/";
    }

    public static final class Model
    {
        public static final String MODEL_LOCATION = "models/";
        public static final String MODEL_TEXTURES = "textures/models/";
    }
}