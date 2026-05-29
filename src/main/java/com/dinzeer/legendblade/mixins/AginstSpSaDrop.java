package com.dinzeer.legendblade.mixins;

import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.event.bladestand.BlandStandEventHandler;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BlandStandEventHandler.class)
public abstract class AginstSpSaDrop {
    @Inject(method = "eventCopySA",at = @At("HEAD"),cancellable = true,remap = false)
    private static void onCopySA(SlashBladeEvent.BladeStandAttackEvent event, CallbackInfo ci) {
        if (event.getDamageSource().getEntity() instanceof Player player) {
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            ISlashBladeState state = event.getSlashBladeState();
            ItemStack blade = event.getBlade();
           var b= blade.getItem().asItem();
            if (!blade.isEmpty()) {
                if(b==SBItems.slashblade) {
                    if (player.getMainHandItem().getItem() == SBItems.proudsoul_ingot && stack.isEnchanted()) {

                        if (state.getSlashArtsKey().toString().equals(LBslashArtRegsitry.LastMoondrive.getId().toString())) {
                            ci.cancel();
                        }
                    }
                }
            }
        }
    }
}
