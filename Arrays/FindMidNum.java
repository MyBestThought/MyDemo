class FindMidNum {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums1){
            list.add(i);
        }
        for(int i : nums2){
            list.add(i);
        }
        Collections.sort(list);
        int len = list.size();
        double result = 0;
        if(len % 2 == 0){
            result = (double)(list.get(len/2-1) + list.get(len/2))/2;
        }else{
            result = list.get(len/2);
        }
        return result;
    }
}