import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        try (final Scanner scanner = new Scanner(System.in)) {
            final String nextLine = scanner.nextLine();
            int x = 0;
            int n = 0;
            final char[] charArray = nextLine.toCharArray();
            for (int length = charArray.length, i = 0; i < length; ++i) {
                if (charArray[i] == 'R') {
                    ++n;
                }
                else {
                    n = 0;
                }
                if (x < n) {
                    x = n;
                }
            }
            System.out.println(x);
        }
    }
}
