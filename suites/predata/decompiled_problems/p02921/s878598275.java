import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        int x = 0;
        final String[] split = next.split("");
        final String[] split2 = scanner.next().split("");
        for (int i = 0; i < split.length; ++i) {
            if (split[i].equals(split2[i])) {
                ++x;
            }
        }
        System.out.println(x);
        scanner.close();
    }
}
