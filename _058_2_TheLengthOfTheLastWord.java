package LeetCode;

public class _058_2_TheLengthOfTheLastWord {
    public static void main(String[] args) {
        String s =   "a";
        System.out.println(Method(s));
    }
    public static int Method(String s){
        int a = 0,length = 0;
        String str = "";
        for (int i = s.length(); i > 0 ; i--) {//标记非空格位置
            if (s.charAt(i-1) != ' '){
                a = i ;
                break;
            }
        }
        for (int j = a; j > 0 ; j--) {
            if (s.charAt(j-1) == ' '){
                break;
            }else {
                str = s.substring(j-1 , a);
                length = a-(j-1);
            }
        }
        System.out.println(str);
        return length;
    }
}
