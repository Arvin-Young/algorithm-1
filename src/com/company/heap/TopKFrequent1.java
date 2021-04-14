package com.company.heap;

import java.util.*;

public class TopKFrequent1 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        //int[] nums = {1,2};
        int[] array = topKFrequent(nums, 2);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0 ; i < nums.length; i ++) {
            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else
                map.put(nums[i], 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k,
                (a, b) -> { return map.get(b) - map.get(a); }
        );

        for (Integer key : map.keySet())
            queue.offer(key);

        int[] array = new int[k];
        if (!queue.isEmpty()) {
            for (int i = 0; i < k; i ++) {
                array[i] = queue.remove();
            }
        }

        return array;
    }

}
