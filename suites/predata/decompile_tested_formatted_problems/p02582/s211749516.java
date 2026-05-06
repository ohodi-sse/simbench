import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final String next = new Scanner(System.in).next();
        int x = 0;
        if (next.contains("R")) {
            if (next.charAt(0) == next.charAt(1) && next.charAt(0) == next.charAt(2)) {
                x = 3;
            }
            else if ((next.charAt(0) == 'R' && next.charAt(1) == 'R') || (next.charAt(1) == 'R' && next.charAt(2) == 'R')) {
                x = 2;
            }
            else {
                x = 1;
            }
        }
        System.out.println(x);
    }
}
