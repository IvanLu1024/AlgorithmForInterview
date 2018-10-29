package com.southeast.code_02_find;

import org.junit.Test;

import java.util.*;

/**
 * 15. 3Sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],、
 * A solution set is:[[-1, 0, 1],[-1, -1, 2]]
 */
public class Code_03_3Sum {
    /**
     * 思路：
     * 类比twoSum中方法
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return null;
        }
        Map<Integer,Integer> map=new HashMap<>();
        List<List<Integer>> ret=new ArrayList<>();

        //HashMap<Intager,Integer>,键存储的是该元素的值，值存储的是该元素的下标.
        for(int i=0;i<nums.length;i++){
            int target=-nums[i];
            for(int j=i+1;j<nums.length;j++){
                int v=target-nums[j];
                if(map.containsKey(v)){
                    List<Integer> list=new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    list.add(map.get(v));
                    ret.add(list);
                }
            }
            map.put(nums[i],i);
        }
        return ret;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        if (nums==null||nums.length==0){
            return null;
        }
        List<List<Integer>> res=new ArrayList<>();
        Map<Integer,Integer> numMap=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int target=-nums[i];
            for (int j = 0; j <nums.length ; j++) {
                int cmp=target-nums[j];
                if (numMap.containsKey(cmp)){
                    List<Integer> list=new LinkedList<>();
                    list.add(-target);
                    list.add(cmp);
                    list.add(nums[j]);
                    res.add(list);
                }
                numMap.put(nums[j],j);
            }
        }
        return  res;

    }

    @Test
    public void test(){
        int[] arr={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list=threeSum(arr);
        System.out.println(list);
     }
}
