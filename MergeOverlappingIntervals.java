
import java.util.Arrays;
import java.util.Stack;

public class MergeOverlappingIntervals {

    public static int[][] merge(int[][] intervals) {

        // sorting intervals with first ele using comparator
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // O(nlogn)

        traverseMatrix(intervals);

        // Creating stack as we have to basically compare the last inserted interval in
        // stack with the currently picked interval
        // ecah interval in interval 2d array is a kind of one array, that's why type of
        // stack is int[]
        Stack<int[]> s = new Stack<>();

        s.add(intervals[0]); // adding first interval in array

        for (int i = 1; i < intervals.length; i++) { // starting loop from second interval //O(n)
            int startPoint2 = intervals[i][0]; // startpoint of picked interval is current rows first ele
            int endPoint2 = intervals[i][1]; // endpoint of picked interval is current rows second ele

            int[] popArray = s.pop(); // popping last inserted value from stack and storing in a array, as every ele
                                      // in stack is a array

            int startPoint1 = popArray[0];// first value in popped array is basically fist ele of last inserted interval
                                          // in stack
            int endPoint1 = popArray[1];// second value in popped array is basically second ele of last inserted
                                        // interval in stack

            // 1,4 --popped interval from stack
            // 2,3 -- current picked interval from loop
            // if current picked interval from loop is completely part of popped interval
            // from stack than
            // we have to make sure we are picking the right ending for interval
            int maxEnd = Math.max(endPoint1, endPoint2);

            // coparing end point or second ele of popped interval with startpoint or first
            // ele of current picked interval from loop
            if (startPoint2 <= endPoint1) { // if intervals are merging

                int[] merge = new int[] { startPoint1, maxEnd }; // than storingthe new interval in merge array
                s.add(merge); // inserting the merged interval in stack

            } else { // if intervals are not merging than
                s.add(popArray); // re-addingthe popped value as it is a wrong pop
                s.add(intervals[i]); // adding the current picked interval from loop
            }

        }
        int[][] res = new int[s.size()][2]; // creating the result array for intervals, no of rows will be size of stack
                                            // & colums will be 2 only
        for (int i = s.size() - 1; i >= 0; i--) { // aslast inserted value will be popped from stack, so using reversed
                                                  // loop to store result in res array
            int[] popArray = s.pop(); // popping value from stack
            res[i][0] = popArray[0]; // inserting first value
            res[i][1] = popArray[1]; // inserting second value
        }

        return res; // return res

    }

    public static void traverseMatrix(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 9, 9 }, { 15, 18 } };

        traverseMatrix(arr);

        arr = merge(arr);

        traverseMatrix(arr);
    }

}
