package com.company.array;

import java.util.Arrays;

public class Merge {
    public void merge(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0)
            A[m+n-1] = A[m-1] > B[n-1] ? A[--m] : B[--n];

        while (n > 0)
            A[n-1] = B[--n];
    }

    public static void main(String[] args) {
        int[] A = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] B = new int[] { 2, 5, 6 };
        new Merge().merge1(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }


    public void merge1(int[] A, int m, int[] B, int n) {
        while (m > 0 && n > 0) {
            A[m+n-1] = A[m-1] > B[n-1] ? A[--m] : B[--n];
        }
        if (m < 0)
            A[n-1] = B[--n];
    }
}
