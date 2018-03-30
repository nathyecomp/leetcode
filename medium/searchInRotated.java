/*
Complexity: 
Worst case: 
 5 6 7 8 9 10 1 2 3 4 -> 4
 
*/
class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        return findTarget(0, nums.length-1, target, nums);

    }
    int findTarget(int begin, int end, int target, int[] v){
        if(begin>end){
                return -1; 
        }  
        int half = begin+(end-begin)/2;
        if(v[half] == target) return half;

        if(v[begin]>target && v[end]>v[begin]){
              return -1;
        }
        if(v[begin]>target && v[end]<target){
              return -1;
        }
            
        int left = findTarget(begin,half-1,target,v);
        if(left!=-1){
              return left;
        }
        int right = findTarget(half+1,end,target,v);
        return right;
    }

}