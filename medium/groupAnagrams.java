/*
https://leetcode.com/problems/group-anagrams/description/

Complexity: 
Arrays.sort() -> depends on Java Version. Last version uses Mergesort (NLogN). 
So.. N * SizeWord*log(SizeWord)
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> answer = new ArrayList<>();
        //String key = num_chars +""+hash;
        for(int i = 0; i< strs.length; i++){ 
            String key = getKey(strs[i]);
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }
           else{
                List<String> an = new ArrayList<>();
                an.add(strs[i]);
                map.put(key,an);
            }
        }
        for(String key: map.keySet()){
            answer.add(map.get(key));
        }
        return answer;
}

    public String getKey(String str){
        if(str.length()<=1) return str; 
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        String key = String.valueOf(ch);
        return key;
    }

}