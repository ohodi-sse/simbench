import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        for (int i = 0; i < nextLine.length(); ++i) {
            if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == 'S') {
                ++n;
            }
            else if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == 'C') {
                ++n2;
            }
            else if (nextLine.charAt(i) == nextLine2.charAt(i) && nextLine.charAt(i) == 'R') {
                ++n3;
            }
        }
        System.out.println(n + n2 + n3);
    }
}
