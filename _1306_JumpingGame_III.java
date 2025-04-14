package LeetCode;
//这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
//请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。注意，不管是什么情况下，你都无法跳到数组之外。
//示例 1：
//输入：arr = [4,2,3,0,3,1,2], start = 5
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 5 -> 下标 4 -> 下标 1 -> 下标 3
//下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
//示例 2：
//输入：arr = [4,2,3,0,3,1,2], start = 0
//输出：true
//解释：
//到达值为 0 的下标 3 有以下可能方案：
//下标 0 -> 下标 4 -> 下标 1 -> 下标 3
//示例 3：
//输入：arr = [3,0,2,1,2], start = 2
//输出：false
//解释：无法到达值为 0 的下标 1 处。
public class _1306_JumpingGame_III {
    public static void main(String[] args) {
        int []arr = {4,2,3,0,3,1,2};
        int start = 5;
        boolean [] visited = new boolean[arr.length];
        System.out.println(Method(arr,start,visited));
    }
    public static boolean Method(int []arr,int start,boolean [] visited){
        if(start > arr.length-1 || start < 0){//起始位置超过数组最大索引
            return false;
        }
        if (arr[start] == 0){//当前位置为0
            return true;
        }
        if (visited[start]){//如果当前位置访问过，就直接打断，即visited[start]=true
            return false;
        }else visited[start] = true;//没访问过就归为访问过
        return Method(arr,arr[start]+start,visited) || Method(arr,start-arr[start],visited);
//        以上都不满足，就进入递归，分别为 i + arr[i]和 i - arr[i] 到达的位置，将这个位置设为start，然后判断是否为0
    }
}
