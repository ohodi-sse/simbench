import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final long nextLong = scanner.nextLong();
        final String next = scanner.next();
        String s = "";
        for (int i = 0; i < next.length(); ++i) {
            if (next.charAt(i) != '.') {
                s += next.charAt(i);
            }
        }
        System.out.println(nextLong * new Integer(s) / 100L);
    }
}
