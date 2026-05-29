package com.dinzeer.legendblade.mixins;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mods.flammpfeil.slashblade.client.renderer.entity.JudgementCutRenderer;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import mods.flammpfeil.slashblade.entity.EntityJudgementCut;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityDimensions;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.awt.Color;
import javax.annotation.Nullable;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.client.renderer.model.obj.WavefrontObject;
import mods.flammpfeil.slashblade.client.renderer.util.BladeRenderState;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import mods.flammpfeil.slashblade.entity.EntityJudgementCut;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.awt.*;

@Mixin(JudgementCutRenderer.class)
public abstract class JCRMixin<T extends EntityJudgementCut> extends EntityRenderer<T> {
    @Shadow(remap = false)
    @Final
    private static ResourceLocation modelLocation;

    protected JCRMixin(EntityRendererProvider.Context p_174008_) {
        super(p_174008_);
    }

    @Inject(at = @At("HEAD"), method = "render(Lmods/flammpfeil/slashblade/entity/EntityJudgementCut;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V", remap = false, cancellable = true)
    private void render(T entity, float entityYaw, float partialTicks, PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, CallbackInfo ci) {
        EntityDimensions dimensions = entity.getDimensions(entity.getPose());
        if (dimensions.width * dimensions.height > 4) {
            MSAutoCloser msac = MSAutoCloser.pushMatrix(matrixStackIn);

            try {
                matrixStackIn.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
                matrixStackIn.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot())));
                WavefrontObject model = BladeModelManager.getInstance().getModel(modelLocation);
                int lifetime = entity.getLifetime();
                double deathTime = (double) lifetime;
                double baseAlpha = Math.min(deathTime, (double) Math.max(0.0F, (float) (lifetime - entity.tickCount) - partialTicks)) / deathTime;
                baseAlpha = -Math.pow(baseAlpha - 1.0, 4.0) + 1.0;
                int seed = entity.getSeed();
                matrixStackIn.mulPose(Axis.YP.rotationDegrees((float) seed));
                float v = dimensions.width * dimensions.height;
                float scale = 8;
            //    matrixStackIn.scale(scale*0.01f, scale*0.01f, scale*0.01f);
                matrixStackIn.scale(scale, scale, scale);

                int color = entity.getColor() & 16777215;
                Color col = new Color(color);
                float[] hsb = Color.RGBtoHSB(col.getRed(), col.getGreen(), col.getBlue(), (float[]) null);
                int baseColor = Color.HSBtoRGB(0.5F + hsb[0], hsb[1], 0.2F) & 16777215;
                MSAutoCloser msacB = MSAutoCloser.pushMatrix(matrixStackIn);

                int l;
                try {
                    for (l = 0; l < 5; ++l) {
                        //matrixStackIn.scale(scale*0.95f, scale*0.95f, scale*0.95f);
                        BladeRenderState.setCol(baseColor | (255 & (int) (102.0 * baseAlpha)) << 24);
                        BladeRenderState.renderOverridedReverseLuminous(ItemStack.EMPTY, model, "base", this.getTextureLocation(entity), matrixStackIn, bufferIn, packedLightIn);
                    }
                } catch (Throwable var48) {
                    if (msacB != null) {
                        try {
                            msacB.close();
                        } catch (Throwable var44) {
                            var48.addSuppressed(var44);
                        }
                    }

                    throw var48;
                }

                if (msacB != null) {
                    msacB.close();
                }

                int loop = 3;
                l = 0;

                label99:
                while (true) {
                    if (l >= loop) {
                        int windCount = 5;
                         l = 0;

                        while (true) {
                            if (l >= windCount) {
                                break label99;
                            }

                             msacB = MSAutoCloser.pushMatrix(matrixStackIn);

                            try {
                                matrixStackIn.mulPose(Axis.XP.rotationDegrees(360.0F / (float) windCount * (float) l));
                                matrixStackIn.mulPose(Axis.YP.rotationDegrees(30.0F));
                                double rotWind = 18.0;
                                double offsetBase = 7.0;
                                double offset = (double) l * offsetBase;
                                double motionLen = offsetBase * (double) (windCount - 1);
                                double ticks = (double) ((float) entity.tickCount + partialTicks + (float) seed);
                                double offsetTicks = ticks + offset;
                                double progress = offsetTicks % motionLen / motionLen;
                                double rad = 6.283185307179586;
                                rad *= progress;
                                float windScale = (float) (0.4 + progress) *scale;
                            //    matrixStackIn.scale(windScale, windScale, windScale);
                                matrixStackIn.mulPose(Axis.ZP.rotationDegrees((float) (rotWind * offsetTicks)));
                                Color cc = new Color(col.getRed(), col.getGreen(), col.getBlue(), 255 & (int) Math.min(0.0, 255.0 * Math.sin(rad) * baseAlpha));
                                BladeRenderState.setCol(cc);
                                BladeRenderState.renderOverridedColorWrite(ItemStack.EMPTY, model, "wind", this.getTextureLocation(entity), matrixStackIn, bufferIn, 15728864);
                            } catch (Throwable var47) {
                                if (msacB != null) {
                                    try {
                                        msacB.close();
                                    } catch (Throwable var45) {
                                        var47.addSuppressed(var45);
                                    }
                                }

                                throw var47;
                            }

                            if (msacB != null) {
                                msacB.close();
                            }

                            ++l;
                        }
                    }

                     msacB = MSAutoCloser.pushMatrix(matrixStackIn);

                    try {
                        float cycleTicks = 15.0F;
                        float wave = ((float) entity.tickCount + cycleTicks / (float) loop * (float) l + partialTicks) % cycleTicks;
                        float waveScale = 1.0F + 0.03F * wave;
                        waveScale *= scale;
                 //       matrixStackIn.scale(waveScale, waveScale, waveScale);
                        BladeRenderState.setCol(baseColor | (int) ((double) (136.0F * ((cycleTicks - wave) / cycleTicks)) * baseAlpha) << 24);
                        BladeRenderState.renderOverridedReverseLuminous(ItemStack.EMPTY, model, "base", this.getTextureLocation(entity), matrixStackIn, bufferIn, packedLightIn);
                    } catch (Throwable var46) {
                        if (msacB != null) {
                            try {
                                msacB.close();
                            } catch (Throwable var43) {
                                var46.addSuppressed(var43);
                            }
                        }

                        throw var46;
                    }

                    if (msacB != null) {
                        msacB.close();
                    }

                    ++l;
                }
            } catch (Throwable var49) {
                if (msac != null) {
                    try {
                        msac.close();
                    } catch (Throwable var42) {
                        var49.addSuppressed(var42);
                    }
                }

                throw var49;
            }

            if (msac != null) {
                msac.close();
            }
            ci.cancel();
        }
    }
}

