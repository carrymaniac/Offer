package Chap6;

public class q58_1 {
    //先反转局部单词
    //再反转整体
    public String ReverseSentence(String str) {
    if(str==null||str.length()==0){
        return "";
    }
    char[] chars = str.toCharArray();
    int i = 0 ;
    int j = 0 ;
    int n = str.length();
    while(j<n){
        if(j == n||chars[j]==' '){
            reverse(chars,i,j);
        }
        j++;
    }
    reverse(chars,0,n-1);
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
