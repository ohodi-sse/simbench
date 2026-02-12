import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

final class Main
{
    private static void main$3231c38a() {
        final String nextLine = new Scanner(System.in).nextLine();
        int length = 0;
        final String[] split = nextLine.split("S", -1);
        for (int i = 0; i < split.length; ++i) {
            if (split[i].length() > length) {
                length = split[i].length();
            }
        }
        System.out.println(length);
    }
}
