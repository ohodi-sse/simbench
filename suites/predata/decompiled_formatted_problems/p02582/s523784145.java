import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.util.Vector;
import java.io.PrintStream;
import java.util.Scanner;





public class Main
{
    static Scanner cin;
    static PrintStream cout;
    
    public static void main(final String[] array) {
        final Vector vector = new Vector();
        final char[] charArray = Main.cin.next().toCharArray();
        int max = 0;
        int b = 0;
        final char[] array2 = charArray;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i] == 'R') {
                ++b;
            }
            else {
                b = 0;
            }
            max = Math.max(max, b);
        }
        Main.cout.println(max);
    }
    
    static {
        Main.cin = new Scanner(System.in);
        Main.cout = new PrintStream(new FileOutputStream(FileDescriptor.out));
    }
}