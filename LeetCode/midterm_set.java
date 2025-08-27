package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class midterm_set {
    List<Integer> set=new LinkedList<>();

    public void add(int d){
        if(!contains(d)){
            set.addFirst(d);
        }
        
    }

    public boolean contains(int n){
        return set.contains(n);
    }

    public boolean delete(int d){
        if(contains(d)){
            set.remove(d);
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        midterm_set mySet = new midterm_set();

        // Add elements
        mySet.add(5);
        mySet.add(10);
        mySet.add(5); // duplicate, should not be added
        mySet.add(7);

        // Test contains
        System.out.println("Contains 10? " + mySet.contains(10)); // true
        System.out.println("Contains 3? " + mySet.contains(3));   // false

        // Test delete
        System.out.println("Delete 5: " + mySet.delete(5));       // true
        System.out.println("Delete 5 again: " + mySet.delete(5)); // false

        // Add more elements
        mySet.add(15);

        // Print set content
        System.out.println("Current set: " + mySet.set);
    }

    
    
}
