public class InsertNodeInSortedManner {


    /*
     * TC=O(n)
     * SC=O(1)
     * 
     * 
     */
    public static Node insert(int data, Node head){

        Node n= new Node(data);
        if(head==null){  //if list is empty than return the node
            return n;
        }
        if(data<=head.data){ //if data is less than or equal to the first node data
            n.next=head;
            head=n;
        }
        Node temp=head;
        while(temp.next!=null){ // finding point where new node can be inserted
            
            if(data<=temp.next.data){
                break;
            }
            temp=temp.next;
        }
        n.next=temp.next;
        temp.next=n;
    
    
        return head;

    }

    public static void main(String[] args) {
        
    }
    
}
