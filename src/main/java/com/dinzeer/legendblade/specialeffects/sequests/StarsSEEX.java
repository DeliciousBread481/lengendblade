package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.event.ItemAttributeModifierEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Mod.EventBusSubscriber
public class StarsSEEX extends SpecialEffectEx {

    public StarsSEEX() {
        super(60);
    }
    @SubscribeEvent
    public static void DubheEX2(ItemAttributeModifierEvent s){
        if (s.getSlotType() != EquipmentSlot.MAINHAND)return;
        if (hasSpecialEffect(s.getItemStack(), LBSpecialEffectsRegistry.DubheEX.getId()) ){

            Map<Enchantment, Integer> allEnchantments = s.getItemStack().getAllEnchantments();
            AtomicInteger value = new AtomicInteger();
            allEnchantments.forEach(
                    (k,v)->{
                        value.addAndGet(v);
                    }
            );
            // 修改：根据value值动态调整增幅系数，40级后增幅递减更明显
            int totalValue = value.get();
            double coefficient = 1.5d;
            if (totalValue > 40) {
                // 超过40级部分每增加1级，系数减少0.01（基础1.5，40级后逐步递减）
                coefficient = 1.5d - (totalValue - 40) * 0.01;
                // 保证最低增幅系数不低于0.5
                coefficient = Math.max(coefficient, 0.5);
            }
            s.addModifier(Attributes.ATTACK_DAMAGE,new AttributeModifier(UUID.nameUUIDFromBytes("tianshu2".getBytes()),"tianshu2",
                    totalValue * coefficient, AttributeModifier.Operation.ADDITION));
        }
    }
    @SubscribeEvent
    public static void HagenEX2(ItemAttributeModifierEvent s){
        if (hasSpecialEffect(s.getItemStack(), LBSpecialEffectsRegistry.HagenEX.getId()) ){
            if (s.getSlotType() != EquipmentSlot.MAINHAND)return;

            Map<Enchantment, Integer> allEnchantments = s.getItemStack().getAllEnchantments();
            AtomicInteger value = new AtomicInteger();
            allEnchantments.forEach(
                    (k,v)->{
                        value.addAndGet(v);
                    }
            );
            s.addModifier(Attributes.ARMOR_TOUGHNESS,new AttributeModifier(UUID.nameUUIDFromBytes("tianxuan2".getBytes()),"tianxuan2",
                    value.get()*0.1d, AttributeModifier.Operation.ADDITION));
        }
    }
    @SubscribeEvent
    public static void Phecda2(LivingHurtEvent event){
        hurtEventHandleSe(event,(p,l,state)->{

            int mobLooting = p.getMainHandItem().getEnchantmentLevel(Enchantments.MOB_LOOTING);
            hurtEventAmountBase(event, Math.min(mobLooting *0.05f,1.25f));
        },LBSpecialEffectsRegistry.PhecdaEX.getId());
    }
    @SubscribeEvent
    public static void Megrez2(LivingHurtEvent event){
        hurtEventHandleSe(event,(p,l,state)->{
            hurtEventAmountBase(event, Math.min(((int) (p.experienceLevel/30))*0.05f,1.25f));

            },LBSpecialEffectsRegistry.MegrezEX.getId());
    }
    @SubscribeEvent
    public static void Fenrir2(LivingHurtEvent event){
        hurtEventHandleSe(event,(p,l,state)->{
            hurtEventAmountBase(event, Math.min(((int) (state.getProudSoulCount()/2000))*0.05f,1.25f));
        },LBSpecialEffectsRegistry.FenrirEX.getId());
    }
    @SubscribeEvent
    public static void Mizar2(LivingHurtEvent event){
        hurtEventHandleSe(event,(p,l,state)->{
            Map<Enchantment, Integer> allEnchantments = p.getMainHandItem().getAllEnchantments();
            AtomicInteger value = new AtomicInteger();
            allEnchantments.forEach(
                    (k,v)->{
                        value.addAndGet(v);
                    }
            );
            hurtEventAmountBase(event, (float) Math.max(0.5-value.get()*0.1f,1.25f));
        },LBSpecialEffectsRegistry.MizarEX.getId());
    }
    @SubscribeEvent
    public static void Alkaid2(LivingHurtEvent event){
        if (event.getEntity() instanceof Player player){
            if (hasSpecialEffect2(player.getMainHandItem(),LBSpecialEffectsRegistry.AlkaidEX.getId(), player)){
                hurtEventAmountBase(event, (float) Math.max(-0.1,-0.01*player.getAttributeValue(Attributes.LUCK)));
            }
        }
    }

}
