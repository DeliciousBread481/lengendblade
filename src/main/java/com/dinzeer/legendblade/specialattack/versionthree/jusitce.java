package com.dinzeer.legendblade.specialattack.versionthree;

import com.dinzeer.legendblade.entity.SpSumonSwordEntity;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.attrbute.GetplayerattrUtil;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.slasharts.CircleSlash;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

import static java.lang.Math.*;

public class jusitce {

    public static void dojusitceSlash(LivingEntity playerIn, double damage, float speed, int y) {
        dojusitceSlash(playerIn,20,damage,speed,y);
        dojusitceSlash(playerIn,20,damage,speed,y+1);
    }
    public static void doultraSlash(LivingEntity playerIn, double damage, float speed, int y) {
        doultraSlash(playerIn,20,damage,speed,y);
        doultraSlash(playerIn,20,damage,speed,y+1);
        doultraSlash2(playerIn,20,damage,speed,y);
        doultraSlash2(playerIn,20,damage,speed,y+1);
    }
    public static void dorotSlash(LivingEntity playerIn, double damage, float speed, int y) {
        doRotSlash(playerIn,20,damage,speed,y);
    }
    public static void docrotSlash(LivingEntity entityIn, double damage, float speed, int y) {
        CircleSlash.doCircleSlashAttack(entityIn, 180);
        CircleSlash.doCircleSlashAttack(entityIn, 90);
        CircleSlash.doCircleSlashAttack(entityIn, 70);
        CircleSlash.doCircleSlashAttack(entityIn, -90);
        CircleSlash.doCircleSlashAttack(entityIn, 160);
        CircleSlash.doCircleSlashAttack(entityIn, 32);
        CircleSlash.doCircleSlashAttack(entityIn, 46);
        CircleSlash.doCircleSlashAttack(entityIn, -79);
        CircleSlash.doCircleSlashAttack(entityIn, 180);
        CircleSlash.doCircleSlashAttack(entityIn, 90);
        CircleSlash.doCircleSlashAttack(entityIn, 70);
        CircleSlash.doCircleSlashAttack(entityIn, -90);
        CircleSlash.doCircleSlashAttack(entityIn, 160);
        CircleSlash.doCircleSlashAttack(entityIn, 32);
        CircleSlash.doCircleSlashAttack(entityIn, 46);
        CircleSlash.doCircleSlashAttack(entityIn, -79);
    }
    public static void dojusitceSlash(LivingEntity playerIn, int lifetime, double damage, float speed,int y) {
        if (playerIn.level().isClientSide()) return;

        int count = 20;
        int colorCode= (Integer) playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map((state) -> {
            return state.getColorCode();
        }).orElse(-13421569);
        Vec3 centerOffset=Vec3.ZERO;
        KnockBacks knockback= KnockBacks.cancel;
        for (int i = 0; i <= count; i += 1 ) {
            EntityDrive driveEx = new EntityDrive(SlashBlade.RegistryEvents.Drive, playerIn.level());
            boolean isRight = i % 2 ==0;

            Vec3 lookAngle = playerIn.getLookAngle();

            double x_ = asin(lookAngle.x);
            double z_ = asin(lookAngle.z);

            Vec3 pos = playerIn.position().add(0.0D, (double) playerIn.getEyeHeight() * 0.75D, 0.0D);

            pos = pos.add(getVectorForRotation(0, playerIn.getViewYRot(0)).scale(centerOffset.y))
                    .add(getVectorForRotation(0, playerIn.getViewYRot(0) + 90).scale(centerOffset.z))
                    .add(lookAngle.scale(centerOffset.z));

            playerIn.level().addFreshEntity(driveEx);
            driveEx.setDamage(damage);
            driveEx.setSpeed(speed);
            driveEx.setDelay(20);

            if (x_ * z_ >= 0) {
                driveEx.setPos(pos.x + sin(x_ + (22.5 * i * PI /180) * (double) (isRight ? 1:-1)),
                        pos.y+y,
                        pos.z + (sin(z_ + (22.5 * (i-1) * PI /180)) * (double) (isRight ? 1:-1)));
                driveEx.shoot(sin(x_ + (22.5 * i * PI /180) * (double) (isRight ? 1:-1)),
                        0.0D,
                        cos(z_ + (22.5 * (i * PI /180)) * (double) (isRight ? 1:-1)),
                        driveEx.getSpeed(),
                        0);
            } else {
                driveEx.setPos(pos.x - sin(x_ + (22.5 * i * PI /180) * (double) (isRight ? 1:-1)),
                        pos.y,
                        pos.z - (sin(z_ + (22.5 * (i-1) * PI /180)) * (double) (isRight ? 1:-1)));
                driveEx.shoot(sin(x_ - (22.5 * i * PI /180) * (double) (isRight ? 1:-1)),
                        0.0D,
                        sin(z_ - (22.5 * (i * PI /180)) * (double) (isRight ? 1:-1)),
                        driveEx.getSpeed(),
                        0);
            }
            driveEx.setOwner(playerIn);

            driveEx.setDelay(20);

            driveEx.setColor(colorCode);
            driveEx.setIsCritical(false);
            driveEx.setNoClip(false);
            driveEx.setKnockBack(knockback);
            driveEx.setLifetime(lifetime);
            if (playerIn != null) {
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT)
                        .ifPresent(rank -> driveEx.setRank(rank.getRankLevel(playerIn.level().getGameTime())));
            }
        }
    }



    public static void doultraSlash(LivingEntity playerIn, int lifetime, double damage, float speed, int y) {
        if (playerIn.level().isClientSide()) return;

        int count = 20;
        int colorCode = (Integer) playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
                .map(state -> state.getColorCode()).orElse(-13421569);

        Vec3 playerLook = playerIn.getLookAngle();
        Vec3 playerPos = playerIn.position()
                .add(0.0, playerIn.getEyeHeight() * 0.75, 0.0)
                .add(playerLook.scale(1.2)); // 基础生成位置前移

        for (int i = 0; i <= count; i++) {
            EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, playerIn.level());

            // 半球形随机方向生成（上半球）
            double theta = Math.toRadians(playerIn.getYRot() + 90 + (Math.random() - 0.5) * 120); // 水平散布±60度
            double phi = Math.toRadians(-30 - Math.random() * 60); // 俯角-30°到-90°（向上）

            Vec3 direction = new Vec3(
                    Mth.sin((float) theta) * Mth.cos((float) phi),
                    Mth.sin((float) -phi), // 反转phi适应Minecraft坐标系
                    Mth.cos((float) theta) * Mth.cos((float) phi)
            ).normalize();

            // 位置偏移增强立体感
            Vec3 spawnPos = playerPos.add(
                    (Math.random() - 0.5) * 1.5 * direction.x,
                    y + (Math.random() - 0.5) * 0.8,
                    (Math.random() - 0.5) * 1.5 * direction.z
            );

            drive.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
            drive.shoot(direction.x, direction.y, direction.z, speed * 1.2f, 12.0f); // 提高散布参数

            // 属性设置（保持不变）
            drive.setDamage(damage);
            drive.setSpeed(speed);
            drive.setOwner(playerIn);
            drive.setColor(colorCode);
            drive.setLifetime(lifetime);
            playerIn.level().addFreshEntity(drive);
        }
    }
    public static void doultraSlash2(LivingEntity playerIn, int lifetime, double damage, float speed, int y) {
        if (playerIn.level().isClientSide()) return;

        int count = 20;
        int colorCode = (Integer) playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
                .map(state -> state.getColorCode()).orElse(-13421569);

        Vec3 playerPos = playerIn.position()
                .add(0.0, playerIn.getEyeHeight() * 0.75, 0.0);

        // 后半球参数（+90°~+270°）
        for (int i = 0; i <= count; i++) {
            EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, playerIn.level());

            // 水平角度：玩家反方向 ±90°
            double theta = Math.toRadians(playerIn.getYRot() + 180 + (Math.random() - 0.5) * 180);
            // 垂直角度：-30°~-60°
            double phi = Math.toRadians(-45 - Math.random() * 30);

            Vec3 direction = new Vec3(
                    Mth.sin((float) theta) * Mth.cos((float) phi),
                    Mth.sin((float) -phi), // 向上
                    Mth.cos((float) theta) * Mth.cos((float) phi)
            ).normalize();

            Vec3 spawnPos = playerPos.add(
                    direction.x * 2.0 + (Math.random() - 0.5) * 1.0,
                    y + (Math.random() - 0.5) * 0.6,
                    direction.z * 2.0 + (Math.random() - 0.5) * 1.0
            );

            drive.setPos(spawnPos.x, spawnPos.y, spawnPos.z);
            drive.shoot(direction.x, direction.y, direction.z, speed * 0.95f, 12.0f);

            // 属性设置（保持不变）
            drive.setDamage(damage);
            drive.setSpeed(speed);
            drive.setOwner(playerIn);
            drive.setColor(colorCode);
            drive.setLifetime(lifetime);
            playerIn.level().addFreshEntity(drive);
        }
    }

    public static void doRotSlash(LivingEntity playerIn, int lifetime, double damage, float speed, int y) {
        if (playerIn.level().isClientSide()) return;

        int colorCode= (Integer) playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map((state) -> {
            return state.getColorCode();
        }).orElse(-13421569);
        Vec3 centerOffset=Vec3.ZERO;
        KnockBacks knockback= KnockBacks.cancel;
        Vec3 pos = playerIn.position().add(0.0D, (double) playerIn.getEyeHeight() * 0.75D, 0.0D)
                .add(playerIn.getLookAngle().scale(0.3f));

        pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, playerIn.getViewYRot(0)).scale(centerOffset.y))
                .add(VectorHelper.getVectorForRotation(0, playerIn.getViewYRot(0) + 90).scale(centerOffset.z))
                .add(playerIn.getLookAngle().scale(centerOffset.z));

            EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, playerIn.level());

            playerIn.level().addFreshEntity(drive);


            drive.setPos(pos.x, pos.y, pos.z);
            drive.setDamage(damage);
            drive.setSpeed(speed);
            drive.shoot(playerIn.getLookAngle().x, playerIn.getLookAngle().y, playerIn.getLookAngle().z, drive.getSpeed(), 0);

            drive.setOwner(playerIn);
            drive.setRoll(90);
            drive.setYRot(360);
            drive.setColor(colorCode);
            drive.setIsCritical(true);
            drive.setKnockBack(knockback);
            drive.setLifetime(lifetime);

            if (playerIn != null)
                playerIn.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT)
                        .ifPresent(rank -> drive.setRank(rank.getRankLevel(playerIn.level().getGameTime())));



    }
    public static void dohealSlash(LivingEntity playerIn, int lifetime, double damage, float speed, int y) {
        if (playerIn.level().isClientSide()) return;
        int colorCode= (Integer) playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map((state) -> {
            return state.getColorCode();
        }).orElse(-13421569);
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {
            Level worldIn = playerIn.level();

            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT)
                    .map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int count = 6; // 物体的数量，均分圆上的位置
            float radius = 2f; // 半径，可以根据需要调整

            Vec3 playerPos = playerIn.position(); // 获取玩家当前位置
            float playerYaw = Mth.wrapDegrees(playerIn.getYRot()); // 获取玩家朝向（Y轴旋转）

            for (int i = 0; i < count; i++) {
                // 计算每个实体的角度（度）
                double angleDeg = 360.0 / count * i;
                // 将角度从度转换为弧度
                double angleRad = Math.toRadians(angleDeg);

                // 使用极坐标转换计算新位置
                double offsetX = radius * Math.cos(angleRad);
                double offsetZ = radius * Math.sin(angleRad);

                // 考虑玩家朝向进行偏移
                double cosYaw = Math.cos(Math.toRadians(playerYaw));
                double sinYaw = Math.sin(Math.toRadians(playerYaw));

                // 应用偏移量到玩家位置
                double finalX = playerPos.x + offsetX * cosYaw - offsetZ * sinYaw;
                double finalZ = playerPos.z + offsetX * sinYaw + offsetZ * cosYaw;

                SpSumonSwordEntity ss = new SpSumonSwordEntity(LBEntiteRegristrys.sps, worldIn);


                ss.setSpeed(speed);
                ss.setIsCritical(false);
                ss.setOwner(playerIn);
                ss.setColor(colorCode);
                ss.setRoll(0);
                ss.setDamage(damage);
                ss.startRiding(playerIn, true);
                ss.setDelay(1);
                SpSumonSwordEntity.setHeal(GetplayerattrUtil.getdamage(playerIn));

                double yOffset = i * 0.005 + 0.5;
                double zOffset = -1.0;

                // 设置实体位置
                ss.setPos(finalX, playerPos.y + yOffset, finalZ);
                ss.setOffset(new Vec3(offsetX, yOffset, offsetZ));
                worldIn.addFreshEntity(ss);
                playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
            }

        });
    }

    static public Vec3 getVectorForRotation(float pitch, float yaw) {
        float f = pitch * ((float) Math.PI / 180F);
        float f1 = -yaw * ((float) Math.PI / 180F);
        float f2 = Mth.cos(f1);
        float f3 = Mth.sin(f1);
        float f4 = Mth.cos(f);
        float f5 = Mth.sin(f);
        return new Vec3((double) (f3 * f4),(double) (-f5), (double) (f2 * f4));
    }

    static public Vec3i f2i(Vec3 src) {
        return  new Vec3i(Mth.floor(src.x),Mth.floor(src.y),Mth.floor(src.z));
    }

    static public Vec3i f2i(double x,double y,double z) {
        return new Vec3i(Mth.floor(x),Mth.floor(y),Mth.floor(z));
    }

    static public Matrix4f matrix4fFromArray(float[] in) {
        return new Matrix4f(in[0], in[1], in[2], in[3], in[4], in[5], in[6],
                in[7], in[8], in[9], in[10], in[11], in[12], in[13], in[14], in[15]);
    }
}
