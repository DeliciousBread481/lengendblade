package com.dinzeer.legendblade.specialattack.HeartBlade;

import com.dinzeer.legendblade.entity.BulletEntity;
import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class Bullet {
    public static void doSlash(LivingEntity playerIn)
    {
        if (playerIn.level().isClientSide()) return;
        float  speed=4F;
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();

            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int count = 3;

            for (int i = 0; i < count; i++)
            {
                BulletEntity ss = new BulletEntity(LBEntiteRegristrys.be, worldIn);

                worldIn.addFreshEntity(ss);

                ss.setSpeed(speed);
                ss.setIsCritical(true);
                ss.setOwner(playerIn);
                ss.setColor(16711764);
                ss.setRoll(0);
                ss.setDamage(5);
                // force riding
                ss.startRiding(playerIn, true);

                ss.setDelay(10+i);

                boolean isRight = ss.getDelay() % 2 == 0;
                RandomSource random = worldIn.getRandom();

                double xOffset = random.nextDouble() * 2.5 * (isRight ? 1 : -1);
                double yOffset = random.nextFloat() * 2;
                double zOffset = random.nextFloat() * 0.5;

                ss.setPos(playerIn.position().add(xOffset, yOffset, zOffset));
                ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
            }
        });
    }
}
