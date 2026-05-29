package com.dinzeer.legendblade.entity;


import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import mods.flammpfeil.slashblade.entity.EntityDrive;
import mods.flammpfeil.slashblade.entity.Projectile;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraftforge.network.PlayMessages;

public class DriveSummonEntityFire extends EntityDrive {
    public DriveSummonEntityFire(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    public static DriveSummonEntityFire createInstance(PlayMessages.SpawnEntity packet, Level worldIn) {
        return new DriveSummonEntityFire(LBEntiteRegristrys.sd, worldIn);
    }

    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();

        Level level = entity.level();
        if (!level.isClientSide()) {
            BlockPos blockpos = entity.blockPosition();
            entity.setSecondsOnFire(8);
            this.playSound(SoundEvents.FIRECHARGE_USE, 5.0F, 1.0F);
            hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.FIREBALL), entity), 8);
        }
        if (entity.isOnFire() && entity.isAlive()) {
            entity.extinguishFire();
        }

    }
}
