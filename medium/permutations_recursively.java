//REVIEW THIS QUESTIONS BECAUSE IT IS NOT GOOD!!!!!

class Solution {
    List<List<Integer>> permutations = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> result = new ArrayList<>();
        backtracking(result,nums);
        
        return permutations;
    }
    
    public boolean backtracking(List<Integer> result, int[] nums){
        
        for(int i = 0; i< nums.length; i++){
            if(!result.contains(nums[i])){
                result.add(nums[i]);
                if(result.size() == nums.length){
                    if(!permutations.contains(result)){
                        permutations.add(result);  
                        return true;
                    }
                    else{
                        int size = result.size()-1;
                        result.remove(size);
                    }
                }
                else{
                    List<Integer> resultCopy = new ArrayList<Integer>(result); // O(N)?
                    boolean callnext = backtracking(resultCopy,nums);
                    int size = result.size()-1;
                    result.remove(size);
                }
            }
        }
        return false;
    }
}