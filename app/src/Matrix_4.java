package com.anikesh.splititmatrix;

import java.util.Arrays;

/**
 * Created by anikesh on 08-09-2017.
 */

public class Matrix {
    int[][] split = new int[5][5];
    int[] spent = new int[5];

    public Matrix(int[][] split, int[] spent) {
        this.split = split;
        this.spent = spent;
    }

    public String toStringMatrix() {
        return "Matrix{" +
                "split=" + Arrays.toString(split) +
                ", spent=" + Arrays.toString(spent) +
                '}';
    }

    public int[][] getSplit() {
        return split;
    }

    public void setSplit(int[][] split) {
        this.split = split;
    }

    public int[] getSpent() {
        return spent;
    }

    public void setSpent(int[] spent) {
        this.spent = spent;
    }
}
