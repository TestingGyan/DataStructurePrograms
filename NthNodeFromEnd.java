public class NthNodeFromEnd extends BasicOperations {


    /*
     * 
     * Tc= O(n); full travesrsal done two times assuming last node is the nth node
     * SC= O(1);
     * 
     */
    public static int nthNodeBrute(Node head, int n){

        if(head==null){
            return -1;
        }
        else{
            Node temp=head;
            int counter=0;
            while(temp!=null){ //finding length of list
                temp=temp.next;
                counter++;

            }
            if(n>counter){  //making sure nth index is not bigger than length of list
                return -1;
            }
            int nthNode=counter-n; //finding nth node index from begining

            temp=head;
            for(int i=0;i<nthNode;i++){ //traversing till nth node from begining of list
                temp=temp.next;               
            }

            return temp.data; //returning data
        }
        
    }


    /*
     * TC=O(n) // no full traversals
     * SC=O(1)
     * 
     * 
     */
    public static int nthNodeEfficient(Node head,  int n){
        if(head==null){
            return -1;
        }
        else{
            Node slow=head;
            Node fast=head;

            for(int i=0;i<n;i++){
                if(fast==null){ //making sure nth node index exist in list or not bigger than list
                    return -1;
                }
                fast=fast.next;
            }
            while(fast!=null){ //with this loop when fast reaches null, slow reaches nth node
                slow=slow.next;
                fast=fast.next;
            }
            return slow.data;
        }
    }
    public static void main(String[] args) {
        Node n1=new Node(0);
        Node n2=new Node(2);
        Node n3=new Node (3);
        Node n4=new Node(4);

       n1.next=n2;
       n2.next=n3;
       n3.next=n4;

       Node head=n1;

       traverse(head);

       System.out.println(nthNodeBrute(head, 5));
       System.out.println(nthNodeEfficient(head, 5));
    }
    
}
