import java.util.HashSet;

public class DetectStartPointOfCycle extends BasicOperations {

    /*
     * 
     * TC=O(N)
     * Sc=O(N)
     * 
     */
    public static int startB(Node head) {

        if (head == null || head.next == null) { // empty or one node list check
            return -1;
        }
        HashSet<Node> set = new HashSet<>(); // hashset to store nodes
        Node temp = head;

        boolean cycleExist = false;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;

            if (set.contains(temp)) { // if cycle exist than break after updating the cycle check
                cycleExist = true;
                break;
            }
        }

        Node temp2 = head;

        if (temp != null && cycleExist == true) { // ensuring if statement works only if cycle exist
            int pos = 0;
            while (temp2 != temp) { // iterating till the cycle node and updating pos variable
                pos++;
                temp2 = temp2.next;
            }
            return pos;
        }

        return -1;
    }

    /*
     * 
     * TC=O(N)
     * SC=O(1)
     * 
     */
    public static int startE(Node head) {

        if (head == null || head.next == null) {
            return -1;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) { // detecting loop with floyd's algorythm

            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // if loop exists
                Node entry = head; // creating a new node entry
                int pos = 0;
                while (slow != entry) { // traversing both entry and slow node untill they meet
                    slow = slow.next;
                    entry = entry.next;
                    pos++;
                }

                return pos;

            }

        }

        return -1;

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

        System.out.println(startB(head));

        System.out.println(startE(head));

    }

}
