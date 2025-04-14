package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//编写一个算法来判断一个数 n 是不是快乐数。
//「快乐数」 定义为：
//对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
//然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
//如果这个过程 结果为 1，那么这个数就是快乐数。
//如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
//示例 1：
//输入：n = 19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//示例 2：
//输入：n = 2
//输出：false
public class _0202_HappyNumber {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(Method1(n));
    }
    public static boolean Method1(int n){
        String s = String.valueOf(n);
        List<Integer> list = new ArrayList<>();
        List<Boolean> judge = new ArrayList<>();//判断是否是快乐数
        HashSet<String> hashSet = new HashSet<>();
        Method2(list,judge,s,0,hashSet);
        return judge.get(0);
    }
    public static void Method2(List<Integer> list, List<Boolean> judge,String s,int pres,HashSet<String> hashSet){
        if (list.size()==1 && list.get(0) == 1){//平方和为1
            judge.add(true);
            return;
        }
        if (list.size()==1 && list.get(0) <= 3 && list.get(0) > 1){//平方和为个数且凑不成1
            judge.add(false) ;
            return;
        }
        for (int i = 0; i < list.size(); i++) {//计算平方
            if (list.get(i)*list.get(i) != 0){
                pres += list.get(i) * list.get(i);
            }
        }
        if (pres != 0){
            s = String.valueOf(pres);
            pres = 0;
        }

        if (!hashSet.contains(s)){//判断是否陷入同一个数的平方和循环
            hashSet.add(s);
        }else {
            judge.add(false);
            return;
        }
        list.removeAll(list);//将list清空，装入新的数字
        for (int i = 0; i < s.length(); i++){//list存入新的平方和
            list.add(Integer.valueOf(s.substring(i,i+1)));
        }
        Method2(list,judge,s,pres,hashSet);//进入递归，下一次判断
    }
}
