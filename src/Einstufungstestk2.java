public class Einstufungstestk2 {

    //Implementieren Sie hier die in der Angabe beschriebenen statischen Methoden.

    public static void main(String[] args) {
        short result = (short) iterate(23001, 3);
        System.out.println("Result: " + result);
        
        String test = "1FreundDerZiffern1234567890";
        System.out.println(iterate(1, 4));
        System.out.println(iterate(11, 2));
        System.out.println(iterate(90, 5));
        System.out.println(iterate(2048, 16));
        System.out.println(compare(test, "1Feind"));
        System.out.println(compare(test.substring(24), "89"));
        System.out.println(compare("EP1", "TUW"));
        System.out.println(compare(test.substring(24), test.substring(18)));
        System.out.println(replace("Hier eifrig ersetzen!", 2));
        System.out.println(replace("Im WS21: EP1!", 3));
        System.out.println(replace(test, 3));
        System.out.println(replace("Ätsch", 10));
        printPattern(3, 3);
        printPattern(3, 8);
        printPattern(4, 9);
        printPattern(5, 10);
    }

    private static int iterate(int start, int n) {
        for(int i = 0; i < n; i++) {
            int zehn = start / 10 % 10;
            int eins = start % 10;
            if(zehn < eins) {
                start *= 2;
            } else {
                start /= 3;
            }
        }
        return start;
    }
    
    private static String compare(String a, String b) {
        if(a.length() > b.length()) {
            return a.substring(0, Math.min(a.length(), 7)) + ">" + b;
        }
        if(a.length() < b.length()) {
            return Integer.toString(b.length());
        }
        return "a=b" + a.length();
    }

    private static String replace(String input, int jump) {
        String ret = "";
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= '0' && c <= '9') {
                ret += c;
                continue;
            }
            ret += i % jump != 0 ? c : '_';
        }
        return ret;
    }
    
    private static void printPattern(int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            char c = ' ';
            if(i == 1 || i == rows - 2) {
                c = '-';
            }
            for (int j = 0; j < cols; j++) {
                System.out.print(j % 2 == 0 || j == cols-1 ? '|' : c);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
