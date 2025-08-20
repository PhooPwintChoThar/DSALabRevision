package Lab06.pack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyQueueL_671755<T> implements Iterable{
    
    private List<T> items=new ArrayList<>();
    public void enqueue(T d){
        items.add(d);
    }

    public T deque(){
        if (isEmpty()){
            return null;
        }

        return items.remove(0);
    }

    public T peek(){
        return items.get(0);
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public String toString(){
        StringBuilder sb= new StringBuilder();
        sb.append("Top ->");
        for(T i:items){
            sb.append(i+" -> ");
        }
        sb.append("bottom");
        return sb.toString();
        
    }

    @Override
    public Iterator  iterator(){
        return items.iterator();
    }
}
