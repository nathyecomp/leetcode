/*
https://leetcode.com/problems/trapping-rain-water/description/

Complexidade ficou muito alta..No pior caso, em que Water = 0, eu vou varrer todo o vetor N, e pra cada N,
meu point pode executar mais N*HeightMax.
O(N2*height).
*/
class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if(size<=1) return 0;
        int point1 = 0;
        int point2 = 1;
        int sumTotal = 0;
        int sumPartial = 0;
        int h1 = height[point1];
        while(point1<size){
            
            while(point2<size&&h1>height[point2]){
                sumPartial+=(h1-height[point2]);
                point2++;
            }
            if(point2==size && h1>height[size-1]){ 
                sumPartial = 0;
                point2 = point1 +1;
                h1 = h1-1;
            }
            else{
                point1 = point2;
                point2++;
                sumTotal+=sumPartial;
                sumPartial = 0;
                if(point1<size)
                    h1 = height[point1];
            }        
            
       }
        return sumTotal;
    }
}