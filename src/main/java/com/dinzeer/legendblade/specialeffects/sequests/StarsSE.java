package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.Config;
import com.dinzeer.legendblade.handle.ComboHandle;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class StarsSE extends SpecialEffectEx {

    public StarsSE() {
        super(30);
    }
    //todo what

    @SubscribeEvent
    public static void apply(LivingHurtEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (Config.comboadder){
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Dubhe.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Hagen.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Alkaid.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Megrez.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Mizar.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Phecda.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.Fenrir.getId())) {
                event.setAmount(event.getAmount() * (1 + 0.01f * ComboHandle.getCombo(player)));
            }
            }
        }
    }

    @SubscribeEvent
    public static void onupdate(SlashBladeEvent.UpdateEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (event.getEntity() instanceof Player player) {
            if (!event.isSelected())
                return;
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Dubhe.getId())) {

                int level = player.experienceLevel;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Dubhe.get(), level)) {
                    if (ComboHandle.getCombo(player) < 10) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0));
                    }
                    if (ComboHandle.getCombo(player) >= 10 && ComboHandle.getCombo(player) < 100) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 1));
                    }
                    if (ComboHandle.getCombo(player) >= 100) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 2));
                    }

                }
            }
            if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Hagen.getId())) {

                int level = player.experienceLevel;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Hagen.get(), level)) {
                    if (ComboHandle.getCombo(player) < 10) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0));
                    }
                    if (ComboHandle.getCombo(player) >= 10 && ComboHandle.getCombo(player) < 100) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 1));
                    }
                    if (ComboHandle.getCombo(player) >= 100) {
                        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 2));
                    }

                }
            }
            if (hasSpecialEffect2(event.getBlade(), LBSpecialEffectsRegistry.Alkaid.getId(), player)) {
                if (ComboHandle.getCombo(player) < 10) {
                    player.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 1));
                }
                if (ComboHandle.getCombo(player) >= 10) {
                    player.addEffect(new MobEffectInstance(MobEffects.LUCK, 100, 2));
                }
            }

        }
    }


    @SubscribeEvent
    public static void Megrez(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (hasSpecialEffect2(player.getMainHandItem(), LBSpecialEffectsRegistry.Megrez.getId(), player)) {
                double d = 0.5f;
                if (ComboHandle.getCombo(player) > 10) {
                    d = 1;
                }
                event.getEntity().getPersistentData().putDouble("bootXpDrop", d);
            }
        }
    }

    @SubscribeEvent
    public static void Fenrir(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (hasSpecialEffect2(player.getMainHandItem(), LBSpecialEffectsRegistry.Fenrir.getId(), player)) {
                player.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state ->{
                    state.setKillCount(state.getKillCount()+1);
                    return 0;
                });
            }
        }
    }
    @SubscribeEvent
    public static void Mizar   (LivingHurtEvent event){
        hurtEventHandleSe(event,(p,l,state)->{
            hurtEventAmountBase(event, 0.1f);
        },LBSpecialEffectsRegistry.Mizar.getId());
    }
}


