package com.company.array;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        int[] array = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(array));

        //Map<Integer, Integer> map = new HashMap<>();
        //map.getOrDefault()
    }

    public static int longestConsecutive(int[] nums) {
        int longStreak = 0;
        if (nums == null)
            return longStreak;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (numSet.contains(cur-1))
                continue;
            int currentStreak = 0;
            while (numSet.contains(cur++))
                currentStreak++;
            longStreak = Math.max(longStreak, currentStreak);
        }
        return longStreak;
    }

    public static int longestConsecutive1(int[] nums) {
        if (nums == null)
            return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums)
            numSet.add(num);

        int longestStreak = 0;

        for (int num : numSet) {
            if (numSet.contains(num - 1))
                continue;
            int currentStreak = 0;
            while (numSet.contains(num++))
                currentStreak++;
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}
