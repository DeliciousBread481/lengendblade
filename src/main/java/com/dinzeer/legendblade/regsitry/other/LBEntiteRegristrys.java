package com.dinzeer.legendblade.regsitry.other;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.*;
import com.dinzeer.legendblade.entity.boss.NoEndBoss;
import com.google.common.base.CaseFormat;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.dinzeer.legendblade.Legendblade.MODID;

public class LBEntiteRegristrys {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final ResourceLocation SSLOC = new ResourceLocation(MODID, classToString(SumonSwordEntity.class));
    public static EntityType<SumonSwordEntity> ss;
    public static final ResourceLocation SDLOC = new ResourceLocation(MODID, classToString(DriveSummonEntity.class));
    public static EntityType<DriveSummonEntity> sd;
    public static final ResourceLocation SSEXLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityEX.class));
    public static EntityType<SumonSwordEntityEX> ssex;
    public static final ResourceLocation SSDOLOC = new ResourceLocation(MODID, classToString(DriveSummonEntityOne.class));
    public static EntityType<DriveSummonEntityOne> ssdo;
    public static final ResourceLocation maloc = new ResourceLocation(MODID, classToString(SevenSkillField.class));
    public static EntityType<SevenSkillField> ma;
    public static final ResourceLocation MDLOC = new ResourceLocation(MODID, classToString(MoonDriveEntity.class));
    public static EntityType<MoonDriveEntity> md;
    public static final ResourceLocation spsLOC = new ResourceLocation(MODID, classToString(SpSumonSwordEntity.class));
    public static EntityType<SpSumonSwordEntity> sps;

    public static final ResourceLocation dbfloc = new ResourceLocation(MODID, classToString(DemonBladeFragments.class));
    public static EntityType<DemonBladeFragments> dbf;
    public static final ResourceLocation srloc = new ResourceLocation(MODID, classToString(SwordRainEntity.class));
    public static EntityType<SwordRainEntity> sr;
    public static final ResourceLocation MDEXLOC = new ResourceLocation(MODID, classToString(MoonDriveEntityEX.class));
    public static EntityType<MoonDriveEntityEX> mdex;
    public static final ResourceLocation SSEXSLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityEXSeven.class));
    public static EntityType<SumonSwordEntityEXSeven> ssexs;
    public static final ResourceLocation FDKOC = new ResourceLocation(MODID, classToString(DriveSummonEntityFire.class));
    public static EntityType<DriveSummonEntityFire> fd;
    public static final ResourceLocation BELOC = new ResourceLocation(MODID, classToString(BulletEntity.class));
    public static EntityType<BulletEntity> be;
    public static final ResourceLocation ssexflyLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityfly.class));
    public static EntityType<SumonSwordEntityfly> ssexfly;
    public static final ResourceLocation ssexflaLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityFlaxy.class));
    public static EntityType<SumonSwordEntityFlaxy> ssexfla;
    public static final ResourceLocation ssexneoLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityNeo.class));
    public static EntityType<SumonSwordEntityNeo> ssexneo;
    public static final ResourceLocation ssexneoforeverLOC = new ResourceLocation(MODID, classToString(SumonSwordEntityNeoForever.class));
    public static EntityType<SumonSwordEntityNeoForever> ssexneoforever;
    public static void register(RegisterEvent event){

        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntity> entity = ss = EntityType.Builder
                        .of(SumonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntity::createInstance)
                        .build(SSLOC.toString());
                helper.register(SSLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DriveSummonEntity> entity = sd = EntityType.Builder
                        .of(DriveSummonEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DriveSummonEntity::createInstance)
                        .build(SDLOC.toString());
                helper.register(SDLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityEX> entity = ssex = EntityType.Builder
                        .of(SumonSwordEntityEX::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityEX::createInstance)
                        .build(SSEXLOC.toString());
                helper.register(SSEXLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DriveSummonEntityOne> entity = ssdo = EntityType.Builder
                        .of(DriveSummonEntityOne::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DriveSummonEntityOne::createInstance)
                        .build(SSDOLOC.toString());
                helper.register(SSDOLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SevenSkillField> entity = ma = EntityType.Builder
                        .of(SevenSkillField::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SevenSkillField::createInstance)
                        .build(maloc.toString());
                helper.register(maloc, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<MoonDriveEntity> entity = md = EntityType.Builder
                        .of(MoonDriveEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(MoonDriveEntity::createInstance)
                        .build(MDLOC.toString());
                helper.register(MDLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SpSumonSwordEntity> entity = sps = EntityType.Builder
                        .of(SpSumonSwordEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SpSumonSwordEntity::createInstance)
                        .build(spsLOC.toString());
                helper.register(spsLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DemonBladeFragments> entity = dbf = EntityType.Builder
                        .of(DemonBladeFragments::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DemonBladeFragments::createInstance)
                        .build(dbfloc.toString());
                helper.register(dbfloc, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SwordRainEntity> entity = sr = EntityType.Builder
                        .of(SwordRainEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SwordRainEntity::createInstance)
                        .build(srloc.toString());
                helper.register(srloc, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<MoonDriveEntityEX> entity = mdex = EntityType.Builder
                        .of(MoonDriveEntityEX::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(MoonDriveEntityEX::createInstance)
                        .build(MDEXLOC.toString());
                helper.register(MDEXLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityEXSeven> entity = ssexs = EntityType.Builder
                        .of(SumonSwordEntityEXSeven::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityEXSeven::createInstance)
                        .build(SSEXSLOC.toString());
                helper.register(SSEXSLOC, entity);
            }

        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<DriveSummonEntityFire> entity = fd = EntityType.Builder
                        .of(DriveSummonEntityFire::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(DriveSummonEntityFire::createInstance)
                        .build(FDKOC.toString());
                helper.register(FDKOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<BulletEntity> entity = be = EntityType.Builder
                        .of(BulletEntity::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(BulletEntity::createInstance)
                        .build(BELOC.toString());
                helper.register(BELOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityfly> entity = ssexfly = EntityType.Builder
                        .of(SumonSwordEntityfly::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityfly::createInstance)
                        .build(ssexflyLOC.toString());
                helper.register(ssexflyLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityFlaxy> entity = ssexfla = EntityType.Builder
                        .of(SumonSwordEntityFlaxy::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityFlaxy::createInstance)
                        .build(ssexflaLOC.toString());
                helper.register(ssexflaLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityNeo> entity = ssexneo = EntityType.Builder
                        .of(SumonSwordEntityNeo::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityNeo::createInstance)
                        .build(ssexneoLOC.toString());
                helper.register(ssexneoLOC, entity);
            }
        });
        event.register(ForgeRegistries.Keys.ENTITY_TYPES, helper -> {
            {
                EntityType<SumonSwordEntityNeoForever> entity = ssexneoforever = EntityType.Builder
                        .of(SumonSwordEntityNeoForever::new, MobCategory.MISC)
                        .sized(0.9F, 0.9F)
                        .setTrackingRange(4)
                        .setUpdateInterval(20).setCustomClientFactory(SumonSwordEntityNeoForever::createInstance)
                        .build(ssexneoforeverLOC.toString());
                helper.register(ssexneoforeverLOC, entity);
            }
        });
    }


    public static String classToString(Class<? extends Entity> entityClass)
    {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, entityClass.getSimpleName())
                .replace("entity_", "");
    }




    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class other{
        public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Legendblade.MODID);
        public static final RegistryObject<EntityType<NoEndBoss>> NOEND = register("no_end",
                EntityType.Builder.<NoEndBoss>of(NoEndBoss::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(NoEndBoss::new).sized(0.6f, 1.8f));;

        private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
            return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
        }
        @SubscribeEvent
        public static void init(FMLCommonSetupEvent event) {
            event.enqueueWork(NoEndBoss::init);
        }
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(NOEND.get(), NoEndBoss.createAttributes().build());

    }
}

}










