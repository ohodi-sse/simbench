import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final char[] charArray = new Scanner(System.in).next().toCharArray();
        int i = 0;
        int max = 0;
        while (i < charArray.length) {
            if (charArray[i] != 'R') {
                ++i;
            }
            else {
                int b = 0;
                while (i < charArray.length && charArray[i] == 'R') {
                    ++b;
                    ++i;
                }
                max = Math.max(max, b);
                ++i;
            }
        }
        System.out.println(max);
    }
}
