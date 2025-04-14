package LeetCode;

import ShiYan6_2.Method;

import java.util.ArrayList;
import java.util.List;

//列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
//从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
//重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
//不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
//给你整数 n ，返回 arr 最后剩下的数字。
//示例 1：
//输入：n = 9
//输出：6
//解释：
//arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
//arr = [2, 4, 6, 8]
//arr = [2, 6]
//arr = [6]
public class _0390_EliminateGame {
    public static void main(String[] args) {
        int n = 9;

        System.out.println(Method1(n));
    }
    public static int Method1(int n){
        int a1 = 1;//首项
        int d = 1;//公差
        int len = n ;//数列长度
        int k = 1;//按次数记录删除，第一次从左到右，第二次从右到左，以此类推
        while(len>1){
            if (k % 2 != 0){//按次数算，如果是第奇次删除数据，则从左往右开始，首项一定会变为当前数列第二个
            a1 = a1 + d;
            }else {//按次数算，如果是第偶次删除数据，则从右往左开始
                if (len%2!=0){//从左往右，如果长度为偶数，那么首项就不会改变，为奇数，首项变为当前数列的第二个
                    a1 = a1+d;
                }
            }
            k++;
            len /= 2;//每一次删除数字，得到的新数列，长度都会减半
            d *= 2;///每一次删除数字，得到新数列的公差是上一次的二倍
        }
        return a1;
    }
}
