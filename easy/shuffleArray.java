//IMPROVE!!
//O(N2) because list.remove() is N. 
//If i use two pointers in shuffle, the complexity will be O(N)
class Solution {
    int[] copy;
    int[] original;
    public Solution(int[] nums) {
        copy = new int[nums.length];
        original = nums;
        for(int i = 0; i< nums.length; i++){
            copy[i] = nums[i];
        }
     }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = new ArrayList<>();
        int[] answer = new int[copy.length];
        for(int i = 0; i<copy.length; i++){
            aux.add(copy[i]);
        }
        for(int i = copy.length-1; i>=0; i--){
            int sorted = (int)(Math.random()*i);
            answer[i]=aux.remove(sorted);
        }
        return answer;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */