package com.dinzeer.legendblade;


import cn.mmf.slashblade_addon.SlashBladeAddon;
import cn.mmf.slashblade_addon.data.SlashBladeAddonBuiltInRegistry;
import com.dinzeer.legendblade.data.LegendBuiltInRegsitry;
import com.dinzeer.legendblade.regsitry.other.LBModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.init.SBItems;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

public class CommonEventHandler {

    @Mod.EventBusSubscriber
    public class CommonEventHandlerEX {
        public CommonEventHandlerEX() {
        }

        @SubscribeEvent
        public static void onVillagerTrades(VillagerTradesEvent event) {
            addVillageTrade(event, "weaponsmith", 2, new VillagerSlashBladeListing(64, LegendBuiltInRegsitry.RUSTGODFOX.location(), 3, 5, 0.05F));
            addVillageTrade(event, "weaponsmith", 2, new VillagerSlashBladeListing(64, SlashBladeBuiltInRegistry.SABIGATANA.location(), 3, 5, 0.05F));
            if (event.getType() == VillagerProfession.WEAPONSMITH) {

                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 12), new ItemStack(SBItems.proudsoul), 516, 5, 2f));
                event.getTrades().get(1).add(new BasicItemListing(new ItemStack(Items.EMERALD, 3), new ItemStack(SBItems.proudsoul_tiny), 1024, 5, 2f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 24), new ItemStack(SBItems.proudsoul_ingot), 256, 5, 2f));
                event.getTrades().get(2).add(new BasicItemListing(new ItemStack(Items.EMERALD, 36), new ItemStack(SBItems.proudsoul_sphere), 128, 5, 2f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 48), new ItemStack(SBItems.proudsoul_crystal), 64, 5, 2f));
                event.getTrades().get(3).add(new BasicItemListing(new ItemStack(Items.EMERALD, 64), new ItemStack(SBItems.proudsoul_trapezohedron), 32, 5, 2f));


            }
        }

        @SubscribeEvent
        public static void onWandererTrades(WandererTradesEvent event) {
            List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();
            rareTrades.add(new VillagerSlashBladeListing(64, LegendBuiltInRegsitry.RUSTGODFOX.location(), 3, 5, 0.05F));
            rareTrades.add(new VillagerSlashBladeListing(64, LegendBuiltInRegsitry.rustkingsowrd.location(), 3, 5, 0.05F));
           rareTrades.add(new VillagerSlashBladeListing(64, SlashBladeBuiltInRegistry.SABIGATANA.location(), 3, 5, 0.05F));
            rareTrades.add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(SBItems.proudsoul_tiny), 4056, 5, 0.05f));
            rareTrades.add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(SBItems.proudsoul), 2048, 5, 0.05f));
            if(ModList.get().isLoaded(SlashBladeAddon.MODID)){
                rareTrades.add(new VillagerSlashBladeListing(64, LegendBuiltInRegsitry.RUSTGODFOX.location(), 3, 5, 0.05F));
            }
            rareTrades.add(new BasicItemListing(new ItemStack(Items.EMERALD, 6), new ItemStack(LBModItems.whiteButterfly), 1, 5, 0.05f));
        }

        public static void addVillageTrade(VillagerTradesEvent event, String villager, int level, VillagerTrades.ItemListing listing) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            VillagerProfession profession = event.getType();
            if (profession.name() != null) {
                if (profession.name().equals(villager)) {
                    ((List)trades.get(level)).add(listing);
                }

            }
        }
    }

}
