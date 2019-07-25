package Chap2;

/**
 *
 * 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 *
 *
 */
public class MatrixhasPath {
    //key:用一个数组代表上下左右四个方向
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    int rows ;
    int cols;
    public boolean hasPath(char[] arrays,int rows,int cols,char[] str){
        //1.矫正参数
        if(rows==0|cols==0){
            return false;
        }
        this.cols =cols;
        this.rows = rows;
        //2.构建标记矩阵和字符矩阵
        boolean[][] mark = new boolean[rows][cols];
        char[][] matrix = buildmatrix(arrays,rows,cols);
        //3.进行检查
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (backtracking(matrix, str, mark, 0, i, j))
                    return true;
        return false;
    }

    private boolean backtracking(char[][] matrix, char[] str, boolean[][] mark, int pathLen, int r, int c) {
        if(pathLen==str.length){
            //已经找到,返回ture
            return true;
        }
        if(r<0||r>=rows||c<0||c>cols||matrix[r][c]!=str[pathLen]||mark[r][c]){
            return false;
        }
        mark[r][c] = true;
        for(int[] n:next){
            if(backtracking(matrix,str,mark,pathLen+1,r+n[0],c+n[1]))
                return true;
        }
        //如果四边都不行,则这个点不通,不走,将其还原为false(未走)
        mark[r][c] = false;
        return false;
    }

    private char[][] buildmatrix(char[] arrays, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for(int i=0,idx=0;i<rows;i++){
            for(int k=0;k<cols;k++){
                matrix[i][k] = arrays[idx++];
            }
        }
        return matrix;
    }
}
