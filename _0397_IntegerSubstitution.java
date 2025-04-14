package LeetCode;

import java.util.ArrayList;
import java.util.List;

//给定一个正整数 n ，你可以做如下操作：
//如果 n 是偶数，则用 n / 2替换 n 。
//如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
//返回 n 变为 1 所需的 最小替换次数 。
//示例 1：
//输入：n = 8
//输出：3
//解释：8 -> 4 -> 2 -> 1
//示例 2：
//输入：n = 7
//输出：4
//解释：7 -> 8 -> 4 -> 2 -> 1
//或 7 -> 6 -> 3 -> 2 -> 1
public class _0397_IntegerSubstitution {
    public static void main(String[] args) {
        int n = 2147483647;
        System.out.println(Method(n));
    }
    public static int Method(int n){//运用深度优先搜索，递归将当前值判断之后，进行处理，然后进行下一次递归
        if (n == 1 ){
            return 0;
        }
        if(n%2 ==0){
            return 1 + Method(n/2) ;//一直递归求解
        }
        return 2 + Math.min(Method(n/2),Method(n/2+1));//返回这两者递归结果的最小值加2（因为从n变到n/2或n/2+1需要加2步）
    }
}
