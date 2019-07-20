package sort;

import common.SortUtil;

/**
 * 快排
 */
public class QuickSort {

    public static void quicSort(int[] arr){
        if(arr==null||arr.length<2){
            return;
        }
        quicSort(arr,0,arr.length);
    }

    private static void quicSort(int[] arr, int l, int r) {
        if(l<r) {
            //打乱
            SortUtil.swap(arr,r,(int)(Math.random()*(r-l+1))+l);
            int[] partition = partition(arr, l, r);
            quicSort(arr,l,partition[0]-1);
            quicSort(arr,partition[1]+1,r);
        }
    }

    public static int[] partition(int[] arr, int l, int r){
        int less = l - 1 ;
        int more = r ;
        while(l<r){
            if(arr[l]<arr[r]){
                SortUtil.swap(arr,l++,++less);
            }else if(arr[l]>arr[r]){
                SortUtil.swap(arr,l,--more);
            }else {
                l++;
            }
        }
        SortUtil.swap(arr,r,more);
        return new int[]{less+1,more};
    }
}
