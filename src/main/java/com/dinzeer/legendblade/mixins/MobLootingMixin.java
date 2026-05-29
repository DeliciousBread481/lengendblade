package com.dinzeer.legendblade.mixins;

import com.dinzeer.legendblade.handle.ComboHandle;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EnchantmentHelper.class)
public class MobLootingMixin {
    @Inject(method = "getMobLooting",at = @At(value = "HEAD"), cancellable = true)
    private static void getMobLooting(LivingEntity livingEntity, CallbackInfoReturnable<Integer> cir) {
        if (livingEntity instanceof Player player) {
            if (SpecialEffectEx.hasSpecialEffect2(player.getMainHandItem(), LBSpecialEffectsRegistry.Phecda.getId(),player)){
                int v = 1;
                if (ComboHandle.getCombo(player)>10){
                    v = 2;
                }
                cir.setReturnValue(cir.getReturnValueI()+ v);
            }
        }
    }
}
