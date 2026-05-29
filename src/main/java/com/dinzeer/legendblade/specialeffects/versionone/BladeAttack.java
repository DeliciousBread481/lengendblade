package com.dinzeer.legendblade.specialeffects.versionone;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import mods.flammpfeil.slashblade.SlashBladeConfig;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class BladeAttack extends SpecialEffect {
    public BladeAttack() {
        super(60,false,false);
    }


    @SubscribeEvent
    public  static  void blaze(SlashBladeEvent.UpdateEvent event){
        ISlashBladeState state = event.getSlashBladeState();
        if(state.hasSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())) {
            if (!(event.getEntity() instanceof Player)) {
                return;
            }

            if(!event.isSelected())
                return;

            Player player = (Player) event.getEntity();

            int level = player.experienceLevel;

            if(SpecialEffect.isEffective(LBSpecialEffectsRegistry.BLadeAttack.get(),level)){
                if (!player.hasEffect(MobEffects.ABSORPTION)){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 3));
                }else
                if (player.getEffect(MobEffects.ABSORPTION).getDuration()<=5*20){
                    player.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 3));
                }

            }
        }
    }
    @SubscribeEvent
    public static void onSlashBladeHit(SlashBladeEvent.HitEvent event) {
        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())) {
            if (!(event.getUser() instanceof Player player)) {
                return;
            }

            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.BLadeAttack.get(), level)) {
                event.getTarget().addEffect(new MobEffectInstance(MobEffects.HARM, 10, 1));

                if (level>240){
                    event.getTarget().invulnerableTime=0;
                    var damageSource = new DamageSource(player.level().registryAccess()
                            .registryOrThrow(net.minecraft.core.registries.Registries.DAMAGE_TYPE)
                            .getHolderOrThrow(DamageTypes.WITHER), player);
                    // 改为曲线型伤害计算，基于玩家等级的自然对数增长
                    float attackDamage = (float) player.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
                    float damage = attackDamage * (float) (0.5 + Math.log(state.getRefine() + 1) * 0.1);
                    System.out.println("现算法:"+damage);
                    System.out.println("旧算法:"+player.getAttribute(Attributes.ATTACK_DAMAGE).getValue()*0.5*state.getRefine());
                    event.getTarget().hurt(damageSource,damage);

                }
            }
        }

    }

}
