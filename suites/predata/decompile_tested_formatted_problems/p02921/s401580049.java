import java.io.OutputStream;
import java.util.Scanner;
import java.io.PrintWriter;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static PrintWriter out;
    public static Scanner in;
    
    void solve() {
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
    
    public static void main(final String[] array) {
        new Main().solve();
        Main.out.flush();
    }
    
    static {
        Main.out = new PrintWriter(System.out);
        Main.in = new Scanner(System.in);
    }
}
