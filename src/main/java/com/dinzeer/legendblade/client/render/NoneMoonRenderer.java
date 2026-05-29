package com.dinzeer.legendblade.client.render;

import com.dinzeer.legendblade.entity.MoonDriveEntityEX;
import com.exfantasy.mclib.Utils.UUIDToIntConverter;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;



import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

import java.util.UUID;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class NoneMoonRenderer extends EntityRenderer<MoonDriveEntityEX> {
	private static final ResourceLocation texture = new ResourceLocation(MODID, "models/entity/black.png");
	private final BlackSlabe<MoonDriveEntityEX> model;

	public NoneMoonRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new BlackSlabe<MoonDriveEntityEX>(context.bakeLayer(BlackSlabe.LAYER_LOCATION));
	}

	@Override
	public void render(MoonDriveEntityEX entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		UUIDToIntConverter converter = new UUIDToIntConverter(800, 1000);

		poseStack.scale(0.34F, (float) converter.convert(entityIn.getUUID()), 0.34F);
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.0625f);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(MoonDriveEntityEX entity) {
		return texture;
	}
}
