
package com.dinzeer.legendblade.client.render;

import com.dinzeer.legendblade.entity.boss.NoEndBoss;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import mods.flammpfeil.slashblade.client.renderer.layers.LayerMainBlade;
import mods.flammpfeil.slashblade.client.renderer.util.MSAutoCloser;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
public  class NoEndRender  extends HumanoidMobRenderer<NoEndBoss, HumanoidModel<NoEndBoss>>{
	private LayerMainBlade<LocalPlayer, ?> layer = null;

	public NoEndRender(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));

    }


	private static final skinType[] SKIN_TYPES = skinType.values();

	private static enum skinType {
		air,
		canyue,
		cat,
		dinzeer,
		past,
		player,
		tianyi,
		yaoxing,
		morning,
		morning2,
		stone,
		eily,
		biantwin,
		gwen
	}

	@Override
	public ResourceLocation getTextureLocation(NoEndBoss noEndBoss) {
		// 获取实体的UUID，并用它来创建一个确定性的随机数生成器
		UUID uuid = noEndBoss.getUUID();
		Random random = new Random(uuid.hashCode());

		// 使用随机数生成器来选择皮肤类型
		skinType selectedSkin = SKIN_TYPES[random.nextInt(SKIN_TYPES.length)];

		// 返回对应的纹理位置
		return new ResourceLocation("legendblade:textures/entity/" + selectedSkin.name() + ".png");
	}
}
