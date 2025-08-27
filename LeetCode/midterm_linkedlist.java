package LeetCode;

public class midterm_linkedlist {

    static class Node{
        Node next;
        int data;
        Node(int d){
            data=d;
        }
    }

    public static void main(String[] args) {
      
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);

        System.out.println("Original list:");
        printList(head);


        head = deleteLastOccurrence(head, 2);
        System.out.println("After deleting first occurrence of 2:");
        printList(head);


        head = deleteLastOccurrence(head, 1);
        System.out.println("After deleting first occurrence of 1:");
        printList(head);


        head = deleteLastOccurrence(head, 10);
        System.out.println("After trying to delete 10 (not in list):");
        printList(head);
    }

    static Node deleteLastOccurrence(Node head, int n){
        Node prevLast=null, last=null, prev=null, curr;
        curr=head;

        while (curr!=null) {
            if(curr.data==n){
                prevLast=prev;
                last=curr;

            }

            prev=curr;
            curr=curr.next;
            
        }

        if(last!=null){
            prevLast.next=prevLast.next.next;
        }

        return head;
    }

    static void printList(Node head){
        StringBuffer s=new StringBuffer();
        s.append("head->");
        Node current= head;
        while(current!=null){
            s.append("("+current.data+")->");
            current=current.next;
        }
        s.append("null");
        System.out.println(s.toString());

    }
    
}
