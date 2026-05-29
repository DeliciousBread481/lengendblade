package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.HeartBlade.Bullet;
import com.dinzeer.legendblade.specialattack.HeartBlade.ButterFly;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class PhysicsDepartmentFly extends SpecialEffect {
    public PhysicsDepartmentFly() {
        super(30);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

        ISlashBladeState state = event.getSlashBladeState();

        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.PhysicsDepartmentFly.getId())) {


            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.PhysicsDepartmentFly.get(), level)) {
                ButterFly.doSlash(player,4,1.5F);
            }




        }
}
}
