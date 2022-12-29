import java.util.HashSet;
import java.util.Hashtable;

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
        HashSet<Node> set = new HashSet<>();

        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
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
            if (slow == fast) {
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
