package com.southeast.code_01_array;

import org.junit.Test;

/**
 *
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true

 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class Code_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<s.length();k++){
            if(isAlphaNumeric(s.charAt(k))){
                if(s.charAt(k)>='A' && s.charAt(k)<='Z'){
                    sb.append((char)(s.charAt(k)+32));
                }else{
                    sb.append(s.charAt(k));
                }
            }
        }
        s=sb.toString();
        int i=0;
        int j=s.length()-1;
        System.out.println(s);
        while(i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if((c1 !=c2)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isAlphaNumeric(char c){
        if((c>='A' && c<='Z') || (c>='a' && c<='z')){
            return true;
        }
        if(c>='0' && c<='9'){
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        boolean flag=isPalindrome("0P");
        System.out.println(flag);
    }
}
