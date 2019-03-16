package Chap2;

/**
 * 在一个长度为n+1的数组里的所有数字都在1~n的范围内，所以数组中至少有一个数字是重复的。
 * 请找出数组中任意一个重复的数字，但是不能修改输入的数组。例如，如果输入长度为8的数组{2,3,5,4,3,2,6,7}，那么对应的输出是重复的数字2或者3。
 */
public class FindDuplicate2 {
    /**
     * 通过创建辅助数组来进行操作,空间复杂度是O(n);
     *
     * @param arr
     * @return
     */
    public static int getDuplication(int[] arr) {
        //判断数组是否有格式问题
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] >= arr.length) {
                return -1;
            }
        }
        //创建辅助数组
        int tempArr[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            //发现有重复项目
            if (arr[i] == tempArr[arr[i]]) {
                return arr[i];
            }
            tempArr[arr[i]] = arr[i];
        }
        return -1;
    }

    /**
     * 使用二分法来查询
     *
     * @param arr
     * @return
     */
    public static int getDuplication2(int[] arr) {
        //判断数组是否有格式问题
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] >= arr.length) {
                return -1;
            }
        }
        int start = 1;
        int end = arr.length - 1;
        int mid = 0;
        int count = 0;
        while (start <= end) {
            if (start == end) {
                count = countRange(arr, start, end);
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            mid = (start + end) / 2;
            count = countRange(arr, start, end);
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    //遍历该数组,查看该数组的有多少个数在给定的范围内
    public static int countRange(int[] arr, int start, int end) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= start && arr[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 4, 2, 5, 6, 7};
        int result = getDuplication(numbers);
        System.out.println(result);
    }
}

