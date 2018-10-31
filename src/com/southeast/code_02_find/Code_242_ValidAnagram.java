package com.southeast.code_02_find;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false

 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class Code_242_ValidAnagram {
    public boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freq[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char curChar=t.charAt(i);
            if(freq[curChar-'a']==0){
                return false;
            }
            freq[curChar-'a']--;
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        //使用map统计 s中字符出啊先的次数
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            int freq=map.get(s.charAt(i))==null?0:map.get(s.charAt(i));
            map.put(c,++freq);
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(map.containsKey(c)){
                int freq=map.get(c);
                map.put(c,--freq);
            }else{
                return false;
            }
        }
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i))!=0){
                return false;
            }
        }
        return true;
    }
        //使用map统计 s中字符出啊先的次数
       /* Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> tMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            int sFreq=sMap.get(s.charAt(i))==null?0:sMap.get(s.charAt(i));
            sMap.put(sChar,++sFreq);
            char tChar=t.charAt(i);
            int tFreq=tMap.get(t.charAt(i))==null?0:tMap.get(t.charAt(i));
            tMap.put(tChar,++tFreq);
        }
        for(int i=0;i<t.length();i++){
            char tChar=t.charAt(i);
            if(!sMap.containsKey(tChar) || !(sMap.get(tChar)==tMap.get(tChar))){
                return false;
            }
        }
        return true;
        */
}
