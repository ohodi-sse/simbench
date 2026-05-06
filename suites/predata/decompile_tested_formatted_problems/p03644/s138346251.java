import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final int nextInt = new Scanner(System.in).nextInt();
        int max = 0;
        int x = 0;
        for (int i = 1; i <= nextInt; ++i) {
            final int counttwo = counttwo(i);
            max = Math.max(max, counttwo);
            if (counttwo == max) {
                x = i;
            }
        }
        System.out.println(x);
    }
    
    static int counttwo(int n) {
        int n2 = 0;
        while (n % 2 == 0) {
            ++n2;
            n /= 2;
        }
        return n2;
    }
}
