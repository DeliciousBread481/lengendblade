package com.dinzeer.legendblade.regsitry.other;

import com.dinzeer.legendblade.Legendblade;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class ProudSoulTreeGrower extends AbstractTreeGrower {

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                Legendblade.prefix("proud_soul_tree") // 必须与 JSON 文件中的 ID 一致
        );
    }
}
