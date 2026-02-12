import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.util.Vector;
import java.io.PrintStream;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner cin;
    private static PrintStream cout;
    
    private static void main$3231c38a() {
        new Vector();
        final char[] charArray = Main.cin.next().toCharArray();
        int max = 0;
        int b = 0;
        for (int length = charArray.length, i = 0; i < length; ++i) {
            if (charArray[i] == 'R') {
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
