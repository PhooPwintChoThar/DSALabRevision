package Lab06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution_671755 {
        public Solution_671755(){}
        public int maxLandArea(int[][] grid) {
        int max = 0;
        int row_len=grid.length;
        int col_len=grid[0].length;
        boolean[][] visited=new boolean[grid.length][grid[0].length];
    
        for(int r=0 ; r<row_len; r++){
            for(int c=0 ; c<col_len ; c++){
                if (grid[r][c]==1 && !visited[r][c]){
                    int area=calculateArea(grid, visited, r, c);
                    max=Math.max(max, area);
                }
            }
        }

        return max;
    }

    int calculateArea(int[][] grid, boolean[][] visited, int r, int c){
       
        int count=0;
        Queue<int[]> areas=new LinkedList<>();
        int[][] directions={{-1,0}, {1,0}, {0,-1}, {0,1}};
        areas.add(new int[]{r,c});
        visited[r][c]=true;
        int[] current;
        int c_r;
        int c_c;
        while (!areas.isEmpty()) {
            current=areas.remove();
            c_r = current[0];
            c_c =current[1];
            count+=1;
            int n_r, n_c;
            for(int[]d : directions){
                n_r=c_r+d[0];
                n_c=c_c+d[1];
                if(n_r>=0 && n_r<grid.length && n_c>=0 && n_c<grid[0].length && !visited[n_r][n_c] && grid[n_r][n_c]==1){
                 
                    areas.offer(new int[]{n_r, n_c});
                    visited[n_r][n_c]=true;
                }
            }
            
        }

        return count;



    }



    public static void main(String[] args) {
        int[][] grid = {
            {1, 1, 0, 0},
            {1, 0, 0, 1},
            {0, 1, 1, 1},
            {1, 1, 1, 0}
        };
        Solution_671755 s = new Solution_671755();
        int result = s.maxLandArea(grid);
        System.out.println("Largest land area: " + result);
    }
}