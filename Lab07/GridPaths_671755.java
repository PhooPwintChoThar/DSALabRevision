package Lab07;

import java.util.Stack;

public class GridPaths_671755 {

    public int numberOfPaths(int[][] grid){
        int c_r=0;
        int c_c=0;
        int no_of_path=0;
        int[] c;
        Stack<int[]> possible_steps= new Stack<>();
        possible_steps.add(new int[] {c_r , c_c});
        int[][] movements={{1,0}, {0,1}};

        while (!possible_steps.isEmpty()) {
                c=possible_steps.pop();
                c_r=c[0];
                c_c=c[1];
                int n_r, n_c;
                for(var mov :movements){
                    n_r=c_r+mov[0];
                    n_c=c_c+mov[1];
                    if(n_r==grid.length-1 && n_c==grid[0].length-1){
                        no_of_path+=1;
                        continue;
                    }
                    if(n_r>=0 && n_r<grid.length && n_c>=0 && n_c<grid[0].length && grid[n_r][n_c]==0){
                        possible_steps.add(new int[] {n_r, n_c});
                    }
                }
            
        }

        return no_of_path;
    }
    
}
