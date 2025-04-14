package LeetCode;


public class _1881_maxValue {
    public static void main(String[] args) {
        String n = "-132";
        int x = 3;
        System.out.println(Method(n,x));
    }
    public static String Method(String n,int x){
        boolean judge = n.charAt(0)!='-';
        StringBuilder sb = new StringBuilder();
        int len = n.length();
        if(judge){
            for (int i = 0; i < len; i++) {
                int num = Integer.parseInt(n.substring(i,i+1));
                if(num <= x){
                    sb.append(n, 0, i).append(x).append(n, i, len);
                    break;
                }
            }
        }else {
            for (int i = 1; i < len; i++) {
                int num = Integer.parseInt(n.substring(i, i + 1));
                if (num > x) {
                    sb.append(n, 0, i).append(x).append(n, i, len);
                    break;
                }
            }
            if(String.valueOf(sb).isEmpty()){
                sb.append(n).append(x);
            }
        }
        return String.valueOf(sb);
    }
}
