package LeetCode;

import java.util.*;

public class _0140_WordSplitting_II {
    public static void main(String [] arg){
        String s = "catsanddog";
        String []wordDict = {"cat", "cats", "and", "sand", "dog"};
        List<String> list = new ArrayList<>(Arrays.asList(wordDict));

//        以上为准备工作
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>(list);//将list存入字典，方便查找
        dfs(s,0,ans,new LinkedList<>(),set);
        System.out.println(ans);
    }

    public static void dfs(String s, int index,List<String> ans, Deque<String> path,HashSet<String> set){
        if (index == s.length()){//当index=字符串长度时，说明已经判断到了字符串的末尾，所有可以判断的单词已经存入栈中
            ans.add(String.join(" ",path));//单词之间留有空格，存入ans（list）中
            return ;
        }
        for (int i = index; i < s.length(); i++) {//从index开始
            String str = s.substring(index,i+1);//每次增加一个字母，然后判断形成的字符串是否在字典中存在
            if(set.contains(str)){
                path.add(str);//如果存在，只需将该单词存入栈中
                dfs(s,i+1,ans,path,set);//index更新为已经预留 单词 的下一个字母
                path.removeLast();//清空此次所获得的单词，然后再增加一个字母，进行判断，直到到达字符串末尾
            }
        }
    }
}

