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
        if (char1 == char2 && char2 == char3 && char3 == 'R') {
            System.out.println("3");
            return;
        }
        if ((char1 == char2 && char2 == 'R') || (char2 == char3 && char3 == 'R')) {
            System.out.println("2");
            return;
        }
        if (char1 != 'R' && char2 != 'R' && char3 != 'R') {
            System.out.println("0");
            return;
        }
        System.out.println("1");
    }
}
