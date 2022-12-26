public class RemoveNodeWithoutHead extends BasicOperations{
    
    public static Node remove(Node head,Node n){
        if(n.next==null){
            return head;
        }
        Node next=n.next;
        n.data=next.data;
        n.next=next.next;
        return head;
    }

    public static void main(String[] args) {
        Node n1= new Node(2);
        Node n2= new Node(3);
        Node n3= new Node(4);
        Node n4= new Node(5);
        Node n5= new Node(6);


        Node head=n1;
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        traverse(head);

        head=remove(head, n2);

        traverse(head);


    }
}
