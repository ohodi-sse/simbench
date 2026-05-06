import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String next = scanner.next();
        final String next2 = scanner.next();
        final char[] array2 = new char[next.length()];
        final char[] array3 = new char[next2.length()];
        int x = 0;
        for (int i = 0; i < next.length(); ++i) {
            array2[i] = next.charAt(i);
        }
        for (int j = 0; j < next2.length(); ++j) {
            array3[j] = next2.charAt(j);
        }
        for (int k = 0; k < 3; ++k) {
            if (array2[k] == array3[k]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
