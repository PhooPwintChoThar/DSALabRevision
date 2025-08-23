package DynamicProgramming;
//Given an m x n grid, count the number of unique paths from the top-left to the bottom-right corner, moving only down or right.
public class UniquePaths {

    public  static void main(String[] args){
        //int[][] grids={{-1,-1,-1},{-1,-1,-1}, {-1,-1,-1}};
        //int[][] grids={{-1,-1},{-1,-1}, {-1,-1}};
        int[][] grids={{-1,-1,-1},{-1,-1,-1}, {-1,-1,-1},{-1,-1,-1}};
        int paths=findPaths_Memoization(0, 0, grids);
        System.out.println(paths);

        paths=findPaths_Tabulation(4, 3);
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

    static int  findPaths_Tabulation(int er, int ec){
        int[][] grid= new int[er][ec];
        grid[er-1][ec-1]=1;

        for(int r=er-1; r>=0 ; r--){
            for(int c=ec-1; c>=0; c--){
                if(r==er-1 && c==ec-1){
                    continue;
                }
                int right_paths= c+1<ec ? grid[r][c+1] : 0;
                int bottom_paths= r+1<er ? grid[r+1][c] : 0;
                grid[r][c]=right_paths+bottom_paths;
            }
        }

        return grid[0][0];
        

    }
    
}
