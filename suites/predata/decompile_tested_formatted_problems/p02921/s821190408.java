// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        new Solver().run();
    }
}
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Solver
{
    public void run() {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.next().toCharArray();
        final char[] charArray2 = scanner.next().toCharArray();
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
