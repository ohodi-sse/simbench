import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() throws Exception {
        final String next = new Scanner(System.in).next();
        boolean b = false;
        int x = 0;
        final char[] array = new char[next.length()];
        for (int i = 0; i < next.length(); ++i) {
            array[i] = next.charAt(i);
            if (array[i] == 'R') {
                ++x;
                b = true;
            }
            if (array[i] == 'S' && b) {
                break;
            }
        }
        System.out.println(x);
    }
}
