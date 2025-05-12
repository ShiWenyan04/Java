package LanQiao;

import java.util.HashSet;
import java.util.Scanner;
/*合根植物
题目描述
星球的一个种植园，被分成 m×n 个小格子（东西方向m 行，南北方向 n 列）。每个格子里种了一株合根植物。
这种植物有个特点，它的根可能会沿着南北或东西方向伸展，从而与另一个格子的植物合成为一体。
如果我们告诉你哪些小格子间出现了连根现象，你能说出这个园中一共有多少株合根植物吗？*/
public class _110_RhizomatousPlants {
	static int m,n;
	static int []root;
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		m = scanner.nextInt();
		n = scanner.nextInt();
		root = new int [n*m+1];
		for(int i = 0; i < root.length; i ++) {//默认每个节点的根节点都是自己
			root[i] = i;
		}
		int k = scanner.nextInt();
		while(k-- > 0) {//组数
			int a = scanner.nextInt(); 
			int b = scanner.nextInt(); 
			merge(a, b);//构建a和b的关系
		}
		HashSet< Integer> set = new HashSet<Integer>();//哈希存root根节点，有几个根节点就有几棵树
		for(int i = 1; i < root.length;i++) {
			set.add(finds(root[i], root));//查找当前的节点的根节点并存入
		}
		System.out.println(set.size());
		
	}
	
	public static int finds(int x,int[] root) {//寻找x的根节点
		if(x != root[x]) {//如果根节点不是自己，那就继续找
			root[x] = finds(root[x], root);
		}
		return root[x];
	}
	public static void merge(int a,int b) {
		int roota = finds(a, root);//找到a和b的根节点，将a并到b上
		int rootb = finds(b, root);
		root[roota] = rootb;//a的根节点是b，此时两棵树变为一棵树
	}
}
