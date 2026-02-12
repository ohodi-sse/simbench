import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String next;
        final char char1 = (next = (scanner = new Scanner(System.in)).next()).charAt(0);
        final char char2 = next.charAt(1);
        final char char3 = next.charAt(2);
        if (char1 == char2 && char2 == char3 && char1 == 'S') {
            System.out.println(0);
            return;
        }
        if (char1 == char2 && char2 == char3 && char1 == 'R') {
            System.out.println(3);
        }
        else if (char1 == 'R') {
            if (char1 == char2) {
                System.out.println(2);
            }
            else {
                System.out.println(1);
            }
        }
        else if (char3 == 'R') {
            if (char2 == char3) {
                System.out.println(2);
            }
            else {
                System.out.println(1);
            }
        }
        else {
            System.out.println(1);
        }
        scanner.close();
    }
}
