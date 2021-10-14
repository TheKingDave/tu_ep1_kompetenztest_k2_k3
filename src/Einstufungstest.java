import java.util.Arrays;

public class Einstufungstest {

    public static void main(String[] args) {
        // 18:34
        int[] test1 = {1, -5, 0, 6};
        int[][] test2 = {{1}, {2}, {3}};
        int[][] test3 = {{1, 0, 1}, {}, {5, 5, 6, 5}, {}};
        int[][] test4 = {{7, 7, 5, 7, 3}, {2, -4}, {10, 20, 30}, {-1, -2, -3, -4, -5, -6, -7}};
        int[][] test5 = {{}, {}};
        int[][] test6 = {{}};
        
        int[][] result1 = generate(test1);

        System.out.println(result1[0] == test1);
        System.out.println(result1[0] == result1[1]);
        System.out.println(result1[0] == result1[2]);
        System.out.println(result1[1] == result1[2]);

        change(test2);
        System.out.println(Arrays.deepToString(test2));
        change(test3);
        System.out.println(Arrays.deepToString(test3));
        change(test4);
        System.out.println(Arrays.deepToString(test4));
        change(test5);
        System.out.println(Arrays.deepToString(test5));
        change(test6);
        System.out.println(Arrays.deepToString(test6));

        System.out.println(isEqual("blah", "blahblah"));
        System.out.println(isEqual("blah", "blah"));
        System.out.println(isEqual("", ""));
        System.out.println(isEqual(null, null));

        // My tests:
        System.out.println("\n\nMy Tests:");
        // Check missing case
        System.out.println("isEqual(\"blah1\", \"blah2\"): " + isEqual("blah1", "blah2"));
    }
    
    private static int[][] generate(int[] inputArray) {
        // Generate array which is one longer thant input
        int[][] ret = new int[inputArray.length + 1][];
        // Pass inputArray by reference
        ret[0] = inputArray;
        // Crete & Copy always shorter arrays
        for (int i = 1; i <= inputArray.length; i++) {
            int[] row = new int[inputArray.length + 1 - i];
            for (int j = 0; j < row.length; j++) {
                row[j] = inputArray[j];
            }
            ret[i] = row;
        }
        return ret;
    }
    
    private static void change(int[][] inputArray) {
        int n = inputArray.length;
        
        // Make copy truncated to square and fill rest with 0s
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = j >= inputArray[i].length ? 0 : inputArray[i][j];
            }
        }
        
        // Replace inner arrays and fill with rotated entries from copy
        for (int i = 0; i < n; i++) {
            inputArray[i] = new int[n];
            for (int j = 0; j < n; j++) {
                inputArray[i][j] = copy[n - 1 - j][i];
            }
        }
    }
    
    private static boolean isEqual(String s1, String s2) {
        // Both null => equal
        if(s1 == null && s2 == null) return true;
        // One is null => not equal
        if(s1 == null || s2 == null) return false;
        // Both empty => equal
        if(s1.isEmpty() && s2.isEmpty()) return true;
        // One empty => not equal
        if(s1.isEmpty() || s2.isEmpty()) return false;
        // Check if first character is equal and all following characters are equal
        return s1.charAt(0) == s2.charAt(0) && isEqual(s1.substring(1), s2.substring(1));
    }
    
}
