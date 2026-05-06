import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.charAt(0) == 'R') {
            x = 1;
            if (next.charAt(1) == 'R') {
                ++x;
                if (next.charAt(2) == 'R') {
                    ++x;
                }
            }
        }
        else if (next.charAt(1) == 'R') {
            ++x;
            if (next.charAt(2) == 'R') {
                ++x;
            }
        }
        else if (next.charAt(2) == 'R') {
            ++x;
        }
        System.out.println(x);
    }
}
