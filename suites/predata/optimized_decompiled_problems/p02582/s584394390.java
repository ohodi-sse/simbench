import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        final String substring = (next = new Scanner(System.in).next()).substring(0, 1);
        final String substring2 = next.substring(1, 2);
        final String substring3 = next.substring(2, 3);
        if (substring.equals("R") && substring2.equals("R") && substring3.equals("R")) {
            System.out.println("3");
            return;
        }
        if (substring.equals("R") && substring2.equals("R") && substring3.equals("S")) {
            System.out.println("2");
            return;
        }
        if (substring.equals("S") && substring2.equals("R") && substring3.equals("R")) {
            System.out.println("2");
            return;
        }
        if (substring.equals("R") && substring2.equals("S") && substring3.equals("S")) {
            System.out.println("1");
            return;
        }
        if (substring.equals("S") && substring2.equals("R") && substring3.equals("S")) {
            System.out.println("1");
            return;
        }
        if (substring.equals("S") && substring2.equals("S") && substring3.equals("R")) {
            System.out.println("1");
            return;
        }
        if (substring.equals("R") && substring2.equals("S") && substring3.equals("R")) {
            System.out.println("1");
            return;
        }
        if (substring.equals("S") && substring2.equals("S") && substring3.equals("S")) {
            System.out.println("0");
        }
    }
}
