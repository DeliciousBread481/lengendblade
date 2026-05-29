package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.entity.SumonSwordEntityEX;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.color.RandomColor;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class SommonSwordSommonEX {
    public static void doSlash(LivingEntity playerIn, boolean critical, double damage, float speed)
    {

        int colorCode = playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
        doSlash(playerIn, colorCode, critical, damage, speed);
    }
    private final static Random random = new Random();
    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed)
    {
        if (playerIn.level().isClientSide()) return;

        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();
            Vec3 v = playerIn.position();
            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int count = 500;
            SMoveUtil.sendDashMessage((Player) playerIn, 3, -0.5);

            Legendblade.queueServerWork(25, () -> {


                for (int i = 0; i < count; i++) {
                    int finalI = i;
                    Legendblade.queueServerWork((int) (i * 0.3)+1, () -> {
                        playerIn.setPos(v);
                        SumonSwordEntity ss = new SumonSwordEntity(LBEntiteRegristrys.ss, worldIn);

                        worldIn.addFreshEntity(ss);

                        ss.setSpeed(speed*2);
                        ss.setIsCritical(critical);
                        ss.setOwner(playerIn);
                        ss.setColor(RandomColor.returnner(random.nextInt(93) + 1));
                        ss.setRoll(0);
                        ss.setDamage(damage);
                        // force riding
                        ss.startRiding(playerIn, true);

                        ss.setDelay(100 + finalI);

                        boolean isRight = ss.getDelay() % 2 == 0;
                        RandomSource random = worldIn.getRandom();

                        double xOffset = random.nextDouble() * finalI * 0.08 * (isRight ? 1 : -1);
                        double yOffset = random.nextFloat() * finalI * 0.08;
                        double zOffset = random.nextFloat() * finalI * 0.08;

                        ss.setPos(playerIn.position().add(xOffset, yOffset, zOffset));
                        ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                        playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
                    });

                }
            });
        });
    }
}
