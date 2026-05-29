package com.dinzeer.legendblade.data.utils;


import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;


import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class BranchingTrunkPlacer extends TrunkPlacer {

    private final int branchDownwardOffset;
    private final BranchesConfig branchesConfig;
    private final boolean perpendicularBranches;

    public BranchingTrunkPlacer(int baseHeight, int randomHeightA, int randomHeightB, int branchDownwardOffset, BranchesConfig branchesConfig, boolean perpendicularBranches) {
        super(baseHeight, randomHeightA, randomHeightB);
        this.branchDownwardOffset = branchDownwardOffset;
        this.branchesConfig = branchesConfig;
        this.perpendicularBranches = perpendicularBranches;
    }

    protected TrunkPlacerType<twilightforest.world.components.feature.trees.treeplacers.BranchingTrunkPlacer> type() {
        return (TrunkPlacerType) LBFeatureModifiers.TRUNK_BRANCHING.get();
    }

    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader worldReader, BiConsumer<BlockPos, BlockState> worldPlacer, RandomSource random, int height, BlockPos startPos, TreeConfiguration treeConfig) {
        List<FoliagePlacer.FoliageAttachment> leafAttachments = Lists.newArrayList();

        int numBranches;
        for(numBranches = 0; numBranches <= height; ++numBranches) {
            if (!this.placeLog(worldReader, worldPlacer, random, startPos.above(numBranches), treeConfig)) {
                height = numBranches;
                break;
            }
        }

        leafAttachments.add(new FoliagePlacer.FoliageAttachment(startPos.above(height), 0, false));
        numBranches = this.branchesConfig.branchCount() + random.nextInt(this.branchesConfig.randomAddBranches() + 1);
        float offset = random.nextFloat();

        for(int b = 0; b < numBranches; ++b) {
            this.buildBranch(worldReader, worldPlacer, startPos, leafAttachments, height - this.branchDownwardOffset + b, this.branchesConfig.length(), this.branchesConfig.spacingYaw() * (double)b + (double)offset, this.branchesConfig.downwardsPitch(), random, treeConfig, this.perpendicularBranches);
        }

        return leafAttachments;
    }

    private void buildBranch(LevelSimulatedReader worldReader, BiConsumer<BlockPos, BlockState> worldPlacer, BlockPos pos, List<FoliagePlacer.FoliageAttachment> leafBlocks, int height, double length, double angle, double tilt, RandomSource treeRNG, TreeConfiguration treeConfig, boolean perpendicularBranches) {
        BlockPos src = pos.above(height);
        BlockPos dest = FeatureLogic.translate(src, length, angle, tilt);
        if (perpendicularBranches) {
            this.drawBresenhamBranch(worldReader, worldPlacer, treeRNG, src, new BlockPos(dest.getX(), src.getY(), dest.getZ()), treeConfig);
            int max = Math.max(src.getY(), dest.getY());

            for(int i = Math.min(src.getY(), dest.getY()); i < max + 1; ++i) {
                this.placeLog(worldReader, worldPlacer, treeRNG, new BlockPos(dest.getX(), i, dest.getZ()), treeConfig);
            }
        } else {
            this.drawBresenhamBranch(worldReader, worldPlacer, treeRNG, src, dest, treeConfig);
        }

        this.placeLog(worldReader, worldPlacer, treeRNG, dest.east(), treeConfig);
        this.placeLog(worldReader, worldPlacer, treeRNG, dest.west(), treeConfig);
        this.placeLog(worldReader, worldPlacer, treeRNG, dest.south(), treeConfig);
        this.placeLog(worldReader, worldPlacer, treeRNG, dest.north(), treeConfig);
        leafBlocks.add(new FoliagePlacer.FoliageAttachment(dest, 0, false));
    }

    private void drawBresenhamBranch(LevelSimulatedReader worldReader, BiConsumer<BlockPos, BlockState> worldPlacer, RandomSource random, BlockPos from, BlockPos to, TreeConfiguration config) {
        Iterator var7 = (new VoxelBresenhamIterator(from, to)).iterator();

        while(var7.hasNext()) {
            BlockPos pixel = (BlockPos)var7.next();
            this.placeLog(worldReader, worldPlacer, random, pixel, config);
        }

    }
}