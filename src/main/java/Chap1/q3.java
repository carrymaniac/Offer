package Chap1;

/**
 * @Author Ha
 * @DATE 2019/6/22 10:53
 **/
//数组中重复的数字
public class q3 {
    public boolean duplicate(int[] nums,int length,int[] duplication){
        if(nums == null||length<=0){
            return false;
        }
        for(int i = 0;i<length;i++){
            while (nums[i]!=i){
                if(nums[nums[i]]==nums[i]){
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i , int j){
        int t = nums[i];
        nums[i] = nums[j] ;
        nums[j] = t ;
    }
}
