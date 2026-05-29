package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.entity.exer.absNeoSummonSword;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.network.PlayMessages;
import org.joml.Vector3f;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SumonSwordEntityNeoForever extends absNeoSummonSword {
    private static final EntityDataAccessor<Boolean> IT_FIRED = SynchedEntityData.defineId(SumonSwordEntityNeoForever.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> CAN_FIRE = SynchedEntityData.defineId(SumonSwordEntityNeoForever.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(SumonSwordEntityNeoForever.class, EntityDataSerializers.FLOAT);
    private static final EntityDataAccessor<Integer> LifeTick = SynchedEntityData.defineId(SumonSwordEntityNeoForever.class, EntityDataSerializers.INT);

    private static final EntityDataAccessor<Vector3f> OFFSET = SynchedEntityData.defineId(SumonSwordEntityNeoForever.class, EntityDataSerializers.VECTOR3);
    long fireTime = -1;

    public SumonSwordEntityNeoForever(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);

        this.setPierce((byte) 0);
    }

    public static SumonSwordEntityNeoForever createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new SumonSwordEntityNeoForever(LBEntiteRegristrys.ssexneoforever, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();

        this.entityData.define(IT_FIRED, false);
        this.entityData.define(CAN_FIRE, false);
        this.entityData.define(SPEED, 3.0f);
        this.entityData.define(OFFSET, Vec3.ZERO.toVector3f());
        this.entityData.define(LifeTick, 20);
    }

    public void doFire() {
        this.getEntityData().set(IT_FIRED, true);
    }
    public void canFire() {
        this.getPersistentData().putBoolean("CanFire",true);
    }

    public boolean itFired() {
        return this.getEntityData().get(IT_FIRED);
    }
    public boolean itCanFired() {
        return this.getPersistentData().getBoolean("CanFire");
    }

    public void setSpeed(float speed) {
        this.getEntityData().set(SPEED, speed);
    }

    public float getSpeed() {
        return this.getEntityData().get(SPEED);
    }
    public int getLifeTick() {
        return this.getEntityData().get(LifeTick);
    }
    public void setLifeTick(int value) {
        this.getEntityData().set(LifeTick, value);
    }
    public void setOffset(Vec3 offset) {
        this.getEntityData().set(OFFSET, offset.toVector3f());
    }

    public Vec3 getOffset() {
        return new Vec3(this.getEntityData().get(OFFSET));
    }
    /**
     * 让一个实体围绕另一个实体做圆周运动。
     *
     * @param follower 跟随的实体。
     * @param leader 被跟随的实体。
     * @param radius 圆周运动的半径。
     * @param speed 旋转速度（每秒的旋转角度）。
     */
    public static void orbitAroundEntity(Entity follower, Entity leader, double radius, float speed,double offsetY) {
        Vec3 leaderPos = leader.position();
        Vec3 followerPos = follower.position();

        // 计算当前的偏移角度
        double offsetX = followerPos.x - leaderPos.x;
        double offsetZ = followerPos.z - leaderPos.z;
        double currentAngle = Math.toDegrees(Math.atan2(offsetZ, offsetX)) - 90.0D;

        // 计算新的角度
        double newAngle = currentAngle + speed;

        // 根据新角度计算新的位置
        double newX = leaderPos.x + radius * Math.cos(Math.toRadians(newAngle));
        double newZ = leaderPos.z + radius * Math.sin(Math.toRadians(newAngle));

        // 设置跟随实体的新位置
        follower.setPos(newX, leaderPos.y+offsetY, newZ);

        // 设置跟随实体的朝向
        float yaw = (float) newAngle;
        follower.setYRot(yaw);
        follower.setYHeadRot(yaw);
    }

    @Override
    protected void onHitBlock(BlockHitResult blockraytraceresult) {
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    public void tick() {

        if (!itFired() && level().isClientSide() && getVehicle() == null)
            startRiding(this.getOwner(), true);

        super.tick();

        var sender = getOwner();
        if (sender==null)return;

        Level worldIn = sender.level();
        Vec3 dir = this.getViewVector(0);
        final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
        List<Entity> _entfound = this.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(8), a -> true)
                .stream()
                .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                .toList();

        Optional<Entity> entityiterator = _entfound.stream()
                .filter(e -> e instanceof LivingEntity && ((LivingEntity) e).getHealth() > 0 && e != sender)
                .findFirst();
        if (entityiterator.isEmpty()){
            if (getLifeTick()>0){
                setLifeTick(getLifeTick()-1);
            }
            if (getLifeTick()==0)this.remove(RemovalReason.DISCARDED);
        }else {
            canFire();
            doFire();

            Vec3 targetPos = entityiterator.map((e) -> new Vec3(e.getX(), e.getY() + e.getEyeHeight() * 0.5, e.getZ()))
                    .orElseGet(() ->
                    {

                        Vec3 start = sender.getEyePosition(1.0f);
                        Vec3 end = start.add(sender.getLookAngle().scale(40));
                        HitResult result = worldIn.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sender));
                        return result.getLocation();
                    });
            Vec3 pos = this.getPosition(0.0f);
            dir = targetPos.subtract(pos).normalize();
            this.shoot(dir.x, dir.y, dir.z, getSpeed(), 1f);

        }
    }

    @Override
    public void rideTick() {
        tick();
        if (this.itFired()) {

        } else {
            this.setDeltaMovement(Vec3.ZERO);
            if (this.canUpdate()) {
                this.baseTick();
            }

            this.faceEntityStandby();
            if (200 < this.tickCount ) {
                this.burst();
            }

            if (!this.level().isClientSide()) {
                this.hitCheck();
            }

        }
    }

    private void hitCheck() {
        Vec3 positionVec = this.position();
        Vec3 dirVec = this.getViewVector(1.0F);
        EntityHitResult raytraceresult = null;
        EntityHitResult entityraytraceresult = this.getRayTrace(positionVec, dirVec);
        if (entityraytraceresult != null) {
            raytraceresult = entityraytraceresult;
        }

        if (raytraceresult != null && raytraceresult.getType() == HitResult.Type.ENTITY) {
            Entity entity = raytraceresult.getEntity();
            Entity entity1 = this.getShooter();
            if (entity instanceof Player && entity1 instanceof Player && !((Player)entity1).canHarmPlayer((Player)entity)) {
                raytraceresult = null;
                entityraytraceresult = null;
            }
        }

        if (raytraceresult != null && raytraceresult.getType() == HitResult.Type.ENTITY && !ForgeEventFactory.onProjectileImpact(this, raytraceresult)) {
            this.onHit(raytraceresult);
            this.resetAlreadyHits();
            this.hasImpulse = true;
        }

    }
    private void faceEntityStandby() {
        long cycle = 30L;
        long tickOffset = 0L;
        if (this.level().isClientSide()) {
            tickOffset = 1L;
        }

        int ticks = (int)((this.level().getGameTime() + tickOffset) % cycle);
        double rotParTick = 360.0 / (double)cycle;
        double offset = (double)this.getDelay();
        double degYaw = ((double)ticks * rotParTick + offset) % 360.0;
        double yaw = Math.toRadians(degYaw);
        Vec3 dir = new Vec3(0.0, 0.0, 1.0);
        dir = dir.yRot((float)(-yaw));
        dir = dir.normalize().scale(2.0);
        if (this.getVehicle() != null) {
            dir = dir.add(this.getVehicle().position());
            dir = dir.add(0.0, (double)this.getVehicle().getEyeHeight() / 2.0, 0.0);
        }

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.setPos(dir);
        this.setRot((float)(-degYaw), 0.0F);
    }
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        Entity targetEntity = p_213868_1_.getEntity();
        if (targetEntity instanceof ServerPlayer player){
            if (player.isCreative())return;
        }
        if (targetEntity instanceof LivingEntity a) {
            KnockBacks.cancel.action.accept(a);
            StunManager.setStun(a);
            a.invulnerableTime=0;
        }

        super.onHitEntity(p_213868_1_);
    }



}
