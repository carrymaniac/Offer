package Chap5;

/**
 * @Author Ha
 * @DATE 2019/6/24 16:35
 * 连续子数组的最大和
 * 记录下之前和的最大值，当和为负数时，舍弃现有的序列
 * 规律在于:若前面的值已经为负数,此时应该舍弃前面的值,重新开始计算和
 *
 * 换一个思路：动态规划来考虑
 * f(i)的值为f(i-1)+pData[i]或者是pData[i]
 * 取决于f(i-1)是否大于0
 *
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
