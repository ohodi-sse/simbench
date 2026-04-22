import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main
{
    static String br;
    static Scanner sc;
    static PrintWriter out;
    
    public static void main(final String[] array) {
        final char[] charArray = next().toCharArray();
        final char[] charArray2 = next().toCharArray();
        int i = 0;
        for (int j = 0; j < charArray.length; ++j) {
            if (charArray[j] == charArray2[j]) {
                ++i;
            }
        }
        println(i);
    }
    
    static int nextInt() {
        return Integer.parseInt(next());
    }
    
    static Long nextLong() {
        return Long.parseLong(next());
    }
    
    static String next() {
        return Main.sc.next();
    }
    
    static String nextLine() {
        return Main.sc.nextLine();
    }
    
    static void println(final Object x) {
        Main.out.println(x);
        Main.out.flush();
    }
    
    static void print(final Object obj) {
        final PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print(obj);
        printWriter.flush();
    }
    
    static {
        Main.br = System.getProperty("line.separator");
        Main.sc = new Scanner(System.in);
        Main.out = new PrintWriter(System.out);
    }
}