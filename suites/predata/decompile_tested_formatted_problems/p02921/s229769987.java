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
        final char[] array2 = new char[3];
        for (int i = 0; i < next.length(); ++i) {
            array2[i] = next.charAt(i);
        }
        final char[] array3 = new char[3];
        for (int j = 0; j < next2.length(); ++j) {
            array3[j] = next2.charAt(j);
        }
        int x = 0;
        for (int k = 0; k < array2.length; ++k) {
            if (array2[k] == array3[k]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
