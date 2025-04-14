package LeetCode;

public class _0151_2_InvertAWordInAString {
    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        StringBuilder sb =new StringBuilder();
        char []c = s.toCharArray();
        int i = s.length()-1;
        for (; i >= 0; i--) {
//            从后往前遍历，先找单词的末尾
            while (i>=0 && c[i] == ' '){
                i--;
            }
            if (i < 0){
                break;
            }
            int end = i;//单词末尾的索引
//            再找单词的开头
            while(i>=0 && c[i] != ' '){
                i--;
            }
//            先添加“ ”，在添加单词
            sb.append(" ").append(s.substring(i+1,end+1));
        }
        return sb.toString().trim();
    }
}
