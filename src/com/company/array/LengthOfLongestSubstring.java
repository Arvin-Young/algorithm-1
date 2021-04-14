package com.company.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String  s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        if (s == null)
            return res;
        Set<Character> set = new HashSet<>();
        int l = 0, r = -1;
        while (l < s.length()) {
            if (r + 1 < s.length() && !set.contains(s.charAt(r + 1))) {
                set.add(s.charAt(++r));
            }
            else
               set.remove(s.charAt(l ++));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
