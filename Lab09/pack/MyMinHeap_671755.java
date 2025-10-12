package Lab09.pack;

public class MyMinHeap_671755 {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public MyMinHeap_671755(){}
    
    private void swap(int i, int j) {
        heap[i] = heap[i] + heap[j];
        heap[j] = heap[i] - heap[j];
        heap[i] = heap[i] - heap[j];
    }
    public int peek() {
        return heap[0];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(int d) {
        if(!isFull()){
        int idx=size++;
        heap[idx]=d;
        int parent=(idx-1)/2;
        while( idx>0 && heap[parent]>heap[idx]){
            swap(idx, parent);
            idx=parent;
            parent=(idx-1)/2;
        }
        }
    }

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        heap[size] = d;
        int p = 0;
        while (true) {
            /* your code */
            int left=2*p+1;
            if(left>=size) break;
            
            int right=2*p+2;
            if(right==size){
                if(heap[left]<heap[p])
                    swap(right, p);
                break;
            
            }else{
                int smaller= (heap[left]<heap[right])?left:right;
                if(heap[p]>heap[smaller]){
                    swap(p, smaller);
                    p=smaller;
                }else{
                    break;
                }
            }
            System.out.println("heap snapshot (cur_size = " + size + ") " + this.toString());
        } 
        return d;
    } //end while

    public String toString() {
        int i;
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (i = 0; i < size; i++) {
            sb.append(heap[i]);
            sb.append(",");
        }
        if (size > 0) {
            sb.append("]");
        }
        return sb.toString();
    }
    
}