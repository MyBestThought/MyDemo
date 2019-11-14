/**
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/
/**
对于这个题，其中的一个核心问题就在于找到当前数组的最长递减子序列，然后将其逆序。
为了满足比原序列的字典序大，需要在之前找到的最小序列中找打一个比前一个元素大并且最接近它的数字，然后进行交换即可
*/
class NextRange {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1; i >= 0; i--){
            if(i == 0){
                reverseArray(nums, 0, nums.length-1);
                return;
            }
            if(nums[i] > nums[i-1]){
                reverseArray(nums, i, nums.length-1);
                for(int j=i; j < nums.length; j++){
                    if(nums[j] > nums[i-1]){
                        swap(nums, j, i-1);
                        return;
                    }
                    
                }
            }
        }

    }
    public void reverseArray(int[] nums, int begin, int end){
        while(begin < end){
            swap(nums, begin++, end--);
        }
    }
    public void swap(int[] nums, int val1, int val2){
        int temp = nums[val1];
        nums[val1] = nums[val2];
        nums[val2] = temp;
    }
}