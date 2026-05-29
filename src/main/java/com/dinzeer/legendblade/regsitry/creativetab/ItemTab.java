package com.dinzeer.legendblade.regsitry.creativetab;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.other.LBModBlocks;
import com.dinzeer.legendblade.regsitry.other.LBModItems;

import mods.flammpfeil.slashblade.SlashBladeCreativeGroup;
import mods.flammpfeil.slashblade.client.renderer.model.BladeModelManager;
import mods.flammpfeil.slashblade.init.SBItems;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.slashblade.SlashBladeDefinition;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.Map;

import static com.dinzeer.legendblade.Legendblade.LOGGER;
import static com.dinzeer.legendblade.Legendblade.MODID;


public class ItemTab {

    public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public static final RegistryObject<CreativeModeTab> LBITEM = REGISTRY.register("legendblade",
            () -> CreativeModeTab.builder().title(Component.translatable("item_group.legendblade.legendbladeitem")).icon(() -> new ItemStack(
                            LBModBlocks.wonder_reactor.get())).displayItems((parameters, tabData) -> {
                        tabData.accept( LBModBlocks.wonder_reactor.get());
                    })
                    .withBackgroundLocation(Legendblade.prefix("textures/gui/container/creative_inventory/tab_legendblade.png"))
                    .build());

    public static final RegistryObject<CreativeModeTab> LBSlashblade = REGISTRY.register("legendblade_slashblade",
            () -> CreativeModeTab.builder()
                    .withTabsBefore(SlashBladeCreativeGroup.SLASHBLADE_GROUP.getId())
                    .title(Component.translatable("item_group.legendblade.legendblade_slashblade")).icon(() -> {
                        ItemStack stack = new ItemStack(SBItems.slashblade);
                        stack.getCapability(ItemSlashBlade.BLADESTATE).ifPresent(s -> {
                            s.setModel(new ResourceLocation(Legendblade.MODID, "model/foxex/model.obj"));
                            s.setTexture(new ResourceLocation(Legendblade.MODID, "model/foxex/texture3.png"));
                        });
                        return stack;
                    })
                    .displayItems((parameters, tabData) -> {

                        fillBlades(tabData);
                    })
                    .withSearchBar()

                    .build());

    public static void register(IEventBus e){
        REGISTRY.register(e);
    }
    private static void fillBlades(CreativeModeTab.Output output) {
        if (Minecraft.getInstance().getConnection() != null) {
            BladeModelManager.getClientSlashBladeRegistry()
                    .entrySet().stream()
                    // 步骤1：过滤空值
                    .filter(entry -> entry.getKey() != null && entry.getValue() != null)
                    // 步骤2：解析字符串为ResourceLocation并过滤命名空间
                    .filter(entry -> {
                        ResourceLocation loc = ResourceLocation.tryParse(entry.getKey().location().toString());
                        return loc != null && loc.getNamespace().equals(Legendblade.MODID);
                    })
                    // 步骤3：按字符串键排序
                    .sorted(Map.Entry.comparingByKey())
                    .forEach(entry -> {
                        LOGGER.info("Registering Slashblade: {}", entry.getKey());
                        output.accept(entry.getValue().getBlade());
                    });
        }
    }

}
