package com.dinzeer.legendblade.specialattack.HeartBlade;

import com.dinzeer.legendblade.client.render.FlaxyRender;
import com.dinzeer.legendblade.entity.SumonSwordEntityFlaxy;
import com.dinzeer.legendblade.entity.SumonSwordEntityfly;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.attrbute.GetplayerattrUtil;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ICE {
    public static void doSlash(LivingEntity playerIn, int count, float damageadder)
    {
        if (playerIn.level().isClientSide()) return;

        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();

            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int damage= (int) (GetplayerattrUtil.getdamage(playerIn)*0.11);

            for (int i = 0; i < count; i++)
            {
                SumonSwordEntityFlaxy ss = new SumonSwordEntityFlaxy(LBEntiteRegristrys.ssexfla, worldIn);

                worldIn.addFreshEntity(ss);

                ss.setSpeed(3F);
                ss.setIsCritical(false);
                ss.setOwner1(playerIn);

                ss.setColor(917759);
                ss.setRoll(0);
                ss.setDamage(damage*damageadder);
                // force riding
                ss.setPierce((byte) 0);
                ss.setDelay(5+i);
                ss.setIsCritical(true);
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
