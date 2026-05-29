package com.dinzeer.legendblade.specialattack.versiontwo;

import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.client.renderer.entity.DriveRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.JudgementCutRenderer;
import mods.flammpfeil.slashblade.entity.EntityJudgementCut;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.util.RayTraceHelper;
import mods.flammpfeil.slashblade.util.TargetSelector;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class JudgementCutExBig {
    public JudgementCutExBig() {
    }

    public static EntityJudgementCut doJudgementCutJust(LivingEntity user) {
        EntityJudgementCut sa = doJudgementCut(user);
        sa.setDamage(sa.getDamage()*14 );
        sa.setIsCritical(true);
        return sa;
    }

    public static EntityJudgementCut doJudgementCut(LivingEntity user) {
        Level worldIn = user.level();
        Vec3 eyePos = user.getEyePosition(1.0F);
        double airReach = 5.0;
        double entityReach = 7.0;
        ItemStack stack = user.getMainHandItem();
        Optional<Vec3> resultPos = (Optional)stack.getCapability(ItemSlashBlade.BLADESTATE).filter((s) -> {
            return s.getTargetEntity(worldIn) != null;
        }).map((s) -> {
            return Optional.of(s.getTargetEntity(worldIn).getEyePosition(1.0F));
        }).orElseGet(() -> {
            return Optional.empty();
        });
        if (!resultPos.isPresent()) {
            Optional<HitResult> raytraceresult = RayTraceHelper.rayTrace(worldIn, user, eyePos, user.getLookAngle(), 5.0, 7.0, (entity) -> {
                return !entity.isSpectator() && entity.isAlive() && entity.isPickable() && entity != user;
            });
            resultPos = raytraceresult.map((rtr) -> {
                Vec3 pos = null;
                HitResult.Type type = rtr.getType();
                switch (type) {
                    case ENTITY:
                        Entity target = ((EntityHitResult)rtr).getEntity();
                        pos = target.position().add(0.0, (double)(target.getEyeHeight() / 2.0F), 0.0);
                        break;
                    case BLOCK:
                        Vec3 hitVec = rtr.getLocation();
                        pos = hitVec;
                }

                return pos;
            });
        }

        Vec3 pos = (Vec3)resultPos.orElseGet(() -> {
            return eyePos.add(user.getLookAngle().scale(5.0));
        });
        EntityJudgementCut jc = new EntityJudgementCut(SlashBlade.RegistryEvents.JudgementCut, worldIn);

        jc.setPos(pos.x, pos.y, pos.z);
        jc.setOwner(user);
        jc.getDimensions(jc.getPose()).scale(2f,2.1f);
        stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {
            jc.setDamage(1);
            jc.setColor(state.getColorCode());
            jc.setLifetime(120);
            jc.setCycleHit(true);
        });
        if (user != null) {
            user.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT).ifPresent((rank) -> {
                jc.setRank(rank.getRankLevel(worldIn.getGameTime()));
            });
        }

        worldIn.addFreshEntity(jc);
        worldIn.playSound((Player)null, jc.getX(), jc.getY(), jc.getZ(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 0.5F, 0.8F / (user.getRandom().nextFloat() * 0.4F + 0.8F));
        return jc;
    }

    //public static void doJudgementCutSuper(LivingEntity owner) {
   //     doJudgementCutSuper(owner, (List)null);
   // }


}
