import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int n = 0;
        for (int i = 1; i <= nextInt; i *= 2) {
            ++n;
        }
        --n;
        System.out.println(1 << n);
    }
}
