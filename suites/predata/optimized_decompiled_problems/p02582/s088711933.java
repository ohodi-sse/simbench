import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String next;
        int x;
        if ((next = new Scanner(System.in).next()).charAt(0) == 'R' && next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            x = 3;
        }
        else if (next.charAt(0) == 'R' && next.charAt(1) == 'R') {
            x = 2;
        }
        else if (next.charAt(1) == 'R' && next.charAt(2) == 'R') {
            x = 2;
        }
        else if (next.charAt(0) != 'R' && next.charAt(1) != 'R' && next.charAt(2) != 'R') {
            x = 0;
        }
        else {
            x = 1;
        }
        System.out.println(x);
    }
}
