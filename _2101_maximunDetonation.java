package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

//给你一个炸弹列表。一个炸弹的 爆炸范围 定义为以炸弹为圆心的一个圆。
//炸弹用一个下标从 0 开始的二维整数数组 bombs 表示，其中 bombs[i] = [xi, yi, ri] 。xi 和 yi 表示第 i 个炸弹的 X 和 Y 坐标，ri 表示爆炸范围的 半径 。
//你需要选择引爆 一个 炸弹。当这个炸弹被引爆时，所有 在它爆炸范围内的炸弹都会被引爆，这些炸弹会进一步将它们爆炸范围内的其他炸弹引爆。
//给你数组 bombs ，请你返回在引爆 一个 炸弹的前提下，最多 能引爆的炸弹数目。
//输入：bombs = [[2,1,3],[6,1,4]]
//输出：2
//输入：bombs = [[1,1,5],[10,10,5]]
//输出：1
//输入：bombs = [[1,2,3],[2,3,1],[3,4,2],[4,5,3],[5,6,4]]
//输出：5
public class _2101_maximunDetonation {
    public static void main(String[] args) {
        int [][]bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};
        System.out.println(Method(bombs));
    }
    public static int Method(int [][] bombs){
        int n = bombs.length;
        List<Integer> [] map = new List[n];
        // 手动建图，认为 A 到 B 可达的条件是 AB 两点距离小于 A 的爆炸范围
        for (int i = 0; i < n; i++) {//先预留顶点的位置
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // 计算两点直线距离
                double len = Math.sqrt(Math.pow(bombs[i][0] - bombs[j][0], 2) + Math.pow(bombs[i][1] - bombs[j][1], 2));
                // 直线距离小于炸弹i的范围，那么i到j有边
                if(len <= bombs[i][2]){
                    map[i].add(j);
                }
                // 直线距离小于炸弹j的范围，那么j到i有边
                if (len <= bombs[j][2]){
                    map[j].add(i);
                }
            }
        }
        // 对 graph 计算最大的连通分量
        int res = 0;
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        for (int i = 0; i < n; i++) {//遍历当前炸弹，然后dfs能够引爆的所有点，也就是当前顶点能够指向的顶点
            res = Math.max(res,dfs(map,i,visited,i));//获得每个连接的的最长联通分量
        }
        return res;
    }
    public static int dfs(List<Integer> [] map,int temp,int []visited,int start){
        visited[temp] = start;//打标记，已经引爆过的标记为start的值，未引爆过的标记为-1
        int res = 1;
        for (Integer ele : map[temp]) {//ele是temp顶点所有的连接点
            if(visited[ele] != start ){//判断当前这个连接点是否被引爆过
                res+=dfs(map,ele,visited,start);
            }
        }
        return res;
    }
}
