import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        int x = 0;
        final String[] split = scanner.next().split("");
        int n = 0;
        scanner.close();
        String[] array;
        for (int length = (array = split).length, i = 0; i < length; ++i) {
            if ("R".equals(array[i])) {
                if (n != 0) {
                    ++x;
                }
                else {
                    x = 1;
                }
                n = 1;
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
