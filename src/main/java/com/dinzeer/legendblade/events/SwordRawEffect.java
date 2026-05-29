package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.Util;
import com.dinzeer.legendblade.entity.SumonSwordEntityEX;
import com.dinzeer.legendblade.entity.SwordRainEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber
public class SwordRawEffect
{
    @SubscribeEvent
    public static void apply(SlashBladeEvent.HitEvent event){
        LivingEntity target = event.getTarget();
        if (target !=null){

            LivingEntity user = event.getUser();
            ItemStack mainHandItem = user.getMainHandItem();
            if (mainHandItem.getAllEnchantments().containsKey(Legendblade.SWORD_RAW.get())){
                Level worldIn = target.level();
                int enchantLevel = mainHandItem.getEnchantmentLevel(Legendblade.SWORD_RAW.get());
                if (Math.random() > enchantLevel*0.1)return;
                doS(worldIn, user, mainHandItem, enchantLevel, target);

            }
        }
    }

    public static void doS(Level worldIn, LivingEntity user, ItemStack mainHandItem, int enchantLevel, LivingEntity target) {
        SwordRainEntity ss = new SwordRainEntity(LBEntiteRegristrys.sr, worldIn);

        worldIn.addFreshEntity(ss);

        //     ss.setSpeed(enchantLevel*0.5f);
        ss.setIsCritical(false);
        ss.setOwner(user);
        ss.setColor(mainHandItem.getCapability(ItemSlashBlade.BLADESTATE).map(e->e.getColorCode()).get());
        ss.setRoll(0);
        ss.setForward(true);
        ss.setDamage(enchantLevel);
        // force riding
        ss.startRiding(user, true);

        ss.doFire();
        //       ss.setDelay(deplay+i);

        boolean isRight = ss.getDelay() % 2 == 0;
        RandomSource random = worldIn.getRandom();

        double xOffset = random.nextDouble() * 3 * (isRight ? 1 : -1);
        double yOffset = random.nextFloat() * 2;
        double zOffset = random.nextFloat() * 0.5;

        ss.setPos(target.position().add(xOffset, yOffset+3.5, zOffset));
        //      ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

        user.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
    }
}
