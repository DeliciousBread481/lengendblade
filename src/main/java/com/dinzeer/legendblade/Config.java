package com.dinzeer.legendblade;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.boss.wither.WitherBoss;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = Legendblade.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue open_damege_fix = BUILDER
            .comment("Whether to enable abnormal damage repair")
            .comment("是否启用平衡捍卫者")
            .define("open_damege_fix", false);
    private static final ForgeConfigSpec.ConfigValue<Double> damegeadd = BUILDER
            .comment("The forging number affects the sa and se ratio, with a default forging ratio of 1 and an additional ratio of 0.1")
            .comment("锻数影响sa倍率，默认1锻造：0.1额外倍率（已不再维护）")
            .define("damegeadd", 0.1);
    private static final ForgeConfigSpec.ConfigValue<Double> damegeaddmax = BUILDER
            .comment("damegeadd max if 0 is off")
            .comment("锻造数影响倍率上限，0为关闭（已不在维护）")
            .define("damegeaddmax", 0.0);
    private static final ForgeConfigSpec.BooleanValue sevenbladeskill = BUILDER
            .comment("seven sword kill or no kill")
            .comment("魔刀sa是否靠杀敌启动")
            .define("sevenbladeskill", true);
    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal = BUILDER
            .comment("soul crystal loot")
            .comment("魂缚晶的掉落要求血量（看基础值）")
            .define("soul_crystal", 200.0);
    private static final ForgeConfigSpec.ConfigValue<Double> distance = BUILDER
            .comment("damage repair distance max" )
            .comment("平衡捍卫者最大削减")
            .define("distance", 5.0);
    private static final ForgeConfigSpec.ConfigValue<Double> BALANCE_DAMAGE_AMOUNT = BUILDER
            .comment("damage repair distance min" )
            .comment("平衡捍卫者削减")
            .define("blanke_damage_amount", 0.2);
    private static final ForgeConfigSpec.BooleanValue comboadd = BUILDER
            .comment("Can the sword that uses the combo system receive damage increase from the combo system?")
            .comment("使用到连击系统的拔刀剑是否能收到连击系统增伤")
            .define("comboadd", false);
    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal_extra = BUILDER
            .comment("Extra drop configuration item for soul crystal (algorithm based on monster's maximum health - required health)/This configuration item")
            .comment("魂缚晶的额外掉落配置项（算法为怪物最大血量-要求血量）/本配置项")
            .define("soul_crystal_extra", 50.0);
    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal_extra_MAX = BUILDER
            .comment("Extra drop configuration item for Soul Binding Crystals (algorithm based on monster's maximum health - required health)/This configuration item")
            .comment("魂缚晶一次最多能掉多少")
            .define("soul_crystal_extra_max", 10.0);

    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal_add_kill_count = BUILDER
            .comment("魂缚晶增幅多少杀敌数")
            .define("soul_crystal_add_kill_count", 100.0);
    private static final ForgeConfigSpec.ConfigValue<Double> Soul_crystal_add_proud_soul_count = BUILDER
            .comment("魂缚晶增幅多少耀魂数")
            .define("soul_crystal_add_proud_soul_count", 300.0);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean Open_damege_fix;
    public static double damegeaddd;
    public static double damegeadddmaX;
    public static boolean sevenbladesKill;
    public static double soul_crystal;
    public static double distanceget;
    public static double BALANCE_DAMAGE_AMOUNT_GET;
    public static double soul_crystal_extra;
    public static double soul_crystal_extra_max;
    public static boolean comboadder;
    public static int soul_crystal_add_kill_count;
    public static int soul_crystal_add_proud_soul_count;
    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        Open_damege_fix = open_damege_fix.get();
        damegeaddd=damegeadd.get();
        damegeadddmaX=damegeaddmax.get();
        sevenbladesKill=sevenbladeskill.get();
        soul_crystal=Soul_crystal.get();
        distanceget=distance.get();
        BALANCE_DAMAGE_AMOUNT_GET=BALANCE_DAMAGE_AMOUNT.get();
        comboadder=comboadd.get();
        soul_crystal_extra=Soul_crystal_extra.get();
        soul_crystal_extra_max=Soul_crystal_extra_MAX.get();
        soul_crystal_add_kill_count= (int) Math.ceil(Soul_crystal_add_kill_count.get());
        soul_crystal_add_proud_soul_count=(int) Math.ceil(Soul_crystal_add_proud_soul_count.get());
    }
}
