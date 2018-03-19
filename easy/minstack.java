/*
Problem description:
https://leetcode.com/problems/min-stack/description/

-------------------
Requirement: all functions must execute in O(1):


*/
class MinStack {
    static class ElementStack{
    int value = 0;
    int min_element_pos = 0; 
    
    ElementStack(int value, int min_element_pos){
        this.value = value;
        this.min_element_pos = min_element_pos;
    }
    }
     
    /** initialize your data structure here. */
    ElementStack[] min_stack;
   // int[] min_stack; 
    int min_element = -1;
    int min_element_pos = 0;
    int stack_size = 0;
    public MinStack() {
        min_stack = new ElementStack[10000];
    }
    
    public void push(int x) {
        ElementStack es = new ElementStack(x,min_element_pos);
        min_stack[stack_size] = es;
        if(stack_size==0 || x<=min_element){
            min_element = x;
            min_element_pos = stack_size;
        }
        stack_size++;
    }
    
    public void pop() {
        if(stack_size>0){
            ElementStack last = min_stack[stack_size-1];
            if(last.value==min_element){
                min_element_pos = last.min_element_pos;
                min_element = min_stack[min_element_pos].value;
            }
            stack_size--;
        }
    }
    
    public int top() {
        ElementStack last = min_stack[stack_size-1];
        return last.value;
    }
    
    public int getMin() {
        if(stack_size>0){
            return min_element;
        }
        else return 0;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */