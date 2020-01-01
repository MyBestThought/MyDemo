/**
返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。

如果没有和至少为 K 的非空子数组，返回 -1 。

 

示例 1：

输入：A = [1], K = 1
输出：1

示例 2：

输入：A = [1,2], K = 4
输出：-1

示例 3：

输入：A = [2,-1,2], K = 3
输出：3

 

提示：

    1 <= A.length <= 50000
    -10 ^ 5 <= A[i] <= 10 ^ 5
    1 <= K <= 10 ^ 9


*/
class SubArrayLength {
    public int shortestSubarray(int[] A, int K) {
        int minResult = Integer.MAX_VALUE;
        int sum = 0, left = 0;
        for(int right=0; right < A.length; right++){
            if(A[right] >= K){
                return 1;
            }
            sum += A[right];
            if(sum < 1){
                sum = 0;
                left = right + 1;
                continue;
            }
            for(int j = right-1; A[j+1] < 0; --j){
                A[j] += A[j+1];
                A[j+1] = 0;
            }
            if(sum >= K){
                while(sum - A[left] >= K || A[left] <= 0 ){
                    sum -= A[left++];
                }
                minResult = Math.min(minResult, right-left + 1);
            }
        }
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}