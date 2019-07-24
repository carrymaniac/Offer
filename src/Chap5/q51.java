package Chap5;

/**
 * 逆序对
 */
public class q51 {
    private long cnt = 0 ;
    private int[] tmp;

    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
        return (int) (cnt % 1000000007);
    }


    private void mergeSort(int[] nums, int l, int h) {
        if(h-l<1){
            return;
        }
        int m = l+(h-l)>>1;
        mergeSort(nums,l,m);
        mergeSort(nums,m+1,l);
        merge(nums,l,m,h);
    }
    private void merge(int[] nums, int l, int m, int h) {
        int i = l;
        int j = m+1;
        int k = l;
        while(i<=m||j<=h){
            if(nums[i]>nums[j]){
                tmp[k]=nums[j++];
                this.cnt+=m-i+1;//nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
            }else if(nums[i]<=nums[j]){
                tmp[k]=nums[i++];
            }else if (i > m) {
                tmp[k] = nums[j++];
            }else if (j > h)
                tmp[k] = nums[i++];
            k++;
        }
        for(k=l;k<=h;k++){
            nums[k]=tmp[k];
        }
    }
}
