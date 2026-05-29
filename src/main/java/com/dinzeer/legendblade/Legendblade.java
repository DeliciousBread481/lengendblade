package com.dinzeer.legendblade;

import cn.mmf.slashblade_addon.SlashBladeAddon;
import com.dinzeer.legendblade.effect.*;
import com.dinzeer.legendblade.enchantments.SwordRawEnchantment;
import com.dinzeer.legendblade.network.DemonBladeMessage;
import com.dinzeer.legendblade.network.DemonBladeMessageA;
import com.dinzeer.legendblade.regsitry.compat.*;
import com.dinzeer.legendblade.regsitry.other.*;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitry;
import com.dinzeer.legendblade.regsitry.slashblade.LBComboRegsitryA;
import com.dinzeer.legendblade.regsitry.slashblade.LBSpecialEffectsRegistry;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.dinzeer.legendblade.specialeffects.compat.l2hostily.Arkex;
import com.exfantasy.mclib.Utils.Dash.DashMessage;
import com.dinzeer.legendblade.regsitry.creativetab.ItemTab;
import com.github.alexthe666.iceandfire.IceAndFire;
import com.mojang.logging.LogUtils;
import com.tterrag.registrate.Registrate;
import dev.xkmc.l2damagetracker.contents.attack.AttackEventHandler;
import dev.xkmc.l2hostility.init.L2Hostility;
import net.minecraft.data.DataGenerator;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import twilightforest.TwilightForestMod;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;


@Mod(Legendblade.MODID)
public class Legendblade {


    public static ResourceLocation prefix(String path) {

        return new ResourceLocation(MODID, path);
    }


    public static final String MODID = "legendblade";

    public static final Logger LOGGER = LogUtils.getLogger();

    public static final Registrate REGISTRATE = Registrate.create(MODID);


    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MODID, "main"),
            () -> "1.0",
            s -> true,
            s -> true
    );
    private static int messageID = 0;
    public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
        INSTANCE.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
        messageID++;
    }

    public Legendblade() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        LangRegsitry.registerAddlang();
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::register);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
         LBEntiteRegristrys.register(modEventBus);
         LBEntiteRegristrys.other.REGISTRY.register(modEventBus);
        LBComboRegsitry.COMBO_STATES.register(modEventBus);
        LBComboRegsitryA.COMBO_STATES.register(modEventBus);
        LBSpecialEffectsRegistry.REGISTRY_KEY2.register(modEventBus);
        EffectAbout.REGISTRY.register(modEventBus);

        LBslashArtRegsitry.SLASH_ARTS.register(modEventBus);
        LBModItems.register();
        LBModBlocks.register();

        if (ModList.get().isLoaded(IceAndFire.MODID)){

            new ICFEntiyRegsitry().register(modEventBus);
            ICFLBcompatRegsitry.register(modEventBus);
        }
        LBSounds.REGISTRY.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        if (ModList.get().isLoaded(L2Hostility.MODID)){

          new L2LBcompatRegsitry().register(modEventBus);
            AttackEventHandler.register(5000, new Arkex());


        }
        ItemTab.REGISTRY.register(modEventBus);
        if (ModList.get().isLoaded(SlashBladeAddon.MODID)){
            SBALBSlashArtRegsitry.register(modEventBus);
        }
        if (ModList.get().isLoaded(TwilightForestMod.ID)){
            TFLBcompat.register(modEventBus);
        }
        REGISTRY.register(modEventBus);

        INSTANCE.messageBuilder(DashMessage.class, messageID++)
                .encoder(DashMessage::encode)
                .decoder(DashMessage::decode)
                .consumerMainThread(DashMessage::handle)
                .add();
        INSTANCE.registerMessage(messageID++, DemonBladeMessage.class, DemonBladeMessage::encode, DemonBladeMessage::new, DemonBladeMessage::handle);
        INSTANCE.registerMessage(messageID++, DemonBladeMessageA.class, DemonBladeMessageA::encode, DemonBladeMessageA::new, DemonBladeMessageA::handle);
    }
    public void register(RegisterEvent event) {
        LBEntiteRegristrys.register(event);



    }
    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    @SubscribeEvent
    public void tick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
            workQueue.forEach(work -> {
                work.setValue(work.getValue() - 1);
                if (work.getValue() == 0)
                    actions.add(work);
            });
            actions.forEach(e -> e.getKey().run());
            workQueue.removeAll(actions);
        }
    }
    public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, MODID);
    public static final RegistryObject<Enchantment> SWORD_RAW = REGISTRY.register("sword_raw", () -> new SwordRawEnchantment());

    public static class EffectAbout{
        public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Legendblade.MODID);
        public static final RegistryObject<StrengthBoost> STRENGTH_BOOST = REGISTRY.register("strength_boost", StrengthBoost::new);
        public static final RegistryObject<HitDamageEffect> HIT_DAMAGE = REGISTRY.register("hit_damage", HitDamageEffect::new);
        public static final RegistryObject<SumeruEffect> SUMERU = REGISTRY.register("sumeru", SumeruEffect::new);
        public static final RegistryObject<MoDaoEffect> MO_DAO = REGISTRY.register("mo_dao", MoDaoEffect::new);
        public static final RegistryObject<ImprisonMobEffect> IMPRISON = REGISTRY.register("imprison", ImprisonMobEffect::new);
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        boolean server = event.includeServer();
        DataGenerator dataGenerator = event.getGenerator();
    }
}
