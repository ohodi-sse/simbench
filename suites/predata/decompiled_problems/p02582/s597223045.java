import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            final String nextLine = scanner.nextLine();
            int max = 0;
            int b = 0;
            for (int i = 0; i < nextLine.length(); ++i) {
                if (nextLine.charAt(i) == 'R') {
                    ++b;
                }
                else {
                    b = 0;
                }
                max = Math.max(max, b);
            }
            System.out.println(max);
        }
    }
}
