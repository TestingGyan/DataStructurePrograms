import java.util.ArrayList;

public class Palindrome extends BasicOperations {

    /*
     * 
     * TC=O(N)
     * SC=O(N)
     * 
     */
    public static boolean palindromeCheckN(Node head) {

        ArrayList<Integer> al = new ArrayList<>();
        Node temp = head;

        while (temp != null) {
            al.add(temp.data);
            temp = temp.next;
        }
        temp = head;
        for (int i = al.size() - 1; i >= 0; i--) {
            if (temp.data != al.get(i)) {
                return false;
            }
            temp = temp.next;
        }

        return true;
    }

    /*
     * 
     * 
     * TC=O(N)
     * SC=O(1)
     */

    public static boolean palindromeCheckE(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) { // Reaching mid node
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = head;
        slow = reverse(slow); // Reversing mid node

        while (slow != null) {
            if (temp.data != slow.data) { // comparing first and second halve of list
                return false;
            }
            temp = temp.next;
            slow = slow.next;
        }

        return true;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node c = head;
        Node p = null;
        while (c != null) {
            Node n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        return p;
    }

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        Node head = n1;
        n1.next = n2;
        n2.next = n3;

        traverse(head);

        System.out.println(palindromeCheckN(head));

        System.out.println(palindromeCheckE(head));

    }

}
