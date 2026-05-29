package com.dinzeer.legendblade.mixins;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(LivingEntity.class)
public abstract class DropXPMixin {
    @Shadow public abstract void remove(Entity.RemovalReason p_276115_);

    @Shadow @Nullable protected Player lastHurtByPlayer;

    @Shadow protected abstract boolean isAlwaysExperienceDropper();

    @Shadow protected int lastHurtByPlayerTime;

    @Inject(method = "dropExperience",at = @At(value = "HEAD"))
    private void modifier(CallbackInfo ci) {
        LivingEntity livingEntity = (LivingEntity) (Object)this;
        if (livingEntity.getPersistentData().contains("bootXpDrop")) {

            if (livingEntity.level() instanceof ServerLevel && !livingEntity.wasExperienceConsumed() && (this.isAlwaysExperienceDropper() || this.lastHurtByPlayerTime > 0 && livingEntity.shouldDropExperience() && livingEntity.level().getGameRules().getBoolean(GameRules.RULE_DOMOBLOOT))) {
                int reward = (int) (net.minecraftforge.event.ForgeEventFactory.getExperienceDrop(livingEntity, this.lastHurtByPlayer, livingEntity.getExperienceReward())  * (1 + livingEntity.getPersistentData().getDouble("bootXpDrop")));;
                ExperienceOrb.award((ServerLevel) livingEntity.level(), livingEntity.position(), reward);
            }

        }
    }
}
