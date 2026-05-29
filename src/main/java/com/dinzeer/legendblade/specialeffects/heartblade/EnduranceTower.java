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
public class EnduranceTower extends SpecialEffect {
    public EnduranceTower() {
        super(88);
    }
    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.EnduranceTower.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.EnduranceTower.get(),level)){

                player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 100, 2));
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 0));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 100, 0));

                if (!player.hasEffect(MobEffects.REGENERATION)){
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                }else
                if (player.getEffect(MobEffects.REGENERATION).getDuration()<=5*20){
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                }
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 0));
            }
        }
    }

}
