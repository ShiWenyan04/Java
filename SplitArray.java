package LeetCode;
//给定一个非负整数数组，你需要将这个数组分成2个非空的连续子数组。
//设计一个算法使得这2个子数组各自和的最大值最小。
//示例 1：
//输入：nums = [7,2,5,10,8], k = 2
//输出：18

//示例 2：
//输入：nums = [1,2,3,4,5], k = 2
//输出：9

//示例 3：
//输入：nums = [1,4,4], k = 3
//输出：4
//public class SplitArray {
//    public static void main(String[] args) {
//    int []nums= {7,2,5,10,8};
//    int k = 2;
//        System.out.println(splitArray(nums,k));
//    }
//    public static  int splitArray(int[] nums, int k) {
//        int count = nums.length - 1;
//        int []maxStr = new int[10];
//        }


//        int number = count/2;
//            //        he
//            int sumRight = 0;
//            int sumLeft = 0;
//            for (int i = 0; i < number; i++) {
//                sumRight = sumRight + nums[i];
//                sumLeft = sumLeft + nums[i+number];
//            }
////        最大值
//            int max = 0;
//            int maxRl =0;
//            if(sumLeft > sumRight){
//                maxRl = sumLeft;
//                number = number--;
//            }else {
//                maxRl = sumRight;
//                number = number++;
//            }
//            max = Math.max(max,maxRl);

//    }
//
//
//}
