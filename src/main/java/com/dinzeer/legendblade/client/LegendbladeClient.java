package com.dinzeer.legendblade.client;

import com.dinzeer.legendblade.regsitry.compat.ICFEntiyRegsitry;
import com.dinzeer.legendblade.regsitry.compat.L2LBcompatRegsitry;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.other.LBModBlocks;
import com.github.alexthe666.iceandfire.IceAndFire;
import dev.xkmc.l2hostility.init.L2Hostility;
import mods.flammpfeil.slashblade.client.renderer.entity.DriveRenderer;
import mods.flammpfeil.slashblade.client.renderer.entity.SummonedSwordRenderer;
import moze_intel.projecte.gameObjs.registration.impl.BlockRegistryObject;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import com.dinzeer.legendblade.client.render.*;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import static com.dinzeer.legendblade.Legendblade.MODID;
//客户端渲染
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT,modid = MODID)
public class LegendbladeClient {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(LBEntiteRegristrys.ss, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssexneo, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssexneoforever, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sd, DriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.fd, DriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssex, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssexs, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sr, SummonedSwordRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssdo, DriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ma, SevenSkillFieldRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.md, MoonDriveRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.mdex, NoneMoonRenderer::new);
        event.registerEntityRenderer(LBEntiteRegristrys.be, BulletRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.sps, SaveAllRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssexfly, FlyRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.dbf, DemonBladeFragmentsRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.ssexfla, FlaxyRender::new);
        event.registerEntityRenderer(LBEntiteRegristrys.other.NOEND.get(), NoEndRender::new);
        if(ModList.get().isLoaded(IceAndFire.MODID)){
        event.registerEntityRenderer(ICFEntiyRegsitry.FSFE, SummonedSwordRenderer::new);
        event.registerEntityRenderer(ICFEntiyRegsitry.LSS, SummonedSwordRenderer::new);

        event.registerEntityRenderer(ICFEntiyRegsitry.ISSE, SummonedSwordRenderer::new);
        }
        if (ModList.get().isLoaded(L2Hostility.MODID)){
        event.registerEntityRenderer(L2LBcompatRegsitry.HSS, SummonedSwordRenderer::new);
        }
    }
    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BlackSlabe.LAYER_LOCATION, BlackSlabe::createBodyLayer);
    }
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(() -> {
            // 设置树苗和树叶的渲染类型
            ItemBlockRenderTypes.setRenderLayer(LBModBlocks.proud_soul_sampling.get(), RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(LBModBlocks.proud_soul_leaves.get(), RenderType.cutoutMipped());
            ItemBlockRenderTypes.setRenderLayer(LBModBlocks.proud_soul_log.get(), RenderType.cutoutMipped());
        });
    }
}
