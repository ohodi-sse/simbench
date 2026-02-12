import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 1;
        int n = 0;
        for (int nextInt = scanner.nextInt(), i = 1; i <= nextInt; ++i) {
            if (i % 2 == 0) {
                int n2 = i;
                int n3 = 0;
                int j = 1;
                while (j != 0) {
                    if (n2 % 2 == 0) {
                        n2 /= 2;
                        ++n3;
                    }
                    else {
                        j = 0;
                    }
                }
                final int n4 = n3;
                if (n < n4) {
                    n = n4;
                    x = i;
                }
            }
        }
        System.out.println(x);
        scanner.close();
    }
    
    private static int countHalf(int n) {
        int n2 = 0;
        int i = 1;
        while (i != 0) {
            if (n % 2 == 0) {
                n /= 2;
                ++n2;
            }
            else {
                i = 0;
            }
        }
        return n2;
    }
}
