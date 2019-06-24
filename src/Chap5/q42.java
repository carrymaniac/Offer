package Chap5;

/**
 * @Author Ha
 * @DATE 2019/6/24 16:35
 * 连续子数组的最大和
 *
 * 规律在于:若前面的值已经为负数,此时应该舍弃前面的值,重新开始计算和
 **/
public class q42 {

    public int FindGreatestSumOfSubArray(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int greatestSum = Integer.MIN_VALUE;
        int sum = 0 ;
        for(int num:nums){
            sum = sum<0?num:num+sum;
            greatestSum = Math.max(sum,greatestSum);
        }
        return greatestSum;
    }
}
