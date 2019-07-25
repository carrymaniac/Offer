package Chap5;

import java.util.ArrayList;

/**
 * @Author Ha
 * @DATE 2019/6/24 15:45
 * 利用快速排序的 partition() 方法
 **/
public class q40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (k > nums.length || k <= 0)
            return ret;
        findKthSmallest(nums, k - 1);
        /* findKthSmallest 会改变数组，使得前 k 个数都是最小的 k 个数 */
        for (int i = 0; i < k; i++)
            ret.add(nums[i]);
        return ret;
    }

    public void findKthSmallest(int[] nums,int k){
        int left = 0 ;
        int right = nums.length - 1;
        while (left<right){
            int j = partition(nums,left,right);
            if (j == k)
                break;
            if (j > k)
                right = j - 1;
            else
                left = j + 1;
        }
    }
    private int partition(int[] nums,int left,int right){
        int p = nums[left];
        int l =left;
        int r =right;
        while (true) {
            while (nums[++l] < p && l < right) ;
            while (nums[--r] > p && p > left) ;
            if (l > r) break;
            swap(nums,l,r);
        }
        swap(nums,l,left);
        return l;
    }
    private void swap(int[] nums,int j ,int k ){
        int tmp = nums[j];
        nums[j] = nums[k];
        nums[k] = tmp;
    }
}

