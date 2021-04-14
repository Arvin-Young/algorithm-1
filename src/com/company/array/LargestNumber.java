package com.company.array;

public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            for (int j = i; j > 0 && compareIfAThanB(nums[j], nums[j-1]); j --) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
        String ret = "";
        for (int i = 0; i < nums.length; i ++)
            ret += nums[i];
        return ret;
    }

    private static boolean compareIfAThanB(int a, int b) {
        String A = String.valueOf(a);
        String B = String.valueOf(b);

        if (A.length() < B.length())
            return compareIfAThanB(A, B);
        if (A.length() > B.length())
            return compareIfAThanB(B, A);
        return true;
    }
    private static boolean compareIfAThanB(String A, String B) {
        int index = 0;
        for (int i = 0 ; i < B.length(); i ++) {
            if (A.charAt(index) > B.charAt(i))
                return true;
            if (A.charAt(index) < B.charAt(i) )
                return false;
            index ++;
            if (index == A.length())
                index = 0;
        }
        return true;
    }
    private static boolean compareIfAThanB1(int a, int b) {
        String A = String.valueOf(a);
        String B = String.valueOf(b);

        if (A.length() < B.length())
            A = enlargeStr(A, B);
        if (A.length() > B.length())
            B = enlargeStr(B, A);

        int index = 0;
        while (index < A.length()) {
            if (A.charAt(index) > B.charAt(index))
                return true;
            else if (A.charAt(index) < B.charAt(index))
                return false;
            else
                index ++;
        }
        return true;
    }

    private static String enlargeStr(String A, String B) {
        int index = 0;
        while (A.length() < B.length()) {
            A += A.charAt(index ++);
            if (index == A.length())
                index = 0;
        }
        return A;
    }
}
