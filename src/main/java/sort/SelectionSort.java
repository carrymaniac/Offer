package sort;

import common.SortUtil;

public class SelectionSort {

    public static void SelectSort(int[] arr) {
        if (arr.length < 2 || arr == null) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;

            }
            SortUtil.swap(arr, minIndex, i);
        }
    }
}
