package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SE37 extends SpecialEffectEx {
    public SE37() {
        super(37);
    }
    @SubscribeEvent
    public static void hurtEntityEvent(LivingHurtEvent event){
        LivingEntity target = event.getEntity();

        if (event.getSource().getEntity() instanceof Player player) {
            int level = player.experienceLevel;
            if(hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.SeizetheBlood.getId())){
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.SeizetheBlood.get(), level)){

                    event.setAmount((float) (event.getAmount()+target.getMaxHealth()*((float) 7 /1000)));
                }
            }
            if(hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.HelplessRest.getId())){
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.HelplessRest.get(), level)){

                    event.setAmount((float) (event.getAmount()+target.getMaxHealth()*((float) 6 /1000)));
                }
            }
        }
    }
}
