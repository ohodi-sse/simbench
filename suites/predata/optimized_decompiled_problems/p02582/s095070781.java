import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String next;
        final boolean b = (next = new Scanner(System.in).next()).charAt(0) == 'R';
        final boolean b2 = next.charAt(1) == 'R';
        final boolean b3 = next.charAt(2) == 'R';
        int x;
        if (b && b2 && b3) {
            x = 3;
        }
        else if ((b && b2) || (b2 && b3)) {
            x = 2;
        }
        else if (b || b2 || b3) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
    
    private static void test_mine() {
        final String next;
        int x;
        if ((next = new Scanner(System.in).next()).charAt(1) == 'S') {
            if (next.charAt(0) == 'R' || next.charAt(2) == 'R') {
                x = 1;
            }
            else {
                x = 0;
            }
        }
        else if (next.charAt(0) == 'R') {
            if (next.charAt(2) == 'R') {
                x = 3;
            }
            else {
                x = 2;
            }
        }
        else if (next.charAt(2) == 'R') {
            if (next.charAt(0) == 'R') {
                x = 3;
            }
            else {
                x = 2;
            }
        }
        else {
            x = 1;
        }
        System.out.println(x);
    }
    
    private static void test_ans() {
        final String next;
        final boolean b = (next = new Scanner(System.in).next()).charAt(0) == 'R';
        final boolean b2 = next.charAt(1) == 'R';
        final boolean b3 = next.charAt(2) == 'R';
        int x;
        if (b && b2 && b3) {
            x = 3;
        }
        else if ((b && b2) || (b2 && b3)) {
            x = 2;
        }
        else if (b || b2 || b3) {
            x = 1;
        }
        else {
            x = 0;
        }
        System.out.println(x);
    }
}
