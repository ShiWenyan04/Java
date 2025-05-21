package LeetCode;

public class _0104_ {//深度优先搜索
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftLen = 0, rightLen = 0;
        leftLen = maxDepth(root.left);
        rightLen = maxDepth(root.right);
        return Math.max(leftLen,rightLen)+1;
    }


}
// public int maxDepth(TreeNode root) {//广度优先搜索
//      if(root == null){
//         return 0;
//     }
//     Queue<TreeNode> q = new LinkedList<TreeNode>();//由于是普通树结构，没有优先级一说，所以不使用优先队列
//     q.offer(root);
//     int cnt = 0;
//     while(!q.isEmpty()){//队列不为空
//         int size = q.size();
//         while(size > 0){//当前层次的节点未遍历完
//             TreeNode n = q.poll();
//             if(n.left!= null){
//                 q.offer(n.left);
//             }
//             if(n.right != null){
//                 q.offer(n.right);
//             }
//             size--;
//         }
//         cnt++;
//     }
//     return cnt;
// }
