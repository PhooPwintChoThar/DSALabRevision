package Lab03.pack;

public class MyArrayBasic_671755 {
    protected int MAX_SIZE=5;
    protected int data[]=new int[MAX_SIZE];
    protected int size=0;

    public MyArrayBasic_671755(){}
    public MyArrayBasic_671755(int ...a){
        MAX_SIZE=a.length;
        data=new int[MAX_SIZE];
        for(int i: a){
            add(i);
        }
    }


    public void add(int d){
        data[size++]=d;
    }

    public void insert(int d){

       
        int index=size-1;
        while(data[index]>=d){
            data[index+1]=data[index];
            --index;
        }
        data[index+1]=d;
        ++size;   
    
    }

    public void insert_unordered(int index, int value){
            data[size]=data[index];
            data[index]=value;
            ++size;
    }

    public int find(int d){
        for(int i=0; i<size; i++){
            if(data[i]==d){
                return i;
            }
        }

        return -1;
    }

    public void delete(int index){
        for(int i=index; i<size-1; i++){
            data[index]=data[index+1];
        }
        --size;
    }

    public int getAt(int index){
        
        return data[index];
    }

    public void setAt(int index , int d){
        data[index]=d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0;  i <size-1 ; i++)
            sb.append(data[i] + ", "); 
        if (size > 0)
            sb.append(data[size-1]);
        sb.append("]");
        return sb.toString();
    }
    
}
