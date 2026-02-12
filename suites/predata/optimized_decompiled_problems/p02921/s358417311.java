import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public final class Main
{
    private static void main$3231c38a() {
        final Scanner scanner = new Scanner(System.in);
        final String[] array = new String[2];
        for (int i = 0; i < 2; ++i) {
            array[i] = scanner.next();
        }
        final String[] split = array[0].split("");
        final String[] split2 = array[1].split("");
        int x = 0;
        for (int j = 0; j < split.length; ++j) {
            if (split[j].equals(split2[j])) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
