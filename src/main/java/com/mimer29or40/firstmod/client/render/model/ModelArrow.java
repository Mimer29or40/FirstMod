package com.mimer29or40.firstmod.client.render.model;

import com.mimer29or40.firstmod.reference.Models;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

@SideOnly(Side.CLIENT)
public class ModelArrow
{
    private IModelCustom modelArrow;

    public ModelArrow()
    {
        modelArrow = AdvancedModelLoader.loadModel(Models.ARROW);
    }

    public void render()
    {
        modelArrow.renderAll();
    }
}