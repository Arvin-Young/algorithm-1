package com.company.array;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {7,6,4,3,1};
        MaxProfit p = new MaxProfit();
        System.out.println(p.maxProfit(a));
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        int in = prices[0];
        for (int i = 1; i < prices.length; i ++) {
            max = Math.max(max, prices[i] - in);
            in = Math.min(in, prices[i]);
        }
        return max;
    }
}
