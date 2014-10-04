package com.mimer29or40.firstmod.util.helpers;

import com.mimer29or40.firstmod.reference.Textures;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class IconHelper
{
    public static IIcon forName(IIconRegister ir, String name)
    {
        return ir.registerIcon(Textures.RESOURCE_PREFIX + name);
    }

    public static IIcon forDir(IIconRegister ir, String name, String dir)
    {
        return forName(ir, dir+ "/" + name);
    }

    public static IIcon forBlock(IIconRegister ir, Block block)
    {
        return forName(ir, block.getUnlocalizedName().replaceAll("tile\\.", "").replace(Textures.RESOURCE_PREFIX, ""));
    }

    public static IIcon forBlock(IIconRegister ir, Block block, int i)
    {
        return forBlock(ir, block, Integer.toString(i));
    }

    public static IIcon forBlock(IIconRegister ir, Block block, int i, String dir)
    {
        return forBlock(ir, block, Integer.toString(i), dir);
    }

    public static IIcon forBlock(IIconRegister ir, Block block, String s)
    {
        return forName(ir, block.getUnlocalizedName().replaceAll("tile\\.", "").replace(Textures.RESOURCE_PREFIX, "") + s);
    }

    public static IIcon forBlock(IIconRegister ir, Block block, String s, String dir)
    {
        return forName(ir, dir + "/" + block.getUnlocalizedName().replaceAll("tile\\.", "").replace(Textures.RESOURCE_PREFIX, "") + s);
    }

    public static IIcon forItem(IIconRegister ir, Item item)
    {
        return forName(ir, item.getUnlocalizedName().replaceAll("item\\.", "").replace(Textures.RESOURCE_PREFIX, ""));
    }

    public static IIcon forItem(IIconRegister ir, Item item, int i)
    {
        return forItem(ir, item, Integer.toString(i));
    }

    public static IIcon forItem(IIconRegister ir, Item item, String s)
    {
        return forName(ir, item.getUnlocalizedName().replaceAll("item\\.", "").replace(Textures.RESOURCE_PREFIX, "") + s);
    }
}