import java.util.HashSet;

public class DetectCycle extends BasicOperations {

    /*
     * 
     * TC=O(n)
     * SC=O(n)
     * 
     * 
     * 
     */
    public static boolean detectB(Node head) {

        Node temp = head;
        HashSet<Node> set = new HashSet<>(); // as set can have only unique values

        while (temp != null) {
            if (set.contains(temp)) { // if node is already present than it means cycle exist
                return true;
            }
            set.add(temp); // storing nodes in set
            temp = temp.next;
        }
        return false;
    }

    /*
     * 
     * TC=O(n)
     * SC=O(1)
     * 
     */
    public static boolean detectE(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // if loop exists than at some point slow and fast pointers will meet
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Node n1 = new Node(0);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Node head = n1;

    }
}
