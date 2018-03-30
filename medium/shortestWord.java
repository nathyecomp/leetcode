//IMPROVE IT! YOU CAN USE A INT[] INSTEAD OF A HASHMAP...AS EACH LETTER IS AN INTEGER..
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Integer,Integer> map = createDictionary(licensePlate);
        int minLength = Integer.MAX_VALUE;
        char[] answer = {};
        for(int i=0; i< words.length; i++){
            char[] word = words[i].toCharArray();
            int currentSize = word.length; 
            if(currentSize<minLength|| (i==0 && currentSize==minLength)){
                if(compareWord((HashMap<Integer,Integer>)map.clone(),word)){ 
                    minLength = currentSize;
                    answer =  word;
                }
            }
        }
        return String.valueOf(answer);
    }
    public HashMap<Integer,Integer> createDictionary(String licensePlate){
        HashMap<Integer,Integer> map = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();
        char[] lp = licensePlate.toCharArray();
        for(int i =0; i<lp.length; i++){
            int v = Integer.valueOf(lp[i]);
            if((v>=65 && v<=90)||(v>=97&&v<=122)){
                if(map.containsKey(v)){
                    int n = map.get(v)+1;
                    map.put(v,n);
                }
                else map.put(v,1);
            }
        }
        return map;
    }

    public boolean compareWord(HashMap<Integer,Integer> map, char[] word){
        for(int i = 0; i< word.length; i++){
            int v = Integer.valueOf(word[i]);
            if(map.containsKey(v)){
                if(map.get(v)>1){
                    int n = map.get(v)-1;
                    map.put(v,n);   
                }
                else {
                    map.remove(v);
                    if(map.size()==0){
                        return true;
                    }
                }   
            }
        }
        return false;
    }

}