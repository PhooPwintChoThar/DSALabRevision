package Lab04.pack;


public class MyLinkedList {
    protected Node head;

    protected class Node{
        int data;
        Node next;
        Node (int d){
            data=d;
        }
        
    }

    public MyLinkedList(){
        this.head=null;
    }

    public int size(){
        int s=0;
        Node current=head;
        while(current!=null){
            s+=1;
            current=current.next;
        }

        return s;
    }

    public void add(int d){
        Node newNode=new Node(d);
        newNode.next=head;
        head=newNode;
    }

    public void add(int[] d){
        for(int i=d.length-1 ; i>-1 ; i--){
            add(d[i]);
        }
    }



    public void insert(int d){
        Node newNode= new Node(d);
        if (head==null || head.data>d){
            newNode.next=head;
            head=newNode;
        }else{
            Node current=head;
            while(current.next!=null && current.next.data<d){
                current=current.next;
            }

           newNode.next=current.next;
           current.next=newNode;

        }
    }

    public void insert(int[] d){
        for(int i :d){
            insert(i);
        }
    }

    public int find(int d){
        int count=0;
        Node current=head;
        while(current!=null){
            if (current.data==d){
                return count;
            }
            current=current.next;
            count+=1;
        }
        return -1;

    }

    public void delete(int d){
        if (head==null){
            return;
        }

        
        if (head.data==d){
            head=head.next;
            return ;
            
        }
        Node current=head;
        while(current.next!=null){
            if (current.next.data==d){
                current.next=current.next.next;
                return;
            }
            current=current.next;
        }
    }

    public int getAt(int index){
        int count=0;
        Node current=head;

        while(count<index){
            current=current.next;
            count+=1;
        }

        return current.data;
    }

    public void setAt(int index, int i){
        int count=0;
        Node current=head;
        while(count<index){
            current=current.next;
            count+=1;
        }

        current.data=i;

    }
    @Override
    public String toString(){
        StringBuffer s=new StringBuffer();
        s.append("head->");
        Node current= head;
        while(current!=null){
            s.append("("+current.data+")->");
            current=current.next;
        }
        s.append("null");
        return s.toString();

    }

}
