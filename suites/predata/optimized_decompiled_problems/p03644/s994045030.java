import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static Scanner sc;
    
    private static void main$3231c38a() {
        final int nextInt = Main.sc.nextInt();
        int x = 1;
        int n = 0;
        for (int i = 2; i <= nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n < n3) {
                n = n3;
                x = i;
            }
        }
        System.out.println(x);
    }
    
    static {
        Main.sc = new Scanner(System.in);
    }
}
