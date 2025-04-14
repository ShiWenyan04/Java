package LeetCode;
//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
//
//找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
//返回容器可以储存的最大水量。

//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。


import java.util.Scanner;

public class TheWaterBottle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入有几个元素");
        int n = in.nextInt();
//        int []result = new int[ (3*n+n*n)/2 ];
//        int [][]a=new int[n][n];
        int []element = new int[n];
        int derta, result1= 0,resultMax=0;
//        输入元素
        System.out.println("请输入元素");
        for (int i = 0; i <n ; i++) {
            element[i] = in.nextInt();
        }
//        进行计算
        for (int i = 0; i < n; ++i) {
            for (int j = i+1; j < n ; ++j) {
                derta = j - i;
                result1 = derta * Math.min(element[i],element[j]);
                if (result1>resultMax){
                    resultMax=result1;
                }
            }
        }
//        进行比较，得出结论
//        for (int i = 0; i < result.length; i++) {
//            result1  = Math.max(result[i],result[i+1]);
//        }
        System.out.println("最大容器体积为：" +  resultMax);
    }

}
