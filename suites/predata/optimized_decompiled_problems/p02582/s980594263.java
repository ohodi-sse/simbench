import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int x = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == 'R') {
                x = 0;
                while (nextLine.charAt(i) != 'S' && i < nextLine.length()) {
                    ++x;
                    if (++i == nextLine.length()) {
                        break;
                    }
                }
            }
        }
        System.out.println(x);
    }
}
