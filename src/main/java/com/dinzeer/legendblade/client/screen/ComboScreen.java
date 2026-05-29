package com.dinzeer.legendblade.client.screen;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.handle.ComboHandle;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Overlay;
import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

import static com.dinzeer.legendblade.Legendblade.MODID;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class ComboScreen {
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void eventHandler(RenderGuiEvent.Pre event) {
        int w = event.getWindow().getGuiScaledWidth();
        int h = event.getWindow().getGuiScaledHeight();
        Level world = null;
        double x = 0;
        double y = 0;
        double z = 0;
        int init1 = 0;
        Player entity = Minecraft.getInstance().player;

        if (entity != null) {
            world = entity.level();
            x = entity.getX();
            y = entity.getY()+y;
            z = entity.getZ();
        }
        int combo = ComboHandle.getCombo(entity);

        if (combo > 0) {
            Font font = Minecraft.getInstance().font;
            GuiGraphics gg =event.getGuiGraphics();
            RenderSystem.disableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.enableBlend();
            RenderSystem.setShader(GameRenderer::getPositionTexShader);
            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            RenderSystem.setShaderColor(1, 1, 1, 1);
            gg.pose().pushPose();
        //    gg.pose().scale(2f, 0f, 2f);
            gg.drawString(font, String.valueOf(combo), w / 2 - font.width(String.valueOf(combo)) / 2, h / 2 - font.lineHeight / 2-6-30, 0xffffff);
            gg.pose().popPose();

            RenderSystem.depthMask(true);
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            RenderSystem.disableBlend();
            RenderSystem.setShaderColor(1, 1, 1, 1);
        }
    }
}


