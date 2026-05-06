import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        int x = 1;
        for (int i = 1; i < nextInt + 1; ++i) {
            int n2 = i;
            int n3 = 0;
            while (n2 % 2 == 0) {
                ++n3;
                n2 /= 2;
            }
            if (n < n3) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
}
