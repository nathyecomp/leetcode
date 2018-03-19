/*
Problem description:
https://leetcode.com/problems/valid-parentheses/description/

-------------------

best case O(1) -> impar string
worst and medium cases O(n)
*/

class Solution {
    char[] stack;
    public boolean isValid(String s) {
        int s_length = s.length();
        char[] s_char = s.toCharArray();
        if(s_length%2!=0){
            return false;
        }
        if(s_length==0) return true;
        stack = new char[s_length];
        stack[0] = s_char[0];
        int top_stack = 1;
        for(int i= 1; i<s_length; i++){
            if(top_stack>0 && compare(stack[top_stack-1],s_char[i])){
                    top_stack--;
            }
            else{
                stack[top_stack] = s_char[i];
                top_stack++;
            }  
        }
        
        if(top_stack>0) return false;
        return true;
        
    }
    
    public boolean compare(char open, char close){
        if(open=='{' && close=='}')
            return true;
        if(open=='(' && close==')')
            return true;
        if(open=='[' && close==']')
            return true;
        
        return false;
    }
}