package com.dinzeer.legendblade.specialeffects.heartblade;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DarkGod extends SpecialEffect {
    public DarkGod() {
        super(1);
    }
    @SubscribeEvent
    public static void onSlashBladeHit(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.DarkGod.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.DarkGod.get(), level)) {
                event.getTarget().curePotionEffects(new ItemStack(Items.MILK_BUCKET));
                player.curePotionEffects(new ItemStack(Items.MILK_BUCKET));
            }
        }

    }
    @SubscribeEvent
    public static void onSlashBladeHit2(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.GoldBlade.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }

            Player player = (Player)event.getUser();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.GoldBlade.get(), level)) {
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.HARM, 20, 1));
            }
        }

    }
    @SubscribeEvent
    public static void onSlashBladeUpdate(SlashBladeEvent.UpdateEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.BreakAll.getId())) {
            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BreakAll.get(), level)) {
                if (!player.hasEffect(MobEffects.REGENERATION)){
                player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100, 1));
                }
                if (!player.hasEffect(MobEffects.ABSORPTION)){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 100, 1));
                }
                player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100, 1));
                player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 100, 1));
            }
        }
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.NonePower.getId())) {
            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.NonePower.get(), level)) {

                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100000, 254));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 10000, 6));
            }
        }
    }
}
