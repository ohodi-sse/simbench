import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        int x = 0;
        final String substring = next.substring(0, 1);
        final String substring2 = next.substring(1, 2);
        final String substring3 = next.substring(2, 3);
        for (int i = 0; i <= 0; ++i) {
            if ((substring + substring2 + substring3).equals("RRR")) {
                x += 3;
                break;
            }
            if ((substring + substring2).equals("RR") || (substring2 + substring3).equals("RR")) {
                x += 2;
                break;
            }
            if (substring.equals("R") || substring2.equals("R") || substring3.equals("R")) {
                ++x;
                break;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
