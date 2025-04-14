package LeetCode;

import java.util.Scanner;

public class TheWaterBottle_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String element = in.next();//输入高度

//        切割字符串
        String[] temp = element.split("[,\\[\\]]");
//
//        去除空字符
        String[]temp1 = new String[temp.length-1];
        for (int i = 0; i < temp.length-1; i++) {
         temp1[i] = temp[i+1];
        }

//        转化为int型
        int []height = new int[temp1.length];
        for (int i = 0; i < temp.length-1; i++) {
            height[i] = Integer.parseInt(temp1[i]);
        }
//
//     计算
     int left = 0, right = temp1.length - 1, derta = 0,  result = 0,resultMax = 0;
        while (left < right) {
             derta = right - left;//宽
             result = derta * Math.min(height[left],height[right]);//宽*高
             resultMax = Math.max(result,resultMax);
             if(Math.min(height[left],height[right]) == height[left]){
             left++;
             } else {
                 right--;
             }
        }
        System.out.println(resultMax);
    }
}
