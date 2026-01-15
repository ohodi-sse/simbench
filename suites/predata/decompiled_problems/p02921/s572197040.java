import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        Integer x = 0;
        for (Integer n = 0; n < next.length(); ++n) {
            if (next.charAt(n) == next2.charAt(n)) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
