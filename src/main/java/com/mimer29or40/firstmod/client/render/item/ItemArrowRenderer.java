package com.mimer29or40.firstmod.client.render.item;

import com.mimer29or40.firstmod.client.render.model.ModelArrow;
import com.mimer29or40.firstmod.reference.Textures;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class ItemArrowRenderer implements IItemRenderer
{
    private final ModelArrow modelArrow;

    public ItemArrowRenderer()
    {
        modelArrow = new ModelArrow();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case ENTITY:
            {
                renderArrow(-0.5F, -0.38F, 0.5F);
                return;
            }
            case EQUIPPED:
            {
                renderArrow(0.0F, 0.0F, 1.0F);
                return;
            }
            case EQUIPPED_FIRST_PERSON:
            {
                renderArrow(0.0F, 0.0F, 1.0F);
                return;
            }
            case INVENTORY:
            {
                renderArrow(-1.0F, -0.9F, 0.0F);
                return;
            }
            default:
        }
    }

    private void renderArrow(float x, float y, float z)
    {
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);

        // Scale, Translate, Rotate
        GL11.glScalef(1F, 1F, 1F);
        GL11.glTranslatef(x, y, z);
        GL11.glRotatef(-90F, 1F, 0, 0);

        // Bind texture
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(Textures.MODEL_ARROW);

        // Render
        modelArrow.render();

        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}