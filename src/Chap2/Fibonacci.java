package Chap2;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 *
 *
 * 如果使用递归求解，会重复计算一些子问题。例如，计算 f(10) 需要计算 f(9) 和 f(8)，计算 f(9) 需要计算 f(8) 和 f(7)，可以看到 f(8) 被重复计算了。
 *
 * 使用分治的思想,把大问题分解为小问题
 *
 */
public class Fibonacci {
    /**
     * 用数组存储结果
     * @param n
     * @return
     */
    public int Fibonacci(int n){
        if(n<=1){
            return n;
        }
        int[] fib = new int[n+1];
        fib[1] = 1;
        for(int i =2 ; i<=n; i++){
            fib[i]= fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    /**
     * 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，从而将空间复杂度由 O(N) 降低为 O(1)。
     * @param n
     * @return
     */
    public int Fibonacci1(int n){
        if (n <= 1)
            return n;
        int pre2 = 0,pre1 =1;
        int fib = 0;
        for(int i =2;i<=n;i++){
            fib = pre2 + pre1;
            pre2 = pre1 ;
            pre1 = fib ;
        }
        return fib;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int fibonacci1 = fibonacci.Fibonacci(9);
        System.out.println(fibonacci1);
    }
}
