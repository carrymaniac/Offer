package nowcode.class8;

public class Code_07_MinPath {

    //暴力递归的方式，判断全部的情况,枚举
    public int process(int[][] arr, int r, int c){
        if(c==arr[1].length-1&&r==arr.length-1){
            //到达末尾
            return arr[c][r];
        }
        if(r==arr.length-1){
            //到达最后一行，此时只能往右走
            return arr[r][c]+process(arr,r,c+1);
        }
        if(c==arr[1].length-1){
            //到达最后一列，只能往下
            return arr[r][c]+process(arr,r+1,c);
        }
        return Math.min(arr[r][c]+process(arr,r+1,c),arr[r][c]+process(arr,r,c+1));
    }
//   动态规划，由暴力递归修改而来
//    先考虑暴力递归的base case：其中可得知最右下角的值
//    通过最右下角的值可以推导最右一列和最下一行的全部值
//    通过递归的方程推导其余全部
//  反转思考，右下角到左上角的距离为？
    public int process(int[][] grid){
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        int col = grid[0].length;
        int row = grid.length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int j =1;j<col;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i = 1;i<row;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j = 1;j<col;j++){
            for(int i = 1;i<row;i++){
                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }
}
