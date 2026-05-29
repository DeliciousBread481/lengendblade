package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.exfantasy.mclib.Utils.color.RandomColor;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SuperMe extends SpecialEffect {

    public SuperMe( ) {
        super(30);
    }
    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.SuperMe.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.SuperMe.get(), level)) {
                if (!player.hasEffect(MobEffects.REGENERATION)){
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                }else
                if (player.getEffect(MobEffects.REGENERATION).getDuration()<=5*20){
                    player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 0));
                }
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
                if (!player.hasEffect(MobEffects.ABSORPTION)){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 3));
                }else
                if (player.getEffect(MobEffects.ABSORPTION).getDuration()<=5*20){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 3));
                }
            }




        }
    }
}
