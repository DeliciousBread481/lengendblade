package com.dinzeer.legendblade.regsitry.slashblade;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.specialattack.stars.StarEdge;
import com.dinzeer.legendblade.specialattack.versionone.*;
import com.dinzeer.legendblade.specialattack.versionthree.jusitce;
import com.dinzeer.legendblade.specialattack.versiontwo.*;
import com.exfantasy.mclib.Utils.SlashBlade.SlashEffectUtils;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.SlashBlade;
import mods.flammpfeil.slashblade.ability.StunManager;
import mods.flammpfeil.slashblade.event.client.UserPoseOverrider;
import mods.flammpfeil.slashblade.init.DefaultResources;
import mods.flammpfeil.slashblade.registry.combo.ComboState;
import mods.flammpfeil.slashblade.slasharts.CircleSlash;
import mods.flammpfeil.slashblade.slasharts.Drive;
import mods.flammpfeil.slashblade.util.AttackManager;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import com.dinzeer.legendblade.specialattack.versiontwo.BloodThrusts;
import com.dinzeer.legendblade.specialattack.HeartBlade.*;
import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBComboRegsitryA {
    public static final DeferredRegister<ComboState> COMBO_STATES =
            DeferredRegister.create(ComboState.REGISTRY_KEY,MODID);
    public static final RegistryObject<ComboState> Bloodthrusts = COMBO_STATES.register("bloodbirdthrust",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> BloodThrusts.doSlash(entityIn,5F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> sevenbladeslash = COMBO_STATES.register("sevenbladeslash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> Sevenbladeslash.doSlash(entityIn,5F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> MoonDrive = COMBO_STATES.register("moondrive",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> MoonDriveSumon.doSlash(entityIn,90,20,Vec3.ZERO,false,3F,1F,1F,1,0))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> FrogGlaxy = COMBO_STATES.register("frog_glaxy",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, Glaxy::doSlash)
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> saveall = COMBO_STATES.register("save_all",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2,(entityIn) -> SaveAll.doSlash(entityIn,false,-1,2F,10))
                            .put(3,(entityIn) -> SaveAll.doSlash(entityIn,false,-1,1.5F,10))
                            .put(4,(entityIn) -> SaveAll.doSlash(entityIn,false,-1,1F,10))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> elbowstrike = COMBO_STATES.register("elbowstrike",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, Elbowstrike::doSlash)
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> swordRain = COMBO_STATES.register("sword_rain",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(3, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(4, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(5, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(6, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(7, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .put(8, (entityIn) -> SwordRain.doSlash(entityIn,true,2.5F,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> lastMoondrive = COMBO_STATES.register("lastmoondrive",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2,(entityIn) -> LastMoondrive.doSlash(entityIn,Vec3.ZERO))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> MoonDriveEX = COMBO_STATES.register("moondriveex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> EXmoonDrive.doSlash(entityIn,Vec3.ZERO))
                            .put(3, (entityIn) -> EXmoonDrive.doSlash(entityIn,Vec3.ZERO))
                            .put(4, (entityIn) -> EXmoonDrive.doSlash(entityIn,Vec3.ZERO))
                            .put(5, (entityIn) -> EXmoonDrive.doSlash(entityIn,Vec3.ZERO))
                            .put(6, (entityIn) -> EXmoonDrive.doSlash(entityIn,Vec3.ZERO))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> eXmoonDrive =MoonDriveEX;
    public static final RegistryObject<ComboState> sommonSwordSommonEX = COMBO_STATES.register("sommon_sword_sommonex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> SommonSwordSommonEX.doSlash(entityIn,false,5F,3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> THRUSTSUMMONSWORD = COMBO_STATES.register("thrust_summon_sword",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> SommonSwordSommon.doSlash(entityIn,16711680,true,12,3F,1,10,1))
                            .put(3, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, 2, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(4, (entityIn) -> Thrusts.doSlash(entityIn,8F,1))

                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVER = COMBO_STATES.register("all_over",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, 0.1F))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -40F, Vec3.ZERO, false, false, 0.1F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 40F, Vec3.ZERO, false, false, 0.1F))
                            .put(5, (entityIn) -> AttackManager.doSlash(entityIn, 50F, Vec3.ZERO, false, false, 0.1F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, -50F, Vec3.ZERO, false, false, 0.1F))
                            .put(7, (entityIn) -> AttackManager.doSlash(entityIn, -60F, Vec3.ZERO, false, false, 0.1F))
                            .put(8, (entityIn) -> AttackManager.doSlash(entityIn, 60F, Vec3.ZERO, false, false, 0.1F))
                            .put(9, (entityIn) -> AttackManager.doSlash(entityIn, -70F, Vec3.ZERO, false, false, 0.1F))
                            .put(10, (entityIn) -> AttackManager.doSlash(entityIn, 70F, Vec3.ZERO, false, false, 0.1F))
                            .put(11, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.1F))
                            .put(12, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 0.1F))
                            .put(13, (entityIn) -> AttackManager.doSlash(entityIn, 110F, Vec3.ZERO, false, false, 0.1F))
                            .put(14, (entityIn) -> AttackManager.doSlash(entityIn, -110F, Vec3.ZERO, false, false, 0.1F))
                            .put(15, (entityIn) -> AttackManager.doSlash(entityIn, 120F, Vec3.ZERO, false, false, 0.1F))
                            .put(16, (entityIn) -> AttackManager.doSlash(entityIn, -120F, Vec3.ZERO, false, false, 0.1F))
                            .put(17, (entityIn) -> AttackManager.doSlash(entityIn, -130F, Vec3.ZERO, false, false, 0.1F))
                            .put(18, (entityIn) -> AttackManager.doSlash(entityIn, 130F, Vec3.ZERO, false, false, 0.1F))
                            .put(19, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.1F))
                            .put(20, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.1F))


                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> StarSlash = COMBO_STATES.register("starslash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2,(entityIn) -> StarEdge.doSlash(entityIn,Vec3.ZERO))


                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> forever = COMBO_STATES.register("forever",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2,(entityIn) -> Forever.doSlash(entityIn, 16711680,true,80,3F))


                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> SAKURA_END_LEFTEX2 = COMBO_STATES.register("sakura_end_left_ex1",
            ComboState.Builder.newInstance().startAndEnd(1816, 1859).speed(6F).priority(50)
                    .next((entity) -> Legendblade.prefix("sakura_end_right_ex2"))
                    .nextOfTimeout(entity -> Legendblade.prefix("sakura_end_right_ex2"))
                    .clickAction((entityIn) -> AttackManager.doSlash(entityIn, 22.5F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,2)))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .build())
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> SAKURA_END_RIGHTEX = COMBO_STATES.register("sakura_end_right_ex2",
            ComboState.Builder.newInstance().startAndEnd(204, 218).speed(1.1F).priority(50)
                    .next((entity) -> Legendblade.prefix("circle_slash"))
                    .nextOfTimeout(entity -> Legendblade.prefix("circle_slash"))
                    .clickAction((entityIn) -> AttackManager.doSlash(entityIn, 180F - 22.5F, Vec3.ZERO, false, true, SlashEffectUtils.addslashbladesaDamage(entityIn,2)))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .build())
                    .addHitEffect((t, a) -> StunManager.setStun(t, 36))::build);



    public static final RegistryObject<ComboState> CIRCLE_SLASH9 = COMBO_STATES.register("circle_slash",
            ComboState.Builder.newInstance().startAndEnd(725, 743).priority(50)
                    .next(entity -> SlashBlade.prefix("circle_slash"))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(4, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(5, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(6, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 0))
                            .put(7, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90)).build())
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(7 - 3 + 0, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(7 - 3 + 1, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(7 - 3 + 2, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(7 - 3 + 3, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(7 - 3 + 4, (entityIn) -> UserPoseOverrider.setRot(entityIn, 72, true))
                            .put(7 - 3 + 5, (entityIn) -> UserPoseOverrider.resetRot(entityIn)).build())
                    .addHitEffect(StunManager::setStun)::build);

    public static final RegistryObject<ComboState> thrust = COMBO_STATES.register("for_thrust",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> PhantomThrust.doThrust(entityIn,2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Butterfly = COMBO_STATES.register("fly",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, SlashEffectUtils.addslashbladesaDamage(entityIn,1)))
                            .put(3, (entityIn) -> ButterFly.doSlash(entityIn,100,10F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> JudgementCutExbig = COMBO_STATES.register("judgement_cut_ex_big",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1,JudgementCutExBig::doJudgementCut)
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> ThrustEEX = COMBO_STATES.register("thrusteex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> PhantomThrust.doSlash(entityIn,30F*3,true))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> DragonBoost = COMBO_STATES.register("dragon_boost",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 901F, Vec3.ZERO, false, false, 1F))
                            .put(2, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, 5, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(3, (entityIn) -> SommonSwordSommon.doSlash(entityIn,16711680,true,30,3F,1,10,1))
                            .put(4, (entityIn) -> SommonSwordSommon.doSlash(entityIn,16711680,true,30,3F,1,10,1))
                            .put(5,(entityIn)->{
                                entityIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 900, 3));
                                entityIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 900, 3));
                                entityIn.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 900, 3));

                            })
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> BlackHole = COMBO_STATES.register("black_hole",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1,JudgementCutEx::doJudgementCut)
                            .put(3, (entityIn) -> SommonSwordSommon.doSlash(entityIn,16777215,true,10,3F,1,15,1))
                            .put(4, (entityIn) -> SommonSwordSommon.doSlash(entityIn,16777215,true,10,3F,1,15,1))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> kingblade = COMBO_STATES.register("kingblade",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 45F, Vec3.ZERO, false, false, 1F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, -45F, Vec3.ZERO, false, false, 1F))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, 45F, Vec3.ZERO, false, false, 1F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, -45F, Vec3.ZERO, false, false, 1F))
                            .put(5, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, 1, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(6, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false, 1, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(7, (entityIn) -> DriveSumon.doSlash(entityIn, 45F, 20, Vec3.ZERO, false, 1, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))
                            .put(8, (entityIn) -> DriveSumon.doSlash(entityIn, -45F, 20, Vec3.ZERO, false, 1, 1f, 3f, 2, SlashbladeUtils.getcolor(entityIn)))

                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Blackslash = COMBO_STATES.register("black_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 1F))
                            .put(3, (entityIn) -> SommonSwordSommon.doSlash(entityIn,0,true,10,3F,1,30,1))
                            .put(4, (entityIn) -> SommonSwordSommon.doSlash(entityIn,0,true,10,3F,1,30,1))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ThrustSlash = COMBO_STATES.register("thrustslash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> PhantomThrust.doSlash(entityIn,3F*3,true))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, -45F, Vec3.ZERO, false, false, 1F))
                            .put(9, (entityIn) -> AttackManager.doSlash(entityIn, -45F, Vec3.ZERO, false, false, 3F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ThrustSlashEX = COMBO_STATES.register("thrustslash_ex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(2, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(3, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 0))
                            .put(4, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90))
                            .put(5, (entityIn) -> PhantomThrust.doSlash(entityIn,3F*3,true))
                            .put(6, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(7, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(8, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 0))
                            .put(9, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90))                           .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> jusitce_slash = COMBO_STATES.register("jusitce_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> jusitce.dojusitceSlash(entityIn,  3, 1, 0))
                     .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);

    public static final RegistryObject<ComboState> ultra_slash = COMBO_STATES.register("ultra_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> jusitce.doultraSlash(entityIn,  3, 0.5F, 0))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> rot_slash = COMBO_STATES.register("rot_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 0))
                            .put(3, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 1))
                            .put(4, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 2))
                            .put(5, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 3))
                            .put(6, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 4))
                            .put(7, (entityIn) -> jusitce.dorotSlash(entityIn,  1F, 2F, 5))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> heal_slash = COMBO_STATES.register("heal_slash",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.1F))
                            .put(2, (entityIn) -> jusitce.dohealSlash(entityIn,  20,3F, 2F, 0))
                            .put(3, (entityIn) -> jusitce.dohealSlash(entityIn,  20,  3F, 2F, 1))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> CircleSlashex = COMBO_STATES.register("circleslashex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(2, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(3, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 70))
                            .put(4, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90))
                            .put(5, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 160))
                            .put(6, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 32))
                            .put(7, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 46))
                            .put(8, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -79))
                            .put(9, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(10, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 90))
                            .put(11, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 70))
                            .put(12, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -90))
                            .put(13, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 160))
                            .put(14, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 32))
                            .put(15, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 46))
                            .put(16, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, -79))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> Wakeup = COMBO_STATES.register("wakeup",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> CircleSlash.doCircleSlashAttack(entityIn, 180))
                            .put(2,(entityIn)->{
                                entityIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 3));
                                entityIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.SUMERU.get(), 900, 3));
                                entityIn.hurt(new DamageSource(entityIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), entityIn), 60);

                            })
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX = COMBO_STATES.register("all_over_ex",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_over_ex_alf"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, 0.2F))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -40F, Vec3.ZERO, false, false, 0.2F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 40F, Vec3.ZERO, false, false, 0.2F))
                            .put(5, (entityIn) -> AttackManager.doSlash(entityIn, 50F, Vec3.ZERO, false, false, 0.2F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, -50F, Vec3.ZERO, false, false, 0.2F))
                            .put(7, (entityIn) -> AttackManager.doSlash(entityIn, -60F, Vec3.ZERO, false, false, 0.2F))
                            .put(8, (entityIn) -> AttackManager.doSlash(entityIn, 60F, Vec3.ZERO, false, false, 0.2F))
                            .put(9, (entityIn) -> AttackManager.doSlash(entityIn, -70F, Vec3.ZERO, false, false, 0.2F))
                            .put(10, (entityIn) -> AttackManager.doSlash(entityIn, 70F, Vec3.ZERO, false, false, 0.2F))
                            .put(11, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(12, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 0.2F))
                            .put(13, (entityIn) -> AttackManager.doSlash(entityIn, 110F, Vec3.ZERO, false, false, 0.2F))
                            .put(14, (entityIn) -> AttackManager.doSlash(entityIn, -110F, Vec3.ZERO, false, false, 0.2F))
                            .put(15, (entityIn) -> AttackManager.doSlash(entityIn, 120F, Vec3.ZERO, false, false, 0.2F))
                            .put(16, (entityIn) -> AttackManager.doSlash(entityIn, -120F, Vec3.ZERO, false, false, 0.2F))
                            .put(17, (entityIn) -> AttackManager.doSlash(entityIn, -130F, Vec3.ZERO, false, false, 0.2F))
                            .put(18, (entityIn) -> AttackManager.doSlash(entityIn, 130F, Vec3.ZERO, false, false, 0.2F))
                            .put(19, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .put(20, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX_ALF = COMBO_STATES.register("all_over_ex_alf",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX2 = COMBO_STATES.register("all_over_ex2",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_over_ex_alf2"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, 0.2F))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -40F, Vec3.ZERO, false, false, 0.2F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 40F, Vec3.ZERO, false, false, 0.2F))
                            .put(5, (entityIn) -> AttackManager.doSlash(entityIn, 50F, Vec3.ZERO, false, false, 0.2F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, -50F, Vec3.ZERO, false, false, 0.2F))
                            .put(7, (entityIn) -> AttackManager.doSlash(entityIn, -60F, Vec3.ZERO, false, false, 0.2F))
                            .put(8, (entityIn) -> AttackManager.doSlash(entityIn, 60F, Vec3.ZERO, false, false, 0.2F))
                            .put(9, (entityIn) -> AttackManager.doSlash(entityIn, -70F, Vec3.ZERO, false, false, 0.2F))
                            .put(10, (entityIn) -> AttackManager.doSlash(entityIn, 70F, Vec3.ZERO, false, false, 0.2F))
                            .put(11, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(12, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 0.2F))
                            .put(13, (entityIn) -> AttackManager.doSlash(entityIn, 110F, Vec3.ZERO, false, false, 0.2F))
                            .put(14, (entityIn) -> AttackManager.doSlash(entityIn, -110F, Vec3.ZERO, false, false, 0.2F))
                            .put(15, (entityIn) -> AttackManager.doSlash(entityIn, 120F, Vec3.ZERO, false, false, 0.2F))
                            .put(16, (entityIn) -> AttackManager.doSlash(entityIn, -120F, Vec3.ZERO, false, false, 0.2F))
                            .put(17, (entityIn) -> AttackManager.doSlash(entityIn, -130F, Vec3.ZERO, false, false, 0.2F))
                            .put(18, (entityIn) -> AttackManager.doSlash(entityIn, 130F, Vec3.ZERO, false, false, 0.2F))
                            .put(19, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .put(20, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX_ALF2 = COMBO_STATES.register("all_over_ex_alf2",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_over_ex2_2"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX2_2 = COMBO_STATES.register("all_over_ex2_2",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_over_ex_alf2_2"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, -30F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 30F, Vec3.ZERO, false, false, 0.2F))
                            .put(3, (entityIn) -> AttackManager.doSlash(entityIn, -40F, Vec3.ZERO, false, false, 0.2F))
                            .put(4, (entityIn) -> AttackManager.doSlash(entityIn, 40F, Vec3.ZERO, false, false, 0.2F))
                            .put(5, (entityIn) -> AttackManager.doSlash(entityIn, 50F, Vec3.ZERO, false, false, 0.2F))
                            .put(6, (entityIn) -> AttackManager.doSlash(entityIn, -50F, Vec3.ZERO, false, false, 0.2F))
                            .put(7, (entityIn) -> AttackManager.doSlash(entityIn, -60F, Vec3.ZERO, false, false, 0.2F))
                            .put(8, (entityIn) -> AttackManager.doSlash(entityIn, 60F, Vec3.ZERO, false, false, 0.2F))
                            .put(9, (entityIn) -> AttackManager.doSlash(entityIn, -70F, Vec3.ZERO, false, false, 0.2F))
                            .put(10, (entityIn) -> AttackManager.doSlash(entityIn, 70F, Vec3.ZERO, false, false, 0.2F))
                            .put(11, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(12, (entityIn) -> AttackManager.doSlash(entityIn, -90F, Vec3.ZERO, false, false, 0.2F))
                            .put(13, (entityIn) -> AttackManager.doSlash(entityIn, 110F, Vec3.ZERO, false, false, 0.2F))
                            .put(14, (entityIn) -> AttackManager.doSlash(entityIn, -110F, Vec3.ZERO, false, false, 0.2F))
                            .put(15, (entityIn) -> AttackManager.doSlash(entityIn, 120F, Vec3.ZERO, false, false, 0.2F))
                            .put(16, (entityIn) -> AttackManager.doSlash(entityIn, -120F, Vec3.ZERO, false, false, 0.2F))
                            .put(17, (entityIn) -> AttackManager.doSlash(entityIn, -130F, Vec3.ZERO, false, false, 0.2F))
                            .put(18, (entityIn) -> AttackManager.doSlash(entityIn, 130F, Vec3.ZERO, false, false, 0.2F))
                            .put(19, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .put(20, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
    public static final RegistryObject<ComboState> ALLOVEREX_ALF2_2 = COMBO_STATES.register("all_over_ex_alf2_2",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> AttackManager.doSlash(entityIn, 180F, Vec3.ZERO, false, false, 0.2F))
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);



    public static final RegistryObject<ComboState> SaveTheWorld = COMBO_STATES.register("save_the_world",
            ComboState.Builder.newInstance().startAndEnd(400, 459).priority(50)
                    .motionLoc(DefaultResources.ExMotionLocation)
                    .next(ComboState.TimeoutNext.buildFromFrame(15, entity -> SlashBlade.prefix("none")))
                    .nextOfTimeout(entity -> Legendblade.prefix("all_reuse"))
                    .addTickAction(ComboState.TimeLineTickAction.getBuilder()
                            .put(1, (entityIn) -> AttackManager.doSlash(entityIn, 90F, Vec3.ZERO, false, false, 0.2F))
                            .put(2, (entityIn) -> jusitce.dojusitceSlash(entityIn,  10, 1, 0))
                            .put(3, (entityIn) -> jusitce.doultraSlash(entityIn,  10, 1, 0))
                            .put(4, (entityIn) -> jusitce.dorotSlash(entityIn,  10, 1, 0))
                            .put(5, (entityIn) -> jusitce.dojusitceSlash(entityIn,  10, 1, 0))
                            .put(6, (entityIn) -> jusitce.dohealSlash(entityIn,  20,3F, 2F, 0))
                            .put(7, (entityIn) -> jusitce.dohealSlash(entityIn,  20,  3F, 2F, 1))
                            .put(8, (entityIn) -> jusitce.docrotSlash(entityIn,  20,  3F, 2))
                            .put(9,(entityIn)->{
                                entityIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 3));
                                entityIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.SUMERU.get(), 900, 3));
                                entityIn.hurt(new DamageSource(entityIn.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL), entityIn), 60);

                            })
                            .build())
                    .addHitEffect(StunManager::setStun)
                    ::build);
}
