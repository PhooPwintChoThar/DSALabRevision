package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class midterm_bfs {

    public static void main(String[] args) {
        // Test case 1: single connected land
        int[][] grid1 = {
            {1, 1, 0},
            {0, 1, 0},
            {0, 0, 0}
        };

        // Test case 2: separated lands (fault)
        int[][] grid2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        // Test case 3: all water
        int[][] grid3 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        System.out.println("Grid1 valid? " + checkLand(grid1));
        System.out.println("Grid2 valid? " + checkLand(grid2));
        System.out.println("Grid3 valid? " + checkLand(grid3));
    }

    // Calls your existing BFS / nested loops logic
    static boolean checkLand(int[][] array) {
        int icount = 0;
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] == 1) {
                    icount++;
                    if (icount > 1) return false;
                    bfs(array, i, j); // your BFS marks connected land as visited
                }
            }
        }
        return true;
    }

    // Stub for your BFS implementation
    static void bfs(int[][] array, int row, int col) {
        Queue<int[]> lands=new LinkedList<>();
        array[row][col]=2;
        lands.offer(new int[]{row , col});
        int[][] directions={{1,0}, {-1,0}, {0,1},{0,-1}};
        while(!lands.isEmpty()){
            int[] curr=lands.poll();
            int curr_r=curr[0];
            int curr_c=curr[1];
            int next_r, next_c;
            for(int[] dire: directions){
                next_r=curr_r+dire[0];
                next_c=curr_c+dire[1];
                if(next_r>=0 && next_r<array.length &&  next_c>=0 && next_c<array[0].length && array[next_r][next_c]==1){
                    array[next_r][next_c]=2;
                    lands.offer(new int[]{next_r, next_c});
                }
            }
        }
    }
}
