import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int x = 1;
        while (true) {
            final int n = x * 2;
            if (n > nextInt) {
                break;
            }
            x = n;
        }
        System.out.println(x);
    }
}
