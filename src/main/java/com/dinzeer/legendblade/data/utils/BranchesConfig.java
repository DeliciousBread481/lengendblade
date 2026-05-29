package com.dinzeer.legendblade.data.utils;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record BranchesConfig(int branchCount, int randomAddBranches, double length, double randomAddLength, double spacingYaw, double downwardsPitch) {

    public BranchesConfig(int branchCount, int randomAddBranches, double length, double randomAddLength, double spacingYaw, double downwardsPitch) {
        this.branchCount = branchCount;
        this.randomAddBranches = randomAddBranches;
        this.length = length;
        this.randomAddLength = randomAddLength;
        this.spacingYaw = spacingYaw;
        this.downwardsPitch = downwardsPitch;
    }

    public int branchCount() {
        return this.branchCount;
    }

    public int randomAddBranches() {
        return this.randomAddBranches;
    }

    public double length() {
        return this.length;
    }

    public double randomAddLength() {
        return this.randomAddLength;
    }

    public double spacingYaw() {
        return this.spacingYaw;
    }

    public double downwardsPitch() {
        return this.downwardsPitch;
    }
}