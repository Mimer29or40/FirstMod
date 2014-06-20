package com.mimer29or40.firstmod.blocks;

import com.mimer29or40.firstmod.creativetab.CreativeTabFirstMod;
import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.LogHelper;
import com.mimer29or40.firstmod.util.NameHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FMBlocks extends Block
{
    protected FMBlocks()
    {
        super(Material.rock);
    }

    public FMBlocks(Material material)
    {
        super(material);
        this.setCreativeTab(CreativeTabFirstMod.FIRSTMOD_TAB);
    }

    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, NameHelper.getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(String.format("%s", NameHelper.getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLiving, ItemStack itemStack)
    {

    }
}
