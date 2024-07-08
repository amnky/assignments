package com.techlabs.model;

import java.util.Arrays;

public class MathUtil {
    public int add(int a, int b){
        return a+b;
    }

    public int divide(int a, int b){
        return a/b;
    }

    public int[] sortArray(int[] arr){
        Arrays.sort(arr);
        return arr;
    }
}
