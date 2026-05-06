import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        int i;
        int n;
        for (i = new Scanner(System.in).nextInt(), n = 0; i > 0; i /= 2, ++n) {}
        System.out.println(1 << n - 1);
    }
}
