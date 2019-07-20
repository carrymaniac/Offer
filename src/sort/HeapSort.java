package sort;

import static common.SortUtil.swap;

public class HeapSort {


    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) >> 1]) {
            swap(arr, index, (index - 1) >> 1);
            index = (index - 10 >> 1);
        }
    }


    public void heapify(int[] arr, int index, int size) {
        int left = index * 2+1;
        while (left < size) {
            int largest = (left + 1 < size && arr[left + 1] > arr[left]) ? left + 1 : left;
            largest = (arr[index] < arr[largest]) ? largest : index;
            if (index == largest) {
                break;
            } else {
                swap(arr, index, largest);
                index = largest;
                left = index * 2+1;
            }
        }
    }

    public void HeapSort(int[] arr){
        if (arr==null||arr.length<2){
            return;
        }
        for(int i = 0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int size = arr.length;
        swap(arr,0,--size);
        while(size>0){
            heapify(arr,0,size);
            swap(arr,0,--size);
        }

    }
}
