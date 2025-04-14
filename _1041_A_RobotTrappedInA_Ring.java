package LeetCode;
//示例 1：
//
//输入：instructions = "GGLLGG"
//输出：true
//示例 2：
//输入：instructions = "GG"
//输出：false
//示例 3：
//输入：instructions = "GL"
//输出：true
//解释：机器人最初在(0,0)处，面向北方。
//“G”:移动一步。位置:(0,1)方向:北。
//“L”:逆时针旋转90度。位置:(0,1).方向:西。
//“G”:移动一步。位置:(- 1,1)方向:西。
//“L”:逆时针旋转90度。位置:(- 1,1)方向:南。
//“G”:移动一步。位置:(- 1,0)方向:南。
//“L”:逆时针旋转90度。位置:(- 1,0)方向:东方。
//“G”:移动一步。位置:(0,0)方向:东方。
//“L”:逆时针旋转90度。位置:(0,0)方向:北。
//重复指令，机器人进入循环:(0,0)——>(0,1)——>(- 1,1)——>(- 1,0)——>(0,0)。
//在此基础上，我们返回true。
public class _1041_A_RobotTrappedInA_Ring {
    public static void main(String[] args) {
        String instructions = "RLLGLRRRRGGRRRGLLRRR";
        System.out.println(Method(instructions));
    }
    public static boolean Method(String instructions){//属于一个周期性问题
        int []dx = {-1,0,1,0};//先规定x在遇见l的次数后，需要变化的结果
        int []dy = {0,1,0,-1};//先规定y在遇见l的次数后，需要变化的结果
        int x = 0,y = 0;
        int times = 0;
        int k = 0;
        while(k<4){
            for (int i = 0; i < instructions.length(); i++) {
                if (instructions.charAt(i) == 'G'){//直走，计算出遇见l的次数，然后得出最新的xy坐标
                    x += dx[(times) % 4];
                    y += dy[times % 4];
                }
                if (instructions.charAt(i) == 'L'){//记录l的次数
                    times=(times-1+4);
                }
                if (instructions.charAt(i) == 'R'){//与l相反
                    times=(times+1+4);
                }
            }
            if (x==0&&y==0){//回归原位
                return true;
            }
            k++;
        }
        return false;
    }
}
