package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//符号 值
//I	1
//V	5
//X	10
//L	50
//C	100
//D	500
//M	1000
//如果该值不是以 4 或 9 开头，请选择可以从输入中减去的最大值的符号，将该符号附加到结果，减去其值，然后将其余部分转换为罗马数字。
//如果该值以 4 或 9 开头，使用 减法形式，表示从以下符号中减去一个符号，例如 4 是 5 (V) 减 1 (I): IV ，9 是 10 (X) 减 1 (I)：IX。仅使用以下减法形式：4 (IV)，9 (IX)，40 (XL)，90 (XC)，400 (CD) 和 900 (CM)。
//只有 10 的次方（I, X, C, M）最多可以连续附加 3 次以代表 10 的倍数。你不能多次附加 5 (V)，50 (L) 或 500 (D)。如果需要将符号附加4次，请使用 减法形式。
//示例 1：
//输入：num = 3749
//输出： "MMMDCCXLIX"
//解释：
//3000 = MMM 由于 1000 (M) + 1000 (M) + 1000 (M)
// 700 = DCC 由于 500 (D) + 100 (C) + 100 (C)
//  40 = XL 由于 50 (L) 减 10 (X)
//   9 = IX 由于 10 (X) 减 1 (I)
//注意：49 不是 50 (L) 减 1 (I) 因为转换是基于小数位
public class _012_IntegerToRomanNumbers {
    public static void main(String[] args) {
        int num = 3749;
        String [][]Roman = {{ "I", "V" },{ "X", "L" },{ "C", "D" },{"M"}};
        System.out.println(Method(num,Roman));
    }
    public static String Method(int num, String [][] roman){
        List<String> list = new ArrayList<>();
        int i = 0;
        String nums = String.valueOf(num);
        while(true){
            int target = num%10;
            if (target == 9){
                list.add(roman[i][0]+roman[i+1][0]);
            } else if (target == 4) {
                list.add(roman[i][0]+roman[i][1]);
            } else if (5 <= target && target < 9) {
                list.add(roman[i][1]+Method2(target-5,  roman[i][0]));
            } else  {
                list.add(Method2(target, roman[i][0]));
            }
            if (i==nums.length()-1){
                break;
            }
            num = num/10;
            i++;
        }
        Collections.reverse(list);
        String s =  String.join("", list);
        return s;
    }
    public static String Method2(int times, String str){
        StringBuilder strs = new StringBuilder();
        for (int j = 0; j < times; j++) {
            strs.append(str);
        }
        return strs.toString();
    }

}
