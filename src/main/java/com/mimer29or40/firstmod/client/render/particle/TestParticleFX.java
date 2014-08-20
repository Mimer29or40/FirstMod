package com.mimer29or40.firstmod.client.render.particle;

import com.mimer29or40.firstmod.reference.Textures;
import com.mimer29or40.firstmod.util.LogHelper;
import com.mimer29or40.firstmod.util.ResourceLocationHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class TestParticleFX extends EntityFX
{
    protected int particleTextureIndexX;
    protected int particleTextureIndexY;
    protected float particleTextureJitterX;
    protected float particleTextureJitterY;
    protected int particleAge;
    protected int particleMaxAge;
    protected float particleScale;
    protected float particleGravity;
    protected float particleRed;
    protected float particleGreen;
    protected float particleBlue;
    protected float particleAlpha;
    protected IIcon particleIcon;
    public static double interpPosX;
    public static double interpPosY;
    public static double interpPosZ;
    private static final String __OBFID = "CL_00000914";
    public static final ResourceLocation texture = ResourceLocationHelper.getResourceLocation(Textures.TEST_PARTICLE);

    public TestParticleFX(World world, double x, double y, double z)
    {
        super(world, x, y, z);
        this.particleAlpha = 1.0F;
        this.setSize(0.2F, 0.2F);
        this.yOffset = this.height / 2.0F;
        this.setPosition(x, y, z);
        this.lastTickPosX = x;
        this.lastTickPosY = y;
        this.lastTickPosZ = z;
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleTextureJitterX = this.rand.nextFloat() * 3.0F;
        this.particleTextureJitterY = this.rand.nextFloat() * 3.0F;
        this.particleScale = (this.rand.nextFloat() * 0.5F + 0.5F) * 2.0F;
        this.particleMaxAge = (int)(4.0F / (this.rand.nextFloat() * 0.9F + 0.1F));
        this.particleAge = 0;
    }

    public TestParticleFX(World world, double x, double y, double z, double dx, double dy, double dz)
    {
        this(world, x, y, z);
        this.motionX = dx + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.motionY = dy + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        this.motionZ = dz + (double)((float)(Math.random() * 2.0D - 1.0D) * 0.4F);
        float f = (float)(Math.random() + Math.random() + 1.0D) * 0.15F;
        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
        this.motionX = this.motionX / (double)f1 * (double)f * 0.4000000059604645D;
        this.motionY = this.motionY / (double)f1 * (double)f * 0.4000000059604645D + 0.10000000149011612D;
        this.motionZ = this.motionZ / (double)f1 * (double)f * 0.4000000059604645D;
    }

    public EntityFX multiplyVelocity(float velocity)
    {
        this.motionX *= (double)velocity;
        this.motionY = (this.motionY - 0.10000000149011612D) * (double)velocity + 0.10000000149011612D;
        this.motionZ *= (double)velocity;
        return this;
    }

    public EntityFX multipleParticleScaleBy(float scale)
    {
        this.setSize(0.2F * scale, 0.2F * scale);
        this.particleScale *= scale;
        return this;
    }

    public void setRBGColorF(float red, float green, float blue)
    {
        this.particleRed = red;
        this.particleGreen = green;
        this.particleBlue = blue;
    }

    /**
     * Sets the particle alpha (float)
     */
    public void setAlphaF(float alphaF)
    {
        this.particleAlpha = alphaF;
    }

    public float getRedColorF()
    {
        return this.particleRed;
    }

    public float getGreenColorF()
    {
        return this.particleGreen;
    }

    public float getBlueColorF()
    {
        return this.particleBlue;
    }

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    protected void entityInit() {}

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.motionY -= 0.04D * (double)this.particleGravity;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }

    @Override
    public void renderParticle(Tessellator tessellator, float partialTicks, float float2, float float3, float float4, float float5, float float6)
    {
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

//        GL11.glDepthMask(false);
//        GL11.glEnable(GL11.GL_BLEND);
//        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
//        GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);

        tessellator.startDrawingQuads();
        tessellator.setBrightness(getBrightnessForRender(partialTicks));

        float scale = 0.1F * particleScale;
        float x = (float)(this.prevPosX + (this.posX - this.prevPosX));
        float y = (float)(this.prevPosY + (this.posY - this.prevPosY));
        float z = (float)(this.prevPosZ + (this.posZ - this.prevPosZ));

        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);

        double x1 = (double)x - scale * (float2 - float5); double y1 = (double)y - scale * float3; double z1 = (double)z - scale * (float4 - float6);
        double x2 = (double)x - scale * (float2 + float5); double y2 = (double)y + scale * float3; double z2 = (double)z - scale * (float4 + float6);
        double x3 = (double)x + scale * (float2 + float5); double y3 = (double)y + scale * float3; double z3 = (double)z + scale * (float4 + float6);
        double x4 = (double)x + scale * (float2 - float5); double y4 = (double)y - scale * float3; double z4 = (double)z + scale * (float4 - float6);

//        LogHelper.info(String.format("x1: %s x2: %s x3: %s x4: %s", x1, x2, x3, x4));

        tessellator.addVertexWithUV(x1, y1, z1, 0, 0);
        tessellator.addVertexWithUV(x2, y2, z2, 1, 0);
        tessellator.addVertexWithUV(x3, y3, z3, 1, 1);
        tessellator.addVertexWithUV(x4, y4, z4, 0, 1);

        tessellator.draw();

//        GL11.glDisable(GL11.GL_BLEND);
//        GL11.glDepthMask(true);
//        GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);

//        float f6 = (float)this.particleTextureIndexX / 16.0F;

//        float f7 = f6 + 0.0624375F;
//        float f8 = (float)this.particleTextureIndexY / 16.0F;
//        float f9 = f8 + 0.0624375F;
//
//        if (this.particleIcon != null)
//        {
//            f6 = this.particleIcon.getMinU();
//            f7 = this.particleIcon.getMaxU();
//            f8 = this.particleIcon.getMinV();
//            f9 = this.particleIcon.getMaxV();
//        }
//
//
//        tessellator.setColorRGBA_F(this.particleRed, this.particleGreen, this.particleBlue, this.particleAlpha);
//        tessellator.addVertexWithUV((double) (f11 - float2 * f10 - float5 * f10), (double) (f12 - float3 * f10), (double) (f13 - float4 * f10 - float6 * f10), (double) f7, (double) f9);
//        tessellator.addVertexWithUV((double) (f11 - float2 * f10 + float5 * f10), (double) (f12 + float3 * f10), (double) (f13 - float4 * f10 + float6 * f10), (double) f7, (double) f8);
//        tessellator.addVertexWithUV((double) (f11 + float2 * f10 + float5 * f10), (double) (f12 + float3 * f10), (double) (f13 + float4 * f10 + float6 * f10), (double) f6, (double) f8);
//        tessellator.addVertexWithUV((double) (f11 + float2 * f10 - float5 * f10), (double) (f12 - float3 * f10), (double) (f13 + float4 * f10 - float6 * f10), (double) f6, (double) f9);
    }

    @Override
    public int getFXLayer()
    {
        return 3;
    }

    @Override
    public void setParticleIcon(IIcon icon)
    {
        if (this.getFXLayer() == 1)
        {
            this.particleIcon = icon;
        }
        else
        {
            if (this.getFXLayer() != 2)
            {
                throw new RuntimeException("Invalid call to Particle.setTex, use coordinate methods");
            }

            this.particleIcon = icon;
        }
    }

    /**
     * Public method to set private field particleTextureIndex.
     */
    public void setParticleTextureIndex(int particleTextureIndex)
    {
        if (this.getFXLayer() != 0)
        {
            throw new RuntimeException("Invalid call to Particle.setMiscTex");
        }
        else
        {
            this.particleTextureIndexX = particleTextureIndex % 16;
            this.particleTextureIndexY = particleTextureIndex / 16;
        }
    }

    public void nextTextureIndexX()
    {
        ++this.particleTextureIndexX;
    }

    public String toString()
    {
        return this.getClass().getSimpleName() + ", Pos (" + this.posX + "," + this.posY + "," + this.posZ + "), RGBA (" + this.particleRed + "," + this.particleGreen + "," + this.particleBlue + "," + this.particleAlpha + "), Age " + this.particleAge;
    }

    public TestParticleFX setMaxAge(int age)
    {
        this.particleMaxAge = age;
        return this;
    }

    public TestParticleFX setScale(int scale)
    {
        this.particleScale = scale;
        return this;
    }
}