package Lab03.pack;

public class MyArray_671755  extends MyArrayBasic_671755{

    public MyArray_671755(){
        MAX_SIZE=100_000;
        data=new int[MAX_SIZE];
    }

    public MyArray_671755(int max){
        MAX_SIZE=max;
        data=new int[MAX_SIZE];
    }

    public boolean isFull(){
        return size==MAX_SIZE;
    }    
    
    public boolean isEmpty(){
        return size==0;
    }
    
    int[] expandByK(int k){
        MAX_SIZE=k*MAX_SIZE;
        int[] newArray=new int[MAX_SIZE];
        for(int i=0; i<size ;i++){
            newArray[i]=data[i];
        }
        data=newArray;
        return newArray;

    }

    int[] expand(){
       return expandByK(2);
     }

    public void add(int d){
        if(isFull()){
            expand();
        }
        data[size++]=d;
    }

     public void insert(int d){
        if(isFull()){
            expand();
        }
       
        int index=size-1;
        while(data[index]>=d){
            data[index+1]=data[index];
            --index;
        }
        data[index+1]=d;
        ++size;   
    
    }

    public void insert_unordered(int index, int value){
            if(isFull()){
            expand();
        }
        data[size]=data[index];
        data[index]=value;
        ++size;
    }

    public void delete(int index){
        if(isEmpty() || index>=size){
            return;
        }

        for(int i=index; i<size-1; i++){
            data[index]=data[index+1];
        }
        --size;
    }

    public int binarySearch(int target){
        int mid=size/2;
        int start=0;
        int end=size-1;
        while (start<=end) {

            if(data[mid]==target)
             return mid;
            else if (data[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }  
            
            mid=(start+end)/2;
        }

        return  -(1+start);
        
    }
    
}
