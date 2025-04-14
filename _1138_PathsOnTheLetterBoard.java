package LeetCode;

import java.util.HashMap;

//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
//在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。
//我们可以按下面的指令规则行动：
//如果方格存在，'U' 意味着将我们的位置上移一行；
//如果方格存在，'D' 意味着将我们的位置下移一行；
//如果方格存在，'L' 意味着将我们的位置左移一列；
//如果方格存在，'R' 意味着将我们的位置右移一列；
//'!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。（注意，字母板上只存在有字母的位置。）
//返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
//示例 1：
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
//示例 2：
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
public class _1138_PathsOnTheLetterBoard {
    public static void main(String[] args) {
        String s = "zdz";
        System.out.println(Method(s));
    }
    public static String Method(String s){
        String str = "";
        String[][] map = {{"abcde"},{"fghij"},{"klmno"},{"pqrst"},{"uvwxy"},{"z"}};
        int j = 0;
        String[] temp = {"","0"};
        for (int i = 0; i < s.length(); i++) {
            for (; j < 6; j++) {
                if ( (j<5 && s.charAt(i) <= map[j][0].charAt(4) && s.charAt(i) >= map[j][0].charAt(0)) || (( j==5) && (s.charAt(i) == 'z'))){
                   //判断字母是否在当前字母序列当中，如果在就只需要进入Method，判断是否需要左移或者右移
                    //如果字母等于z，且当前序列在第五行，就直接今method，然后加“！”
                    Method2(s.charAt(i),map,j,Integer.parseInt(temp[1]),temp);
                    str+=temp[0];
                    break;
                }else if(Integer.parseInt(temp[1])!=0&&s.charAt(i) == 'z'){
                    //如果字母等于z，且当前序列不在第五行，就先进入method，进行左移右移，当纵坐标成为0时再出来，进行上下移动
                    Method2(s.charAt(i),map,j,Integer.parseInt(temp[1]),temp);
                    str+=temp[0];
                    j--;
                } else if (s.charAt(i) < map[j][0].charAt(0)) {
                    str+="U";
                    j=j-2;
                } else if (s.charAt(i) > map[j][0].charAt(4)) {
                    str+="D";
                }
            }
        }
        return str;
    }
    public static String[] Method2(char ch, String[][] map, int i,int j,String[] temp) {
        String str = "";
        int  index = j;
        if (ch == 'z' && i != 5){//z不在第五行，右移直到index等于0
            for (int k = j; k >0 ; k--) {
                str+="L";
                index--;
            }
        }else if(ch == 'z'&& i == 5){//z在第五行，直接！
            str+="!";
        }else {//其他字母的左移右移
            for (int k = j; k < map[i][0].length(); k++) {
                if (map[i][0].charAt(k) < ch) {
                    str += "R";
                    index++;
                } else if (map[i][0].charAt(k) > ch) {
                    str += "L";
                    index--;
                    k-=2;
                } else {
                    str += "!";
                    break;
                }
            }
        }
        temp[0] = str;
        temp[1] = String.valueOf(index);
        return temp;
    }
}
