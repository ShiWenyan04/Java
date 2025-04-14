package LeetCode;
//示例 1：
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//带下划线线的字符是所读的内容，插入符号是当前读入位置。
//示例 2：
//输入：s = " -042"
//输出：-42
//示例 3：
//输入：s = "1337c0d3"
//输出：1337
//示例 4：
//输入：s = "0-1"
//输出：0
//示例 5：
//输入：s = "words and 987"
//输出：0
public class _08_StringsToIntegers {
    public static void main(String[] args) {
        String s = "-91283472332";
        char [] ch = s.toCharArray();
        int index = 0;
        boolean judge =false;
        StringBuilder sb = new StringBuilder();
        if (s.length() == 1 && Character.isDigit(ch[index])){
            System.out.println(s);
        }
        while(index < s.length() &&  (ch[index] == ' ')) {//去除前导空格
            index++;
        }
        if (index==s.length()){//去除前导空格后到了末尾
            System.out.println(0);;
        }
        if (ch[index] == '-' || ch[index] == '+'){//开头有符号且为“-”"+"
            sb.append(ch[index]);
            index++;
            if (s.length() == 1 || !Character.isDigit(ch[index])){//如果字符串为1且还是符号，或者下一个字符仍为字符
                System.out.println(0);;
            }
        }else if (!Character.isDigit(ch[index]) && ch[index] != '-' && ch[index] != '+'){//开头为其他符号
            System.out.println(0);
        }
        while(index < s.length() && ch[index] == '0'){//去除前端无效0
            index++;
        }
        while (index < s.length() && Character.isDigit(ch[index])){//记录数字
            sb.append(ch[index]);
            index++;
            judge = true;//为正常可记录数字形式
            if (Long.parseLong(sb.toString()) >= Integer.MAX_VALUE){//数字值大于int界限
                System.out.println(Integer.MAX_VALUE);
            }
            if (Long.parseLong(sb.toString()) <= Integer.MIN_VALUE){//数字值小于int界限
                System.out.println(Integer.MAX_VALUE);
            }
        }
        if (!judge){//为不正常可记录数字形式
            System.out.println(0);
        }else System.out.println(Integer.valueOf(sb.toString()));//为正常可记录数字形式
    }
}

