package DynamicProgramming;
//Given an integer n, print the nth Fibonacci number. The Fibonacci sequence is defined as:
//F(0) = 0, F(1) = 1, F(n) = F(n-1) + F(n-2) for n ≥ 2.
import java.util.Arrays;

public class Fibonancci {
    public  void main(String[] args){
        int num=7;
        int[] results=new int[num+1];
        Arrays.fill(results, -1);
        int r=fibonancci_memoization(num, results);
        System.out.println(r);

        num+=2;
        int p=fibonannci_tabulation(num);
        System.out.println(p);


    }

    private int fibonancci_memoization(int n, int[] a){
        if (a[n]!= -1){
            return a[n];
        }
        
        if (n<=1){

            return n;
        }
        a[n]=fibonancci_memoization(n-1, a)+fibonancci_memoization(n-2, a);

        return a[n];
}

    private int fibonannci_tabulation(int n){
        if(n==1){
            return 1;
        }

        if(n==0){
            return 0;
        }

        int[] results= new int[n+1];
        results[0]=0;
        results[1]=1;
        int current=2;
        for(int i=current; i<=n ; i++){
            results[i]=results[i-1]+results[i-2];
        }

        return results[n];
    }

}