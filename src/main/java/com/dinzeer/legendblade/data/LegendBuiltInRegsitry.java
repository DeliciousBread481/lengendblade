package com.dinzeer.legendblade.data;

import cn.mmf.slashblade_addon.registry.SBASlashArtsRegistry;
import cn.mmf.slashblade_addon.registry.SBASpecialEffectsRegistry;
import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.compat.ICFLBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.TFLBcompat;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.dinzeer.legendblade.regsitry.compat.L2LBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.compat.SBALBSlashArtRegsitry;
import dev.xkmc.l2complements.init.registrate.LCEnchantments;
import mods.flammpfeil.slashblade.item.SwordType;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.registry.slashblade.EnchantmentDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.PropertiesDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.RenderDefinition;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.registries.ForgeRegistries;
import net.xianyu.prinegorerouse.registry.NrSpecialEffectsRegistry;

import java.util.List;

public class LegendBuiltInRegsitry {

    //伪死念
    public static final ResourceKey<SlashBladeDefinition> NIHILEXFAKE;
    //血腥
    public static final ResourceKey<SlashBladeDefinition> BLOODKATANA;
    //真红
    public static final ResourceKey<SlashBladeDefinition> SHINKU;
    //妖刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> GODFOX;
    //锈迹斑斑的刀
    public static final ResourceKey<SlashBladeDefinition> RUSTGODFOX;
    //木鞘「刃条」
    public static final ResourceKey<SlashBladeDefinition> stickgodfox;
    //御神灵刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> NEOGODFOX;
    //木鞘「神狐」
    public static final ResourceKey<SlashBladeDefinition> WHITEGODFOX;
    //御神刀「神狐」
    public static final ResourceKey<SlashBladeDefinition> TRUEGODFOX;
    //恶
    public static final ResourceKey<SlashBladeDefinition> evil;
    //一代色欲
    public static final ResourceKey<SlashBladeDefinition> asmodeus;
    //一代暴食
    public static final ResourceKey<SlashBladeDefinition> beelzebub;
    //一代懒惰
    public static final ResourceKey<SlashBladeDefinition> belphegor;
    //一代嫉妒
    public static final ResourceKey<SlashBladeDefinition> leviathan;
    //一代傲慢
    public static final ResourceKey<SlashBladeDefinition> lucifer;
    //一代贪婪
    public static final ResourceKey<SlashBladeDefinition> mammon;
    //一代愤怒
    public static final ResourceKey<SlashBladeDefinition> samael;
    //EX色欲
    public static final ResourceKey<SlashBladeDefinition> asmodeusex;
    //EX暴食
    public static final ResourceKey<SlashBladeDefinition> beelzebubex;
    //EX懒惰
    public static final ResourceKey<SlashBladeDefinition> belphegorex;
    //EX恶
    public static final ResourceKey<SlashBladeDefinition> evilex;
    //EX嫉妒
    public static final ResourceKey<SlashBladeDefinition> leviathanex;
    //EX傲慢
    public static final ResourceKey<SlashBladeDefinition> luciferex;
    //EX贪婪
    public static final ResourceKey<SlashBladeDefinition> mammonex;
    //EX愤怒
    public static final ResourceKey<SlashBladeDefinition> samaelex;
    //ex白狐
    public static final ResourceKey<SlashBladeDefinition> foxex;
    //ex黑狐
    public static final ResourceKey<SlashBladeDefinition> foxex2;
    //exex灵刃狐月刀
    public static final ResourceKey<SlashBladeDefinition> foxexfinal;
    //无九
    public static final ResourceKey<SlashBladeDefinition> wujiu;
    //原罪交响曲·贝尔西普
    public static final ResourceKey<SlashBladeDefinition> belphebubex;
    //乌卡EX
    public static final ResourceKey<SlashBladeDefinition> waterex;
    //阿贝EX
    public static final ResourceKey<SlashBladeDefinition> fireex;
    //坎娜EX
    public static final ResourceKey<SlashBladeDefinition> lightningex;
    //魔刀千刃
    public static final ResourceKey<SlashBladeDefinition> sevensword;
    //毕方
    public static final ResourceKey<SlashBladeDefinition> godbird;
    //红樱ex
    public static final ResourceKey<SlashBladeDefinition> crimsoncherryex;

    //狱刀ex
    public static final ResourceKey<SlashBladeDefinition> nihilulex;
    //炼狱刀死念ex
    public static final ResourceKey<SlashBladeDefinition> nihilbxex;
    //恶太刀「破法」
    public static final ResourceKey<SlashBladeDefinition> ark;
    //破法EX
    public static final ResourceKey<SlashBladeDefinition> neo;
    //管理员之刃「伪物」
    public static final ResourceKey<SlashBladeDefinition> administrator;
    //血羽「邪凤」
    public static final ResourceKey<SlashBladeDefinition> demonbird;
    //龙骨刀「烈火」
    public static final ResourceKey<SlashBladeDefinition> fire;
    //龙骨刀「怒雷」
    public static final ResourceKey<SlashBladeDefinition> ice;
    //龙骨刀「天寒」
    public static final ResourceKey<SlashBladeDefinition> lightning;
    //柱子的刀
    public static final ResourceKey<SlashBladeDefinition> zhuzi;
    //龙钢猎刃「怒焰」
    public static final ResourceKey<SlashBladeDefinition> blaze;
    //龙钢猎刃「天霆」
    public static final ResourceKey<SlashBladeDefinition> zerogalaxy;
    //龙钢猎刃「永霜」
    public static final ResourceKey<SlashBladeDefinition> foreverice;
    //妖魔刀「血狐」
    public static final ResourceKey<SlashBladeDefinition> truebloodfox;
    //痛刀「爱莉」
    public static final ResourceKey<SlashBladeDefinition> eiily;
    //现世刀「斩月」
    public static final ResourceKey<SlashBladeDefinition> zangetsu;
    //铭刀「蟾宫」
    public static final ResourceKey<SlashBladeDefinition> frog;
    //铭刀「鱼音」
    public static final ResourceKey<SlashBladeDefinition> fish;
    //天锁斩月
    public static final ResourceKey<SlashBladeDefinition> tensazangetsu;
    //红「天锁斩月」
    public static final ResourceKey<SlashBladeDefinition> tensazangetsured;
    //物理学圣剑
    public static final ResourceKey<SlashBladeDefinition> crowbar;
    //彩虹之剑
    public static final ResourceKey<SlashBladeDefinition> rainbow;
    //§4§o铭刀「悭臾」
    public static final ResourceKey<SlashBladeDefinition> undragon;
    //骑士刃「甲穿」
    public static final ResourceKey<SlashBladeDefinition> breakarm;
    //冰晶刃「寒流」
    public static final ResourceKey<SlashBladeDefinition> allice;
    //炽铁刃「炎灼」
    public static final ResourceKey<SlashBladeDefinition> fireiron;

    //奇迹部件X
    public static final ResourceKey<SlashBladeDefinition> wonderblade;
    //欲望
    public static final ResourceKey<SlashBladeDefinition> desireblade;
    //超级大葱
    public static final ResourceKey<SlashBladeDefinition> shallot;
    //云刀「星河」
    public static final ResourceKey<SlashBladeDefinition> starriverblade;
    //天锁斩月·无月
    public static final ResourceKey<SlashBladeDefinition> tensazangetsunomoon;
    //诸神幻影
    public static final ResourceKey<SlashBladeDefinition> phantomOfGods;
    //异端刀
    public static final ResourceKey<SlashBladeDefinition> Itan;
    //卓越刀
    public static final ResourceKey<SlashBladeDefinition> nobleblade;
    //双持散华
    public static final ResourceKey<SlashBladeDefinition> sangeex;
    //柯院长的刀
    public static final ResourceKey<SlashBladeDefinition> mrke;
    //痛刀「胡桃」
    public static final ResourceKey<SlashBladeDefinition> hu;
    //虚空大剑
    public static final ResourceKey<SlashBladeDefinition> VoidSword;
    //魔剑「帝国」
    public static final ResourceKey<SlashBladeDefinition> dguoblade;
    //日刀「晓煌」
    public static final ResourceKey<SlashBladeDefinition> xhar;
    //痛刀「希儿」
    public static final ResourceKey<SlashBladeDefinition> Seele;
    //魅影刃
    public static final ResourceKey<SlashBladeDefinition> mirageedge;
    //血刃「死寂血狐」
    public static final ResourceKey<SlashBladeDefinition> bloodfoxex;
    //「正义」
    public static final ResourceKey<SlashBladeDefinition> justicegun;
    //冥刀「自然之心」
    public static final ResourceKey<SlashBladeDefinition> natureblade;
    //圣晓刀「超越」
    public static final ResourceKey<SlashBladeDefinition> beyondblade;
    //圣宣
    public static final ResourceKey<SlashBladeDefinition> SolemnLament;
    //基姆重工
    public static final ResourceKey<SlashBladeDefinition> maxkimblade;
    //Reversed Solomon
    public static final ResourceKey<SlashBladeDefinition> Reversed;
    //聚魂大剑「寒冰」
    public static final ResourceKey<SlashBladeDefinition> iceblade;
    //星璇「天枢」
    public static final ResourceKey<SlashBladeDefinition> Dubhe;
    //星璇「天权」
    public static final ResourceKey<SlashBladeDefinition> Megrez;
    //星璇「开阳」
    public static final ResourceKey<SlashBladeDefinition> Mizar;
    //星璇「天玑」
    public static final ResourceKey<SlashBladeDefinition> Phecda;
    //星璇「天玄」
    public static final ResourceKey<SlashBladeDefinition> Hagen;
    //星璇「瑶光」
    public static final ResourceKey<SlashBladeDefinition> Alkaid;
    //星璇「玉衡」
    public static final ResourceKey<SlashBladeDefinition> Fenrir;
    //星璇「空白」
    public static final ResourceKey<SlashBladeDefinition> White;
    //惊涛宝剑「闪铳」
    public static final ResourceKey<SlashBladeDefinition> matongcblade;
    //黑云已布
    public static final ResourceKey<SlashBladeDefinition> blackcloud;
    //失落「王传」
    public static final ResourceKey<SlashBladeDefinition> rustkingsowrd;
    //复生「王传」
    public static final ResourceKey<SlashBladeDefinition> kingsowrd;

    //极夜风暴「虚荣」
    public static final ResourceKey<SlashBladeDefinition> vanity;
    //钻石剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_diamond;
    //铁剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_iron;
    //石剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_stone;
    //金剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_gold;
    //木剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_wood;
    //下界合金剑「」
    public static final ResourceKey<SlashBladeDefinition> blade_netherite;
    //次元之刃「伪」
    public static final ResourceKey<SlashBladeDefinition> dimension;
    //龙刃「猩红」
    public static final ResourceKey<SlashBladeDefinition> dragonblade;
    //黑瞳
    public static final ResourceKey<SlashBladeDefinition> blackpixie;
    //「灭」
    public static final ResourceKey<SlashBladeDefinition> kingblade;
    //山樱「伪」
    public static final ResourceKey<SlashBladeDefinition> kumasakura;
    //魔刃
    public static final ResourceKey<SlashBladeDefinition> magicblade;
    //紫刃「虚」
    public static final ResourceKey<SlashBladeDefinition> purplesblade;
    //「黑刃」
    public static final ResourceKey<SlashBladeDefinition> pseudosword;
    //「白刃」
    public static final ResourceKey<SlashBladeDefinition> whitesword;
    //「隐月·刃」
    public static final ResourceKey<SlashBladeDefinition> latent;
    //荆棘之刃「虚」
    public static final ResourceKey<SlashBladeDefinition> vitex;
    //「命刃」
    public static final ResourceKey<SlashBladeDefinition> xblades;

    //善
    public static final ResourceKey<SlashBladeDefinition> zein;
    //圣
    public static final ResourceKey<SlashBladeDefinition> holy;
    //一代公正
    public static final ResourceKey<SlashBladeDefinition> Charlier;
    //一代谨慎`
    public static final ResourceKey<SlashBladeDefinition> Lemir;
    //一代仁慈`
    public static final ResourceKey<SlashBladeDefinition> Rafael;
    //一代睿智`
    public static final ResourceKey<SlashBladeDefinition> Michael;
    //一代希望`
    public static final ResourceKey<SlashBladeDefinition> Uriel;
    //一代信念`
    public static final ResourceKey<SlashBladeDefinition> Gabriel ;
    //一代勇敢`
    public static final ResourceKey<SlashBladeDefinition> metatron;
    //二代公正`
    public static final ResourceKey<SlashBladeDefinition> Charlierex;
    //二代谨慎·
    public static final ResourceKey<SlashBladeDefinition> Lemirex;
    //二代仁慈`
    public static final ResourceKey<SlashBladeDefinition> Rafaelex;
    //二代睿智`
    public static final ResourceKey<SlashBladeDefinition> Michaelex;
    //二代希望`
    public static final ResourceKey<SlashBladeDefinition> Urielx;
    //二代信念`
    public static final ResourceKey<SlashBladeDefinition> Gabrielex;
    //二代勇敢`
    public static final ResourceKey<SlashBladeDefinition> metatronx;
    //痛刀「缇里西庇俄丝」
    public static final ResourceKey<SlashBladeDefinition> Timotheos;
    //痛刀「牵绊红」
    public static final ResourceKey<SlashBladeDefinition> superred;
    //痛刀「武神之刃」
    public static final ResourceKey<SlashBladeDefinition> bujin_sword;
    //迪欧斯
    public static final ResourceKey<SlashBladeDefinition> dios;
    //十圣刃
    public static final ResourceKey<SlashBladeDefinition> ten_blades;
    //节制之种
    public static final ResourceKey<SlashBladeDefinition> temperance;
    //反思之芽
    public static final ResourceKey<SlashBladeDefinition> reflection;
    //所罗门
    public static final ResourceKey<SlashBladeDefinition> solomon;
    //逆位「所罗门」
    public static final ResourceKey<SlashBladeDefinition> reverse_solomon;
    //痛刀「西琳」
    public static final ResourceKey<SlashBladeDefinition> shirin;
    //万物不终结「摆件星空」
    public static final ResourceKey<SlashBladeDefinition> everything_not_ending;
    //来自本地的游客之刃
    public static final ResourceKey<SlashBladeDefinition> from_local_tourist;
    static {
        SHINKU=register("shinku");
        BLOODKATANA=register("bloodkatana");
        NIHILEXFAKE=register("nihilexfake");
        TRUEGODFOX=register("truegodfox");
        evil=register("evil");
        asmodeus=register("asmodeus");
        beelzebub=register("beelzebub");
        belphegor=register("belphegor");
        leviathan=register("leviathan");
        lucifer=register("lucifer");
        mammon=register("mammon");
        samael=register("samael");
        asmodeusex=register("asmodeusex");
        beelzebubex=register("beelzebubex");
        belphegorex=register("belphegorex");
        leviathanex=register("leviathanex");
        luciferex=register("luciferex");
        mammonex=register("mammonex");
        samaelex=register("samaelex");
        evilex=register("evilex");
        foxex=register("foxex");
        foxex2=register("foxex2");
        foxexfinal=register("foxexfinal");
        GODFOX=register("godfox");
        RUSTGODFOX=register("rustgodfox");
        stickgodfox=register("stickgodfox");
        NEOGODFOX=register("neogodfox");
        WHITEGODFOX=register("whitegodfox");
        wujiu=register("wujiu");
        belphebubex=register("belphebubex");
        waterex=register("waterex");
        fireex=register("fireex");
        lightningex=register("lightningex");
        sevensword=register("sevensword");
        godbird=register("godbird");
        crimsoncherryex=register("crimsoncherryex");

        nihilulex=register("nihilulex");
        nihilbxex=register("nihilbxex");
        ark=register("ark");
        neo=register("neo");

        administrator=register("administrator");
        demonbird=register("demonbird");
        fire=register("dragon_fire");
        ice=register("dragon_ice");
        lightning=register("dragon_lightning");
        zhuzi=register("zhuzi");
        blaze=register("blaze");
        zerogalaxy=register("zerogalaxy");
        foreverice=register("foreverice");
        truebloodfox=register("truebloodfox");
        eiily=register("eiily");
        zangetsu=register("zangetsu");
        frog=register("frog");
        fish=register("fish");
        tensazangetsu=register("tensazangetsu");
        tensazangetsured=register("tensazangetsured");
        crowbar=register("crowbar");
        rainbow=register("rainbow");
        undragon=register("undragon");
        breakarm=register("breakarm");
        allice=register("allice");
        fireiron=register("fireiron");
        wonderblade=register("wonderblade");
        desireblade=register("desireblade");
        shallot=register("shallot");
        starriverblade=register("starriverblade");
        tensazangetsunomoon=register("tensazangetsunomoon");
        phantomOfGods=register("phantomofgods");
        Itan=register("itan");
        nobleblade=register("nobleblade");
        sangeex=register("sangeex");
        mrke=register("mrke");
        hu=register("hu");
        VoidSword=register("voidsword");
        dguoblade=register("dguoblade");
        xhar=register("xhar");
        Seele=register("seele");
        mirageedge=register("mirageedge");
        bloodfoxex=register("bloodfoxex");
        justicegun=register("justicegun");
        natureblade=register("natureblade");
        beyondblade=register("beyondblade");
        SolemnLament=register("solemnlament");

        maxkimblade=register("maxkimblade");
        Reversed=register("reversed");
        iceblade=register("iceblade");
        Dubhe=register("dubhe");
        Megrez=register("megrez");
        Mizar=register("mizar");
        Phecda=register("phecda");
        Hagen=register("hagen");
        Alkaid=register("alkaid");
        Fenrir=register("fenrir");
        White=register("white");
        matongcblade=register("matongcblade");
        blackcloud=register("blackcloud");
        rustkingsowrd=register("rustkingsowrd");
        kingsowrd=register("kingsowrd");
        vanity=register("vanity");
        blade_diamond=register("blade_diamond");
        blade_iron=register("blade_iron");
        blade_stone=register("blade_stone");
        blade_gold=register("blade_gold");
        blade_wood=register("blade_wood");
        blade_netherite=register("blade_netherite");
        dimension=register("dimension");
        dragonblade=register("dragonblade");
        blackpixie=register("blackpixie");
        kingblade=register("kingblade");
        kumasakura=register("kumasakura");
        magicblade=register("magicblade");
        purplesblade=register("purplesblade");
        pseudosword=register("pseudosword");
        whitesword=register("whitesword");
        latent=register("latent");
        vitex=register("vitex");
        xblades=register("xblades");
        zein=register("zein");
        holy=register("holy");
        Charlier=register("charlier");
        Urielx=register("urielx");
        Gabrielex=register("gabrielex");
        metatronx=register("metatronx");
        Lemir=register("lemir");
        Rafael=register("rafael");
        Michaelex=register("michaelex");
        Rafaelex=register("rafaelex");
        Uriel=register("uriel");
        Lemirex=register("lemirex");
        Michael=register("michael");
        Charlierex=register("charlierex");
        metatron=register("metatron");
        Gabriel=register("gabriel");
        Timotheos=register("timotheos");
        superred=register("superred");
        bujin_sword=register("bujin_sword");
        dios=register("dios");
        ten_blades=register("ten_blades");
        temperance=register("temperance");
        reflection=register("reflection");
        solomon=register("solomon");
        reverse_solomon=register("reverse_solomon");
        shirin=register("shirin");
        everything_not_ending=register("everything_not_ending");
        from_local_tourist=register("from_local_tourist");
    }
    public static void registerAll(BootstapContext<SlashBladeDefinition> bootstrap) {

        bootstrap.register(
                NIHILEXFAKE, new SlashBladeDefinition(Legendblade.prefix("nihilexfake"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/nihilexfake/texture.png"))
                                .modelName(Legendblade.prefix("model/named/nihilexfake/model.obj"))
                                .effectColor(16711697)

                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                BLOODKATANA, new SlashBladeDefinition(Legendblade.prefix("bloodkatana"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/bloodkatanat/texture.png"))
                                .modelName(Legendblade.prefix("model/named/bloodkatanat/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .slashArtsType(LBslashArtRegsitry.HPC.getId())
                                .maxDamage(2000)
                                .addSpecialEffect(LBSpecialEffectsRegistry.BAdBlood.getId())
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));
        bootstrap.register(
                SHINKU, new SlashBladeDefinition(Legendblade.prefix("shinku"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/shinku/texture.png"))
                                .modelName(Legendblade.prefix("model/named/shinku/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .slashArtsType(LBslashArtRegsitry.HP.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.BLadeAttack.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));
        bootstrap.register(
                GODFOX, new SlashBladeDefinition(Legendblade.prefix("godfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/godfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/godfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.MP.getId())
                                .baseAttackModifier(18)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)

                        )
                ));

        bootstrap.register(
                RUSTGODFOX, new SlashBladeDefinition(Legendblade.prefix("rustgodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/rustgodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(5)
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                stickgodfox, new SlashBladeDefinition(Legendblade.prefix("stickgodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/stickgodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/stickgodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .slashArtsType(SlashArtsRegistry.DRIVE_HORIZONTAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                NEOGODFOX, new SlashBladeDefinition(Legendblade.prefix("neogodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/neogodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/neogodfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.BlessingSummonSword.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .slashArtsType(LBslashArtRegsitry.MPSS.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(28)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)
                        )
                ));

        bootstrap.register(
                WHITEGODFOX, new SlashBladeDefinition(Legendblade.prefix("whitegodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/whitegodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/whitegodfox/model.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(12)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));

        bootstrap.register(
                TRUEGODFOX, new SlashBladeDefinition(Legendblade.prefix("truegodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/truegodfox/texture.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(15906304)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.BLESSING.getId())
                                .slashArtsType(LBslashArtRegsitry.PROWESS.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(22)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.RESPIRATION), 1)
                        )
                ));


        bootstrap.register(
                evil, new SlashBladeDefinition(Legendblade.prefix("evil"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/unnamed/evil.png"))
                                .modelName(Legendblade.prefix("model/unnamed/evil.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .slashArtsType(SlashArtsRegistry.NONE.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                asmodeus, new SlashBladeDefinition(Legendblade.prefix("asmodeus"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/asmodeus/asmodeus.png"))
                                .modelName(Legendblade.prefix("model/named/asmodeus/asmodeus.obj"))
                                .effectColor(5898495)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.PhantomThrust.getId())
                                .baseAttackModifier(15)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 1))
                ));
        bootstrap.register(
                beelzebub, new SlashBladeDefinition(Legendblade.prefix("beelzebub"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/beelzebub/beelzebub.png"))
                                .modelName(Legendblade.prefix("model/named/beelzebub/beelzebub.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .baseAttackModifier(16)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 1))
                ));
        bootstrap.register(
                belphegor, new SlashBladeDefinition(Legendblade.prefix("belphegor"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/belphegor/belphegor.png"))
                                .modelName(Legendblade.prefix("model/named/belphegor/belphegor.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(LBslashArtRegsitry.soullock.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 4),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_EFFICIENCY), 2))
                ));

        bootstrap.register(
                leviathan, new SlashBladeDefinition(Legendblade.prefix("leviathan"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/leviathan/leviathan.png"))
                                .modelName(Legendblade.prefix("model/named/leviathan/leviathan.obj"))
                                .effectColor(65499)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .baseAttackModifier(15)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 2))
                ));
        bootstrap.register(
                lucifer, new SlashBladeDefinition(Legendblade.prefix("lucifer"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/lucifer/lucifer.png"))
                                .modelName(Legendblade.prefix("model/named/lucifer/lucifer.obj"))
                                .effectColor(16514816)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Thatcher.getId())
                                .baseAttackModifier(16)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2))
                ));

        bootstrap.register(
                mammon, new SlashBladeDefinition(Legendblade.prefix("mammon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/mammon/mammon.png"))
                                .modelName(Legendblade.prefix("model/named/mammon/mammon.obj"))
                                .effectColor(16737792)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.GreedyGrip.getId())
                                .baseAttackModifier(16)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 1)))
                );
        bootstrap.register(
                samael, new SlashBladeDefinition(Legendblade.prefix("samael"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/named/samael/samael.png"))
                                .modelName(Legendblade.prefix("model/named/samael/samael.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .baseAttackModifier(18)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1)
                        )
                ));
        bootstrap.register(
                asmodeusex, new SlashBladeDefinition(Legendblade.prefix("asmodeusex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/asmodeusex/asmodeusex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/asmodeusex/asmodeusex.obj"))
                                .effectColor(5898495)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.PhantomThrust.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.poison.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 3)
                        )
                ));
        bootstrap.register(
                beelzebubex, new SlashBladeDefinition(Legendblade.prefix("beelzebubex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Feastful.getId())
                                .baseAttackModifier(33)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));
        bootstrap.register(
                belphegorex, new SlashBladeDefinition(Legendblade.prefix("belphegorex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/belphegorex/belphegorex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/belphegorex/belphegorex.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.soullock.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Shackles.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_EFFICIENCY), 3)
                        )
                ));
        bootstrap.register(
                evilex, new SlashBladeDefinition(Legendblade.prefix("evilex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/evilex/evilex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/evilex/evilex.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                leviathanex, new SlashBladeDefinition(Legendblade.prefix("leviathanex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/leviathanex/leviathanex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/leviathanex/leviathanex.obj"))
                                .effectColor(65499)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.flurry.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Resentment.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 7)
                        )
                ));
        bootstrap.register(
                luciferex, new SlashBladeDefinition(Legendblade.prefix("luciferex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/luciferex/luciferex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/luciferex/luciferex.obj"))
                                .effectColor(16514816)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Suppress.getId())
                                .slashArtsType(LBslashArtRegsitry.Thatcher.getId())
                                .baseAttackModifier(35)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 7)
                        )
                ));
        bootstrap.register(
                mammonex, new SlashBladeDefinition(Legendblade.prefix("mammonex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/mammonex/mammonex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/mammonex/mammonex.obj"))
                                .effectColor(16737792)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.GreedyGrip.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Endless.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(34)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 7)
                        )
                ));
        bootstrap.register(
                samaelex, new SlashBladeDefinition(Legendblade.prefix("samaelex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/samaelex/samaelex.png"))
                                .modelName(Legendblade.prefix("model/bladeex/samaelex/samaelex.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Sin.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Bloodthirsty.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 7)
                        )
                ));
        bootstrap.register(
                foxex, new SlashBladeDefinition(Legendblade.prefix("foxex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture.png"))
                                .modelName(Legendblade.prefix("model/foxex/model.obj"))
                                .effectColor(16187647)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .slashArtsType(LBslashArtRegsitry.VoidSlashPlus.getId())
                                .baseAttackModifier(22)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                foxex2, new SlashBladeDefinition(Legendblade.prefix("foxex2"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture2.png"))
                                .modelName(Legendblade.prefix("model/foxex/model.obj"))
                                .effectColor(2633861)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .slashArtsType(LBslashArtRegsitry.Thrust.getId())
                                .baseAttackModifier(22)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                foxexfinal, new SlashBladeDefinition(Legendblade.prefix("foxexfinal"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/foxex/texture3.png"))
                                .effectColor(16187647)
                                .modelName(Legendblade.prefix("model/foxex/model2.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SAKURAENDEX.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SummonSword.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .baseAttackModifier(35)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                ));
        bootstrap.register(
                wujiu, new SlashBladeDefinition(Legendblade.prefix("wujiu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/yaoxing/wujiu.png"))
                                .modelName(Legendblade.prefix("model/yaoxing/wujiu.obj"))
                                .effectColor(12434877)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.swordone.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Liuli.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Liulione.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)

                        )
                ));

        bootstrap.register(
                belphebubex, new SlashBladeDefinition(Legendblade.prefix("belphebubex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubexex_export.png"))
                                .modelName(Legendblade.prefix("model/bladeex/beelzebubex/beelzebubex.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.HungerAbsorption.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Feastful.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Shackles.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));

        bootstrap.register(
                waterex, new SlashBladeDefinition(Legendblade.prefix("waterex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/water.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(8703)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.terrifyingwavesSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.Terrifyingwaves.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5)
                        )
                ));
        bootstrap.register(
                fireex, new SlashBladeDefinition(Legendblade.prefix("fireex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/fire.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.DanceSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.FireDancy.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                lightningex, new SlashBladeDefinition(Legendblade.prefix("lightningex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/kaumyex/lightning.png"))
                                .modelName(Legendblade.prefix("model/kaumyex/kamuyex.obj"))
                                .effectColor(16766720)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SBALBSlashArtRegsitry.lightingsumSA.getId())
                                .addSpecialEffect(SBALBSlashArtRegsitry.Lightingsum.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7)
                        )
                ));
        bootstrap.register(
                sevensword, new SlashBladeDefinition(Legendblade.prefix("sevensword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/sevensword/texture.png"))
                                .modelName(Legendblade.prefix("model/sevensword/model.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .slashArtsType(LBslashArtRegsitry.sevenbladeslash.getId())
                                .maxDamage(2000)
                                .addSpecialEffect(LBSpecialEffectsRegistry.FragmentedEdge.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .build(),

                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                godbird, new SlashBladeDefinition(Legendblade.prefix("godbird"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/godbird/texture.png"))
                                .modelName(Legendblade.prefix("model/godbird/model.obj"))
                                .effectColor(65343)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.Thrusts.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 10)
                        )
                ));

        bootstrap.register(
                crimsoncherryex, new SlashBladeDefinition(Legendblade.prefix("crimsoncherryex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/crimsoncherry.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.SAKURA_END.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.EndSakuraRiseUp.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5)
                        )
                ));

        bootstrap.register(
                nihilulex, new SlashBladeDefinition(Legendblade.prefix("nihilulex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/nihilul.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16187647)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.WaveEdgeRiseUp.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5)
                        )
                ));
        bootstrap.register(
                nihilbxex, new SlashBladeDefinition(Legendblade.prefix("nihilbxex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/nihill/nihilbx.png"))
                                .modelName(Legendblade.prefix("model/nihill/nihilbloodex.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SAKURAENDEX.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.EndSakuraRiseUp.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.WaveEdgeRiseUp.getId())
                                .baseAttackModifier(35)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 10)
                        )
                ));
        bootstrap.register(
                ark, new SlashBladeDefinition(Legendblade.prefix("ark"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/ark/ark.png"))
                                .modelName(Legendblade.prefix("model/ark/ark.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(L2LBcompatRegsitry.HosSword.getId())
                                .slashArtsType(L2LBcompatRegsitry.HosSwords.getId())
                                .baseAttackModifier(15)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                neo, new SlashBladeDefinition(Legendblade.prefix("neo"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/ark/neo.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(10289407)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(L2LBcompatRegsitry.HosSwords.getId())
                                .addSpecialEffect(L2LBcompatRegsitry.HosSword.getId())
                                .addSpecialEffect(L2LBcompatRegsitry.ARK.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(LCEnchantments.FLAME_BLADE.get()), 3),
                                new EnchantmentDefinition(getEnchantmentID(LCEnchantments.SHARP_BLADE.get()), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10)

                        )

                ));
        bootstrap.register(
                administrator, new SlashBladeDefinition(Legendblade.prefix("administrator"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/administrator/administrator.png"))
                                .modelName(Legendblade.prefix("model/administrator/administrator.obj"))
                                .effectColor(14591)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(18)
                                .slashArtsType(LBslashArtRegsitry.delete.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)

                        )
                ));
        bootstrap.register(
                demonbird, new SlashBladeDefinition(Legendblade.prefix("demonbird"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/blood/demonbird/texture.png"))
                                .modelName(Legendblade.prefix("model/godbird/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(LBslashArtRegsitry.BloodThrusts.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                fire, new SlashBladeDefinition(Legendblade.prefix("dragon_fire"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/fire.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(16477711)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.fire.getId())
                                .slashArtsType(ICFLBcompatRegsitry.Firesummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                ice, new SlashBladeDefinition(Legendblade.prefix("dragon_ice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/ice.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(46079)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.ice.getId())
                                .slashArtsType(ICFLBcompatRegsitry.Icesummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10))
                ));
        bootstrap.register(
                lightning, new SlashBladeDefinition(Legendblade.prefix("dragon_lightning"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icf/lightning.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icf/model.obj"))
                                .effectColor(8847615)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(ICFLBcompatRegsitry.lightning.getId())
                                .slashArtsType(ICFLBcompatRegsitry.lightningsummonsword.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(13)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10))
                ));
        bootstrap.register(
                zhuzi, new SlashBladeDefinition(Legendblade.prefix("zhuzi"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/sange.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(1834752)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(8)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                blaze, new SlashBladeDefinition(Legendblade.prefix("blaze"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/fire.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(16477711)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Firesummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.fire.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));
        bootstrap.register(
                zerogalaxy, new SlashBladeDefinition(Legendblade.prefix("zerogalaxy"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/lightning.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(8847615)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Lightningsummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.lightning.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));

        bootstrap.register(
                foreverice, new SlashBladeDefinition(Legendblade.prefix("foreverice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/icfcompat/icfex/ice.png"))
                                .modelName(Legendblade.prefix("model/icfcompat/icfex/terra.obj"))
                                .effectColor(46079)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .slashArtsType(ICFLBcompatRegsitry.Icesummonsword.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.ice.getId())
                                .addSpecialEffect(ICFLBcompatRegsitry.icfbreaker.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(30)
                                .maxDamage(800)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                        )
                ));
        bootstrap.register(
                truebloodfox, new SlashBladeDefinition(Legendblade.prefix("truebloodfox"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/blood/demonfox/demonfox.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(16711697)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .addSpecialEffect(LBSpecialEffectsRegistry.bloodfox.getId())
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5)
                        )
                ));
        bootstrap.register(
                eiily, new SlashBladeDefinition(Legendblade.prefix("eiily"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/white.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(11010303)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                zangetsu, new SlashBladeDefinition(Legendblade.prefix("zangetsu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/zangetsu/zangetsu.png"))
                                .modelName(Legendblade.prefix("model/lostblade/zangetsu/zangetsu.obj"))
                                .effectColor(16766464)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.MoonDrive.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 3)
                        )
                ));
        bootstrap.register(
                frog, new SlashBladeDefinition(Legendblade.prefix("frog"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/frog/frog.png"))
                                .modelName(Legendblade.prefix("model/lostblade/frog/frog.obj"))
                                .effectColor(16766464)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.FrogGlaxy.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5)
                        )
                ));
        bootstrap.register(
                fish, new SlashBladeDefinition(Legendblade.prefix("fish"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/fish/fish.png"))
                                .modelName(Legendblade.prefix("model/lostblade/fish/fish.obj"))
                                .effectColor(54527)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SaveAll.getId())
                                .baseAttackModifier(17)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SWEEPING_EDGE), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FALL_PROTECTION), 2)
                        )
                ));
        bootstrap.register(
                tensazangetsu, new SlashBladeDefinition(Legendblade.prefix("tensazangetsu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/tensazangetsu/texture.png"))
                                .modelName(Legendblade.prefix("model/lostblade/tensazangetsu/model.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.EXmoonDrive.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 1)
                        )
                ));
        bootstrap.register(
                tensazangetsured, new SlashBladeDefinition(Legendblade.prefix("tensazangetsured"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/tensazangetsu/texture2.png"))
                                .modelName(Legendblade.prefix("model/lostblade/tensazangetsu/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .slashArtsType(LBslashArtRegsitry.EXmoonDrive.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1)
                        )
                ));
        bootstrap.register(
                crowbar, new SlashBladeDefinition(Legendblade.prefix("crowbar"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/crowbar/crowbar.png"))
                                .modelName(Legendblade.prefix("model/lostblade/crowbar/crowbar.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Elbowstrike.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.ALL_DAMAGE_PROTECTION), 5)
                        )
                ));
        bootstrap.register(
                undragon, new SlashBladeDefinition(Legendblade.prefix("undragon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/undragon/undragon.png"))
                                .modelName(Legendblade.prefix("model/lostblade/undragon/undragon.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.swordRain.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 9)
                        )
                ));

        bootstrap.register(
                breakarm, new SlashBladeDefinition(Legendblade.prefix("breakarm"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/breakarm.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(32768)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(TFLBcompat.breakarm.getId())
                                .baseAttackModifier(18)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                allice, new SlashBladeDefinition(Legendblade.prefix("allice"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/allice.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(54527)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.CIRCLE_SLASH.getId())
                                .addSpecialEffect(TFLBcompat.allice.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000).build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                fireiron, new SlashBladeDefinition(Legendblade.prefix("fireiron"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/tfcompat/fireiron.png"))
                                .modelName(Legendblade.prefix("model/named/truegodfox/model.obj"))
                                .effectColor(14749969)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(20)
                                .slashArtsType(SBASlashArtsRegistry.SPIRAL_EDGE.getId())
                                .addSpecialEffect(TFLBcompat.fire.getId())
                                .maxDamage(2000).build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                wonderblade, new SlashBladeDefinition(Legendblade.prefix("wonderblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/wonderblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/wonderblade.obj"))
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.RainBow.getId())
                                .baseAttackModifier(12)
                                .maxDamage(2000).build(),
                        List.of(
                        )
                )
        );
        bootstrap.register(
                desireblade, new SlashBladeDefinition(Legendblade.prefix("desireblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/desireblade.png"))
                                .effectColor(8847615)
                                .modelName(Legendblade.prefix("model/heartblade/desireblade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.PhantomThrust.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Need.getId())
                                .baseAttackModifier(23)
                                .maxDamage(2000).build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7)
                        )
                )
        );
        bootstrap.register(
                shallot, new SlashBladeDefinition(Legendblade.prefix("shallot"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/shallot.png"))
                                .effectColor(65432)
                                .modelName(Legendblade.prefix("model/heartblade/shallot.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.MaxSky.getId())
                                .addSpecialEffect(NrSpecialEffectsRegistry.Oracle.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000).build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 5)
                        )
                )
        );
        bootstrap.register(
                starriverblade, new SlashBladeDefinition(Legendblade.prefix("starriverblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/starriverblade.png"))
                                .effectColor(16772352)
                                .modelName(Legendblade.prefix("model/heartblade/starriverblade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Shinening.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000).build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 6),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BANE_OF_ARTHROPODS), 10)
                        )
                )
        );
        bootstrap.register(
                tensazangetsunomoon, new SlashBladeDefinition(Legendblade.prefix("tensazangetsunomoon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/tensazangetsu/texture.png"))
                                .modelName(Legendblade.prefix("model/lostblade/tensazangetsu/model.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.LastMoondrive.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 15),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                phantomOfGods, new SlashBladeDefinition(Legendblade.prefix("phantomofgods"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/phantomofgods.png"))
                                .modelName(Legendblade.prefix("model/heartblade/phantomofgods.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.DarkGod.getId())
                                .addSpecialEffect(NrSpecialEffectsRegistry.Oracle.getId())
                                .baseAttackModifier(45)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 101)
                        )
                ));
        bootstrap.register(
                Itan, new SlashBladeDefinition(Legendblade.prefix("itan"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/itan.png"))
                                .modelName(Legendblade.prefix("model/heartblade/itan.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Zain.getId())
                                .baseAttackModifier(26)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                nobleblade, new SlashBladeDefinition(Legendblade.prefix("nobleblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/nobleblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/nobleblade.obj"))
                                .effectColor(9922895)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.EnduranceTower.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                sangeex, new SlashBladeDefinition(Legendblade.prefix("sangeex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/sangeex/sange.png"))
                                .modelName(Legendblade.prefix("model/sangeex/sange.obj"))
                                .effectColor(14404023)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SanNight.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SanNight.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5)
                        )
                ));
        bootstrap.register(
                mrke, new SlashBladeDefinition(Legendblade.prefix("mrke"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/mrke.png"))
                                .modelName(Legendblade.prefix("model/heartblade/mrke.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 0)
                        )
                ));
        bootstrap.register(
                hu, new SlashBladeDefinition(Legendblade.prefix("hu"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/zhao.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3))
                ));
        bootstrap.register(
                VoidSword, new SlashBladeDefinition(Legendblade.prefix("voidsword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/voidsword.png"))
                                .modelName(Legendblade.prefix("model/heartblade/voidsword.obj"))
                                .effectColor(0)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.VoidMaker.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 10)
                        )
                ));
        bootstrap.register(
                dguoblade, new SlashBladeDefinition(Legendblade.prefix("dguoblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/dguoblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/dguoblade.obj"))
                                .effectColor(8847615)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.JUDGEMENT_CUT.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Haiker.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SuperMe.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 3)
                        )
                ));
        bootstrap.register(
                xhar, new SlashBladeDefinition(Legendblade.prefix("xhar"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/xhar.png"))
                                .modelName(Legendblade.prefix("model/heartblade/xhar.obj"))
                                .effectColor(16711680)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.JUDGEMENT_CUT.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Max.getId())

                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 7)
                        )
                ));
        bootstrap.register(
                Seele, new SlashBladeDefinition(Legendblade.prefix("seele"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/seele.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(16711680)
                                .effectColorInverse(true)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))

                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3)
                        )
                ));
        bootstrap.register(
                bloodfoxex, new SlashBladeDefinition(Legendblade.prefix("bloodfoxex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/blood/demonfox/demonfox.png"))
                                .modelName(Legendblade.prefix("model/foxex/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.FoxBlessing.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.bloodfox.getId())
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .baseAttackModifier(35)
                                .maxDamage(2000)
                                .build(),
                        List.of(new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5)
                        )
                ));
        bootstrap.register(
                justicegun, new SlashBladeDefinition(Legendblade.prefix("justicegun"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/justicegun.png"))
                                .modelName(Legendblade.prefix("model/heartblade/justicegun.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.PhysicsDepartment.getId())
                                .slashArtsType(LBslashArtRegsitry.Splitapart.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7)
                        )
                ));
        bootstrap.register(
                natureblade, new SlashBladeDefinition(Legendblade.prefix("natureblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/natureblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/natureblade.obj"))
                                .effectColor(65298)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Strength.getId())
                                .slashArtsType(LBslashArtRegsitry.THRUSTSUMMONSWORD.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10)
                        )
                ));
        bootstrap.register(
                beyondblade, new SlashBladeDefinition(Legendblade.prefix("beyondblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/beyondblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/beyondblade.obj"))
                                .effectColor(16772352)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .slashArtsType(LBslashArtRegsitry.getThrust.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Devastate.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 7),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 7)
                        )
                ));
        bootstrap.register(
                SolemnLament, new SlashBladeDefinition(Legendblade.prefix("solemnlament"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/solemnlament.png"))
                                .modelName(Legendblade.prefix("model/heartblade/solemnlament.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .slashArtsType(LBslashArtRegsitry.ButterFly.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.PhysicsDepartmentFly.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SolemnMourning.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                maxkimblade, new SlashBladeDefinition(Legendblade.prefix("maxkimblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/maxkimblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/maxkimblade.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.MaxSky.getId())

                                .baseAttackModifier(24)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.BLOCK_FORTUNE), 1)
                        )
                ));
        bootstrap.register(
                Reversed, new SlashBladeDefinition(Legendblade.prefix("reversed"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/speed/speed.png"))
                                .modelName(Legendblade.prefix("model/speed/speed.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .slashArtsType(LBslashArtRegsitry.ALLOVER.getId())
                                .addSpecialEffect(SBASpecialEffectsRegistry.BURST_DRIVE.getId())

                                .baseAttackModifier(20)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 10)
                                )
                ));
        bootstrap.register(
                iceblade, new SlashBladeDefinition(Legendblade.prefix("iceblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/iceblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/iceblade.obj"))
                                .effectColor(917759)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Cold.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.GoldBlade.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_PROTECTION), 9),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Dubhe, new SlashBladeDefinition(Legendblade.prefix("dubhe"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/dubhe.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())

                                .addSpecialEffect(LBSpecialEffectsRegistry.Dubhe.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.DubheEX.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Megrez, new SlashBladeDefinition(Legendblade.prefix("megrez"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/megrez.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(65379)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())

                                .addSpecialEffect(LBSpecialEffectsRegistry.Megrez.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.MegrezEX.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Mizar, new SlashBladeDefinition(Legendblade.prefix("mizar"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/mizar.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(917759)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Mizar.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.MizarEX.getId())
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Phecda, new SlashBladeDefinition(Legendblade.prefix("phecda"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/phecda.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(15662848)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Phecda.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.PhecdaEX.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Hagen, new SlashBladeDefinition(Legendblade.prefix("hagen"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/hagen.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(16764160)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Hagen.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.HagenEX.getId())
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Alkaid, new SlashBladeDefinition(Legendblade.prefix("alkaid"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/alkaid.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(11993343)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Alkaid.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.AlkaidEX.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                Fenrir, new SlashBladeDefinition(Legendblade.prefix("fenrir"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/fenrir.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(65535)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Fenrir.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.FenrirEX.getId())
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 9)
                        )
                ));
        bootstrap.register(
                White, new SlashBladeDefinition(Legendblade.prefix("white"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/stars/white.png"))
                                .modelName(Legendblade.prefix("model/lostblade/stars/xingxuan.obj"))
                                .effectColor(16777215)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.StarEdge.getId())
                                .baseAttackModifier(10)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3)
                        )
                ));
        bootstrap.register(
                matongcblade, new SlashBladeDefinition(Legendblade.prefix("matongcblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/matongcblade.png"))
                                .modelName(Legendblade.prefix("model/heartblade/matongcblade.obj"))
                                .effectColor(45311)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.BreakAll.getId())
                                .slashArtsType(SBASlashArtsRegistry.WATER_DRIVE.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 10)
                        )
                ));
        bootstrap.register(
                blackcloud, new SlashBladeDefinition(Legendblade.prefix("blackcloud"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/blackcloud/blackcloud.png"))
                                .modelName(Legendblade.prefix("model/lostblade/blackcloud/blackcloud.obj"))
                                .effectColor(42495)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))



                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10)
                        )
                ));
        bootstrap.register(
                rustkingsowrd, new SlashBladeDefinition(Legendblade.prefix("rustkingsowrd"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/kingsword/kingsword_rusty.png"))
                                .modelName(Legendblade.prefix("model/lostblade/kingsword/kingsword.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))



                                .baseAttackModifier(5)
                                .maxDamage(2000)
                                .build(),
                        List.of(

                        )
                ));
        bootstrap.register(
                kingsowrd, new SlashBladeDefinition(Legendblade.prefix("kingsowrd"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/lostblade/kingsword/kingsword.png"))
                                .modelName(Legendblade.prefix("model/lostblade/kingsword/kingsword.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Foever.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Dawn.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.ExtinctionOfProjectiles.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)
                        )
                ));
        bootstrap.register(
                vanity, new SlashBladeDefinition(Legendblade.prefix("vanity"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/heartblade/dark.png"))
                                .modelName(Legendblade.prefix("model/heartblade/golden.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.NonePower.getId())
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(1000)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 101)
                        )
                ));
        bootstrap.register(
                blade_diamond, new SlashBladeDefinition(Legendblade.prefix("blade_diamond"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade1.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                blade_iron, new SlashBladeDefinition(Legendblade.prefix("blade_iron"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade2.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(6)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                blade_stone, new SlashBladeDefinition(Legendblade.prefix("blade_stone"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade3.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(5)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                blade_gold, new SlashBladeDefinition(Legendblade.prefix("blade_gold"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade4.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(4)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                blade_wood, new SlashBladeDefinition(Legendblade.prefix("blade_wood"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade6.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(4)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                blade_netherite, new SlashBladeDefinition(Legendblade.prefix("blade_netherite"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade5.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/blade/blade.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .baseAttackModifier(10)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                        )
                ));
        bootstrap.register(
                dimension, new SlashBladeDefinition(Legendblade.prefix("dimension"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/dimension/dimension.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/dimension/dimension.obj"))
                                .effectColor(14156031)
                        .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.ThrustEEX.getId())
                                .baseAttackModifier(29)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5)
                        )
                ));
        bootstrap.register(
                dragonblade, new SlashBladeDefinition(Legendblade.prefix("dragonblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/dragonblade/dragonblade.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/dragonblade/dragonblade.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.DragonBoost.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5)
                        )
                ));
        bootstrap.register(
                blackpixie, new SlashBladeDefinition(Legendblade.prefix("blackpixie"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/blackpixie/blackpixie.png"))
                                .modelName(Legendblade.prefix("model/named/godfox/model.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.BlackHole.getId())
                                .baseAttackModifier(35)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 2)
                        )
                ));
        bootstrap.register(
                kingblade, new SlashBladeDefinition(Legendblade.prefix("kingblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/kingblade/kingblade.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/kingblade/kingblade.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.kingblade.getId())
                                .baseAttackModifier(23)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2)
                        )
                ));
        bootstrap.register(
                kumasakura, new SlashBladeDefinition(Legendblade.prefix("kumasakura"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/kumasakura/kumasakura.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/kumasakura/kumasakura.obj"))
                                .effectColor(15662848)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .baseAttackModifier(19)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3)
                        )
                ));
        bootstrap.register(
                magicblade, new SlashBladeDefinition(Legendblade.prefix("magicblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/magicblade/magicblade.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/magicblade/magicblade.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.Blackslash.getId())
                                .baseAttackModifier(32)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3)
                        )
                ));

        bootstrap.register(
                purplesblade, new SlashBladeDefinition(Legendblade.prefix("purplesblade"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/purplesblade/purplesblade.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/purplesblade/purplesblade.obj"))
                                .effectColor(9765119)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.ThrustSlash.getId())
                                .baseAttackModifier(14)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2)
                        )
                ));
        bootstrap.register(
                pseudosword, new SlashBladeDefinition(Legendblade.prefix("pseudosword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/sword/pseudosword.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/sword/sword.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2)
                        )
                ));
        bootstrap.register(
                whitesword, new SlashBladeDefinition(Legendblade.prefix("whitesword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/sword/whitensword.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/sword/sword.obj"))
                                .effectColor(16777215)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(28)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 1),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 1)
                        )
                ));
        bootstrap.register(
                latent, new SlashBladeDefinition(Legendblade.prefix("latent"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/latent/latent.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/emptyblade/emptyblade.obj"))
                                .effectColor(0)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 3)
                        )
                ));
        bootstrap.register(
                vitex, new SlashBladeDefinition(Legendblade.prefix("vitex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/vitex/vitex.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/vitex/vitex.obj"))
                                .effectColor(9765119)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.ThrustSlashEX.getId())
                                .baseAttackModifier(30)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 2),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 3)
                        )
                ));
        bootstrap.register(
                xblades, new SlashBladeDefinition(Legendblade.prefix("xblades"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/pseudo/named/pseudosword/xblades/xblades.png"))
                                .modelName(Legendblade.prefix("model/pseudo/named/pseudosword/xblades/xblades.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(25)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.FIRE_ASPECT), 2)
                        )
                ));
        bootstrap.register(
                zein, new SlashBladeDefinition(Legendblade.prefix("zein"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/other/zein/zein.png"))
                                .modelName(Legendblade.prefix("model/virtue/other/zein/zein.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(10)
                                .slashArtsType(SlashArtsRegistry.NONE.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                holy, new SlashBladeDefinition(Legendblade.prefix("holy"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/other/holy/holy.png"))
                                .modelName(Legendblade.prefix("model/virtue/other/holy/holy.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Charlier, new SlashBladeDefinition(Legendblade.prefix("charlier"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/charlier/charlier.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/charlier/charlier.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Lemir, new SlashBladeDefinition(Legendblade.prefix("lemir"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/lemir/lemir.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/lemir/lemir.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Rafael, new SlashBladeDefinition(Legendblade.prefix("rafael"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/rafael/rafael.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/rafael/rafael.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Michael, new SlashBladeDefinition(Legendblade.prefix("michael"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/michael/michael.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/michael/michael.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Uriel, new SlashBladeDefinition(Legendblade.prefix("uriel"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/uriel/uriel.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/uriel/uriel.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Gabriel, new SlashBladeDefinition(Legendblade.prefix("gabriel"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/gabriel/gabriel.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/gabriel/gabriel.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                metatron, new SlashBladeDefinition(Legendblade.prefix("metatron"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/one/metatron/metatron.png"))
                                .modelName(Legendblade.prefix("model/virtue/one/metatron/metatron.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of()
                ));
        bootstrap.register(
                Charlierex, new SlashBladeDefinition(Legendblade.prefix("charlierex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/charlierex/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/charlierex/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(LBslashArtRegsitry.Wakeup.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.pure.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MOB_LOOTING), 5)
                        )
                ));
        bootstrap.register(
                Lemirex, new SlashBladeDefinition(Legendblade.prefix("lemirex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/lemirex/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/lemirex/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(32)
                                .slashArtsType(LBslashArtRegsitry.rot_slash.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 10)
                        )
                ));
        bootstrap.register(
                Rafaelex, new SlashBladeDefinition(Legendblade.prefix("rafaelex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/rafaelex/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/rafaelex/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(35)
                                .slashArtsType(LBslashArtRegsitry.heal_slash.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.HealIs.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5)
                        )
                ));
        bootstrap.register(
                Michaelex, new SlashBladeDefinition(Legendblade.prefix("michaelex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/michaelex/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/michaelex/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(33)
                                .slashArtsType(LBslashArtRegsitry.jusitce_slash.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Aryadeva.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.PUNCH_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5)
                        )
                ));
        bootstrap.register(
                Urielx, new SlashBladeDefinition(Legendblade.prefix("urielx"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/urielx/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/urielx/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(15)
                                .slashArtsType(LBslashArtRegsitry.ultra_slash.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Eternal.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SMITE), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.SHARPNESS), 5)
                        )
                ));
        bootstrap.register(
                Gabrielex, new SlashBladeDefinition(Legendblade.prefix("gabrielex"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/gabrielex/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/gabrielex/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(34)
                                .slashArtsType(LBslashArtRegsitry.CircleSlashex.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.MaxSky.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.TheShineSummonSword.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 5)
                        )
                ));
        bootstrap.register(
                metatronx, new SlashBladeDefinition(Legendblade.prefix("metatronx"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/virtue/two/metatronx/1.png"))
                                .modelName(Legendblade.prefix("model/virtue/two/metatronx/1.obj"))
                                .effectColor(14540253)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(40)
                                .slashArtsType(LBslashArtRegsitry.JudgementCutExbig.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Justice.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.nofear.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of( new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 10),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.KNOCKBACK), 5),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.THORNS), 3)


                        )
                ));
        bootstrap.register(
                Timotheos, new SlashBladeDefinition(Legendblade.prefix("timotheos"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/timotheos.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .addSpecialEffect(NrSpecialEffectsRegistry.Oracle.getId())
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                superred, new SlashBladeDefinition(Legendblade.prefix("superred"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/super_red.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))

                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                bujin_sword, new SlashBladeDefinition(Legendblade.prefix("bujin_sword"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/bujin_sword.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(20505)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))

                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                dios, new SlashBladeDefinition(Legendblade.prefix("dios"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/dios.png"))
                                .modelName(Legendblade.prefix("model/mrzhu/dios.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(SlashArtsRegistry.WAVE_EDGE.getId())
                                .addSpecialEffect(NrSpecialEffectsRegistry.Oracle.getId())
                                .baseAttackModifier(13)
                                .maxDamage(2000)
                                .build(),
                        List.of(
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.POWER_ARROWS), 3),
                                new EnchantmentDefinition(getEnchantmentID(Enchantments.MENDING), 3)

                        )
                ));
        bootstrap.register(
                ten_blades, new SlashBladeDefinition(Legendblade.prefix("ten_blades"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/saber.png"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(21503)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                temperance, new SlashBladeDefinition(Legendblade.prefix("temperance"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/solmen/temperance.png"))
                                .modelName(Legendblade.prefix("model/solmen/temperance.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(7)
                                .slashArtsType(SlashArtsRegistry.DRIVE_VERTICAL.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of( ))
                );
        bootstrap.register(
                reflection, new SlashBladeDefinition(Legendblade.prefix("reflection"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/solmen/reflection.png"))
                                .modelName(Legendblade.prefix("model/solmen/reflection.obj"))
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(12)
                                .slashArtsType(LBslashArtRegsitry.ALLOVER.getId())
                                .maxDamage(2000)
                                .build(),
                        List.of())
        );
        bootstrap.register(
                solomon, new SlashBladeDefinition(Legendblade.prefix("solomon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/solmen/solomon.png"))
                                .modelName(Legendblade.prefix("model/solmen/solomon.obj"))
                                .effectColor(21503)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.ALLOVEREX2.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Theinescapableguilt.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.HelplessRest.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.Anuntraceablehope.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of())
        );
        bootstrap.register(
                reverse_solomon, new SlashBladeDefinition(Legendblade.prefix("reverse_solomon"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/solmen/reverse_solomon.png"))
                                .modelName(Legendblade.prefix("model/solmen/reverse_solomon.obj"))
                                .effectColor(16711680)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.ALLOVEREX.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.OccupyingHeart.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.SeizetheBlood.getId())
                                .addSpecialEffect(LBSpecialEffectsRegistry.CompassionforTorture.getId())
                                .baseAttackModifier(40)
                                .maxDamage(2000)
                                .build(),
                        List.of())
        );
        bootstrap.register(
                shirin, new SlashBladeDefinition(Legendblade.prefix("shirin"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/mrzhu/shirin.jpg"))
                                .modelName(Legendblade.prefix("model/named/rustgodfox/model.obj"))
                                .effectColor(12124399)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .slashArtsType(LBslashArtRegsitry.SlashShine.getId())
                                .baseAttackModifier(7)
                                .maxDamage(2000)
                                .build(),
                        List.of(  new EnchantmentDefinition(getEnchantmentID(Enchantments.UNBREAKING), 3))
                ));
        bootstrap.register(
                everything_not_ending, new SlashBladeDefinition(Legendblade.prefix("everything_not_ending"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/orm/everything_not_ending/tex.png"))
                                .modelName(Legendblade.prefix("model/orm/everything_not_ending/mdl.obj"))
                                .effectColor(8191)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(1)
                                .maxDamage(2000)
                                .build(),
                        List.of(  )
                ));
        bootstrap.register(
                from_local_tourist, new SlashBladeDefinition(Legendblade.prefix("from_local_tourist"),
                        RenderDefinition.Builder.newInstance()
                                .textureName(Legendblade.prefix("model/orm/hyperdimensional/texture.png"))
                                .modelName(Legendblade.prefix("model/orm/hyperdimensional/model.obj"))
                                .effectColor(3932415)
                                .build(),
                        PropertiesDefinition.Builder.newInstance()
                                .defaultSwordType(List.of(SwordType.BEWITCHED))
                                .baseAttackModifier(1)
                                .maxDamage(2000)
                                .build(),
                        List.of(  )
                ));
    }





    private static ResourceKey<SlashBladeDefinition> register(String id) {
        return ResourceKey.create(SlashBladeDefinition.REGISTRY_KEY, Legendblade.prefix(id));
    }
    static ResourceLocation getEnchantmentID(Enchantment enchantment) {
        return ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
    }

}
