package Chap1;

/**
 * @Author Ha
 * @DATE 2019/6/22 10:58
 **/
public class q4 {
    public boolean Find(int target, int[][] matrix){
        if(matrix == null||matrix.length==0||matrix[0].length==0){
            return false;
        }

        int row = matrix.length;
        int cols = matrix[0].length;
        int r = 0 ;
        int c = cols - 1;
        while (r<row&&c>=0){
            if(target == matrix[r][c]){
                return true;
            }else if (target>matrix[r][c]){
                r++;
            }else {
                c--;
            }
        }
        return false;
    }
}
