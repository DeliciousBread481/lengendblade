package com.dinzeer.legendblade.specialeffects.neo;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Dawn extends SpecialEffectEx{
    public Dawn() {
        super(10);
    }
    @SubscribeEvent
    public static void apply(LivingHurtEvent event){
        if (event.getEntity() instanceof Player player){
            ItemStack mainHandItem = player.getMainHandItem();
                if (hasSpecialEffect(mainHandItem, LBSpecialEffectsRegistry.Dawn.getId())){
                    event.setAmount(event.getAmount() * ((player.getHealth()/player.getMaxHealth())+0.1f));
                }

        }
        if (event.getSource().getEntity() instanceof Player player){
            ItemStack mainHandItem = player.getMainHandItem();
                if (hasSpecialEffect(mainHandItem,LBSpecialEffectsRegistry.Dawn.getId())){
                    event.setAmount(event.getAmount() * (1-player.getHealth()/player.getMaxHealth())*2+2f);
                }

        }
    }
}
