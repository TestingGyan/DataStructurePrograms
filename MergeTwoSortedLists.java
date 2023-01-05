public class MergeTwoSortedLists extends BasicOperations {


    /*
     * TC=O(n)
     * SC=O(1)
     * 
     */
    public static Node merge(Node h1, Node h2){
        if(h1==null){
            return h2;
        }
        if(h2==null){
            return h1;
        }
        Node p=h1;
        Node q=h2;
        Node s=null;//sort pointer
        Node newH=null;
        Node next=null;

        if(p.data<q.data){  //finding first node or new Head
            s=p;
            p=s.next;
            
        }
        else{
            s=q;
            q=s.next;
           
        }
       newH=s;
        while(p!=null && q!=null){ //Traversing through the lists and forming links base on data
            if(p.data<q.data){
                s.next=p; //forming link
                s=p; //changing sort pointer for next traversal
                p=s.next; //updating current node
            }
            else{
                s.next=q;
                s=q;
                q=s.next;
            }
        }

        if(p==null){
            s.next=q;
        }

        if(q==null){
            s.next=p;
        }

        return newH;
        


    }

    public static void main(String[] args) {

        Node n1=new Node(0);
        Node n2=new Node(2);
        Node n3=new Node (3);

       n1.next=n2;
       n2.next=n3;

       Node h1=n1;

       traverse(h1);

       Node m1=new Node(1);
        Node m2=new Node(2);
        Node m3=new Node (4);

       m1.next=m2;
       m2.next=m3;

       Node h2=m1;

       traverse(h2);

       Node hN=merge(h1, h2);

       traverse(hN);
    }

}
