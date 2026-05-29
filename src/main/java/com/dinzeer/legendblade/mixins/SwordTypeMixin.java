package com.dinzeer.legendblade.mixins;


import com.dinzeer.legendblade.data.LegendBuiltInRegsitry;
import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import mods.flammpfeil.slashblade.data.builtin.SlashBladeBuiltInRegistry;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.item.SwordType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static com.dinzeer.legendblade.Legendblade.MODID;


@Mixin(ItemSlashBlade.class)
public class SwordTypeMixin {
    @Inject(method = "appendSwordType", at = @At("HEAD"), remap = false)
    private  void appendSwordType(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn, CallbackInfo ci) {
        var swordType = SwordType.from(stack);
        if (swordType.contains(SwordType.BEWITCHED)||swordType.contains(SwordType.NONE)||swordType.contains(SwordType.ENCHANTED)) {
           if (SlashbladeUtils.hastran(stack, "item."+MODID+"."+LegendBuiltInRegsitry.vanity.location().getPath())){

            tooltip.add(
                    Component.translatable("legendblade.sword_type.iscreate").withStyle(ChatFormatting.LIGHT_PURPLE));
        }
        }

    }

}
