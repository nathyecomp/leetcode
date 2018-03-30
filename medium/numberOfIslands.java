class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int numLines = grid.length;
        int numCol = grid[0].length;
        
        int result = 0;
        for(int l=0; l<numLines; l++){
            for(int c = 0; c<numCol; c++){
                if(grid[l][c]=='1'){
                    result++;
                    visit(l,c,grid);
                }
            }
        }
        return result;
    }
    
    public void visit(int line, int col, char[][] grid){
        if(line==grid.length||line<0||col==grid[0].length||col<0||grid[line][col]=='0') return;
        grid[line][col] = '0';
        visit(line,col+1,grid);
        visit(line+1,col,grid);
        visit(line,col-1,grid);
        visit(line-1,col,grid);
        return;
    }
}