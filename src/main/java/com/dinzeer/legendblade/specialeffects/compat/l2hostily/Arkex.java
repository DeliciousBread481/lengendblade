package com.dinzeer.legendblade.specialeffects.compat.l2hostily;

import com.exfantasy.mclib.Utils.SlashBlade.SlashbladeUtils;
import dev.xkmc.l2damagetracker.contents.attack.AttackListener;
import dev.xkmc.l2damagetracker.contents.attack.CreateSourceEvent;
import dev.xkmc.l2damagetracker.contents.damage.DamageTypeWrapper;
import dev.xkmc.l2damagetracker.contents.damage.DefaultDamageState;
import dev.xkmc.l2damagetracker.init.data.L2DamageTypes;
import dev.xkmc.l2hostility.content.capability.mob.MobTraitCap;
import dev.xkmc.l2hostility.init.L2Hostility;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.fml.ModList;

import java.util.Map;
import java.util.TreeMap;


import static com.dinzeer.legendblade.Legendblade.MODID;

public class Arkex  implements AttackListener {


    @Override
    public void onCreateSource(CreateSourceEvent event) {
        LivingEntity mob = event.getAttacker();
        if (!ModList.get().isLoaded(L2Hostility.MODID)) return;
        if (MobTraitCap.HOLDER.isProper(mob)) {
            ((MobTraitCap)MobTraitCap.HOLDER.get(mob)).traitEvent((k, v) -> {
                k.onCreateSource(v, event.getAttacker(), event);
            });
        }

        DamageTypeWrapper type = event.getResult();
        if (type != null) {
            DamageTypeWrapper root = type.toRoot();
            if (root == L2DamageTypes.MOB_ATTACK || root == L2DamageTypes.PLAYER_ATTACK) {
                if (event.getAttacker() instanceof Player player){
                    if (SlashbladeUtils.hasSpecialEffect(player.getMainHandItem(), MODID + ":ark")) {
                        event.enable(DefaultDamageState.BYPASS_MAGIC);
                    }
                }
            }

        }
    }
}
