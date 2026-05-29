package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.HeartBlade.Bullet;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PhysicsDepartment extends SpecialEffect {
    public PhysicsDepartment() {
        super(30);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

        ISlashBladeState state = event.getSlashBladeState();

        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.PhysicsDepartment.getId())) {


            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.PhysicsDepartment.get(), level)) {
                Bullet.doSlash(player);
            }




        }
}
}
