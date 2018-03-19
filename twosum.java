/*
Problem description:
https://leetcode.com/problems/two-sum/description/

-------------------
Complexity Analisys: 
Worst case: O(n)
Best case: O(2)

Questions:
Should I order the vector first? 
*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        //In the worst case, O(n)
        for(int i1 = 0; i1<nums.length; i1++){
            //HashMap access a direct point in memory  (so, it spends O(1) to get a value)
            if(map.get(nums[i1])!=null && (nums[i1]*2)==target){
                    result[0] = map.get(nums[i1]);
                    result[1] = i1;
                    return result;
            }
            int remaining = target - nums[i1];
            if(map.get(remaining)!=null){
                result[0] = map.get(remaining);
                result[1] = i1;
                return result;
            }
            //HashMap access a direct point in memory  (so, it spends O(1) to add a new value)
            map.put(nums[i1],i1);
        }
        return result;
    }
}