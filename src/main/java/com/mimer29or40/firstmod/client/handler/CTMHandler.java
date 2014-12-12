package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.CTMBlock;
import net.minecraft.block.Block;

public class CTMHandler
{
    public CTMBlock ctmBlock = new CTMBlock();
    public String blockName;
    public String texture;

    public CTMHandler(Block block, String texture)
    {
        if(block != null) ctmBlock.blockName = this.blockName = block.getLocalizedName();

        if(texture != null)
        {
            ctmBlock.texture = texture;

            String path = "/assets/" + Reference.MOD_ID.toLowerCase() + "/" + Textures.Block.BLOCK_TEXTURES + ctmBlock.texture;

            boolean icon = FirstMod.class.getResource(path + ".png") != null;
            boolean ctm = FirstMod.class.getResource(path + "-ctm.png") != null;

            if(! icon && ! ctm)
            {
                throw new RuntimeException("No valid textures found for block '" + this.blockName + "' (" + ctmBlock.texture + ")");
            }
        }
        else
        {
            throw new RuntimeException("Texture location not specified for " + this.blockName);
        }
        ctmBlock.block = block;
    }
}