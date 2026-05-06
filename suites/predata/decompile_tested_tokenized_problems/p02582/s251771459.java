import java.util.Scanner;

// 
// Decompiled by Procyon v0.6.0
// 

public class Main
{
    public static void main(final String[] array) {
        final Scanner scanner = new Scanner(System.in);
        final char[] charArray = scanner.nextLine().toCharArray();
        scanner.close();
        int x = 0;
        final char[] array2 = charArray;
        for (int length = array2.length, i = 0; i < length; ++i) {
            if (array2[i] == 'R') {
                ++x;
            }
        }
        if (x == 2 && charArray[1] == 'S') {
            x = 1;
        }
        System.out.println(x);
    }
}
