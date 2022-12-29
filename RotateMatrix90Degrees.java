public class RotateMatrix90Degrees {

    public static int[][] rotateMAtrix(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        // transpose of maytrix O(n^2)
        for (int i = 0; i < row; i++) {
            for (int j = i; j < col; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        traverseMatrix(arr);

        // INdividual row reversal O(n^2)
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row / 2; j++) {
                int temp = 0;
                temp = arr[i][j];
                arr[i][j] = arr[i][row - 1 - j];
                arr[i][row - 1 - j] = temp;
            }
        }

        traverseMatrix(arr);
        return arr;
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
        System.out.println();

    }

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        traverseMatrix(matrix);

        matrix = rotateMAtrix(matrix);

    }

}
