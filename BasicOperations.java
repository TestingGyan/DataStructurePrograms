public class BasicOperations {


    /*
     * 
     * 
     */
    public static Node insertBegining(Node head,int data){

        Node newN=new Node(data);

        if(head==null){
            return newN;
        }

        newN.next=head;
        head=newN;
        return head;
    }

    public static Node deleteBegining(Node head){

        if(head==null || head.next==null){
            return null;
        }

        return head.next;

    }

    public static Node insertEnd(Node head,int data){
        Node newN=new Node(data);
        if(head==null){
            return newN;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newN;
        return head;
    }

    public static Node deleteEnd(Node head){
        if(head==null || head.next==null){
            return null;
        }
        
        Node temp=head;

        while(temp.next.next!=null){
            temp=temp.next;
        }

        temp.next=null;
        return head;
    }


    /*
     * 
     * 
     */
    public static void traverse(Node head){
        if(head==null){
            System.out.println("Empty List");
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node n1= new Node(2);
        Node n2= new Node(3);
        Node n3= new Node(4);

        Node head=n1;
        n1.next=n2;
        n2.next=n3;

        traverse(head);

        head=insertBegining(head, 0);
        traverse(head);

        head=deleteBegining(head);
        traverse(head);

        head=insertEnd(head, 0);
        traverse(head);

        head=deleteEnd(head);
        traverse(head);



    }
    
}
