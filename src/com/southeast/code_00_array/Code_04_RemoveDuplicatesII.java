package com.southeast.code_00_array;

/**
 * Created by 18351 on 2018/10/26.
 */
public class Code_04_RemoveDuplicatesII {
    public int removeDuplicates(int[] nums) {
        if (nums.length<= 2){
            return nums.length;
        }

        int k = 1;
        //k=1时，前两个元素必然在数组中
        int cnt = 1;
        for(int i=1;i < nums.length;i++) {
            if (nums[i] != nums[i-1]) {
                //相邻元素不相等,元素个数为1
                cnt = 1;
                nums[k++] = nums[i];
            } else {
                //存在相邻元素
                if (cnt < 2) {
                    //cnt<2说明值已经进来1个元素，此时再加1个元素
                    nums[k++] = nums[i];
                    cnt++;
                }
            }
        }
        return k;
    }

    /**
     * 拓展：
     * 给定一个有序数组，对数组中的元素去重，使得原数组中每个元素最多保留n个。返回去重后数组的长度值。
     */
    public int removeDuplicates(int[] nums,int n) {
        if (nums.length<= n){
            return nums.length;
        }

        int k = 1;
        //k=1时，前两个元素必然在数组中
        int cnt = 1;
        for(int i=1;i < nums.length;i++) {
            if (nums[i] != nums[i-1]) {
                //相邻元素不相等,元素个数为1
                cnt = 1;
                nums[k++] = nums[i];
            } else {
                //存在相邻元素
                if (cnt < n) {
                    //cnt<2说明值已经进来1个元素，此时再加1个元素
                    nums[k++] = nums[i];
                    cnt++;
                }
            }
        }
        return k;
    }
}
