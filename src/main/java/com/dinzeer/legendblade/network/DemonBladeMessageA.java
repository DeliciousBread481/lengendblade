package com.dinzeer.legendblade.network;
import com.dinzeer.legendblade.entity.DemonBladeFragments;
import com.dinzeer.legendblade.entity.SumonSwordEntity;
import com.dinzeer.legendblade.entity.SumonSwordEntityEXSeven;
import com.dinzeer.legendblade.events.SwordRawEffect;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.capability.slashblade.SlashBladeState;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.network.NetworkEvent;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
public class DemonBladeMessageA {
    private final int entityId;

    public DemonBladeMessageA(int entityId) {
        this.entityId = entityId;
    }

    public DemonBladeMessageA(FriendlyByteBuf buffer) {
        this(buffer.readInt());
    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(entityId);
    }

    public static void handle(DemonBladeMessageA msg, Supplier<NetworkEvent.Context> ctx) {
        NetworkEvent.Context context = ctx.get();
        LogicalSide side = context.getDirection().getReceptionSide();

        if (side == LogicalSide.SERVER) {
            context.enqueueWork(() -> apply(context.getSender()));
        }
        ctx.get().setPacketHandled(true);
    }

    public static void apply(LivingEntity entity) {
        ItemStack mainHandItem = entity.getMainHandItem();
        ItemStack stack = mainHandItem;
        CompoundTag tag = stack.getTag();
        if (entity.level().isClientSide)return;

        if (tag == null || !SlashbladeUtils.getStringNBT(tag, "translationKey").equals("item.legendblade.sevensword")) {
            return;
        }

        BlockPos center = entity.getOnPos();
        Level level = entity.level();
        List<Entity> entitiesFound = level.getEntitiesOfClass(Entity.class, new AABB(center).inflate(38 / 2d), a -> true)
                .stream()
                .sorted(Comparator.comparingDouble(ent -> ent.distanceToSqr(center.getCenter())))
                .toList();
        Entity entity1 = mainHandItem.getCapability(
                ItemSlashBlade.BLADESTATE
        ).orElse(new SlashBladeState(mainHandItem)).getTargetEntity(level);
        if (entity1 instanceof LivingEntity target) {
            for (var e2 : entitiesFound) {
                if (e2 instanceof DemonBladeFragments demonBladeFragments) {

                    SwordRawEffect.doS(level, entity, mainHandItem, 20, target);
                    demonBladeFragments.remove(Entity.RemovalReason.DISCARDED);
                }
            }
        }
    /*    for (Entity entity2 : entitiesFound) {
            if (entity2 instanceof DemonBladeFragments demonBladeFragments) {
                if (!demonBladeFragments.isFire())return;
                Vec3 _center = entity.position();
       //         if (entity.level() instanceof ServerLevel)
         //           EntityPointer.sendParticleCircle((ServerLevel) entity.level(), entity, ParticleTypes.FLASH, 3, 5);
                //EntityPointer.sendParticleCircle((ServerLevel) entity.level(), entity, ParticleTypes.END_ROD, 3, 3);
                List<Entity> _entfound = entity.level().getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(9 / 2d), a -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
                for (Entity entityiterator : _entfound) {
                    if (entityiterator instanceof LivingEntity) {
                        entityiterator.invulnerableTime = 0;

                        if (entityiterator.level() instanceof ServerLevel)
                            EntityPointer.sendParticleCircle((ServerLevel) entityiterator.level(), entityiterator, ParticleTypes.ENCHANTED_HIT, 1, 2);

                        ((LivingEntity) entityiterator).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 3, (false), (false)));
                        entityiterator.hurt(new DamageSource(entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC), entity), (float) ((((LivingEntity) entity).getAttributeValue(Attributes.ATTACK_DAMAGE)) * 8.3f));

                    }
                }
                demonBladeFragments.remove(Entity.RemovalReason.DISCARDED);

                int colorCode = entity.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state -> state.getColorCode()).orElse(0xFF3333FF);
                SumonSwordEntityEXSeven ss = new SumonSwordEntityEXSeven(LBEntiteRegristrys.ssexs, level);

                level.addFreshEntity(ss);

                ss.setSpeed(1.0f);
                ss.setIsCritical(false);
                ss.setOwner(entity);
                ss.setColor(colorCode);
                ss.setRoll(0);
                ss.setDamage(entity.getAttributeValue(Attributes.ATTACK_DAMAGE)*3.9f);
                // force riding
                ss.setDelay(1);


                double xOffset = 0 ;
                double yOffset = 0.3;
                double zOffset = 0;

                ss.setPos(demonBladeFragments.position().add(xOffset, yOffset, zOffset));

                entity.playSound(SoundEvents.CHORUS_FRUIT_TELEPORT, 0.2F, 1.45F);

            }
        }*/


    }
}
