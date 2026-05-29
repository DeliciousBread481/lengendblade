package com.dinzeer.legendblade.data;

import com.dinzeer.legendblade.Legendblade;
import com.dinzeer.legendblade.regsitry.other.LBModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataProvider;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import com.dinzeer.legendblade.data.utils.*;



public class LegendWorldGenProvider {
    public static final ResourceKey<ConfiguredFeature<?, ?>> proud_soul_tree = registerKey("tree/proud_soul_tree");
    public static final TreeConfiguration PROUD_SOUL_TREE;
    public LegendWorldGenProvider() {
    }



static {


    PROUD_SOUL_TREE = (new TreeConfiguration
            .TreeConfigurationBuilder(BlockStateProvider.simple(
                    (Block) LBModBlocks.proud_soul_log.get()),
            new BranchingTrunkPlacer(20, 5, 5, 7,
                    new BranchesConfig(3, 1, 10.0, 1.0, 0.3, 0.2), false),
            BlockStateProvider.simple((Block) LBModBlocks.proud_soul_leaves.get()),
            new LeafSpheroidFoliagePlacer(4.5F, 1.5F, ConstantInt.of(0), 1, 0, -0.25F, 24),
            new TwoLayersFeatureSize(20, 0, 5)))
        .ignoreVines().build();


}



    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, Legendblade.prefix(name));
    }

    static SimpleWeightedRandomList.Builder<BlockState> createBlockList() {
        return SimpleWeightedRandomList.builder();
    }


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(proud_soul_tree, new ConfiguredFeature(Feature.TREE, PROUD_SOUL_TREE));
    }





}
