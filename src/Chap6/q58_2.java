package Chap6;

//左旋转

public class q58_2 {
    public String LeftRotateString(String str, int n) {
        if(str.length()<=n){
            return str;
        }
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,str.length()-1);
        reverse(chars,0,str.length()-1);
        return new String(chars);
    }


    //反转
    public void reverse(char[] c, int i, int j){
        while (i<j){
            swap(c,i++,j--);
        }
    }

    public void swap(char[] chars, int i, int j){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
