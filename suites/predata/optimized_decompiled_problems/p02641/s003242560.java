import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner;
        final String[] split;
        final int int1 = Integer.parseInt((split = (scanner = new Scanner(System.in)).nextLine().split(" "))[0]);
        final int int2 = Integer.parseInt(split[1]);
        final String nextLine = scanner.nextLine();
        int x = int1;
        int x2 = int1;
        int n = 0;
        final String[] split2;
        if ((split2 = nextLine.split(" ")).length != int2) {
            if (int2 == 0) {
                System.out.println(int1);
            }
            return;
        }
        while (true) {
            for (int i = 0; i < split2.length; ++i) {
                if (x2 == Integer.parseInt(split2[i])) {
                    ++n;
                    --x2;
                }
                if (x == Integer.parseInt(split2[i])) {
                    ++n;
                    ++x;
                }
            }
            if (n == 0) {
                break;
            }
            n = 0;
        }
        if (int1 - x2 > x - int1) {
            System.out.println(x);
            return;
        }
        System.out.println(x2);
    }
}
