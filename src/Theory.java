import java.util.Arrays;

public class Theory {

    private static final int NOT_FOUND = -1;
    private static int calls = 0;

    private static int[] binaryKeys = {99, 36, 7, 37};
    private static int[][] binary = {
            {36, 41, 48, 53, 87, 98, 99, 99},
            {21, 33, 36, 39, 40, 40, 63, 86},
            {6, 7, 35, 39, 58, 77, 82, 85},
            {55, 56, 57, 58, 64, 79, 93, 98}
    };

    public static void main(String[] args) {
        for(int i = 0; i < binary.length; i++) {
            calls = 0;
            binarySearch(binary[i], binaryKeys[i]);
            System.out.println("Binary " + Arrays.toString(binary[i]) + ", key=" + binaryKeys[i] + ", calls=" + calls);
        }
        
        int[][] matrix = generateMatrix(5, 7);
        printMatrix(matrix);
        fill(matrix, matrix.length, 7, 7);
        printMatrix(matrix);
        fill(matrix, matrix.length, 0, 0);
        printMatrix(matrix);
        // Creates exception on negative values of `r` or `c`
        // fill(matrix, matrix.length, -3, 0); 
    }
    
    private static void printMatrix(int[][] matrix) {
        System.out.println(Arrays.deepToString(matrix));
    }
    
    private static int[][] generateMatrix(int n, int fill) {
        int[][] ret = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ret[i][j] = fill;
            }
        }
        return ret;
    }

    private static int binarySearch(int[] data, int key) {
        return binarySearch(data, key, 0, data.length - 1);
    }

    private static int binarySearch(int[] data, int key, int low, int high) {
        calls++;
        if (low > high) return NOT_FOUND;
        int mid = low + (high - low) / 2;
        int value = data[mid];
        if (value < key) {
            return binarySearch(data, key, mid + 1, high);
        } else if (value > key) {
            return binarySearch(data, key, low, mid - 1);
        } else {
            return mid;
        }
    }
    
    private static void fill(int[][] matrix, int n, int r, int c) {
        if(r >= n || c >= n) {
            return;
        }
        matrix[r][c] = (r + c) % 2;
        fill(matrix, n, r + 1, c);
        fill(matrix, n, r, c + 1);
    }

}
