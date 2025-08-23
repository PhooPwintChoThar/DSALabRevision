package DynamicProgramming;

import java.util.Arrays;


//You are climbing a staircase of n steps. You can take either 1 or 2 steps at a time. Find the total number of distinct ways to reach the top.

public class Climbing_Stairs {

    public static void main(String[] args){

        int stairs=3;
        int[] path_counts= new int[stairs+1];
        Arrays.fill(path_counts, -1);
        int possible_steps=steps_memoization(stairs, path_counts);
        
        System.out.println(possible_steps);
        stairs=5;
        possible_steps=steps_tabulation(stairs);
        
        System.out.println(possible_steps);
    }

    private static int steps_memoization(int stairs, int[] path_counts){
        if(stairs<=1){
            return 1;
        }
        if(path_counts[stairs]!=-1){
            return path_counts[stairs];
        }

        path_counts[stairs]=steps_memoization(stairs-1, path_counts)+steps_memoization(stairs-2, path_counts);

        return path_counts[stairs];
    }

    private static int steps_tabulation(int stairs){
        if(stairs==0){
            return 0;
        }

        if (stairs==1){
            return 1;
        }

        int[] path_counts=new int[stairs+1];
        path_counts[0]=1;
        path_counts[1]=1;
        for(int i=2 ; i<=stairs ; i++){
            path_counts[i]=path_counts[i-1]+path_counts[i-2];
        }

        return path_counts[stairs];
    }
        
    
}
