import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        final char char1 = (next = new Scanner(System.in).next()).charAt(0);
        final char char2 = next.charAt(1);
        final char char3 = next.charAt(2);
        if (char1 == 'R') {
            if (char2 != 'R') {
                System.out.println(1);
                return;
            }
            if (char3 == 'R') {
                System.out.println(3);
                return;
            }
            System.out.println(2);
        }
        else if (char2 == 'R') {
            if (char3 == 'R') {
                System.out.println(2);
                return;
            }
            System.out.println(1);
        }
        else {
            if (char3 == 'R') {
                System.out.println(1);
                return;
            }
            System.out.println(0);
        }
    }
}
