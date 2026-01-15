import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        int i;
        int n;
        for (i = new Scanner(System.in).nextInt(), n = 0; i != 1; i /= 2, ++n) {}
        System.out.println(pow(n));
    }
    
    static int pow(final int n) {
        int n2 = 1;
        for (int i = 0; i < n; ++i) {
            n2 *= 2;
        }
        return n2;
    }
}
