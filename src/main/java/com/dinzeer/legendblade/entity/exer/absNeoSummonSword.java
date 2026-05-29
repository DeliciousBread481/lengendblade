package com.dinzeer.legendblade.entity.exer;

import mods.flammpfeil.slashblade.entity.EntityAbstractSummonedSword;
import mods.flammpfeil.slashblade.entity.Projectile;
import mods.flammpfeil.slashblade.item.ItemSlashBlade;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class absNeoSummonSword extends EntityAbstractSummonedSword {
    public absNeoSummonSword(EntityType<? extends Projectile> entityTypeIn, Level worldIn) {
        super(entityTypeIn, worldIn);
    }

    private double damage = 1.0;

    @Override
    public void setDamage(double damageIn) {
        double extra = 1;
        
        if (super.getOwner() instanceof Player player){
            int refine = getRefined(player);
            float baseAttack = getBaseAttackModifier(player);

            // 修改为分段曲线算法：300精炼前0.02系数，300后0.005系数
            extra += (0.02 * Math.min(refine, 300)) + (0.005 * Math.max(refine - 300, 0));
            
            // 保持baseAttack原有线性增幅
            extra += 0.015 * baseAttack;
        }

        this.damage = damageIn * extra;
    }


    public void setDamage2(double damageIn) {
        this.damage=damageIn;
    }





    public static int getRefined(Player player){
        return player.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
                  .map(state -> state.getRefine()).get();
    }

    public static Float getBaseAttackModifier(Player player){
        return player.getMainHandItem().getCapability(ItemSlashBlade.BLADESTATE)
                .map(state -> state.getBaseAttackModifier()).get();
    }

    @Override
    public double getDamage() {

        return damage;
    }
}
