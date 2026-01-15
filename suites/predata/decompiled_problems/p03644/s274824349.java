import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) throws Exception {
        final Scanner scanner = new Scanner(System.in);
        final int nextInt = scanner.nextInt();
        int x = 1;
        int n = 0;
        for (int i = 0; i < nextInt; ++i) {
            int n2;
            int n3;
            for (n2 = i + 1, n3 = 0; n2 % 2 == 0; n2 /= 2, ++n3) {}
            if (n3 > n) {
                n = n3;
                x = i + 1;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
