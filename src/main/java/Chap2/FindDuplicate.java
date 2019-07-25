package Chap2;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2或者3。
 */
public class FindDuplicate {
    public static int duplication;

    public static boolean duplicate(int numbers[]){

            //判断是否为空
            if(numbers==null||numbers.length==0){
                return false ;
            }
            //判断数字是否合法
            for(int i:numbers){
                if(i<0||i>=numbers.length){
                    return false;
                }
            }
            for(int i = 0 ;i<numbers.length;i++){
                while (numbers[i]!=i){
                    if(numbers[i]==numbers[numbers[i]]){
                        //若该数和已在该位置数相同,说明找到重复的数字
                        duplication = numbers[i];
                        System.out.println(numbers[i]);
                        return true;
                    }
                    /*
                        进行交换
                     */
                    int temp = numbers[i];
                    numbers[i] = numbers[temp];
                    numbers[temp] = temp;
                }
            }
            return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,1,0,2,5,3};
        boolean result = duplicate(arr);
        System.out.println(result);
    }

}
