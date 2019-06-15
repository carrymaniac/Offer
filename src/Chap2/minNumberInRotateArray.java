package Chap2;

/**
 * 11. 旋转数组的最小数字
 * NowCoder
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *
 */
public class minNumberInRotateArray {
    public int minNumberInRotateArray(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int l = 0;
        int h = nums.length -1 ;
        while(l<h){
            int m = (l+(h-l))>>1;
            if(nums[m]<=nums[h]){
                h = m;
            }else {
                l = m+1;
            }
        }
        return nums[l];
    }
}
