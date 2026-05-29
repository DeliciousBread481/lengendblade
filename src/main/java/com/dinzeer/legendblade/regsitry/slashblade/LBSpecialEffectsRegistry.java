package com.dinzeer.legendblade.regsitry.slashblade;

import com.dinzeer.legendblade.specialeffects.godfox.Blessing;
import com.dinzeer.legendblade.specialeffects.neo.*;
import com.dinzeer.legendblade.specialeffects.sequests.*;
import com.dinzeer.legendblade.specialeffects.versionone.*;
import com.dinzeer.legendblade.specialeffects.versiontwo.Bloodfox;
import com.dinzeer.legendblade.specialeffects.godfox.*;
import com.dinzeer.legendblade.specialeffects.heartblade.*;
import mods.flammpfeil.slashblade.registry.specialeffects.SpecialEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import com.dinzeer.legendblade.specialeffects.versiontwo.*;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBSpecialEffectsRegistry {
    public static final DeferredRegister<SpecialEffect> REGISTRY_KEY2;
    public static final RegistryObject<SpecialEffect> BLESSING;
    public static final RegistryObject<SpecialEffect> BLadeAttack;
    public static final RegistryObject<SpecialEffect> BAdBlood;
    public static final RegistryObject<SpecialEffect> Sin;
    public static final RegistryObject<SpecialEffect> poison;
    public static final RegistryObject<SpecialEffect> Feastful;
    public static final RegistryObject<SpecialEffect> Shackles;
    public static final RegistryObject<SpecialEffect> Resentment;
    public static final RegistryObject<SpecialEffect> Suppress;
    public static final RegistryObject<SpecialEffect> Endless;
    public static final RegistryObject<SpecialEffect> Bloodthirsty;
    public static final RegistryObject<SpecialEffect> BlessingSummonSword;
    public static final RegistryObject<SpecialEffect> SummonSword;
    public static final RegistryObject<SpecialEffect> FoxBlessing;
    public static final RegistryObject<SpecialEffect> Liuli;
    public static final RegistryObject<SpecialEffect> Liulione;
    public static final RegistryObject<SpecialEffect> EndSakuraRiseUp;
    public static final RegistryObject<SpecialEffect> TheShineSummonSword;
    public static final RegistryObject<SpecialEffect> WaveEdgeRiseUp;
    public static final RegistryObject<SpecialEffect> FragmentedEdge;
    public static final RegistryObject<SpecialEffect> bloodfox;
    public static final RegistryObject<SpecialEffect> RainBow;
    public static final RegistryObject<SpecialEffect> Eternal;
    public static final RegistryObject<SpecialEffect> Need;
    public static final RegistryObject<SpecialEffect> MaxSky;
    public static final RegistryObject<SpecialEffect> Shinening;
    public static final RegistryObject<SpecialEffect> DarkGod;
    public static final RegistryObject<SpecialEffect> Zain;
    public static final RegistryObject<SpecialEffect> EnduranceTower;
    public static final RegistryObject<SpecialEffect> SanNight;
    public static final RegistryObject<SpecialEffect> VoidMaker;
    public static final RegistryObject<SpecialEffect> Haiker;
    public static final RegistryObject<SpecialEffect> SuperMe;
    public static final RegistryObject<SpecialEffect> Max;
    public static final RegistryObject<SpecialEffect> PhysicsDepartment;
    public static final RegistryObject<SpecialEffect> PhysicsDepartmentFly;
    public static final RegistryObject<SpecialEffect> SolemnMourning;
    public static final RegistryObject<SpecialEffect> Devastate;

    public static final RegistryObject<SpecialEffect> Strength;
    public static final RegistryObject<SpecialEffect> Cold;
    public static final RegistryObject<SpecialEffect> Dawn;
    public static final RegistryObject<SpecialEffect> ExtinctionOfProjectiles;
    public static final RegistryObject<SpecialEffect> GoldBlade;
    public static final RegistryObject<SpecialEffect> BreakAll;
    public static final RegistryObject<SpecialEffect> Dubhe;
    public static final RegistryObject<SpecialEffect> DubheEX;
    public static final RegistryObject<SpecialEffect> Megrez;
    public static final RegistryObject<SpecialEffect> MegrezEX;
    public static final RegistryObject<SpecialEffect> Mizar;
    public static final RegistryObject<SpecialEffect> MizarEX;
    public static final RegistryObject<SpecialEffect> Phecda;
    public static final RegistryObject<SpecialEffect> PhecdaEX;
    public static final RegistryObject<SpecialEffect> Hagen;
    public static final RegistryObject<SpecialEffect> HagenEX;
    public static final RegistryObject<SpecialEffect> Alkaid;
    public static final RegistryObject<SpecialEffect> AlkaidEX;
    public static final RegistryObject<SpecialEffect> Fenrir;
    public static final RegistryObject<SpecialEffect> FenrirEX;
    public static final RegistryObject<SpecialEffect> NonePower;//虚无神力

    public static final RegistryObject<SpecialEffect> nofear;//无畏
    public static final RegistryObject<SpecialEffect> HealIs;//慈爱
    public static final RegistryObject<SpecialEffect> pure;//天平
    public  static final  RegistryObject<SpecialEffect> Aryadeva;//圣天
    public  static final  RegistryObject<SpecialEffect> Justice;//裁决

    public  static final  RegistryObject<SpecialEffect> OccupyingHeart;//占据之心
    public  static final  RegistryObject<SpecialEffect> SeizetheBlood;//夺取之血
    public  static final  RegistryObject<SpecialEffect> CompassionforTorture;//悲悯酷刑
    public  static final  RegistryObject<SpecialEffect> Theinescapableguilt;//无可逃离的负罪
    public  static final  RegistryObject<SpecialEffect> HelplessRest;//无可奈何的安息
    public  static final  RegistryObject<SpecialEffect> Anuntraceablehope;//无从找寻的希望

    public  static final  RegistryObject<SpecialEffect> angory;//暴怒·自毁者
    public LBSpecialEffectsRegistry() {
    }


    static {
        REGISTRY_KEY2 = DeferredRegister.create(SpecialEffect.REGISTRY_KEY, MODID);
        BLESSING=REGISTRY_KEY2.register("blessing", Blessing::new);//神佑
        BLadeAttack=REGISTRY_KEY2.register("blade_attack", BladeAttack::new);//刃噬
        BAdBlood=REGISTRY_KEY2.register("bad_blood", BadBlood::new);//坏血
        Sin=REGISTRY_KEY2.register("sin", Sin::new);
        poison=REGISTRY_KEY2.register("poison", Poison::new);
        Feastful=REGISTRY_KEY2.register("feastful", Feastful::new);
        Shackles=REGISTRY_KEY2.register("shackles", Shackles::new);
        Resentment=REGISTRY_KEY2.register("resentment", Resentment::new);
        Suppress=REGISTRY_KEY2.register("suppress", Suppress::new);
        Endless=REGISTRY_KEY2.register("endless", Endless::new);
        Bloodthirsty=REGISTRY_KEY2.register("bloodthirsty", Bloodthirsty::new);
        BlessingSummonSword=REGISTRY_KEY2.register("blessingsummonsword",BlessingSummonSword::new);
        SummonSword=REGISTRY_KEY2.register("summonsword", SummonSword::new);
        FoxBlessing=REGISTRY_KEY2.register("foxbling", FoxBlessing::new);
        Liuli=REGISTRY_KEY2.register("liuli", Liuli::new);
        Liulione=REGISTRY_KEY2.register("liulione", Liulione::new);
        EndSakuraRiseUp=REGISTRY_KEY2.register("endsakurateriseup", EndSakuraRiseUp::new);
        WaveEdgeRiseUp=REGISTRY_KEY2.register("waveedgeriseup", WaveEdgeRiseUp::new);//波刀龙胆se
        TheShineSummonSword=REGISTRY_KEY2.register("theshine",TheShine::new);
        FragmentedEdge=REGISTRY_KEY2.register("fragmentededge", FragmentedEdge::new);
        bloodfox=REGISTRY_KEY2.register("bloodfox", Bloodfox::new);
        RainBow=REGISTRY_KEY2.register("rainbow", RainBow::new);
        Eternal=REGISTRY_KEY2.register("eternal", Eternal::new);
        Need=REGISTRY_KEY2.register("need", Need::new);
        MaxSky=REGISTRY_KEY2.register("maxsky", MaxSky::new);
        Shinening=REGISTRY_KEY2.register("shinening", Shinening::new);
        DarkGod=REGISTRY_KEY2.register("darkgod",DarkGod::new);
        Zain=REGISTRY_KEY2.register("zain",Zain::new);
        EnduranceTower=REGISTRY_KEY2.register("endurancetower", EnduranceTower::new);
        SanNight=REGISTRY_KEY2.register("sannight",SanNight::new);
        VoidMaker=REGISTRY_KEY2.register("voidmaker",VoidMaker::new);
        Haiker=REGISTRY_KEY2.register("haiker",Haiker::new);
        SuperMe=REGISTRY_KEY2.register("superme",SuperMe::new);
        Max=REGISTRY_KEY2.register("max",Max::new);
        PhysicsDepartment=REGISTRY_KEY2.register("physics_department",PhysicsDepartment::new);
        PhysicsDepartmentFly=REGISTRY_KEY2.register("physics_department_fly",PhysicsDepartmentFly::new);
        SolemnMourning=REGISTRY_KEY2.register("solemn_mourning",SolemnMourning::new);
        Devastate=REGISTRY_KEY2.register("devastate",Devastate::new);
        Strength=REGISTRY_KEY2.register("strength",Devastate::new);
        Cold=REGISTRY_KEY2.register("cold",Cold::new);
        Dawn=REGISTRY_KEY2.register("dawn",Dawn::new);
        ExtinctionOfProjectiles=REGISTRY_KEY2.register("ext",ExtinctionOfProjectiles::new);
        GoldBlade=REGISTRY_KEY2.register("goldblade",DarkGod::new);
        BreakAll=REGISTRY_KEY2.register("breakall",DarkGod::new);
        Dubhe=REGISTRY_KEY2.register("bubhe", StarsSE::new);
        DubheEX=REGISTRY_KEY2.register("bubhe_ex", StarsSEEX::new);
        Megrez=REGISTRY_KEY2.register("megrez", StarsSE::new);
        MegrezEX=REGISTRY_KEY2.register("megrez_ex", StarsSEEX::new);
        Mizar=REGISTRY_KEY2.register("mizar", StarsSE::new);
        MizarEX=REGISTRY_KEY2.register("mizar_ex", StarsSEEX::new);
        Phecda=REGISTRY_KEY2.register("phecda", StarsSE::new);
        PhecdaEX=REGISTRY_KEY2.register("phecda_ex", StarsSEEX::new);
        Hagen=REGISTRY_KEY2.register("hagen", StarsSE::new);
        HagenEX=REGISTRY_KEY2.register("hagen_ex", StarsSEEX::new);
        Alkaid=REGISTRY_KEY2.register("alkaid", StarsSE::new);
        AlkaidEX=REGISTRY_KEY2.register("alkaid_ex", StarsSEEX::new);
        Fenrir=REGISTRY_KEY2.register("fenrir", StarsSE::new);
        FenrirEX=REGISTRY_KEY2.register("fenrir_ex", StarsSEEX::new);
        NonePower=REGISTRY_KEY2.register("nonepower",DarkGod::new);
        nofear=REGISTRY_KEY2.register("nofear", SE30::new);
        HealIs=REGISTRY_KEY2.register("healis", SE30::new);
        pure=REGISTRY_KEY2.register("pure", SE30::new);
        Aryadeva=REGISTRY_KEY2.register("aryadeva", SE30::new);
        Justice=REGISTRY_KEY2.register("justice", SE30::new);
        OccupyingHeart=REGISTRY_KEY2.register("occupyingheart", SE17::new);
        SeizetheBlood=REGISTRY_KEY2.register("seizetheblood", SE37::new);
        CompassionforTorture=REGISTRY_KEY2.register("compassionfortorture", SE47::new);
        Theinescapableguilt=REGISTRY_KEY2.register("theinescapableguilt", SE17::new);
        HelplessRest=REGISTRY_KEY2.register("helplessrest", SE37::new);
        Anuntraceablehope=REGISTRY_KEY2.register("anuntraceablehope", SE47::new);
        angory=REGISTRY_KEY2.register("angory", SE30::new);
    }

}
