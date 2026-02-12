import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int i = 0;
        if (nextLine.charAt(0) == 'R') {
            ++i;
            if (nextLine.charAt(1) == 'R') {
                ++i;
                if (nextLine.charAt(2) == 'R') {
                    ++i;
                }
            }
        }
        else if (nextLine.charAt(1) == 'R') {
            ++i;
            if (nextLine.charAt(2) == 'R') {
                ++i;
            }
        }
        else if (nextLine.charAt(2) == 'R') {
            ++i;
        }
        System.out.print(i);
    }
}
