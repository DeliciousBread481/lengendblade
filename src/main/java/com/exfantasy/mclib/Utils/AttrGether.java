
package com.exfantasy.mclib.Utils;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

public class AttrGether {
	public Attribute attribute;
	public AttributeModifier attributeModifier;
	public AttrGether(Attribute attribute, AttributeModifier attributeModifier) {
		this.attribute = attribute;
		this.attributeModifier = attributeModifier;
	}
}
