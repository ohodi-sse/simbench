import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static PrintWriter out;
    private static Scanner in;
    
    private static void solve() {
        final char[] charArray = Main.in.next().toCharArray();
        final char[] charArray2 = Main.in.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static void main$3231c38a() {
        new Main();
        final char[] charArray = Main.in.next().toCharArray();
        final char[] charArray2 = Main.in.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
        Main.out.flush();
    }
    
    static {
        Main.out = new PrintWriter(System.out);
        Main.in = new Scanner(System.in);
    }
}
