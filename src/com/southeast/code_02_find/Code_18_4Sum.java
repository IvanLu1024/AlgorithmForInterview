package com.southeast.code_02_find;

import org.junit.Test;

import java.util.*;

/**
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums
 * such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 *
 * A solution set is:
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * Note:The solution set must not contain duplicate quadruplets.
 */
public class Code_18_4Sum {
    //返回的结果存在大量重复的情况
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret=new ArrayList<>();
        if(nums.length<4){
            return ret;
        }
        Map<Integer,Integer> map=new HashMap<>();
        //HashMap<Intager,Integer>,键存储的是该元素的值，值存储的是该元素出现的次数
        for(int num:nums){
            int freq=map.get(num)==null?0:map.get(num);
            map.put(num,++freq);
        }

        Set<Integer> keySet=map.keySet();
        for(Integer num:keySet){
            //numCount就是num元素出现的次数
            int numCount=map.get(num);
            if(numCount>=4){
                //如果该元素出现的次数>=4,如果存在 4*num==target的情况，(num,num,num,num)就是其中的一个解
                if(4*num==target){
                    ret.add(Arrays.asList(num,num,num,num));
                }
            }
            if(numCount>=3){
                //如果该元素出现的次数>=3，
                int num2=target-3*num;
                if(num!=num2 && map.containsKey(num2)){
                    //num!=num2,防止出现（num,num,num,num）的情况
                    ret.add(Arrays.asList(num,num,num,num2));
                }
            }
            if(numCount>=2){
                for (int num2:map.keySet()){
                    if(num!=num2) {
                        int num3 = target - 2 * num - num2;
                        //这里要保证 num2<num3
                        if (num2 > num3 || num==num3 || !map.containsKey(num3)) {
                            continue;
                        }
                        ret.add(Arrays.asList(num, num, num2, num3));
                    }
                }
            }
            for(int num2:map.keySet()){
                if(num!=num2){
                    for(int num3:map.keySet()){
                        if(num!=num3 && num2!=num3){
                            int num4=target-num-num2-num3;
                            //这里要保证 num<num2<num3<num4
                            if(num>=num2 || num2>=num3 || num3>=num4 || !map.containsKey(num4)){
                                continue;
                            }
                            ret.add(Arrays.asList(num,num2,num3,num4));
                        }
                    }
                }

            }
        }
        return ret;
    }

    public List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> ret=new ArrayList<>();
        if(nums.length<4){
            return ret;
        }
        Arrays.sort(nums);
        return ret;
    }

    @Test
    public void test(){
        //int[] arr={1,0,-1,0,-2,2};
        //int target=0;

        //int[] arr={0,1,5,0,1,5,5,-4};
        //int target=11;

        int [] arr={0,4,-5,2,-2,4,2,-1,4};
        int target=12;
        List<List<Integer>> list=fourSum(arr,target);
        System.out.println(list);
    }
}
