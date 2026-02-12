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
        final String[] split = nextLine.split("");
        final String[] split2 = nextLine2.split("");
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (split[i].compareTo(split2[i]) == 0) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
