public class ReverseListInGroup extends BasicOperations {

    public static Node reverseListRecursive(Node head, int k) {
        Node p = null;
        Node c = head;
        Node next = null;
        int count = 0;

        while (c != null && count < k) { // Reversing list for first K nodes
            next = c.next;
            c.next = p;
            p = c;
            c = next;
            count++;
        }

        if (next != null) { // if next is not null
            Node restHead = reverseListRecursive(next, k); // finding head for the next k nodes in list //Recusrsive
                                                           // call
            head.next = restHead; // now linked list headat first is now last node in the reversed list so forming
                                  // link with it to the next found head
        }

        return p; // at the end returning new head or head after reversal

    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node head = n1;
        traverse(head);

        head = reverseList(head, 2);
        traverse(head);
    }

}
