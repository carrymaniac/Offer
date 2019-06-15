package Chap4;

import java.util.ArrayList;

/**
 * @Author Ha
 * @DATE 2019/6/15 15:21
 **/
public class q29 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> rat = new ArrayList<>();
        int r1 = 0 ;
        int c1 = 0 ;
        int c2 = matrix[0].length - 1 ;
        int r2 = matrix.length - 1 ;
        while (r1<=r2&&c1<=c2){
            //从左往右打印 ->
            for (int i = c1; i <= c2; i++) {
                rat.add(matrix[r1][i]);
            }
            //撞到c2之后 从上往下进行打印
            for(int i = r1;i<= r2 ;i++) {
                rat.add(matrix[i][c2]);
            }
            if(r1 != r2){
                //从右往左打印
                for (int i = c2-1; i >=c1; i--) {
                    rat.add(matrix[r2][i]);
                }
            }
            //从下往上打印
            if(c1 != c2){
                for (int i = r2-1; i >=r1; i--) {
                    rat.add(matrix[i][c1]);
                }
            }
            //结束一轮,缩小边界
            r1++;r2--;c1++;c2--;
        }
        return rat;
    }
}
