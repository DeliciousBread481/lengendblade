package com.dinzeer.legendblade.data.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import twilightforest.init.TFFeatureModifiers;
import twilightforest.util.FeaturePlacers;

public class LeafSpheroidFoliagePlacer extends FoliagePlacer {

    private final float horizontalRadius;
    private final float verticalRadius;
    private final float verticalBias;
    private final int randomHorizontal;
    private final int randomVertical;
    private final int shag_factor;
    public static final twilightforest.world.components.feature.trees.treeplacers.LeafSpheroidFoliagePlacer NO_OP = new twilightforest.world.components.feature.trees.treeplacers.LeafSpheroidFoliagePlacer(0.0F, 0.0F, ConstantInt.of(0), 0, 0, 0.0F, 0);

    public LeafSpheroidFoliagePlacer(float horizontalRadius, float verticalRadius, IntProvider yOffset, int randomHorizontal, int randomVertical, float verticalBias, int shag_factor) {
        super(ConstantInt.of((int)horizontalRadius), yOffset);
        this.horizontalRadius = horizontalRadius;
        this.verticalRadius = verticalRadius;
        this.randomHorizontal = randomHorizontal;
        this.randomVertical = randomVertical;
        this.verticalBias = verticalBias;
        this.shag_factor = shag_factor;
    }

    protected FoliagePlacerType<twilightforest.world.components.feature.trees.treeplacers.LeafSpheroidFoliagePlacer> type() {
        return (FoliagePlacerType) TFFeatureModifiers.FOLIAGE_SPHEROID.get();
    }

    protected void createFoliage(LevelSimulatedReader worldReader, FoliagePlacer.FoliageSetter setter, RandomSource random, TreeConfiguration baseTreeFeatureConfig, int trunkHeight, FoliagePlacer.FoliageAttachment foliage, int foliageHeight, int radius, int offset) {
        BlockPos center = foliage.pos().above(offset);
        FeaturePlacers.placeSpheroid(worldReader, setter, FeaturePlacers.VALID_TREE_POS, random, center, (float)foliage.radiusOffset() + this.horizontalRadius + (float)random.nextInt(this.randomHorizontal + 1), (float)foliage.radiusOffset() + this.verticalRadius + (float)random.nextInt(this.randomVertical + 1), this.verticalBias, baseTreeFeatureConfig.foliageProvider);
        if (this.shag_factor > 0) {
            for(int i = 0; i < this.shag_factor; ++i) {
                float randomYaw = random.nextFloat() * 6.2831855F;
                float randomPitch = random.nextFloat() * 2.0F - 1.0F;
                float yUnit = Mth.sqrt(1.0F - randomPitch * randomPitch);
                float xCircleOffset = yUnit * Mth.cos(randomYaw) * (this.horizontalRadius - 1.0F);
                float zCircleOffset = yUnit * Mth.sin(randomYaw) * (this.horizontalRadius - 1.0F);
                BlockPos placement = center.offset((int)(xCircleOffset + (float)((int)xCircleOffset >> 31)), (int)(randomPitch * (this.verticalRadius + 0.25F) + this.verticalBias), (int)(zCircleOffset + (float)((int)zCircleOffset >> 31)));
                placeLeafCluster(worldReader, setter, random, placement.immutable(), baseTreeFeatureConfig.foliageProvider);
            }
        }

    }

    private static void placeLeafCluster(LevelSimulatedReader worldReader, FoliagePlacer.FoliageSetter setter, RandomSource random, BlockPos pos, BlockStateProvider state) {
        FeaturePlacers.placeLeaf(worldReader, setter, FeaturePlacers.VALID_TREE_POS, pos, state, random);
        FeaturePlacers.placeLeaf(worldReader, setter, FeaturePlacers.VALID_TREE_POS, pos.east(), state, random);
        FeaturePlacers.placeLeaf(worldReader, setter, FeaturePlacers.VALID_TREE_POS, pos.south(), state, random);
        FeaturePlacers.placeLeaf(worldReader, setter, FeaturePlacers.VALID_TREE_POS, pos.offset(1, 0, 1), state, random);
    }

    public int foliageHeight(RandomSource random, int i, TreeConfiguration baseTreeFeatureConfig) {
        return 0;
    }

    protected boolean shouldSkipLocation(RandomSource random, int i, int i1, int i2, int i3, boolean b) {
        return false;
    }
}
