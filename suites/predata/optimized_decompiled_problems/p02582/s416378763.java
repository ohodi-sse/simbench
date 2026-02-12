import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next = new Scanner(System.in).next();
        int i = 0;
        Object substring = null;
        for (int j = 0; j < 3; ++j) {
            final String s = next;
            final int beginIndex = j;
            if (s.substring(beginIndex, beginIndex + 1).equals(substring) || i == 0) {
                final String s2 = next;
                final int beginIndex2 = j;
                if (s2.substring(beginIndex2, beginIndex2 + 1).equals("R")) {
                    ++i;
                }
            }
            final String s3 = next;
            final int beginIndex3 = j;
            substring = s3.substring(beginIndex3, beginIndex3 + 1);
        }
        System.out.println(String.valueOf(i));
    }
    
    private static void p(final String x) {
        System.out.println(x);
    }
}
