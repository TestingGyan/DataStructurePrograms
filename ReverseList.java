import java.util.ArrayList;

public class ReverseList extends BasicOperations{


    /*
     * TC= O(n)+O(n)=O(n)
     * SC= O(n);
     * 
     */

    public static Node reverseB(Node head){
        if(head==null){
            return null;
        }

        Node temp=head;
        ArrayList<Integer> al= new ArrayList<>();

        while(temp!=null){
            al.add(temp.data);
            temp=temp.next;
        }

        temp=head;
        while(temp!=null){
            temp.data=al.remove(al.size()-1);
            temp=temp.next;
        }

        return head;
    }

    /*
     * 
     * TC=O(n)
     * SC=O(1)
     * 
     */
    public static Node reverseE(Node head){

        if(head==null){
            return null;
        }

      Node prev=null;
      Node curr=head;

      while(curr!=null){
        Node next=curr.next;
        curr.next=prev;
        prev=curr;
        curr=next;

      }

      return prev;
        
    }

    public static void main(String[] args) {
        Node n1= new Node(2);
        Node n2= new Node(3);
        Node n3= new Node(4);

        Node head=n1;
        n1.next=n2;
        n2.next=n3;

        traverse(head);

        head=reverseB(head);

        traverse(head);

        head=reverseE(head);

        traverse(head);
    }
    
}
