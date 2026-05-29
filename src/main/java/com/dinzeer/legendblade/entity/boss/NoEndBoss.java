package com.dinzeer.legendblade.entity.boss;

import com.dinzeer.legendblade.CustomItemUtil;
import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.data.LegendBuiltInRegsitry;
import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.entity.SumonSwordEntityNeoForever;
import com.dinzeer.legendblade.events.SevenSwordSkill;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.specialattack.versionone.JudgementCutEx;
import com.dinzeer.legendblade.specialattack.versionone.SommonSwordSommon;
import com.dinzeer.legendblade.specialattack.versiontwo.SwordRain;
import com.exfantasy.mclib.Utils.Dash.DashMessage;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.PathGenerator;
import com.exfantasy.mclib.Utils.RandomUtil.RandomNumber;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import com.exfantasy.mclib.Utils.color.RandomColor;
import com.google.common.collect.ImmutableList;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.EntityJudgementCut;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import mods.flammpfeil.slashblade.util.TargetSelector;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.EndCrystalItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.network.PlayMessages;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.*;
import java.util.function.Predicate;

@Mod.EventBusSubscriber
public class NoEndBoss extends Monster implements PowerableMob, RangedAttackMob {
    @SubscribeEvent
    public static void GenerateBoss(PlayerInteractEvent.RightClickItem event){
        Player player = event.getEntity();
            if (!(player instanceof ServerPlayer player1))return;
            if (player1.getMainHandItem().getItem() == Items.NETHER_STAR){
                var entities = player1.level().getEntities(player1, AABB.ofSize(player1.getOnPos().getCenter(), 5 * 2, 5, 5 * 2));
                for (var a : entities) {
                    if (a instanceof EndCrystal) {
                        if (player1.level().getBlockState(a.getOnPos().offset(0, -2, 0)).getBlock() == Blocks.BEDROCK) {
                            if (player1.level().getBlockState(a.getOnPos().offset(0, -1, 0)).getBlock() == Blocks.BEDROCK) {
                                NoEndBoss p46964 = new NoEndBoss(LBEntiteRegristrys.other.NOEND.get(), player1.level());
                                player1.level().addFreshEntity(p46964);
                                p46964.setPos(a.getOnPos().getCenter());
                                a.remove(RemovalReason.DISCARDED);
                                ((ServerLevel) player1.level()).sendParticles(ParticleTypes.END_ROD,a.getX(),a.getY(),a.getZ(),50,1,1,1,1);
                                player1.getMainHandItem().shrink(1);
                                player1.playSound(SoundEvents.ENDER_DRAGON_SHOOT,1,1);
                                break;

                            }
                        }
                    }
                }
            }
    }
    private static final EntityDataAccessor<Integer> DATA_TARGET_A = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TARGET_B = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_TARGET_C = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.INT);
    private static final List<EntityDataAccessor<Integer>> DATA_TARGETS = ImmutableList.of(DATA_TARGET_A, DATA_TARGET_B, DATA_TARGET_C);
    private static final EntityDataAccessor<Integer> DATA_ID_INV = SynchedEntityData.defineId(WitherBoss.class, EntityDataSerializers.INT);
    private static final int INVULNERABLE_TICKS = 220;
    private final float[] xRotHeads = new float[2];
    private final float[] yRotHeads = new float[2];
    private final float[] xRotOHeads = new float[2];
    private final float[] yRotOHeads = new float[2];
    private final int[] nextHeadUpdate = new int[2];
    private final int[] idleHeadUpdates = new int[2];
    private int destroyBlocksTick;
    public int getInvulnerableTicks() {
        return this.entityData.get(DATA_ID_INV);
    }
    private final ServerBossEvent bossEvent = (ServerBossEvent)(new ServerBossEvent(this.getDisplayName(), BossEvent.BossBarColor.PURPLE, BossEvent.BossBarOverlay.PROGRESS)).setDarkenScreen(true);
    private static final Predicate<LivingEntity> LIVING_ENTITY_SELECTOR = (p_31504_) -> {
        return p_31504_.getMobType() != MobType.UNDEAD && p_31504_.attackable();
    };
    private static final TargetingConditions TARGETING_CONDITIONS = TargetingConditions.forCombat().range(20.0D).selector(LIVING_ENTITY_SELECTOR);



    protected PathNavigation createNavigation(Level p_186262_) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, p_186262_);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        flyingpathnavigation.setCanPassDoors(true);
        return flyingpathnavigation;
    }

    class WitherDoNothingGoal extends Goal {
        public WitherDoNothingGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP, Flag.LOOK));
        }

        public boolean canUse() {
            return NoEndBoss.this.getInvulnerableTicks() > 0;
        }
    }
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new WitherDoNothingGoal());
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, LivingEntity.class, 0, false, false, LIVING_ENTITY_SELECTOR));
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DATA_TARGET_A, 0);
        this.entityData.define(DATA_TARGET_B, 0);
        this.entityData.define(DATA_TARGET_C, 0);
        this.entityData.define(DATA_ID_INV, 0);
    }

    public void addAdditionalSaveData(CompoundTag p_31485_) {
        super.addAdditionalSaveData(p_31485_);
        p_31485_.putInt("Invul", this.getInvulnerableTicks());
    }

    public void readAdditionalSaveData(CompoundTag p_31474_) {
        super.readAdditionalSaveData(p_31474_);
        this.setInvulnerableTicks(p_31474_.getInt("Invul"));
        if (this.hasCustomName()) {
            this.bossEvent.setName(this.getDisplayName());
        }

    }
    public NoEndBoss(PlayMessages.SpawnEntity packet, Level world) {
        this(LBEntiteRegristrys.other.NOEND.get(), world);
    }

    public NoEndBoss(EntityType<NoEndBoss> p_31437_, Level p_31438_) {
        super(p_31437_, p_31438_);

        this.moveControl = new FlyingMoveControl(this, 10, false);

        this.setHealth(this.getMaxHealth());
        this.xpReward = 50;
        try {
            this.setItemSlot(
                    EquipmentSlot.MAINHAND,((SlashBladeDefinition) SlashBlade.getSlashBladeDefinitionRegistry(this.level()).get(LegendBuiltInRegsitry.blackcloud.location())).getBlade());
            ;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    private double getHeadX(int p_31515_) {
        if (p_31515_ <= 0) {
            return this.getX();
        } else {
            float f = (this.yBodyRot + (float)(180 * (p_31515_ - 1))) * ((float)Math.PI / 180F);
            float f1 = Mth.cos(f);
            return this.getX() + (double)f1 * 1.3D;
        }
    }

    private double getHeadY(int p_31517_) {
        return p_31517_ <= 0 ? this.getY() + 3.0D : this.getY() + 2.2D;
    }

    private double getHeadZ(int p_31519_) {
        if (p_31519_ <= 0) {
            return this.getZ();
        } else {
            float f = (this.yBodyRot + (float)(180 * (p_31519_ - 1))) * ((float)Math.PI / 180F);
            float f1 = Mth.sin(f);
            return this.getZ() + (double)f1 * 1.3D;
        }
    }
    public void setInvulnerableTicks(int p_31511_) {
        this.entityData.set(DATA_ID_INV, p_31511_);
    }

    public int getAlternativeTarget(int p_31513_) {
        return this.entityData.get(DATA_TARGETS.get(p_31513_));
    }

    public void setAlternativeTarget(int p_31455_, int p_31456_) {
        this.entityData.set(DATA_TARGETS.get(p_31455_), p_31456_);
    }
    public void aiStep() {
        Vec3 vec3 = this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D);
        if (!this.level().isClientSide && this.getAlternativeTarget(0) > 0) {
            Entity entity = this.level().getEntity(this.getAlternativeTarget(0));
            if (entity != null) {
                double d0 = vec3.y;
                if (this.getY() < entity.getY() || !this.isPowered() && this.getY() < entity.getY() + 5.0D) {
                    d0 = Math.max(0.0D, d0);
                    d0 += 0.3D - d0 * (double)0.6F;
                }

                vec3 = new Vec3(vec3.x, d0, vec3.z);
                Vec3 vec31 = new Vec3(entity.getX() - this.getX(), 0.0D, entity.getZ() - this.getZ());
                if (vec31.horizontalDistanceSqr() > 9.0D) {
                    Vec3 vec32 = vec31.normalize();
                    vec3 = vec3.add(vec32.x * 0.3D - vec3.x * 0.6D, 0.0D, vec32.z * 0.3D - vec3.z * 0.6D);
                }
            }
        }

        this.setDeltaMovement(vec3);
        if (vec3.horizontalDistanceSqr() > 0.05D) {
            this.setYRot((float) Mth.atan2(vec3.z, vec3.x) * (180F / (float)Math.PI) - 90.0F);
        }

        super.aiStep();

        for(int i = 0; i < 2; ++i) {
            this.yRotOHeads[i] = this.yRotHeads[i];
            this.xRotOHeads[i] = this.xRotHeads[i];
        }

        for(int j = 0; j < 2; ++j) {
            int k = this.getAlternativeTarget(j + 1);
            Entity entity1 = null;
            if (k > 0) {
                entity1 = this.level().getEntity(k);
            }

            if (entity1 != null) {
                double d9 = this.getHeadX(j + 1);
                double d1 = this.getHeadY(j + 1);
                double d3 = this.getHeadZ(j + 1);
                double d4 = entity1.getX() - d9;
                double d5 = entity1.getEyeY() - d1;
                double d6 = entity1.getZ() - d3;
                double d7 = Math.sqrt(d4 * d4 + d6 * d6);
                float f = (float)(Mth.atan2(d6, d4) * (double)(180F / (float)Math.PI)) - 90.0F;
                float f1 = (float)(-(Mth.atan2(d5, d7) * (double)(180F / (float)Math.PI)));
                this.xRotHeads[j] = this.rotlerp(this.xRotHeads[j], f1, 40.0F);
                this.yRotHeads[j] = this.rotlerp(this.yRotHeads[j], f, 10.0F);
            } else {
                this.yRotHeads[j] = this.rotlerp(this.yRotHeads[j], this.yBodyRot, 10.0F);
            }
        }

        boolean flag = this.isPowered();

        for(int l = 0; l < 3; ++l) {
            double d8 = this.getHeadX(l);
            double d10 = this.getHeadY(l);
            double d2 = this.getHeadZ(l);
            this.level().addParticle(ParticleTypes.SMOKE, d8 + this.random.nextGaussian() * (double)0.3F, d10 + this.random.nextGaussian() * (double)0.3F, d2 + this.random.nextGaussian() * (double)0.3F, 0.0D, 0.0D, 0.0D);
            if (flag && this.level().random.nextInt(4) == 0) {
                this.level().addParticle(ParticleTypes.ENTITY_EFFECT, d8 + this.random.nextGaussian() * (double)0.3F, d10 + this.random.nextGaussian() * (double)0.3F, d2 + this.random.nextGaussian() * (double)0.3F, (double)0.7F, (double)0.7F, 0.5D);
            }
        }

        if (this.getInvulnerableTicks() > 0) {
            for(int i1 = 0; i1 < 3; ++i1) {
                this.level().addParticle(ParticleTypes.ENTITY_EFFECT, this.getX() + this.random.nextGaussian(), this.getY() + (double)(this.random.nextFloat() * 3.3F), this.getZ() + this.random.nextGaussian(), (double)0.7F, (double)0.7F, (double)0.9F);
            }
        }

    }
    private float rotlerp(float p_31443_, float p_31444_, float p_31445_) {
        float f = Mth.wrapDegrees(p_31444_ - p_31443_);
        if (f > p_31445_) {
            f = p_31445_;
        }

        if (f < -p_31445_) {
            f = -p_31445_;
        }

        return p_31443_ + f;
    }
    protected void customServerAiStep() {
        if (this.getInvulnerableTicks() > 0) {
            int k1 = this.getInvulnerableTicks() - 1;
            this.bossEvent.setProgress(1.0F - (float)k1 / 220.0F);
            if (k1 <= 0) {
                this.level().explode(this, this.getX(), this.getEyeY(), this.getZ(), 7.0F, false, Level.ExplosionInteraction.MOB);
                if (!this.isSilent()) {
                    this.level().globalLevelEvent(1023, this.blockPosition(), 0);
                }
            }

            this.setInvulnerableTicks(k1);
            if (this.tickCount % 10 == 0) {
                this.heal(10.0F);
            }

        } else {
            super.customServerAiStep();

            for(int i = 1; i < 3; ++i) {
                if (this.tickCount >= this.nextHeadUpdate[i - 1]) {
                    this.nextHeadUpdate[i - 1] = this.tickCount + 10 + this.random.nextInt(10);
                    if (this.level().getDifficulty() == Difficulty.NORMAL || this.level().getDifficulty() == Difficulty.HARD) {
                        int i3 = i - 1;
                        int j3 = this.idleHeadUpdates[i - 1];
                        this.idleHeadUpdates[i3] = this.idleHeadUpdates[i - 1] + 1;
                        if (j3 > 15) {
                            float f = 10.0F;
                            float f1 = 5.0F;
                            double d0 = Mth.nextDouble(random, this.getX() - 10.0D, this.getX() + 10.0D);
                            double d1 = Mth.nextDouble(random, this.getY() - 5.0D, this.getY() + 5.0D);
                            double d2 = Mth.nextDouble(random, this.getZ() - 10.0D, this.getZ() + 10.0D);
                            this.performRangedAttack(i + 1, d0, d1, d2, true);
                            this.idleHeadUpdates[i - 1] = 0;
                        }
                    }

                    int l1 = this.getAlternativeTarget(i);
                    if (l1 > 0) {
                        LivingEntity livingentity = (LivingEntity)this.level().getEntity(l1);
                        if (livingentity != null && this.canAttack(livingentity) && !(this.distanceToSqr(livingentity) > 900.0D) && this.hasLineOfSight(livingentity)) {
                            this.performRangedAttack(i + 1, livingentity);
                            this.nextHeadUpdate[i - 1] = this.tickCount + 40 + this.random.nextInt(20);
                            this.idleHeadUpdates[i - 1] = 0;
                        } else {
                            this.setAlternativeTarget(i, 0);
                        }
                    } else {
                        List<LivingEntity> list = this.level().getNearbyEntities(LivingEntity.class, TARGETING_CONDITIONS, this, this.getBoundingBox().inflate(20.0D, 8.0D, 20.0D));
                        if (!list.isEmpty()) {
                            if (getHealth()<getMaxHealth()*0.5f){
                                ArrayList<Entity> exclude = new ArrayList<>(List.of(this));
                      doJudgementCutSuper(this, exclude);
                            //    this.moveControl = new MoveControl(this);
                            }
                            LivingEntity livingentity1 = list.get(this.random.nextInt(list.size()));
                            this.setAlternativeTarget(i, livingentity1.getId());
                        }
                    }
                }
            }

            if (this.getTarget() != null) {
                this.setAlternativeTarget(0, this.getTarget().getId());
            } else {
                this.setAlternativeTarget(0, 0);
            }

            if (this.destroyBlocksTick > 0) {
                --this.destroyBlocksTick;
                if (this.destroyBlocksTick == 0 && ForgeEventFactory.getMobGriefingEvent(this.level(), this)) {
                    int j1 = Mth.floor(this.getY());
                    int i2 = Mth.floor(this.getX());
                    int j2 = Mth.floor(this.getZ());
                    boolean flag = false;

                    for(int j = -1; j <= 1; ++j) {
                        for(int k2 = -1; k2 <= 1; ++k2) {
                            for(int k = 0; k <= 3; ++k) {
                                int l2 = i2 + j;
                                int l = j1 + k;
                                int i1 = j2 + k2;
                                BlockPos blockpos = new BlockPos(l2, l, i1);
                                BlockState blockstate = this.level().getBlockState(blockpos);
                                if (blockstate.canEntityDestroy(this.level(), blockpos, this) && ForgeEventFactory.onEntityDestroyBlock(this, blockpos, blockstate)) {
                                    flag = this.level().destroyBlock(blockpos, true, this) || flag;
                                }
                            }
                        }
                    }

                    if (flag) {
                        this.level().levelEvent((Player)null, 1022, this.blockPosition(), 0);
                    }
                }
            }

            if (this.tickCount % 20 == 0) {
                this.heal(1.0F);
            }

            this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
        }
    }

    public static void doJudgementCutSuper(LivingEntity owner, List<Entity> exclude) {
        Level level = owner.level();
        ItemStack stack = owner.getMainHandItem();
        int radius = 25;
        var founds = level.getEntities(owner, AABB.ofSize(owner.getOnPos().getCenter(), radius * 2, radius *2, radius * 2));
        if (exclude != null) {
            founds.removeAll(exclude);
        }

        for (var e : founds) {
            if (e instanceof LivingEntity entity) {
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 10));
                EntityJudgementCut judgementCut = new EntityJudgementCut(SlashBlade.RegistryEvents.JudgementCut, level);
                judgementCut.setPos(entity.getX(), entity.getY(), entity.getZ());
                judgementCut.setOwner(owner);
                stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {
                    judgementCut.setColor(state.getColorCode());
                });
                owner.getCapability(ConcentrationRankCapabilityProvider.RANK_POINT).ifPresent((rank) -> {
                    judgementCut.setRank(rank.getRankLevel(level.getGameTime()));
                });
                level.addFreshEntity(judgementCut);


            }
        }

        level.playSound(owner, owner.blockPosition(), SoundEvents.ENDERMAN_TELEPORT, SoundSource.PLAYERS, 1.0F, 1.0F);
    }
    private void performRangedAttack(int i, double d0, double d1, double d2, boolean b) {
        for (int a = 0; a < i+5 ; a++) {
            Legendblade.queueServerWork(a,()->{
             //   doSlash(this, RandomColor.returnner(RandomNumber.randomint(94)), false, this.getAttributeValue(Attributes.ATTACK_DAMAGE), 1.4f);

            int count = 4;
            for (int d = 0; d < count; d++) {
                int finalI = d;
                SumonSwordEntityNeoForever ss = new SumonSwordEntityNeoForever(LBEntiteRegristrys.ssexneoforever, this.level());

                this.level().addFreshEntity(ss);

                ss.setSpeed(1.0f);

                ss.setOwner(this);
                ss.setColor(RandomColor.returnner(RandomNumber.randomint(94)));
                ss.setRoll(0);
                ss.setDamage(this.getAttributeValue(Attributes.ATTACK_DAMAGE)*0.1f);
                // force riding
                ss.startRiding(this, true);

                ss.setDelay(360 / count * finalI);
                ss.setLifeTick(160);


            }
                Vec3 pos = this.position().add(0.0D, (double) this.getEyeHeight() * 0.75D, 0.0D)
                        .add(this.getLookAngle().scale(0.3f));
                Vec3 centerOffset = new Vec3(0.0D, 0.0D, 0.0D);
                pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, this.getViewYRot(0)).scale(centerOffset.y))
                        .add(VectorHelper.getVectorForRotation(0, this.getViewYRot(0) + 90).scale(centerOffset.z))
                        .add(this.getLookAngle().scale(centerOffset.z));

                EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, this.level());

                this.level().addFreshEntity(drive);

                drive.setBaseSize(50);
                drive.getDimensions(Pose.STANDING).scale(18, 18);



                drive.setDamage(5f);
                drive.setSpeed(1.2f);
                drive.shoot(pos.x, pos.y, pos.z, drive.getSpeed(), 0);
                drive.setColor(5177599);
                drive.setOwner(this);

                drive.setLifetime(60);
                RandomSource random = this.level().getRandom();
                boolean isRight = i % 2 == 0;
                double xOffset = random.nextDouble() * 2 * (isRight ? 1 : -1);
                double yOffset = random.nextFloat() * 2;
                double zOffset = random.nextFloat() * 0.5;

                drive.setPos(this.position().add(xOffset, yOffset, zOffset));
            });
        }
    }

    @Override
    protected void dropAllDeathLoot(DamageSource p_21192_) {
        super.dropAllDeathLoot(p_21192_);
        this.dropEquipment();
    }

    private void performRangedAttack(int i, LivingEntity livingentity) {
        int count = 4;
        for (int d = 0; d < count; d++) {
            int finalI = d;
            SumonSwordEntityNeoForever ss = new SumonSwordEntityNeoForever(LBEntiteRegristrys.ssexneoforever, this.level());

            this.level().addFreshEntity(ss);

            ss.setSpeed(1.0f);

            ss.setOwner(this);

            ss.setColor(RandomColor.returnner(RandomNumber.randomint(94)));
            ss.setRoll(0);
            ss.setDamage(this.getAttributeValue(Attributes.ATTACK_DAMAGE)*0.1f);
            // force riding
            ss.startRiding(this, true);

            ss.setDelay(360 / count * finalI);
            ss.setLifeTick(160);


        }
        if (Math.random()<0.3){
            a(this,livingentity);
        }else if (Math.random()<0.3){
            for (int a = 0; a < i + 1; a++) {
                Legendblade.queueServerWork(a, () -> {
                    doSlash(this, RandomColor.returnner(RandomNumber.randomint(94)), false, this.getAttributeValue(Attributes.ATTACK_DAMAGE), 1.4f);

                });
            }
        }else {
            for (int a = 0; a < i *2+2; a++) {
                Legendblade.queueServerWork(a, () -> {
                        driveSlash(this,livingentity,i);
                });
            }
        }

    }


    private static void driveSlash(LivingEntity entity,LivingEntity target,int i ){
        Vec3 pos = entity.position().add(0.0D, (double) entity.getEyeHeight() * 0.75D, 0.0D)
                .add(entity.getLookAngle().scale(0.3f));
        Vec3 centerOffset = new Vec3(0.0D, 0.0D, 0.0D);
        pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, entity.getViewYRot(0)).scale(centerOffset.y))
                .add(VectorHelper.getVectorForRotation(0, entity.getViewYRot(0) + 90).scale(centerOffset.z))
                .add(entity.getLookAngle().scale(centerOffset.z));
        EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, entity.level());

        entity.level().addFreshEntity(drive);

        drive.setBaseSize(50);
        drive.getDimensions(Pose.STANDING).scale(18, 18);
        RandomSource random = entity.level().getRandom();

        boolean isRight = i % 2 == 0;
        double xOffset = random.nextDouble() * 2 * (isRight ? 1 : -1);
        double yOffset = random.nextFloat() * 2;
        double zOffset = random.nextFloat() * 0;
        drive.setPos(pos.x +xOffset, pos.y+yOffset, pos.z+zOffset);
        drive.setDamage(5f);
        drive.setSpeed(1.6f);
        Vec3 directionVec = target.position().subtract(entity.position()).normalize();

        drive.shoot(directionVec.x, directionVec.y, directionVec.z, drive.getSpeed(), 0);
        drive.setColor(5177599);
        drive.setOwner(entity);

        drive.setLifetime(60);
    }
            public static void a(LivingEntity entity, LivingEntity tartget2) {
                LivingEntity target =tartget2;
                Vec3 pos = entity.position().add(0.0D, (double) entity.getEyeHeight() * 0.75D, 0.0D)
                        .add(entity.getLookAngle().scale(0.3f));
                Vec3 centerOffset = new Vec3(0.0D, 0.0D, 0.0D);
                pos = pos.add(VectorHelper.getVectorForRotation(-90.0F, entity.getViewYRot(0)).scale(centerOffset.y))
                        .add(VectorHelper.getVectorForRotation(0, entity.getViewYRot(0) + 90).scale(centerOffset.z))
                        .add(entity.getLookAngle().scale(centerOffset.z));
                EntityDrive drive = new EntityDrive(SlashBlade.RegistryEvents.Drive, entity.level());

                entity.level().addFreshEntity(drive);

                drive.setBaseSize(50);
                drive.getDimensions(Pose.STANDING).scale(18, 18);
                drive.getPersistentData().putBoolean("modao", true);


                drive.setPos(pos.x, pos.y, pos.z);
                drive.setDamage(5f);
                drive.setSpeed(1.2f);
                Vec3 directionVec = target.position().subtract(entity.position()).normalize();

                drive.shoot(directionVec.x, directionVec.y, directionVec.z, drive.getSpeed(), 0);
                drive.setColor(5177599);
                drive.setOwner(entity);

                drive.setLifetime(60);
                List<Vec3> vl = PathGenerator.generatePath(Vec3.atCenterOf(entity.blockPosition()), Vec3.atCenterOf(target.blockPosition()));
                for (Vec3 v : vl) {
                    if (entity.level() instanceof ServerLevel serverLevel) {
                        serverLevel.sendParticles(ParticleTypes.DRAGON_BREATH, v.x(), v.y(), v.z(), 4, 0.3, 0.3, 0.3, 0.1);
                        {
                            final Vec3 _center = v;
                            List<Entity> _entfound = serverLevel.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(3 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                            for (Entity entityiterator : _entfound) {
                                if (entityiterator != entity) {
                                    if (entityiterator instanceof LivingEntity) {
                                        entity.heal((float) (entity.getMaxHealth() * 0.01));
                                        entityiterator.invulnerableTime = 0;
                                        entityiterator.hurt(new DamageSource(serverLevel.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) (entity.getAttributeValue(Attributes.ATTACK_DAMAGE) * 1.5 + 2));
                                    }
                                }
                            }
                        }
                    }
                }
                entity.teleportTo(target.getX(), target.getY(), target.getZ());
                if (entity instanceof Player player) {
                    SMoveUtil.sendDashMessage(player, 0, 1.4);}
                else {
                   DashMessage.vmove(entity,0,1.4);
                }
                // player.lookAt(EntityAnchorArgument.Anchor.EYES, target.position().add(0,0.5,0));

                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 2));
                entity.addEffect(new MobEffectInstance(Legendblade.EffectAbout.HIT_DAMAGE.get(), 25, 2));
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 3));


            }

    public static void doSlash(LivingEntity playerIn, int colorCode, boolean critical, double damage, float speed)
    {
        if (playerIn.level().isClientSide()) return;

        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

            Level worldIn = playerIn.level();

            int rank = playerIn.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);
            int count = 5;

            for (int i = 0; i < count; i++)
            {
                SumonSwordEntity ss = new SumonSwordEntity(LBEntiteRegristrys.ss, worldIn);

                worldIn.addFreshEntity(ss);

                ss.setSpeed(speed);
                ss.setIsCritical(critical);
                ss.setOwner(playerIn);
                ss.setColor(colorCode);
                ss.setRoll(0);
                ss.setDamage(damage);
                // force riding
                ss.startRiding(playerIn, true);

                ss.setDelay(5+i);

                boolean isRight = ss.getDelay() % 2 == 0;
                RandomSource random = worldIn.getRandom();

                double xOffset = random.nextDouble() * 5 * (isRight ? 1 : -1);
                double yOffset = random.nextFloat() * 4;
                double zOffset = random.nextFloat() * 0.5;

                ss.setPos(playerIn.position().add(xOffset, yOffset, zOffset));
                ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                playerIn.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);
            }
        });
    }
    /**
     * @deprecated Forge: Use {@link BlockState#canEntityDestroy(BlockGetter, BlockPos, Entity)} instead.
     */
    @Deprecated
    public static boolean canDestroy(BlockState p_31492_) {
        return !p_31492_.isAir() && !p_31492_.is(BlockTags.WITHER_IMMUNE);
    }

    public void makeInvulnerable() {
        this.setInvulnerableTicks(220);
        this.bossEvent.setProgress(0.0F);
        this.setHealth(this.getMaxHealth() / 3.0F);
    }

    public void makeStuckInBlock(BlockState p_31471_, Vec3 p_31472_) {
    }

    public void setCustomName(@Nullable Component p_31476_) {
        super.setCustomName(p_31476_);
        this.bossEvent.setName(this.getDisplayName());
    }
    public void startSeenByPlayer(ServerPlayer p_31483_) {
        super.startSeenByPlayer(p_31483_);
        this.bossEvent.addPlayer(p_31483_);
    }

    public void stopSeenByPlayer(ServerPlayer p_31488_) {
        super.stopSeenByPlayer(p_31488_);
        this.bossEvent.removePlayer(p_31488_);
    }
    @Override
    public boolean alwaysAccepts() {
        return super.alwaysAccepts();
    }
    public static void init() {
    }
    public static AttributeSupplier.@NotNull Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.ATTACK_DAMAGE,3).add(Attributes.MAX_HEALTH, 2000).add(Attributes.MOVEMENT_SPEED, (double)0.6F).add(Attributes.FLYING_SPEED, (double)0.6F).add(Attributes.FOLLOW_RANGE, 40.0D).add(Attributes.ARMOR, 40.0D);
    }

    @Override
    public boolean isPowered() {
        return false;
    }

    @Override
    public void performRangedAttack(LivingEntity p_33317_, float p_33318_) {

    }
}
