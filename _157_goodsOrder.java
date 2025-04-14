package LeetCode;

import java.util.*;

public class _157_goodsOrder {
    public static void main(String[] args) {
        String goods = "agew";
        List <String> list = new ArrayList<>();
        HashSet<String> hashSet = new HashSet<>();
        HashSet<Integer> index = new HashSet<>();
        Method(list,hashSet,goods,"",index);
        String []ans = new String[list.size()];
        int i = 0;
        for (String string : list) {
            ans[i] = string;
            i++;
        }
        System.out.println(Arrays.toString(ans));
    }
    public static void Method(List<String > list,HashSet<String > hashSet,String goods,String str,HashSet<Integer> index){
        if(str.length() == goods.length() && !hashSet.contains(str)){
            list.add(str);
            hashSet.add(str);
            return;
        }else if(hashSet.contains(str)){
            return;
        }
        StringBuilder strBuilder = new StringBuilder(str);
        for (int j = 0; j < goods.length(); j++) {
            if(!index.contains(j)){
                strBuilder.append(goods.charAt(j));
                str = strBuilder.toString();
                index.add(j);
                Method(list,hashSet,goods,str,index);
                index.remove(j);
                strBuilder.deleteCharAt(str.length()-1);
                str = strBuilder.toString();
            }
        }
    }
}
