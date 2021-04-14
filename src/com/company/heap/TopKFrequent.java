package com.company.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {
        //int[] nums = {1,1,1,2,2,3};
        int[] nums = {1,2};
        int[] array = topKFrequent(nums, 2);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < nums.length; i ++) {
            int temp = nums[i];
            if (map.containsKey(temp)) {
                int times = map.get(temp);
                map.put(temp, ++times);
            } else {
                map.put(temp, 1);
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        map.forEach((key, val) -> queue.offer(val));

        int[] array = new int[k];
        Integer a = null;
        for (int i = 0; i < k; i ++) {
            int times = queue.poll();
            for (int key : map.keySet()) {
                if (map.get(key) == times) {
                    array[i] = key;
                    a = key;
                    break;
                }
            }
            map.remove(a);
        }
        return array;
    }
}
class MyHeap {

}