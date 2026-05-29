package com.dinzeer.legendblade.data.utils;


import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;


import java.util.Iterator;
import java.util.function.Predicate;

public final class FeatureLogic {
    public static final Predicate<BlockState> IS_REPLACEABLE_AIR = (state) -> {
        return state.canBeReplaced() || state.isAir();
    };


    public FeatureLogic() {
    }

    public static boolean hasEmptyHorizontalNeighbor(LevelSimulatedReader worldReader, BlockPos pos) {
        return worldReader.isStateAtPosition(pos.north(), IS_REPLACEABLE_AIR) || worldReader.isStateAtPosition(pos.south(), IS_REPLACEABLE_AIR) || worldReader.isStateAtPosition(pos.west(), IS_REPLACEABLE_AIR) || worldReader.isStateAtPosition(pos.east(), IS_REPLACEABLE_AIR);
    }

    public static boolean hasSolidNeighbor(LevelSimulatedReader worldReader, BlockPos pos) {
        return !worldReader.isStateAtPosition(pos.below(), IS_REPLACEABLE_AIR) || !worldReader.isStateAtPosition(pos.north(), IS_REPLACEABLE_AIR) || !worldReader.isStateAtPosition(pos.south(), IS_REPLACEABLE_AIR) || !worldReader.isStateAtPosition(pos.west(), IS_REPLACEABLE_AIR) || !worldReader.isStateAtPosition(pos.east(), IS_REPLACEABLE_AIR) || !worldReader.isStateAtPosition(pos.above(), IS_REPLACEABLE_AIR);
    }

    public static boolean canRootGrowIn(LevelSimulatedReader worldReader, BlockPos pos) {
        return worldReader.isStateAtPosition(pos, IS_REPLACEABLE_AIR) ? hasSolidNeighbor(worldReader, pos) : worldReader.isStateAtPosition(pos, twilightforest.util.FeatureLogic::worldGenReplaceable);
    }


    public static BlockPos translate(BlockPos pos, double distance, double angle, double tilt) {
        double rangle = angle * 2.0 * Math.PI;
        double rtilt = tilt * Math.PI;
        return pos.offset((int)Math.round(Math.sin(rangle) * Math.sin(rtilt) * distance), (int)Math.round(Math.cos(rtilt) * distance), (int)Math.round(Math.cos(rangle) * Math.sin(rtilt) * distance));
    }

    /** @deprecated */
    @Deprecated
    public static BlockState randStone(RandomSource rand, int howMuch) {
        return rand.nextInt(howMuch) >= 1 ? Blocks.COBBLESTONE.defaultBlockState() : Blocks.MOSSY_COBBLESTONE.defaultBlockState();
    }

    public static boolean isAreaClear(BlockGetter world, BlockPos min, BlockPos max) {
        Iterator var3 = BlockPos.betweenClosed(min, max).iterator();

        BlockState state;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            BlockPos pos = (BlockPos)var3.next();
            state = world.getBlockState(pos);
        } while(state.canBeReplaced() || !state.isSolid() || state.liquid());

        return false;
    }

    public static boolean isBlockOk(BlockState state) {
        return state.isSolid();
    }


}
