package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber
public class SE30 extends SpecialEffectEx {
    public SE30() {
        super(30);
    }
    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if (LBSpecialEffectsRegistry.angory.getId()!=null){
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.angory.getId())) {
            if (!(event.getEntity() instanceof Player player)) {
                return;
            }

            if(!event.isSelected())
                return;

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.angory.get(),level)){
              if (player.getHealth() > player.getMaxHealth()/2){
                player.setHealth(player.getHealth()/2);

              }

            }
        }
        }
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.Aryadeva.getId())) {
            if (!(event.getEntity() instanceof Player player)) {
                return;
            }

            if(!event.isSelected())
                return;

            int level = player.experienceLevel;
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Aryadeva.getId())
                    && SpecialEffect.isEffective(LBSpecialEffectsRegistry.Aryadeva.get(), level)){
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,20,3));
                if (!player.hasEffect(MobEffects.ABSORPTION)){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION,20,3));
                }
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,20,1));
            }

        }
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.pure.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();
            int level = player.experienceLevel;
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.pure.getId())
                    && SpecialEffect.isEffective(LBSpecialEffectsRegistry.pure.get(), level)){
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,20,4));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,20,4));
            }

        }
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.nofear.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();
            int level = player.experienceLevel;
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.nofear.getId())
                    &&SpecialEffect.isEffective(LBSpecialEffectsRegistry.nofear.get(), level)){
                player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
            }

        }
    }

    @SubscribeEvent
    public static void hurtEntityEvent(LivingHurtEvent event){
        LivingEntity target = event.getEntity();

        if (event.getSource().getEntity() instanceof Player player) {
            int level = player.experienceLevel;
            if(hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Justice.getId())){
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Justice.get(), level)){
                    event.setAmount((float) (event.getAmount()*1.5));
                }
            }
            if(hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.HealIs.getId())){
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.HealIs.get(), level)){
                    target.heal(event.getAmount()*2);
                    event.setAmount(1);
                }
            }
        }
    }
}
