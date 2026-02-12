import java.util.Objects;
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
        final String s = nextLine;
        final String s2 = nextLine2;
        final String s3 = s;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(s3.charAt(i), s2.charAt(i))) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
import java.util.Objects;
import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class P1
{
    private static void p1() {
        final Scanner scanner;
        final String nextLine = (scanner = new Scanner(System.in)).nextLine();
        final String nextLine2 = scanner.nextLine();
        final String s = nextLine;
        final String s2 = nextLine2;
        final String s3 = s;
        int x = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(s3.charAt(i), s2.charAt(i))) {
                ++x;
            }
        }
        System.out.println(x);
    }
    
    private static int calc(final String s, final String s2) {
        int n = 0;
        for (int i = 0; i < 3; ++i) {
            if (Objects.equals(s.charAt(i), s2.charAt(i))) {
                ++n;
            }
        }
        return n;
    }
}
