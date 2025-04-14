package LeetCode;

//编写一个函数来查找字符串数组中的最长公共前缀。
//如果不存在公共前缀，返回空字符串 ""。
//
//示例 1：
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//示例 2：
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
public class TheLongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs0 = {"flower", "flow", "flight"};
        String[] strs1 = {"reflower","flow","flight"};
        String [] strs2 = {"a"};
        String [] strs3 = {"",""};
        System.out.println(longestCommonPrefix(strs0));
        System.out.println(longestCommonPrefix(strs1));
        System.out.println(longestCommonPrefix(strs2));
        System.out.println(longestCommonPrefix(strs3));
    }

    public static String longestCommonPrefix(String[] strs) {
        int[] id = new int[strs.length];
//        字符串长度存放在id数组
        for (int i = 0; i < strs.length; i++) {
            id[i] = strs[i].length();
        }
//        遍历数组，得出最短字符长度及索引
        int minLength = id[0], min_Id = 0;
        for (int i = 1; i < id.length; i++) {
            if (minLength >= id[i]) {
                minLength = id[i];
                min_Id = i;
            }
        }
//        切割
        String theShortest = strs[min_Id];
        String theLongest = "";
        String []strs2 = new String[strs.length];
        if(strs.length != 1){
            if (theShortest.equals("")){
                theLongest = "";
            }else {
                for (int i = 0; i < strs.length; i++) {
                    if (theShortest.substring(0, 1).equals(strs[i].substring(0, 1))) {
                        for (int j = 1; j < theShortest.length() + 1; j++) {
                            if (theShortest.substring(0, j).equals(strs[i].substring(0, j))) {
                                strs2[i] = theShortest.substring(0, j);
                            }
                        }
                    } else {
                        strs2[i] = "";
                    }
                }
//        把前缀长度存入数组
                int[] index = new int[strs2.length];
                for (int i = 0; i < strs2.length; i++) {
                    index[i] = strs2[i].length();
                }
//        得出最长前缀的序号
                int min = index[0], min_Index = 0;
                for (int i = 1; i < index.length; i++) {
                    if (min >= index[i]) {
                        min = index[i];
                        min_Index = i;
                    }
                }
//                得出最长前缀
                if (strs2[min_Index].equals("")) {
                } else {
                    theLongest = strs2[min_Index];
                }
            }
        }else {
            theLongest = strs[0];
        }
        return theLongest;
    }
}