package com.dinzeer.legendblade.events;

import com.dinzeer.legendblade.Config;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.exfantasy.mclib.Utils.RandomUtil.RandomNumber;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Random;

import static com.exfantasy.mclib.Utils.SlashBlade.SlashEffectUtils.hasSpecialEffect;

@Mod.EventBusSubscriber
public class EntityDrop {



    @SubscribeEvent
    public static void PiglinDead(LivingDropsEvent e){
        if (e.getEntity() instanceof Piglin b){
                Random r = new Random();
                Level level = b.level();
                int v = r.nextInt(100);
                if (e.getSource().getDirectEntity() instanceof Player player) {
                    if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                    int lv = player.experienceLevel;
                    if (level.isClientSide) return;
                    if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)) {

                        ItemStack p_32005_ = new ItemStack(LBModItems.avaritia.get());
                        p_32005_.setCount(1);
                        level.addFreshEntity(new ItemEntity(level, b.getX(), b.getY() + 1, b.getZ()
                                , p_32005_));
                    }
                }
            }

    }
    @SubscribeEvent
    public static void EnderManDead(LivingDropsEvent e){
        if (e.getEntity() instanceof EnderMan b){
            Random r = new Random();
            Level level = b.level();
            int v=r.nextInt(100);
            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_ = new ItemStack(LBModItems.superbia.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_));
                }
            }
        }
    }
    @SubscribeEvent
    public static void BlazeDead(LivingDropsEvent e){
        if (e.getEntity() instanceof Blaze b){
            Level level = b.level();
            Random r = new Random();
            int v=r.nextInt(100);
            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_ = new ItemStack(LBModItems.ira.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_));
                }
            }
        }
    }
    @SubscribeEvent
    public static void ZombieDead(LivingDropsEvent e){
        if (e.getEntity() instanceof Zombie b){
            Level level = b.level();
            Random r = new Random();
            int v=r.nextInt(100);
            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_ = new ItemStack(LBModItems.gula.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_));}

            }
        }
    }
    @SubscribeEvent
    public static void WitherDead(LivingDropsEvent e){
        if (e.getEntity() instanceof WitherBoss b){
            Level level = b.level();
            Random r = new Random();
            ItemStack p_32005_ = new ItemStack(LBModItems.god.get());
            p_32005_.setCount(RandomNumber.randomint(3));
            level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                    , p_32005_));

            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_1 = new ItemStack(LBModItems.invidia.get());
                    p_32005_1.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_1));
                }
            }



        }
    }
    @SubscribeEvent
    public static void SliverDead(LivingDropsEvent e){
        if (e.getEntity() instanceof Silverfish b){
            Level level = b.level();
            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_ = new ItemStack(LBModItems.acedia.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_));
                }
            }
        }
    }
    @SubscribeEvent
    public static void WitcheDead(LivingDropsEvent e){
        if (e.getEntity() instanceof Witch b){
            Level level = b.level();
            if (e.getSource().getDirectEntity() instanceof Player player){
                if (!hasSpecialEffect(player.getMainHandItem(), "legendblade:sin"))return;
                int lv=player.experienceLevel;
                if(level.isClientSide)return;
                if (SpecialEffect.isEffective(LBSpecialEffectsRegistry.Sin.get(), lv)){

                    ItemStack p_32005_ = new ItemStack(LBModItems.luxuria.get());
                    p_32005_.setCount(1);
                    level.addFreshEntity(new ItemEntity(level,b.getX(),b.getY()+1,b.getZ()
                            , p_32005_));
                }
            }
        }
    }
    @SubscribeEvent
    public static void entityheal(LivingDropsEvent e){
        LivingEntity entity = e.getEntity();
        Level level = entity.level();
            if (e.getSource().getDirectEntity() instanceof Player player){
                int lv=player.experienceLevel;
                int all;
                if(level.isClientSide)return;
                if (entity.getAttributeBaseValue(Attributes.MAX_HEALTH) >= Config.soul_crystal){
                    ItemStack p_32005_ = new ItemStack(LBModItems.soul_crystal.get());
                    double x=(entity.getMaxHealth()-Config.soul_crystal)/Config.soul_crystal_extra;




                     all= (int) (1+x);
                     if (all>Config.soul_crystal_extra_max){
                         all= (int) Config.soul_crystal_extra_max;
                     }

                    p_32005_.setCount(all);
                    level.addFreshEntity(new ItemEntity(level,entity.getX(),entity.getY()+1,entity.getZ()
                            , p_32005_));
                }
            }

    }
}
