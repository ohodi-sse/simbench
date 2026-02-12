import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        new String();
        final String next = scanner.next();
        scanner.close();
        final Character[] array = new Character[3];
        for (int i = 0; i < 3; ++i) {
            array[i] = next.charAt(i);
        }
        int n = 0;
        int x = 0;
        for (int j = 0; j < 3; ++j) {
            if (array[j].equals('R')) {
                if (++n > x) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
