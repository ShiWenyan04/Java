package ICPC_GuiZhou;

import java.util.Scanner;
/*
在西江千户苗寨中，分布着26座被云雾环绕的神秘村落,分别以a, b... z命名,
它们坐落到一条直线上。村民们依靠魔法飞毯穿梭山间，每1秒便能跨越100米的距离。
然而，随着往来需求激增，苗疆大巫师在苗寨的入口与出口(两地相隔1000千米)之间架设了神秘的传送法阵一只要踏入法阵，
无论背负多少行囊，都能在1秒内瞬间抵达另一端!
快递员阿杨，这位穿梭在村落间的"飞梭使者“，每日负传递重要文书与特产的使命。
飫,村落的派单系统突然失灵,他不得不按顺序逐个派送，只有完成当前订单，能知晓下一站目的地。
现在,阿杨将从入口出发,携带着所有包裹,你能否帮他计算出完成全部派送的最短时间?
输入格式:
第一行包含-个整数T(1≤T≤10000),表示测试场景的数量。每个测试场景包含: 第一行为26个整数,按
a, b, ..的顺序依次表示各村落距离入口的距离x (单位:千米)， 确保所有苗寨位置互不相同，
且1 < x≤1000;第二行为一串由小写字母组成的字符串s(1≤|s|≤1000),代表快递派送顺序。
输出格式:
输出T行，每行一个整数,示在该场景下完成所有快递派送所需的最短时间(单位:秒)。
 */
public class M {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t-->0){
//            花费最少时间
            long ans = 0;
//            输入26个村的位置
            int [] pos = new int[27];
            pos[0] = 0;
            for (int i = 1; i < 27; i++) {
                pos[i] = scanner.nextInt();
            }
//            送快递的顺序，由于外卖员是从入口开始的，所以将ch第一个位置存放一个0，表示在入口
            String s = "0" + scanner.next();
            char [] ch =s.toCharArray();


            for (int i = 0; i < ch.length-1; i++) {
//                当前位置和下一个要送的位置
                int cur,next ;
                if(i == 0)
                {
                    cur = pos[ch[i] - '0'];
                }else{
                    cur = pos[ch[i] - 'a'+1];
                }
                next = pos[ch[i+1] - 'a'+1];


//            如果用飞毯
                int time1 = Math.abs(cur - next)*10;
//               如果使用传送门
                //当前的位置在入口或者出口
                int time2;
                if(cur == 0){
                    time2 = 1+Math.abs(next-1000)*10;
                }else if (cur == 1000){
                    time2 = 1+Math.abs(next-0)*10;
                }else {
                //当前位置在出口和入口之间
                    time2 = Math.min(Math.abs(cur -0)*10+1+Math.abs(next -1000)*10,Math.abs(cur -1000)*10+1+Math.abs(next -0)*10);
                }
                ans += Math.min(time1, time2);
            }
            System.out.println(ans);
        }
    }

}
