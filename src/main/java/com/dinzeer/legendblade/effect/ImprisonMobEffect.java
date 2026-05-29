
package com.dinzeer.legendblade.effect;

import com.exfantasy.mclib.Utils.AttrGether;
import com.exfantasy.mclib.Utils.AttrUtil;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;


import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.UUID;

public class ImprisonMobEffect extends MobEffect {
	public ImprisonMobEffect() {
		super(MobEffectCategory.HARMFUL, -16777216);
		attrGether2 =new AttrGether(Attributes.KNOCKBACK_RESISTANCE,new AttributeModifier(UUID.fromString("f0f0f0f0-f0f0-f0f0-f0f0-f0f0f0f0f0f1"),"Imprsion",10,AttributeModifier.Operation.ADDITION));

	}
	private static AttrGether attrGether2;
	private static AttrGether attrGether = new AttrGether(Attributes.MOVEMENT_SPEED,new AttributeModifier(UUID.fromString("f0f0f0f0-f0f0-f0f0-f0f0-f0f0f0f0f0f0"),"Imprsion",-10,AttributeModifier.Operation.ADDITION));
	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {

		AttrUtil.entityAddAttrTF(attrGether, entity, AttrUtil.WearOrTake.WEAR);

		AttrUtil.entityAddAttrTF(attrGether2, entity, AttrUtil.WearOrTake.WEAR);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {

		AttrUtil.entityAddAttrTF(attrGether, entity, AttrUtil.WearOrTake.TAKE);
		AttrUtil.entityAddAttrTF(attrGether2, entity, AttrUtil.WearOrTake.TAKE);

	}
	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		entity.setDeltaMovement(0,0,0);
		if (entity.level() instanceof ServerLevel _level)
			_level.sendParticles(ParticleTypes.SMOKE,entity.getX(), entity.getY()+entity.getBbHeight()*0.5, entity.getZ(), 8, 0.4, 0.4, 0.4, 0.05 );	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
