package DynamicProgramming;
//Given an m x n grid, count the number of unique paths from the top-left to the bottom-right corner, moving only down or right.
public class UniquePaths {

    public  static void main(String[] args){
        //int[][] grids={{-1,-1,-1},{-1,-1,-1}, {-1,-1,-1}};
        //int[][] grids={{-1,-1},{-1,-1}, {-1,-1}};
        int[][] grids={{-1,-1,-1},{-1,-1,-1}, {-1,-1,-1},{-1,-1,-1}};
        int paths=findPaths_Memoization(0, 0, grids);
        System.out.println(paths);

    }

   static int  findPaths_Memoization(int r, int c, int[][] grid){
        if(r==grid.length-1 && c==grid[0].length-1){
            return 1;
        }

        if(r>=grid.length || c>=grid[0].length){
            return  0;
        }

        if(grid[r][c]!=-1){
            return grid[r][c];
        }

        grid[r][c]=findPaths_Memoization(r+1, c, grid) + findPaths_Memoization(r, c+1, grid);
        return grid[r][c];


    }
    
}
