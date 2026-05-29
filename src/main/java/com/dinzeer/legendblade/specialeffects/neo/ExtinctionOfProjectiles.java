package com.dinzeer.legendblade.specialeffects.neo;

import com.dinzeer.legendblade.entity.SumonSwordEntityEX;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.exfantasy.mclib.Utils.RandomUtil.RandomNumber;
import com.exfantasy.mclib.Utils.color.RandomColor;
import mods.flammpfeil.slashblade.capability.concentrationrank.CapabilityConcentrationRank;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Comparator;
import java.util.List;

import static twilightforest.util.TFItemStackUtils.damage;

@Mod.EventBusSubscriber
public class ExtinctionOfProjectiles extends SpecialEffectEx{
    public ExtinctionOfProjectiles() {
        super(120);
    }

    @SubscribeEvent
    public static void hurt(LivingHurtEvent event){
        LivingEntity entity = event.getEntity();
        if (entity instanceof Player player){
            if (event.getSource().getDirectEntity() instanceof Projectile projectile) {
                if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.ExtinctionOfProjectiles.getId())) {
                    Entity entity1 = event.getSource().getEntity();
                    if (entity1 !=null){
                        entity1.hurt(new DamageSource(entity1.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MOB_PROJECTILE), entity), event.getAmount()*0.4f);
                    }
                    event.setAmount(event.getAmount()*0.1f);
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,20,3));
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,50,1));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,50,2));
                }
            }
        }
    }
    @SubscribeEvent
    public static void doSlash(SlashBladeEvent.DoSlashEvent event){
        LivingEntity player = event.getUser();
        if (hasSpecialEffect(player.getMainHandItem(), LBSpecialEffectsRegistry.ExtinctionOfProjectiles.getId())) {
            final Vec3 _center = player.position();
            List<Entity> _entfound = player.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(5), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
            for (Entity entityiterator : _entfound) {
                if (entityiterator instanceof Projectile projectile){
                    if (projectile.getOwner() !=player){
                        
                        
                        player.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).ifPresent((state) -> {

                            Level worldIn = player.level();

                            int rank = player.getCapability(CapabilityConcentrationRank.RANK_POINT).map(r -> r.getRank(worldIn.getGameTime()).level).orElse(0);



                                SumonSwordEntityEX ss = new SumonSwordEntityEX(LBEntiteRegristrys.ssex, worldIn);

                                worldIn.addFreshEntity(ss);
                                ss.setSpeed((float) (projectile.getDeltaMovement().x + projectile.getDeltaMovement().y + projectile.getDeltaMovement().z)*0.5f);
                                ss.setIsCritical(false);
                                ss.setOwner(player);
                                ss.setColor(RandomColor.returnner(RandomNumber.randomint(94)));
                                ss.setRoll(0);
                                ss.setDamage(getPlayerDamage(player) *1.75f);
                                // force riding
                                ss.startRiding(player, true);
                                ss.setPierce((byte) 0);
                                ss.setDelay(0);

                                boolean isRight = ss.getDelay() % 2 == 0;
                                RandomSource random = worldIn.getRandom();

                                double xOffset = random.nextDouble() * 2.5 * (isRight ? 1 : -1);
                                double yOffset = random.nextFloat() * 2;
                                double zOffset = random.nextFloat() * 0.5;

                                ss.setPos(player.position().add(xOffset, yOffset, zOffset));
                                ss.setOffset(new Vec3(xOffset, yOffset, zOffset));

                            if (player.level() instanceof ServerLevel level){
                                level.sendParticles(ParticleTypes.SOUL,player.getX() + xOffset,player.getY() +yOffset,player.getZ() + zOffset,8,0.4,0.4,0.4,0.4);
                            }
                                player.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);

                            projectile.remove(Entity.RemovalReason.DISCARDED);
                        });
                    }
                }
}
            }
    }
}
