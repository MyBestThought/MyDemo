class FourNumSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0 || nums.length < 4){
            return list;
        }
        //-2 -1 0 0 1 2
        Arrays.sort(nums);
        for(int i=0; i < nums.length-1; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for(int j=i+1; j < nums.length-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int l = j+1; int r = nums.length-1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        while(l < r && nums[l] == nums[l+1]){
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]){
                            r--;
                        }
                        list.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                }
            }
        }
        return list;
    }

}