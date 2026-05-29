package com.dinzeer.legendblade.handle;

import com.dinzeer.legendblade.network.LegendbladevaV;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber
public class ComboHandle {
    public static int getCombo(Player player){
        LegendbladevaV.PlayerVariables playerVariables = player.getCapability(LegendbladevaV.PLAYER_VARIABLES_CAPABILITY).orElse(null);
        if (playerVariables==null)return 0;
        return playerVariables.Combo;
    }
    public static boolean setCombo(Player player,int comboNum){
        LazyOptional<LegendbladevaV.PlayerVariables> capability = player.getCapability(LegendbladevaV.PLAYER_VARIABLES_CAPABILITY);
        if(!capability.isPresent())return false;
        LegendbladevaV.PlayerVariables playerVariables = capability.orElse(null);
        playerVariables.Combo = comboNum;
        playerVariables.syncPlayerVariables(player);
        return true;
    }
    private static final Map<Player,Integer> _setCooldown = new HashMap<>();
    @SubscribeEvent
    public static void addCombo(LivingHurtEvent event){
        if (event.getSource().getEntity() instanceof  Player player){
            _setCooldown.put(player,20 *10);
            setCombo(player,getCombo(player) +1);

        }
        if (event.getEntity() instanceof Player player){
            _setCooldown.put(player,0);
            setCombo(player,0);
        }
    }
    @SubscribeEvent
    public static void set_setCooldown(TickEvent.PlayerTickEvent event){
        Player player= event.player;
        if (_setCooldown.get(player)==null)return;
        int cooldown = _setCooldown.get(player);
        if (cooldown>0){
            cooldown--;
        }
        if (cooldown==0){
            setCombo(player,0);
        }
        _setCooldown.put(player,cooldown);
    }
}
