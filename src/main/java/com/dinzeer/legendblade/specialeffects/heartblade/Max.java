package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versiontwo.FireDrive;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.Drive;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Max extends SpecialEffect {
    public Max() {
        super(45);
    }
    @SubscribeEvent
    public static void onupadate(SlashBladeEvent.UpdateEvent event) {

        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Max.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getEntity();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;

            if (!SpecialEffect.isEffective(LBSpecialEffectsRegistry.Max.get(), level)) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 300, 1));


               }else {
                player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0));
            }

        }
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Max.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }//写血狐se

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Max.get(), level)) {//血狐的se
                FireDrive.doSlash(player,event.getRoll(),20,Vec3.ZERO,false,0.5F,0.5F,1F,0);


            }





        }
    }
}
