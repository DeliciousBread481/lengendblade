package com.dinzeer.legendblade.specialeffects.sequests;

import com.dinzeer.legendblade.entity.SumonSwordEntityEX;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versionone.DriveSumon;
import com.dinzeer.legendblade.specialattack.versiontwo.FireDrive;
import com.dinzeer.legendblade.specialeffects.neo.SpecialEffectEx;
import com.dinzeer.legendblade.specialeffects.versionone.SummonSword;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.capability.slashblade.ISlashBladeState;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import mods.flammpfeil.slashblade.slasharts.Drive;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class SE47 extends SpecialEffectEx {
    public SE47() {
        super(47);
    }
    @SubscribeEvent
    public static void onDoingSlash(SlashBladeEvent.DoSlashEvent event) {

        ISlashBladeState state = event.getSlashBladeState();
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.CompassionforTorture.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }//写血狐se

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.CompassionforTorture.get(), level)) {//血狐的se
                DriveSumon.doSlash(player,event.getRoll(),20,Vec3.ZERO,false,1F
                        ,0.5F,1F,1, SlashbladeUtils.getcolor(player));

                SumonSwordEntityEX ss = new SumonSwordEntityEX(LBEntiteRegristrys.ssex, player.level());

                player.level().addFreshEntity(ss);

                ss.setSpeed(1);
                ss.setIsCritical(true);
                ss.setOwner(player);
                ss.setColor(SlashbladeUtils.getcolor(player));
                ss.setRoll(90);
                ss.setDamage(10);
                // force riding
                ss.startRiding(player, true);
                ss.setPierce((byte) 0);
                ss.setDelay(10);

                boolean isRight = ss.getDelay() % 2 == 0;
                double xOffset = random.nextDouble() * 7 * (double) (isRight ? 1 : -1);
                double zOffset = (double) random.nextFloat() * 5;
                double yOffset = random.nextFloat() * 7;

                ss.setPos(player.position().add(xOffset, yOffset, zOffset));
                ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);

            }





        }
        if (state.hasSpecialEffect(LBSpecialEffectsRegistry.Anuntraceablehope.getId())) {
            if (!(event.getUser() instanceof Player)) {
                return;
            }//写血狐se

            Player player = (Player)event.getUser();
            RandomSource random = player.getRandom();
            int level = player.experienceLevel;
            if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Anuntraceablehope.get(), level)) {//血狐的se
                DriveSumon.doSlash(player, event.getRoll(), 20, Vec3.ZERO, false, 1F
                        , 1F, 1F, 1, SlashbladeUtils.getcolor(player));



            }




        }
    }

}
