package com.dinzeer.legendblade.data.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static com.dinzeer.legendblade.Legendblade.MODID;


public class LBFeatureModifiers {
    public static final DeferredRegister<PlacementModifierType<?>> PLACEMENT_MODIFIERS;
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS;
    public static final RegistryObject<TrunkPlacerType<BranchingTrunkPlacer>> TRUNK_BRANCHING;


    public LBFeatureModifiers() {
    }
    private static <P extends PlacementModifier> RegistryObject<PlacementModifierType<P>> registerPlacer(String name, Supplier<PlacementModifierType<P>> factory) {
        return PLACEMENT_MODIFIERS.register(name, factory);
    }
    static {
        PLACEMENT_MODIFIERS = DeferredRegister.create(Registries.PLACEMENT_MODIFIER_TYPE, MODID);
        TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MODID);
        TRUNK_BRANCHING = TRUNK_PLACERS.register("branching_trunk_placer", () -> {
            return new TrunkPlacerType(twilightforest.world.components.feature.trees.treeplacers.BranchingTrunkPlacer.CODEC);
        });
    }
}
