package com.dinzeer.legendblade.data.utils;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

import java.util.Iterator;

public class VoxelBresenhamIterator implements Iterator<BlockPos>, Iterable<BlockPos> {
    private final int x_inc;
    private final int y_inc;
    private final int z_inc;
    private final int doubleAbsDx;
    private final int doubleAbsDy;
    private final int doubleAbsDz;
    private final int length;
    private final BlockPos.MutableBlockPos voxel;
    private final Direction.Axis direction;
    private int i;
    private int err_1;
    private int err_2;

    public VoxelBresenhamIterator(BlockPos voxel, BlockPos towards) {
        this(voxel, towards.getX(), towards.getY(), towards.getZ());
    }

    public VoxelBresenhamIterator(BlockPos voxel, int x2, int y2, int z2) {
        this.i = 0;
        this.voxel = voxel.mutable();
        int x1 = this.voxel.getX();
        int y1 = this.voxel.getY();
        int z1 = this.voxel.getZ();
        int xVec = x2 - x1;
        int yVec = y2 - y1;
        int zVec = z2 - z1;
        int absDx = Math.abs(xVec);
        int absDy = Math.abs(yVec);
        int absDz = Math.abs(zVec);
        this.x_inc = xVec < 0 ? -1 : 1;
        this.y_inc = yVec < 0 ? -1 : 1;
        this.z_inc = zVec < 0 ? -1 : 1;
        this.doubleAbsDx = absDx << 1;
        this.doubleAbsDy = absDy << 1;
        this.doubleAbsDz = absDz << 1;
        if (absDx >= absDy && absDx >= absDz) {
            this.err_1 = this.doubleAbsDy - absDx;
            this.err_2 = this.doubleAbsDz - absDx;
            this.direction = Direction.Axis.X;
            this.length = absDx + 1;
        } else if (absDy >= absDx && absDy >= absDz) {
            this.err_1 = this.doubleAbsDx - absDy;
            this.err_2 = this.doubleAbsDz - absDy;
            this.direction = Direction.Axis.Y;
            this.length = absDy + 1;
        } else {
            this.err_1 = this.doubleAbsDy - absDz;
            this.err_2 = this.doubleAbsDx - absDz;
            this.direction = Direction.Axis.Z;
            this.length = absDz + 1;
        }

    }

    public boolean hasNext() {
        return this.i < this.length;
    }

    public BlockPos next() {
        BlockPos out = this.voxel.immutable();
        if (this.hasNext()) {
            this.primeNext();
            ++this.i;
        }

        return out;
    }

    private void primeNext() {
        switch (this.direction) {
            case X:
                if (this.err_1 > 0) {
                    this.voxel.move(0, this.y_inc, 0);
                    this.err_1 -= this.doubleAbsDx;
                }

                if (this.err_2 > 0) {
                    this.voxel.move(0, 0, this.z_inc);
                    this.err_2 -= this.doubleAbsDx;
                }

                this.err_1 += this.doubleAbsDy;
                this.err_2 += this.doubleAbsDz;
                this.voxel.move(this.x_inc, 0, 0);
                break;
            case Y:
                if (this.err_1 > 0) {
                    this.voxel.move(this.x_inc, 0, 0);
                    this.err_1 -= this.doubleAbsDy;
                }

                if (this.err_2 > 0) {
                    this.voxel.move(0, 0, this.z_inc);
                    this.err_2 -= this.doubleAbsDy;
                }

                this.err_1 += this.doubleAbsDx;
                this.err_2 += this.doubleAbsDz;
                this.voxel.move(0, this.y_inc, 0);
                break;
            case Z:
                if (this.err_1 > 0) {
                    this.voxel.move(0, this.y_inc, 0);
                    this.err_1 -= this.doubleAbsDz;
                }

                if (this.err_2 > 0) {
                    this.voxel.move(this.x_inc, 0, 0);
                    this.err_2 -= this.doubleAbsDz;
                }

                this.err_1 += this.doubleAbsDy;
                this.err_2 += this.doubleAbsDx;
                this.voxel.move(0, 0, this.z_inc);
        }

    }

    public Iterator<BlockPos> iterator() {
        return this;
    }
}
