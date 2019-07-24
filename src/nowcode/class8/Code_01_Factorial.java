package nowcode.class8;

/**
 * 求N！
 * 分为几种，暴力递归和动态规划
 */
public class Code_01_Factorial {

    /**
     * 暴力递归方式，找到base case,然后分解小问题
     * @param n
     * @return
     */
    public long getFactorial(int n){
        if(n==1){
            return 1L ;
        }
        return (long)getFactorial(n-1)*n;
    }

    /**
     * 非暴力递归，获取已有的已经能获取到的值，再往后推导
     * @param n
     * @return
     */
    public long getFactorial2(int n){
        long result = 1L;
        for(int i = 1;i<=n;i++){
            result*=i;
        }
        return result;
    }


}
