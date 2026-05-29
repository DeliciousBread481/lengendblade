package com.dinzeer.legendblade.entity;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.NBTHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.network.PlayMessages;

import java.util.Comparator;
import java.util.List;

public class MoonDriveEntityEX extends Projectile {
    public MoonDriveEntityEX(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
        setDuring(20);
        this.noCulling = true;
    }
    private static final EntityDataAccessor<Integer> DURING ;

    static {
        DURING = SynchedEntityData.defineId(SevenSkillField.class, EntityDataSerializers.INT);

    }
    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(DURING, 5);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        NBTHelper.getNBTCoupler(compound).get("DURING", this::setDuring, new Integer[0]);
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        NBTHelper.getNBTCoupler(compound).put("DURING", new Integer[]{this.getDuring()});
    }
    public static MoonDriveEntityEX createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new MoonDriveEntityEX(LBEntiteRegristrys.mdex, worldIn);
    }
    public void setDuring(int value){
        this.getEntityData().set(DURING, value);
    }
    public int getDuring(){
        return  (Integer)this.getEntityData().get(DURING);
    }
    @Override
    public boolean isInvisible() {
        return false;
    }
    protected void onHitEntity(EntityHitResult result) {
        return;
    }
    public static boolean isInRange(double value, double min,double max) {
        return value >= min && value <= max;
    }



    @Override
    public void tick() {
        super.tick();
        if (getDuring()>0){
            setDuring(getDuring()-1);
            Level level = this.level();
            if (level.isClientSide)return;
            BlockPos center = this.getOnPos();
            List<Entity> entitiesFound = level.getEntitiesOfClass(Entity.class, new AABB(center).inflate(20 / 2d), a -> true)
                    .stream()
                    .sorted(Comparator.comparingDouble(ent -> ent.distanceToSqr(center.getCenter())))
                    .toList();
            for (var e : entitiesFound){
                if (e!=this.getOwner()&&e!=this) {
                    if (e instanceof LivingEntity e1) {
                        if (isInRange(e1.getX(),center.getX()-1,center.getX()+1) &&isInRange(e1.getZ(),center.getZ()-1,center.getZ()+1)){
                            e1.invulnerableTime = 0;
                            e1.addEffect(new MobEffectInstance(MobEffects.WEAKNESS,30,10));
                            e1.addEffect(new MobEffectInstance(MobEffects.WITHER,30,10));
                            e1.addEffect(new MobEffectInstance(Legendblade.EffectAbout.IMPRISON.get(),30,10));
                          if(getOwner() instanceof Player pplayer){
                              Holder.Reference<DamageType> holderOrThrow = e1.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL);
                                var a = holderOrThrow.getTagKeys().toList();
                                holderOrThrow.bindTags(List.of(
                                        DamageTypeTags.BYPASSES_RESISTANCE,
                                        DamageTypeTags.BYPASSES_ARMOR,
                                        DamageTypeTags.BYPASSES_EFFECTS,
                                        DamageTypeTags.BYPASSES_COOLDOWN,
                                        DamageTypeTags.BYPASSES_ENCHANTMENTS,
                                        DamageTypeTags.BYPASSES_INVULNERABILITY,
                                        DamageTypeTags.BYPASSES_SHIELD
                                ));

                              e1.hurt(new DamageSource(holderOrThrow, pplayer), (float) (pplayer.getAttributeValue (Attributes.ATTACK_DAMAGE)*10* (float) (Math.pow(e1.getMaxHealth(),2))));
                                holderOrThrow.bindTags(a);
                          }
                        }
                    }
                }
            }
        }else {
            this.remove(RemovalReason.DISCARDED);

        }
    }
}
