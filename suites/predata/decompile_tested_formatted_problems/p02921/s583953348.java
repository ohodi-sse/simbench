import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        final char[] charArray2 = scanner.nextLine().toCharArray();
        int x = 0;
        for (int i = 0; i <= 2; ++i) {
            if (charArray[i] == charArray2[i]) {
                ++x;
            }
        }
        System.out.println(x);
    }
}
