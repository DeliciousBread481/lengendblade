package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Devastate extends SpecialEffect {
    public Devastate() {
        super(30);
    }
    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.Devastate.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.Devastate.get(),level)){

                player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 100, 0));

            }
        }
    }
    @SubscribeEvent
    public static void onSlashBladeHit(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Devastate.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Devastate.get(), level)) {
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 6));
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 300, 6));
            }
        }

    }
    @SubscribeEvent
    public  static  void blazeofstrength(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.Strength.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.Strength.get(),level)){

                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 4));
                player.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, 2));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0));
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0));
            }
        }
    }
}
