import java.util.*;

public class KruskalMST {
    
    public static int kruskal(int vertices, List<int[]> edges) {
        PriorityQueue<int[]> orderedEdges= new PriorityQueue<>(Comparator.comparingInt(a->a[2]));
        
        for(int[] e:edges){
            orderedEdges.offer(e);
        }

        List<List<Integer>> sets=new ArrayList<>();
        for(int i=0; i<vertices; i++){
            sets.add(new ArrayList<>(Arrays.asList(i)));
        }

        int t_distance=0;
        
        while (!orderedEdges.isEmpty()) {
            int[] e=orderedEdges.poll();
            int start=e[0];
            int end=e[1];
            List<Integer>  start_set=null ;
            List<Integer>  end_set=null ;
            for (List<Integer> s:sets){
                if (s.contains(start)) start_set=s;
                if(s.contains(end))   end_set=s;       }

            if (start_set != end_set){
                t_distance+=e[2];
                sets.remove(start_set);
                sets.remove(end_set);
                start_set.addAll(end_set);
                sets.add(start_set);
            }else{
                continue;
            }
            
        }
        
        return t_distance;
    }
    
    public static void main(String[] args) {
        List<int[]> edges = Arrays.asList(new int[][]{
            {0, 1, 4},
            {0, 2, 5},
            {1, 2, 11},
            {1, 3, 9},
            {1, 4, 7},
            {2, 4, 3},
            {3, 4, 13},
            {3, 5, 2},
            {4, 5, 6}
        });

        
        
        System.out.println("Result: " + kruskal(6, edges));
        System.out.println("Expected: 20");
    }
}
