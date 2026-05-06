import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        System.out.println(search(new Scanner(System.in).nextInt()));
    }
    
    public static int search(final int n) {
        int n2 = 1;
        int n3 = 0;
        for (int i = 1; i <= n; ++i) {
            int n4 = 0;
            for (int n5 = i; n5 % 2 == 0 && n5 > 0; n5 /= 2, ++n4) {}
            if (n3 < n4) {
                n2 = i;
                n3 = n4;
            }
        }
        return n2;
    }
}
