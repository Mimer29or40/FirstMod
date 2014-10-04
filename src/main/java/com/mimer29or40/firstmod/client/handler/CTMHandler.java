package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.block.BlockCTM;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.CTMBlock;
import com.mimer29or40.firstmod.util.GeneralClient;
import com.mimer29or40.firstmod.util.TextureSubmap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CTMHandler
{
    public CTMBlock ctmBlock = new CTMBlock();
    public String blockName;
    public String texture;
    private boolean noIcon = false;

    public CTMHandler(Block block, String texture)
    {
        if (block != null)
            ctmBlock.blockName = this.blockName = block.getLocalizedName();

        if (texture != null)
        {
            ctmBlock.texture = texture;

            String path = "/assets/" + Reference.MOD_ID.toLowerCase() + "/" + Textures.Block.BLOCK_TEXTURES + ctmBlock.texture;

            boolean icon = FirstMod.class.getResource(path + ".png") != null;
            boolean ctm1 = FirstMod.class.getResource(path + "-ctm1.png") != null;
            boolean ctm2 = FirstMod.class.getResource(path + "-ctm2.png") != null;
            boolean ctm3 = FirstMod.class.getResource(path + "-ctm3.png") != null;

            if (!icon)
                this.noIcon = true;

            if (!icon && !ctm1 && !ctm2 && !ctm3)
                throw new RuntimeException("No valid textures found for block '" + this.blockName + "' (" + ctmBlock.texture + ")");
        }
        else
            throw new RuntimeException("Texture location not specified for "+ this.blockName);

        ctmBlock.block = block;

    }

    public IIcon getIcon(int side, int metadata)
    {
        if(ctmBlock == null)
            return GeneralClient.getMissingIcon();
        return ctmBlock.icon;
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
    {
        return getIcon(side, world.getBlockMetadata(x, y, z));
    }

    public void registerBlockIcons(IIconRegister register, Block block)
    {
        ctmBlock.submap[0] = new TextureSubmap(register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture + "-ctm1"), 4, 4);

        if (((BlockCTM) block).isAdvCTM())
        {
            ctmBlock.submap[1] = new TextureSubmap(register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture + "-ctm2"), 4, 4);
            ctmBlock.submap[2] = new TextureSubmap(register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture + "-ctm3"), 4, 4);
        }

        if (noIcon)
            ctmBlock.icon = ctmBlock.submap[0].getIcon(1,1);
        else
            ctmBlock.icon = register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture);
    }
}