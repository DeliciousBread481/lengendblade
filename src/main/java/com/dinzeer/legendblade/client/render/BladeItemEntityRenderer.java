package com.dinzeer.legendblade.client.render;

import com.dinzeer.legendblade.CustomItemUtil;
import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.boss.NoEndBoss;
import com.mojang.blaze3d.vertex.PoseStack;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import mods.flammpfeil.slashblade.entity.BladeItemEntity;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import com.mojang.math.Axis;

import java.util.EnumSet;

public class BladeItemEntityRenderer extends EntityRenderer<NoEndBoss> {
    public BladeItemEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    public ResourceLocation getTextureLocation(NoEndRender p_114482_) {
        return null;
    }
    @Override
    public ResourceLocation getTextureLocation(NoEndBoss entity) {
        return new ResourceLocation("legendblade:textures/entity/air.png");
    }


    @Override
    public void render(NoEndBoss p_114485_, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn) {

    }


    /*
     * @Override public void doRenderShadowAndFire(Entity entityIn, double x, double
     * y, double z, float yaw, float partialTicks) {
     * 
     * matrixStackIn.enableBlend(); matrixStackIn.blendFuncSeparate(
     * matrixStackIn.SourceFactor.SRC_COLOR, matrixStackIn.DestFactor.ONE ,
     * matrixStackIn.SourceFactor.ONE, matrixStackIn.DestFactor.ZERO);
     * 
     * matrixStackIn.pushMatrix(); matrixStackIn.translatef((float)x, (float)y,
     * (float)z); matrixStackIn.scaled(1.4,1.8, 1.4);
     * matrixStackIn.translatef((float)-x, (float)-y, (float)-z);
     * 
     * //core super.doRenderShadowAndFire(entityIn, x, y, z, yaw, partialTicks);
     * 
     * 
     * //dark fire matrixStackIn.blendFuncSeparate(
     * matrixStackIn.SourceFactor.SRC_ALPHA, matrixStackIn.DestFactor.ONE ,
     * matrixStackIn.SourceFactor.ONE, matrixStackIn.DestFactor.ZERO);
     * matrixStackIn.translatef((float)x, (float)y, (float)z);
     * matrixStackIn.scaled(1.5,1.6,1.5); matrixStackIn.translatef((float)-x,
     * (float)-y, (float)-z); super.doRenderShadowAndFire(entityIn, x, y, z, yaw,
     * partialTicks); matrixStackIn.blendEquation(GL14.GL_FUNC_REVERSE_SUBTRACT);
     * super.doRenderShadowAndFire(entityIn, x, y, z, yaw, partialTicks);
     * 
     * 
     * matrixStackIn.popMatrix(); matrixStackIn.blendEquation(GL14.GL_FUNC_ADD);
     * matrixStackIn.blendFuncSeparate(GL11.GL_SRC_ALPHA,
     * GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
     * matrixStackIn.disableBlend(); }
     */
}
