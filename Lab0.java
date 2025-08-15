import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Lab0{
    public static void main(String[] args){

        demo_1();

    }

    static void demo_1() {
            /*int n = 3;
            int[] data = {1, 3, 5, 7, 9, 11};*/

            /*int n = 5;
            int[] data = {1, 4, 2, 5, 7, 9, 10, 12, 14, 16};*/

            int n = 3;
            int[] data = {10, 90, 70, 100, 150, 210};

            List<int[]> beams = new ArrayList<>();
            for (int i = 0; i < 2*n; i+=2) {
            beams.add(new int[] {data[i],data[i+1]});
            }
            List<int[]> merged = mergeBeams(beams);
            for (int[] beam : merged) {
            System.out.println(Arrays.toString(beam));
            }
        }

    static List<int[]> mergeBeams(List<int[]> beams){

        List<int []> result=new ArrayList<>();
        int index=0;
        int start=beams.get(0)[0];
        int end=beams.get(0)[1];
        while(index<beams.size()-1){         
          if (beams.get(index+1)[0]>end ){
                   result.add(new int[]{start,end});
                    index+=1;
                    start=beams.get(index)[0];
                    end=beams.get(index)[1];
                    continue;                
                }
        
            end=Math.max(end, beams.get(index+1)[1]);
            index+=1;
        }
        result.add(new int[]{start,end});
    

        return result;
        
    }
}