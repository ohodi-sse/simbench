import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final String s = new String();
        final String next = scanner.next();
        scanner.close();
        final Character[] array2 = new Character[3];
        for (int i = 0; i < 3; ++i) {
            array2[i] = next.charAt(i);
        }
        int n = 0;
        int x = 0;
        for (int j = 0; j < 3; ++j) {
            if (array2[j].equals('R')) {
                if (++n > x) {
                    x = n;
                }
            }
            else {
                n = 0;
            }
        }
        System.out.println(x);
    }
}
