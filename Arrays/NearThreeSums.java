/**
*   双指针的思想
*/
class NearThreeSums {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = nums[0] + nums[1] + nums[2];
        for(int i=0; i < nums.length; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){
                int val = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-val) < Math.abs(target-sum)){
                    sum = val;
                }
                if(val > target){
                    right--;
                }else if(val < target){
                    left++;
                }else{
                    return sum;
                }
            }
        }
        return sum;
    }
}