import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int i = 1;
        final String nextLine;
        if ((nextLine = scanner.nextLine()).charAt(0) == 'S' && nextLine.charAt(1) == 'S' && nextLine.charAt(2) == 'S') {
            System.out.print(0);
            return;
        }
        for (int j = 1; j < nextLine.length(); ++j) {
            if (nextLine.charAt(j) == 'R' && nextLine.charAt(j - 1) == 'R') {
                ++i;
            }
        }
        System.out.print(i);
    }
}
