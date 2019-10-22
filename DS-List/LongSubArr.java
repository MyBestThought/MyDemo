import java.util.*;
/**
*	题目描述：
* 	先给出可整合数组的定义：
*	如果一个数组在排序之后，每相邻两个数的差的绝对值都为1，或者该数组长度为1，则该数组为可整合数组。
*	例如，[5, 3, 4, 6, 2]排序后为[2, 3, 4, 5, 6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组
*	给定一个数组arr, 请返回其中最大可整合子数组的长度。
*	例如，[5, 5, 3, 2, 6, 4, 3]的最大可整合子数组为[5, 3, 2, 6, 4]，所以请返回5 
*
*
*/
public class LongSubArr{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }
        Arrays.sort(nums);
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 0;
        for(int i=1; i < n; i++){
            if(nums[i] - nums[i-1] == 1){
                dp[i] = dp[i-1] + 1;
            }else if(nums[i] == nums[i-1]){
                dp[i] = dp[i-1];
            }else{
                dp[i] = 1;
            }
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}