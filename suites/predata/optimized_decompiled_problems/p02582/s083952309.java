import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next = (scanner = new Scanner(System.in)).next();
        scanner.close();
        String s = "";
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (i == 0) {
                if (next.substring(0, 1).equals("R")) {
                    x = 1;
                }
                s = next.substring(0, 1);
            }
            else {
                final String s2 = next;
                final int beginIndex = i;
                if (s2.substring(beginIndex, beginIndex + 1).equals("R") && s.equals("R")) {
                    ++x;
                }
                else {
                    final String s3 = next;
                    final int beginIndex2 = i;
                    if (s3.substring(beginIndex2, beginIndex2 + 1).equals("R") && s.equals("S")) {
                        x = 1;
                    }
                }
                final String s4 = next;
                final int beginIndex3 = i;
                s = s4.substring(beginIndex3, beginIndex3 + 1);
            }
        }
        System.out.println(x);
    }
}
