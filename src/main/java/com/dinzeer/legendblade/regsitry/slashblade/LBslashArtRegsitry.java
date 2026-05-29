package com.dinzeer.legendblade.regsitry.slashblade;

import com.dinzeer.legendblade.specialattack.versiontwo.SaveAll;
import mods.flammpfeil.slashblade.slasharts.SlashArts;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBslashArtRegsitry {
    public static final DeferredRegister<SlashArts> SLASH_ARTS =
            DeferredRegister.create(SlashArts.REGISTRY_KEY, MODID);

    public static final RegistryObject<SlashArts> PROWESS;//神威
    public static final RegistryObject<SlashArts> MP;//妖力
    public static final RegistryObject<SlashArts> HP;//残心斩
    public static final RegistryObject<SlashArts> HPC;//血弑
    public static final RegistryObject<SlashArts> PhantomThrust;//魅影突刺
    public static final RegistryObject<SlashArts> soullock;//天狱锁魂
    public static final RegistryObject<SlashArts> Thatcher;//卓尔不凡
    public static final RegistryObject<SlashArts> HungerAbsorption;//饥饿吸取
    public static final RegistryObject<SlashArts> Splitapart;//汲血割裂
    public static final RegistryObject<SlashArts> GreedyGrip;//贪婪之握
    public static final RegistryObject<SlashArts> flurry;//影刃乱舞
    public static final RegistryObject<SlashArts> MPSS;//妖力幻影剑
    public static final RegistryObject<SlashArts> VoidSlashPlus;//次元斩改
    public static final RegistryObject<SlashArts> Thrust;//平突改
    public static final RegistryObject<SlashArts> SAKURAENDEX;//终焉樱散
    public static final RegistryObject<SlashArts> swordone;//剑一
    public static final RegistryObject<SlashArts> swordoneex;//剑一EX
    public static final RegistryObject<SlashArts> Thrusts;//裂宵
    public static final RegistryObject<SlashArts> SlashShine;//剑技·闪
    public static final RegistryObject<SlashArts> delete;//数据删除
    public static final RegistryObject<SlashArts> BloodThrusts;//血腥冲锋
    public static final RegistryObject<SlashArts> sevenbladeslash;//满月破
    public static final RegistryObject<SlashArts> MoonDrive;//月牙天冲
    public static final RegistryObject<SlashArts> FrogGlaxy;//月祈
    public static final RegistryObject<SlashArts> SaveAll;//治愈波动
    public static final RegistryObject<SlashArts> Elbowstrike;//星落打
    public static final RegistryObject<SlashArts> swordRain;//剑雨
    public static final RegistryObject<SlashArts> EXmoonDrive;//ex月牙
    public static final RegistryObject<SlashArts> LastMoondrive;//月牙天冲最终
    public static final RegistryObject<SlashArts> SommonSwordSommonEX;//万剑朝宗
    public static final RegistryObject<SlashArts> SanNight;//终焉樱+元刃
    public static final RegistryObject<SlashArts> getThrust;//平突
    public static final RegistryObject<SlashArts> ButterFly;//蝶悼

    public static final RegistryObject<SlashArts> THRUSTSUMMONSWORD;//秋风幻影剑
    public static final RegistryObject<SlashArts> ALLOVER;//所罗门超连击
    public static final RegistryObject<SlashArts> StarEdge;//星光斩
    public static final RegistryObject<SlashArts> Foever;//永远
    public static final RegistryObject<SlashArts> ThrustEEX;//平移
    public static final RegistryObject<SlashArts> DragonBoost;//龙魂附体
    public static final RegistryObject<SlashArts> BlackHole;//黑穴
    public static final RegistryObject<SlashArts> kingblade;//灭
    public static final RegistryObject<SlashArts> Blackslash;//魔爆斩
    public static final RegistryObject<SlashArts> ThrustSlash;//平移斩
    public static final RegistryObject<SlashArts> ThrustSlashEX;//平移斩ex

    public static final RegistryObject<SlashArts> jusitce_slash;//圣天裁决斩
    public static final RegistryObject<SlashArts> ultra_slash;//希望究极斩
    public static final RegistryObject<SlashArts> rot_slash;//慎重螺旋
    public static final RegistryObject<SlashArts> heal_slash;//慈悲为怀
    public static final RegistryObject<SlashArts> CircleSlashex;//信念炫刃
    public static final RegistryObject<SlashArts> Wakeup;//天平觉醒
    public static final RegistryObject<SlashArts> JudgementCutExbig;//勇气裁决

    public static final RegistryObject<SlashArts> ALLOVEREX;//残虐救赎
    public static final RegistryObject<SlashArts> ALLOVEREX2;//剪枝罪孽
    public static final RegistryObject<SlashArts> SaveTheWorld;//此刻·救世
    static {
        PROWESS=SLASH_ARTS.register("prowess", () -> new SlashArts((e) ->
                LBComboRegsitry.PROWESS.getId()));
        MP=SLASH_ARTS.register("monster_power", () -> new SlashArts((e) ->
                LBComboRegsitry.MP.getId()));
        HP=SLASH_ARTS.register("heart_slash", () -> new SlashArts((e) ->LBComboRegsitry.HP.getId()));
        HPC=SLASH_ARTS.register("heart_slashc", () -> new SlashArts((e) ->LBComboRegsitry.HPC.getId()));
        PhantomThrust=SLASH_ARTS.register("phantom_thrust", () -> new SlashArts((e) ->
                LBComboRegsitry.Phantomthrust.getId()));
        soullock=SLASH_ARTS.register("soul_lock", () -> new SlashArts((e) ->
                LBComboRegsitry.Soul_Lock.getId()));
        Thatcher=SLASH_ARTS.register("thatcher", () -> new SlashArts((e) ->
                LBComboRegsitry.thatcher.getId()));
        HungerAbsorption=SLASH_ARTS.register("hunger_absorption", () -> new SlashArts((e) ->
                LBComboRegsitry.HungerA.getId()));
        Splitapart=SLASH_ARTS.register("split_apart", () -> new SlashArts((e) ->
                LBComboRegsitry.splitapart.getId()));
        GreedyGrip=SLASH_ARTS.register("greedy_grip", () -> new SlashArts((e) ->
                LBComboRegsitry.greedyGrip.getId()));
        flurry=SLASH_ARTS.register("flurry", () -> new SlashArts((e) ->
                LBComboRegsitry.flurry.getId()));
        MPSS=SLASH_ARTS.register("mpss", () -> new SlashArts((e) ->LBComboRegsitry.MPSS.getId()));
        VoidSlashPlus=SLASH_ARTS.register("void_slash_plus", () -> new SlashArts((e) ->LBComboRegsitry.VoidSlashPlus.getId()));
        Thrust=SLASH_ARTS.register("thrust", () -> new SlashArts((e) ->LBComboRegsitry.Thrust.getId()));
        SAKURAENDEX=SLASH_ARTS.register("sakura_endex", () -> new SlashArts((e) ->LBComboRegsitry.SAKURA_END_LEFTEX.getId()));
        swordone=SLASH_ARTS.register("swordone", () -> new SlashArts((e) ->LBComboRegsitry.swordone.getId()));
        swordoneex=SLASH_ARTS.register("swordoneex", () -> new SlashArts((e) ->LBComboRegsitry.swordoneex.getId()));
        Thrusts=SLASH_ARTS.register("birdthrust", () -> new SlashArts((e) ->LBComboRegsitry.Thrusta.getId()));
        SlashShine=SLASH_ARTS.register("slashshine",() -> new SlashArts((e) ->LBComboRegsitry.SlashShine.getId()));
        delete=SLASH_ARTS.register("delete",() -> new SlashArts((e) ->LBComboRegsitry.delete.getId()));
        BloodThrusts=SLASH_ARTS.register("bloodbirdthrust",() -> new SlashArts((e) ->LBComboRegsitryA.Bloodthrusts.getId()));
        sevenbladeslash=SLASH_ARTS.register("sevenbladeslash",() -> new SlashArts((e) ->LBComboRegsitryA.sevenbladeslash.getId()));
        MoonDrive=SLASH_ARTS.register("moondrive",() -> new SlashArts((e) ->LBComboRegsitryA.MoonDrive.getId()));
        FrogGlaxy=SLASH_ARTS.register("frog_glaxy",() -> new SlashArts((e) ->LBComboRegsitryA.FrogGlaxy.getId()));
        SaveAll =SLASH_ARTS.register("save_all",() -> new SlashArts((e) ->LBComboRegsitryA.saveall.getId()));
        Elbowstrike=SLASH_ARTS.register("elbowstrike",() -> new SlashArts((e) ->LBComboRegsitryA.elbowstrike.getId()));
        swordRain=SLASH_ARTS.register("swordrain",() -> new SlashArts((e) ->LBComboRegsitryA.swordRain.getId()));
        EXmoonDrive=SLASH_ARTS.register("exmoondrive",()-> new SlashArts((e) ->LBComboRegsitryA.eXmoonDrive.getId()));
        LastMoondrive=SLASH_ARTS.register("lastmoondrive",()-> new SlashArts((e) ->LBComboRegsitryA.lastMoondrive.getId()));
        SommonSwordSommonEX=SLASH_ARTS.register("sommon_sword_sommonex",()-> new SlashArts((e) ->LBComboRegsitryA.sommonSwordSommonEX.getId()));
        SanNight=SLASH_ARTS.register("sannight",()-> new SlashArts((e) ->LBComboRegsitryA.SAKURA_END_LEFTEX2.getId()));
        getThrust=SLASH_ARTS.register("getthrust",()-> new SlashArts((e) ->LBComboRegsitryA.thrust.getId()));
        ButterFly=SLASH_ARTS.register("butterfly",()-> new SlashArts((e) ->LBComboRegsitryA.Butterfly. getId()));
        THRUSTSUMMONSWORD=SLASH_ARTS.register("thrust_summon_sword",()-> new SlashArts((e) ->LBComboRegsitryA.THRUSTSUMMONSWORD.getId()));
        ALLOVER=SLASH_ARTS.register("allover",()-> new SlashArts((e) ->LBComboRegsitryA.ALLOVER.getId()));
        StarEdge=SLASH_ARTS.register("star_edge",()-> new SlashArts((e) ->LBComboRegsitryA.StarSlash.getId()));
        Foever=SLASH_ARTS.register("foever",()-> new SlashArts((e) ->LBComboRegsitryA.forever.getId()));
        JudgementCutExbig=SLASH_ARTS.register("judgement_cut_exbig",()-> new SlashArts((e) ->LBComboRegsitryA.JudgementCutExbig.getId()));
        ThrustEEX=SLASH_ARTS.register("thrust_eex",()-> new SlashArts((e) ->LBComboRegsitryA.ThrustEEX.getId()));
        DragonBoost=SLASH_ARTS.register("dragon_boost",()-> new SlashArts((e) ->LBComboRegsitryA.DragonBoost.getId()));
        BlackHole=SLASH_ARTS.register("black_hole",()-> new SlashArts((e) ->LBComboRegsitryA.BlackHole.getId()));
        kingblade=SLASH_ARTS.register("kingblade",()-> new SlashArts((e) ->LBComboRegsitryA.kingblade.getId()));
        Blackslash=SLASH_ARTS.register("blackslash",()-> new SlashArts((e) ->LBComboRegsitryA.Blackslash.getId()));
        ThrustSlash=SLASH_ARTS.register("thrust_slash",()-> new SlashArts((e) ->LBComboRegsitryA.ThrustSlash.getId()));
        ThrustSlashEX=SLASH_ARTS.register("thrust_slash_ex",()-> new SlashArts((e) ->LBComboRegsitryA.ThrustSlashEX.getId()));
        jusitce_slash=SLASH_ARTS.register("jusitce_slash",()-> new SlashArts((e) ->LBComboRegsitryA.jusitce_slash.getId()));
        ultra_slash=SLASH_ARTS.register("ultra_slash",()-> new SlashArts((e) ->LBComboRegsitryA.ultra_slash.getId()));
        rot_slash=SLASH_ARTS.register("rot_slash",()-> new SlashArts((e) ->LBComboRegsitryA.rot_slash.getId()));
        heal_slash=SLASH_ARTS.register("heal_slash",()-> new SlashArts((e) ->LBComboRegsitryA.heal_slash.getId()));
        CircleSlashex=SLASH_ARTS.register("circleslashex",()-> new SlashArts((e) ->LBComboRegsitryA.CircleSlashex.getId()));
        Wakeup=SLASH_ARTS.register("wakeup",()-> new SlashArts((e) ->LBComboRegsitryA.Wakeup.getId()));
        ALLOVEREX=SLASH_ARTS.register("alloverex",()-> new SlashArts((e) ->LBComboRegsitryA.ALLOVEREX.getId()));
        ALLOVEREX2=SLASH_ARTS.register("alloverex2",()-> new SlashArts((e) ->LBComboRegsitryA.ALLOVEREX2.getId()));
        SaveTheWorld=SLASH_ARTS.register("save_the_world",()-> new SlashArts((e) ->LBComboRegsitryA.SaveTheWorld.getId()));
    }
}
