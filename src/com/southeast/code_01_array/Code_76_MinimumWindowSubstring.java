package com.southeast.code_01_array;

import org.junit.Test;

/**
 * 76. Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"

 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Code_76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        int[] tFreq=new int[256];
        for(int i=0;i<t.length();i++){
            tFreq[t.charAt(i)]++;
        }

        int l=0,r=0;
        //[l,r]为滑动窗口，开始时，没有元素
        int count=0;
        //在滑块中出现的字符串T中的元素个数
        int ret=s.length()+1;
        //记录最长子段的长度
        while(r<s.length()){
            if(tFreq[s.charAt(r)]-->=1){
                //扩展窗口
                //r++;
                count++;
            }
            if(count==t.length()){
                ret=Math.min(ret,r-l);
                l++;
            }
            while(count==t.length()){
                if (++tFreq[s.charAt(++r)]>=1) {
                    count--;
                }
            }
            r++;
        }
        return s.substring(l,l+ret);
    }

    @Test
    public void test(){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(minWindow(S,T));
    }
}
