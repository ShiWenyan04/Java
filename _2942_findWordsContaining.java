package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class _2942_findWordsContaining {
    public static void main(String[] args) {
        String [] words = {"leet","code"};
        char x = 'e';
        System.out.println(findWords(words,x));
    }
    public static List<Integer> findWords(String[] words, char x) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < words.length;i++) {
            if(words[i].contains(String.valueOf(x))){
                list.add(i);
            }
        }
        return list;
    }
}
