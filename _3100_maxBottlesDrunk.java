package LeetCode;

public class _3100_maxBottlesDrunk {
    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        System.out.println(Method(numBottles,numExchange));
    }
    public static int Method(int nb,int ne){
         int empty = nb;
         int sum = nb;
         while(ne <= empty){
             empty-=ne;
             sum ++;
             empty++;
             ne++;
         }
         return sum;
    }
}
