package Chap5;

/**
 * 礼物最大价值
 * 动态规划经典题目
 * 由已知的项目去推导
 */
public class q47 {
    public int getMost(int[][] values){
        if(values==null||values[1].length==0||values.length==0){
            return 0;
        }
        int row = values.length;
        int col = values[0].length;
        int[][] dp = new int[row][col];
        dp[0][0]=values[0][0];
        for(int i = 1;i<row;i++){
            dp[i][0]=values[i][0]+dp[i-1][0];
        }
        for(int j = 1;j<col;j++){
            dp[0][j]=values[0][j]+dp[0][j-1];
        }
        for(int i = 1;i<row;i++){
            for(int j = 1;j<row;j++){
                dp[i][j] = values[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[row-1][col-1];
    }

    //压缩成一维数组
    public int getMost1(int[][] values) {
        if (values == null || values[1].length == 0 || values.length == 0) {
            return 0;
        }
        int n = values[0].length;
        int[] dp = new int[n];
        for(int[] value:values){
            dp[0]+=value[0];
            for(int i = 1;i<n;i++){
                dp[i]=Math.max(dp[i],dp[i-1])+value[i];
            }
        }
        return dp[n-1];
    }
}
