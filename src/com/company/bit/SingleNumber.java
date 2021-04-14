package com.company.bit;

public class SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        int single = singleNumber(nums);
        System.out.println(single);
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums)
            single ^= num;
        return single;
    }
}
