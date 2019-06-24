package Chap5;

/**
 * @Author Ha
 * @DATE 2019/6/24 19:05
 **/
public class q43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            cnt += (a + 8) / 10 * m + (a % 10 == 1 ? b + 1 : 0);
        }
        return cnt;
    }

    public static void main(String[] args) {
        q43 q43 = new q43();
        int i = q43.NumberOf1Between1AndN_Solution(100);
        System.out.println(i);
    }
}
