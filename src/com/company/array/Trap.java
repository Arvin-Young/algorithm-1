package com.company.array;

public class Trap {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int ans = 0;
        if (height == null)
            return ans;
        int len = height.length;
        int leftMax = 0;
        int rightMax = 0;
        int leftIdx = 0;
        int rightIdx = len - 1;
        while (leftIdx < rightIdx) {
            if (height[leftIdx] <= height[rightIdx]) {
                if (height[leftIdx] >= leftMax) {
                    leftMax = height[leftIdx];
                } else
                    ans += leftMax - height[leftIdx];
                leftIdx ++;
            } else {
                if (height[rightIdx] > rightMax) {
                    rightMax = height[rightIdx];
                } else
                    ans += rightMax - height[rightIdx];
                rightIdx --;
            }

        }
        return ans;
    }
}
