package com.dinzeer.legendblade.specialattack.versiontwo;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.entity.MoonDriveEntity;
import com.dinzeer.legendblade.entity.MoonDriveEntityEX;
import com.dinzeer.legendblade.regsitry.other.LBEntiteRegristrys;
import com.dinzeer.legendblade.regsitry.slashblade.LBslashArtRegsitry;
import com.exfantasy.mclib.Utils.Dash.SMoveUtil;
import com.exfantasy.mclib.Utils.EntityPointer;
import com.exfantasy.mclib.Utils.PathGenerator;
import mods.flammpfeil.slashblade.capability.concentrationrank.ConcentrationRankCapabilityProvider;
import mods.flammpfeil.slashblade.event.SlashBladeEvent;
import mods.flammpfeil.slashblade.event.SlashBladeEventHandler;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import mods.flammpfeil.slashblade.registry.SlashArtsRegistry;
import mods.flammpfeil.slashblade.util.KnockBacks;
import mods.flammpfeil.slashblade.util.VectorHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.server.commands.StopSoundCommand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.spongepowered.asm.mixin.Mixin;

@Mod.EventBusSubscriber
public class LastMoondrive {
    public static void doSlash(LivingEntity playerIn, Vec3 centerOffset) {
        ItemStack mainHandItem = playerIn.getMainHandItem();
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state ->{
            state.setSlashArtsKey(LBslashArtRegsitry.MoonDrive.getId());
            return 0;
        });
        ClientboundStopSoundPacket clientboundstopsoundpacket = new ClientboundStopSoundPacket(null, null);
        if (playerIn instanceof  ServerPlayer pl)
            pl.connection.send(clientboundstopsoundpacket);
        if (playerIn.level().isClientSide()) return;
        ((ServerLevel) playerIn.level()).setDayTime(20000);
        var path = PathGenerator.generatePath(playerIn.position(), EntityPointer.findFarthestBlock1(playerIn,50).getCenter());
            int t = 0;
            playerIn.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 20 * 10, 6));
            playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.SUMERU.get(), 20 * 10, 6));
            playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.STRENGTH_BOOST.get(), 20 * 10, 10));
           playerIn.addEffect(new MobEffectInstance(Legendblade.EffectAbout.IMPRISON.get(), 23, 6));


            for (var a : path) {
                t++;
                Legendblade.queueServerWork(t, () -> {
                    MoonDriveEntityEX moonDriveEntityEX = new MoonDriveEntityEX(LBEntiteRegristrys.mdex, playerIn.level());

                    playerIn.level().addFreshEntity(moonDriveEntityEX);
                    moonDriveEntityEX.setDuring(12 * 20);
                    moonDriveEntityEX.setNoGravity(true);

                    moonDriveEntityEX.setPos(new Vec3(a.x(), playerIn.getY(), a.z()));
                    moonDriveEntityEX.setOwner(playerIn);
                });


            }
        SMoveUtil.sendDashMessage((Player) playerIn, 0, -1.8);

        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state ->{
                state.setProudSoulCount(0);
                return 0;
            });
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state ->{
                state.setKillCount(0);
                return 0;
            });
        playerIn.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE).map(state ->{
            state.setRefine(0);
            return 0;
        });
    }

}
