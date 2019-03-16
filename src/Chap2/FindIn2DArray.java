package Chap2;

/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class FindIn2DArray {
    /**
     * 普通思路:
     * 对每个二维数组的每一行进行二分法查找
     *
     */
    /**
     * 书本做法:
     * 从右上角的顶角开始比较
     */
    public boolean Find(int target, int[][] array) {
        if(array!=null&&array.length>0){
            int N =array.length;    //总行数
            int col = array[0].length - 1;//列索引
            int row = 0 ;//行索引
            while (row<N&&col>0){
                if(target<array[row][col]){
                    //目标值小于右上角的数字,切除所在列
                    col--;
                }else if (target>array[row][col]){
                    //目标值大于右上角数字,切除所在行
                        row++;
                }else{
                    //目标值等于右上角数字
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
