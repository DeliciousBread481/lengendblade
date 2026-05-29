package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SE17 extends SpecialEffectEx {
    public SE17() {
        super(17);
    }
    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.OccupyingHeart.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.OccupyingHeart.get(),level)){

                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 2));


            }
        }
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.Theinescapableguilt.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.Theinescapableguilt.get(),level)){

                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 2));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 2));
                if (!player.hasEffect(MobEffects.REGENERATION)){
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 2));
                }
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 2));
                player.addEffect(new MobEffectInstance(MobEffects.WITHER, 300, 2));
                player.addEffect(new MobEffectInstance(MobEffects.GLOWING, 300, 2));
            }
        }
    }
    @SubscribeEvent
    public static void onSlashBladeHit(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.OccupyingHeart.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BAdBlood.get(), level)) {
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.DARKNESS, 10, 3));
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 1));

            }
        }

    }
}
