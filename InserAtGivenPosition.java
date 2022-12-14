public class InserAtGivenPosition extends BasicOperations {


    /*
     * TC : O(n)
     * SC : O(1)
     * 
     * 
     */

    public static Node insert(Node head, int data,int pos){

        Node n1= new Node(data);
        if(pos==1){
            n1.next=head;
            head=n1;       
        }
        else{
            Node temp=head;
            for(int i=1;i<=pos-2&&temp!=null;i++){
                temp=temp.next;
            }
            n1.next=temp.next;
            temp.next=n1;

        }

        return head;
    }


    public static void main(String[] args) {
        
        Node n1=new Node(0);
        Node n2=new Node(2);
        Node n3=new Node (3);

       n1.next=n2;
       n2.next=n3;

       Node head=n1;

       traverse(head);

       head=insert(head, 1, 3);

       traverse(head);

    }
    
}
