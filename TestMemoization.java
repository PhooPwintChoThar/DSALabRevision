import java.util.Arrays;

public class TestMemoization {
    public  void main(String[] args){
        int num=7;
        int[] results=new int[num+1];
        Arrays.fill(results, -1);
        int r=fibonancci(num, results);
        System.out.println(r);
    }

    private int fibonancci(int n, int[] a){
        if (a[n]!= -1){
            return a[n];
        }
        
        if (n<=1){

            return n;
        }
        a[n]=fibonancci(n-1, a)+fibonancci(n-2, a);

        return a[n];
}

}