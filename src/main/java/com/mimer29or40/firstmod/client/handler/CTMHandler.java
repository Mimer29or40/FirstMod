package com.mimer29or40.firstmod.client.handler;

import com.mimer29or40.firstmod.FirstMod;
import com.mimer29or40.firstmod.reference.Reference;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.CTMBlock;
import com.mimer29or40.firstmod.util.GeneralClient;
import com.mimer29or40.firstmod.util.TextureSubmap;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

public class CTMHandler {
    public CTMBlock ctmBlock = new CTMBlock();
    public String blockName;
    public String texture;

    public CTMHandler(Block block, String texture) {
        if (block != null)
            ctmBlock.blockName = this.blockName = block.getLocalizedName();

        if (texture != null) {
            ctmBlock.texture = texture;

            String path = "/assets/" + Reference.MOD_ID.toLowerCase() + "/" + Textures.Block.BLOCK_TEXTURES + ctmBlock.texture;

            boolean icon = FirstMod.class.getResource(path + ".png") != null;
            boolean ctm = FirstMod.class.getResource(path + "-ctm.png") != null;

            if (!icon && !ctm)
                throw new RuntimeException("No valid textures found for block '" + this.blockName + "' (" + ctmBlock.texture + ")");
        } else
            throw new RuntimeException("Texture location not specified for " + this.blockName);

        ctmBlock.block = block;

    }

    public IIcon getIcon(int side, int metadata) {
        if (ctmBlock == null)
            return GeneralClient.getMissingIcon();
        return ctmBlock.icon;
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return getIcon(side, world.getBlockMetadata(x, y, z));
    }

    public void registerBlockIcons(IIconRegister register) {
        ctmBlock.test = new TextureSubmap(register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture + "-ctm"), 8, 8);
        ctmBlock.icon = register.registerIcon(Textures.RESOURCE_PREFIX + ctmBlock.texture);
    }
}