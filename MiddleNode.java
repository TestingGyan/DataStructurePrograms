public class MiddleNode extends BasicOperations {

    public static Node midNodeB(Node head){


        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        int mid=count/2;
        temp=head;
        for(int i=0;i<mid;i++){
            temp=temp.next;
        }
        return temp;
    }


    public static Node midNodeE(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        
        Node n1= new Node(2);
        Node n2= new Node(3);
        Node n3= new Node(4);

        Node head=n1;
        n1.next=n2;
        n2.next=n3;

        traverse(head);

        System.out.println("Mid node data :"+midNodeB(head).data);

        System.out.println("Mid node data :"+midNodeE(head).data);
    }
    
}
