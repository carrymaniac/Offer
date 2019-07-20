package sort;

import common.SortUtil;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void BubbleSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        for(int i = arr.length-1;i>0;i--){
            for(int j = 1;j<=i;i++){
                if(arr[j]<arr[j-1]){
                    SortUtil.swap(arr,j,j-1);
                }
            }
        }
    }


}
