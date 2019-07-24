package Chap5;

public class q50 {
    public int FirstNotRepeatingChar(String str) {
        int[] cnt = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnt[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}