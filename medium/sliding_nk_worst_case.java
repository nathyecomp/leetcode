class Solution {
    //[4,3,-1,2,5,3,6,7] , k=3  -> 3 3 5 5 6 7
    //worst case [7 6 5 4 3 2 1]
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums.length==0) return nums;
        int max = Integer.MIN_VALUE;
        int imax = 0;
        for(int i=0; i<k; i++){
            if(nums[i]>max){
                max = nums[i];
                imax = i;
            }
        } 
        result.add(max); 
        int auxk = k; 
        for(int i=1; i<nums.length-(k-1); i++){ 
            
            if(nums[auxk]>=max){
                max = nums[auxk];
                imax = auxk;
            }
            else if(i-1 == imax){
                max = Integer.MIN_VALUE;
                for(int c = i; c<=auxk; c++){ 
                    if(nums[c]>max){
                        max = nums[c];
                        imax = c;
                    }
                }
            }
            auxk++;
            result.add(max);
        }
        int[] maxs = new int[result.size()];
        int c=0;
        for(Integer i: result){
            maxs[c++] = i;
        }
        return maxs;
    }
}