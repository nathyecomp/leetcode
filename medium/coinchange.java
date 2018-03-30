/*
need to improve it! (Solution based on another solution..=/)
*/
class Solution {
    int[][] dps;
    HashMap<Integer,Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        return dp(amount, coins);
    }   
    
    public int dp(int amount, int[] coins){
        if(amount==0) return 0;
        if(map.containsKey(amount)) return map.get(amount);
        int min = amount+1;
        for(int coin: coins){
          int next = -1;
          if(amount>=coin){
               int remaining = amount-coin;
               if(map.containsKey(remaining)) next = 1+map.get(remaining);
               else{
		        next = 1+dp(amount-coin, coins);
               }
               if(next>0) min = Math.min(min,next);
           } 
        }
        if(min==amount+1) min = -1;
        map.put(amount,min);
        return min;
    } 

}