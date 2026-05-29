package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.entity.exer.absNeoSummonSword;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class SumonSwordEntityFlaxy extends absNeoSummonSword {
    private static final EntityDataAccessor<Boolean> IT_FIRED = SynchedEntityData.defineId(SumonSwordEntityFlaxy.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Float> SPEED = SynchedEntityData.defineId(SumonSwordEntityFlaxy.class, EntityDataSerializers.FLOAT);

    private static final EntityDataAccessor<Vector3f> OFFSET = SynchedEntityData.defineId(SumonSwordEntityFlaxy.class, EntityDataSerializers.VECTOR3);
    long fireTime = -1;
    
    private int searchCooldown = 0;
    private static final int SEARCH_INTERVAL = 5;
    private static final double SEARCH_RADIUS = 12.0;

    public SumonSwordEntityFlaxy(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);

        this.setPierce((byte) 5);
    }

    public static SumonSwordEntityFlaxy createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new SumonSwordEntityFlaxy(LBEntiteRegristrys.ssexfla, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(OWNERIDD, -1);
        this.entityData.define(IT_FIRED, false);
        this.entityData.define(SPEED, 3.0f);
        this.entityData.define(OFFSET, Vec3.ZERO.toVector3f());
    }

    public void doFire() {
        this.getEntityData().set(IT_FIRED, true);
    }

    public boolean itFired() {
        return this.getEntityData().get(IT_FIRED);
    }

    public void setSpeed(float speed) {
        this.getEntityData().set(SPEED, speed);
    }

    public float getSpeed() {
        return this.getEntityData().get(SPEED);
    }

    public void setOffset(Vec3 offset) {
        this.getEntityData().set(OFFSET, offset.toVector3f());
    }

    public Vec3 getOffset() {
        return new Vec3(this.getEntityData().get(OFFSET));
    }

    @Override
    public void tick() {

        if (!itFired() && level().isClientSide() && getVehicle() == null)
            startRiding(this.getOwner(), true);


        super.tick();
        var sender = getOwner1();
        if (sender ==null)return;
        Level worldIn = sender.level();
        Vec3 dir;
        
        if (searchCooldown <= 0) {
            final Vec3 _center = new Vec3(this.getX(), this.getY(), this.getZ());
            List<Entity> _entfound = this.level().getEntitiesOfClass(Entity.class,
                    new AABB(_center, _center).inflate(SEARCH_RADIUS),
                    e -> e instanceof LivingEntity && e.isAlive() && e != getOwner1() && e != this)
                    .stream()
                    .sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center)))
                    .toList();

            searchCooldown = SEARCH_INTERVAL;

            Optional<Entity> entityiterator = _entfound.stream()
                    .filter(e -> e instanceof LivingEntity && ((LivingEntity) e).getHealth() > 0)
                    .findFirst();
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
            this.shoot(dir.x , dir.y , dir.z,getSpeed(),1f );
        } else {
            searchCooldown--;
            Vec3 start = sender.getEyePosition(1.0f);
            Vec3 end = start.add(sender.getLookAngle().scale(40));
            HitResult result = worldIn.clip(new ClipContext(start, end, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, sender));
            Vec3 targetPos = result.getLocation();
            Vec3 pos = this.getPosition(0.0f);
            dir = targetPos.subtract(pos).normalize();
            this.shoot(dir.x , dir.y , dir.z,getSpeed(),1f );
        }
    }

    private static final EntityDataAccessor<Integer> OWNERIDD;
    static {
        OWNERIDD = SynchedEntityData.defineId(SumonSwordEntityFlaxy.class, EntityDataSerializers.INT);
    }

    public @Nullable Entity getOwner1() {
        int id = (Integer)this.entityData.get(OWNERIDD);
        return this.level().getEntity(id);
    }
    public void setOwner1(@Nullable Entity p_37263_) {
        if (p_37263_ != null) {
            this.entityData.set(OWNERIDD, p_37263_.getId());
        } else {
            this.entityData.set(OWNERIDD, -1);
        }

    }
    @Override
    public void rideTick()
    {
        if (itFired() && fireTime <= tickCount)
        {
            faceEntityStandby();
            Entity vehicle = getVehicle();
            Vec3 dir = this.getViewVector(0);
            if (!(vehicle instanceof LivingEntity))
            {
                this.shoot(dir.x, dir.y, dir.z, getSpeed(), 1.0f);
                return;
            }

            LivingEntity sender = (LivingEntity) getVehicle();
            this.stopRiding();

            this.tickCount = 0;












            if (canUpdate()) this.baseTick();

            if (sender instanceof ServerPlayer)
            {
                ((ServerPlayer) sender).playNotifySound(SoundEvents.ENDER_DRAGON_FLAP, SoundSource.PLAYERS, 1.0F, 1.0F);
            }

            return;
        }

        this.setDeltaMovement(Vec3.ZERO);
        if (canUpdate()) this.baseTick();

        faceEntityStandby();

        // lifetime check
        if (!itFired() && getVehicle() instanceof LivingEntity)
        {
            if (tickCount >= getDelay())
            {
                fireTime = tickCount + getDelay();
                doFire();
            }
        }
    }


    protected void faceEntityStandby ()
    {
        Vec3 pos = this.getVehicle().position();
        Vec3 offset = this.getOffset();

        if (this.getVehicle() == null) {
            doFire();
            return;
        }

        offset = offset.xRot((float) Math.toRadians(-this.getVehicle().getXRot()));
        offset = offset.yRot((float) Math.toRadians(-this.getVehicle().getYRot()));

        pos = pos.add(offset);

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();


        setPos(pos);
        setRot(-this.getVehicle().getYRot(), -this.getVehicle().getXRot());
    }
    private IntOpenHashSet alreadyHits;
    protected void onHitEntity(EntityHitResult p_213868_1_) {
        Entity targetEntity = p_213868_1_.getEntity();
        if (targetEntity instanceof LivingEntity a) {
            KnockBacks.cancel.action.accept((LivingEntity)targetEntity);
            StunManager.setStun((LivingEntity)targetEntity);
            a.invulnerableTime=0;
            if (a instanceof Player player) {
            return;
            }
            a.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 180, 1));
            a.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 180, 1));
            a.addEffect(new MobEffectInstance(MobEffects.WITHER, 60, 1));
            a.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 180, 1));
            a.addEffect(new MobEffectInstance(MobEffects.HUNGER, 180, 1));
        }

        int i = Mth.ceil(this.getDamage());
        if (this.getPierce() > 0) {
            if (this.alreadyHits == null) {
                this.alreadyHits = new IntOpenHashSet(5);
            }

            if (this.alreadyHits.size() >= this.getPierce() + 1) {
                this.burst();
                return;
            }

            this.alreadyHits.add(targetEntity.getId());
        }

        if (this.getIsCritical()) {
            i += this.random.nextInt(i / 2 + 2);
        }

        Entity shooter = this.getOwner1();
        DamageSource damagesource;
        if (shooter == null) {
            damagesource = this.damageSources().indirectMagic(this, this);
        } else {
            damagesource = this.damageSources().indirectMagic(this, shooter);
            if (shooter instanceof LivingEntity) {
                Entity hits = targetEntity;
                if (targetEntity instanceof PartEntity) {
                    hits = ((PartEntity)targetEntity).getParent();
                }

                ((LivingEntity)shooter).setLastHurtMob(hits);
            }
        }

        int fireTime = targetEntity.getRemainingFireTicks();
        if (this.isOnFire() && !(targetEntity instanceof EnderMan)) {
            targetEntity.setSecondsOnFire(5);
        }

        targetEntity.invulnerableTime = 0;
        if (targetEntity.hurt(damagesource, (float)i)) {
            Entity hits = targetEntity;
            if (targetEntity instanceof PartEntity) {
                hits = ((PartEntity)targetEntity).getParent();
            }

            if (hits instanceof LivingEntity) {
                LivingEntity targetLivingEntity = (LivingEntity)hits;
                StunManager.setStun(targetLivingEntity);
                if (!this.level().isClientSide() && this.getPierce() <= 0) {
                    this.setHitEntity(hits);
                }

                if (!this.level().isClientSide() && shooter instanceof LivingEntity) {
                    EnchantmentHelper.doPostHurtEffects(targetLivingEntity, shooter);
                    EnchantmentHelper.doPostDamageEffects((LivingEntity)shooter, targetLivingEntity);
                }

                this.affectEntity(targetLivingEntity, this.getPotionEffects(), 1.0);
                if (shooter != null && targetLivingEntity != shooter && targetLivingEntity instanceof Player && shooter instanceof ServerPlayer) {
                    ((ServerPlayer)shooter).playNotifySound(this.getHitEntityPlayerSound(), SoundSource.PLAYERS, 0.18F, 0.45F);
                }
            }

            this.playSound(this.getHitEntitySound(), 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));
            if (this.getPierce() <= 0 && (this.getHitEntity() == null || !this.getHitEntity().isAlive())) {
                this.burst();
            }
        } else {
            targetEntity.setRemainingFireTicks(fireTime);
            this.ticksInAir = 0;
            if (!this.level().isClientSide() && this.getDeltaMovement().lengthSqr() < 1.0E-7) {
                if (this.getPierce() <= 1) {
                    this.burst();
                } else {
                    this.setPierce((byte)(this.getPierce() - 1));
                }
            }
        }

    }


    private int ticksInAir;

}
