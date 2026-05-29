package com.dinzeer.legendblade;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.TagParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class CustomItemUtil {


	public static ItemStack getItemFromString(String string) throws Exception  {
        String itemString = string.split("\\{")[0];
        String nbtString = string.substring(itemString.length());
//        CareerWarMod.LOGGER.debug("itemString: " + itemString);
//        CareerWarMod.LOGGER.debug("nbtString: " + nbtString);
        CompoundTag tag = TagParser.parseTag(nbtString);
        ItemStack itemStack = ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemString)).getDefaultInstance();
        itemStack.setTag(tag);
//        CareerWarMod.LOGGER.debug("itemStack: " + itemStack);
        return itemStack;
    }



}
