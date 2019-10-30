class MoreWater {
    public int maxArea(int[] height) {
         /**
     * 解题思路：这题可以用暴力法，两次循环把所有可能找出来，然后一一比较，时间复杂度为O(n^2)
     *
     * 另外可以用双指针法，头尾一起往中间走，我们知道水桶是由短的一根决定，那我们可以比较首尾两根，将较短的一根往中间移动
     * 
     * 因为如果移动长的那根，高度不会变，长度在缩短，面积肯定是变小的，只有移动短的那根，才有可能把高度增加，让面积变大
     * 
     */
        int len=height.length;
        int max=0;
        int temp;
        for (int i = 0,j=len-1; i < j;) {
            if(height[i]<height[j]){
                temp=(j-i)*height[i++];
            }else {
                temp=(j-i)*height[j--];
            }
            max=temp>max?temp:max;
        }
        return max;
    }
}