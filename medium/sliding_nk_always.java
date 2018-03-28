class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            if((i+k-1)>=(nums.length)) break;
            int max = nums[i];
            for(int i2=i+1; i2<=(i+k-1); i2++){
                if(nums[i2]>max){
                    max = nums[i2];
                }
            }
            result.add(max);
        }
        int[] maxs = new int[result.size()];
        for(int i = 0; i< result.size(); i++){
            maxs[i] = result.get(i);
        }
        
        return maxs;
    }
}