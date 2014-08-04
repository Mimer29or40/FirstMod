package com.mimer29or40.firstmod.init;

import com.mimer29or40.firstmod.util.CraftingHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes
{
    public static void init()
    {
        //GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.torch), " c ", " s ", " s ", 'c', new ItemStack(Items.coal), 's', "stickWood"));
        //GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.torch), "stickWood"));

        CraftingHelper.addShapedOreRecipe(new ItemStack(ModItems.torch), " c ", " s ", " s ", 'c', new ItemStack(Items.coal), 's', "stickWood");
        CraftingHelper.addShapedOreRecipe(new ItemStack(ModBlocks.arrow), " s ", "sts", " t ", 's', "stickWood", 't', "plankWood");
        CraftingHelper.addShapelessOreRecipe(new ItemStack(ModBlocks.flag), new ItemStack(ModItems.torch), "stickWood");
    }
}