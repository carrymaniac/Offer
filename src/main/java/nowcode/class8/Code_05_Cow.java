package nowcode.class8;

/**
 * 有一头母牛，它每年年初生一头小母牛。
 * 每头小母牛从第四个年头开始，每年年初也生一头小母牛。
 * 请编程实现在第n年的时候，共有多少头母牛？
 */
public class Code_05_Cow {

    public int porcess(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }

        return porcess(n - 1) + porcess(n - 3);

    }

    public int process1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int prepre = 1;
        int pre = 2;
        int res = 3;
        int temp1;
        int temp2;
        for (int i = 4; i < n; i++) {
            temp1 = res;
            temp2 = pre;
            res = res + prepre;
            pre = temp1;
            prepre = temp2;
        }
        return res;
    }
}
