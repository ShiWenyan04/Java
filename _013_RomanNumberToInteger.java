package LeetCode;
import java.util.HashMap;
//罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//示例 5:
//输入: s = "MCMXCIV"
//输出: 1994
//解释: M = 1000, CM = 900, XC = 90, IV = 4.
public class _013_RomanNumberToInteger {
    public static void main(String[] args) {
        String s = "III";
        HashMap<Character,Integer> hashMap = new HashMap<>();//使用哈希表存入
        hashMap.put('I',1);
        hashMap.put('V',5);
        hashMap.put('X',10);
        hashMap.put('L',50);
        hashMap.put('C',100);
        hashMap.put('D',500);
        hashMap.put('M',1000);
        int result = 0;
        int preNum = hashMap.get(s.charAt(0));//给一个预备值，使其等于首项罗马值
        for (int i = 1; i < s.length(); i++) {
            int num = hashMap.get(s.charAt(i));
            if (preNum < num){//预备值小于正在遍历的值
                result -= preNum;//做减法
            }else if (preNum >= num){//预备值大于正在遍历的值
                result += preNum;//做加法
            }
            preNum = num;//使正在遍历的值赋给预备值
        }
        result += preNum;//最后结果要加上最后的一个遍历的值
        System.out.println(result);
    }
}
